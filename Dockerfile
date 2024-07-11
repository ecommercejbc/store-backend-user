# Stage 1: Build the native executable
FROM quay.io/quarkus/ubi-quarkus-native-image:22.3-java17 AS build
WORKDIR /work/
COPY . /work/
RUN ./mvnw package -Pnative

# Stage 2: Create the minimal Docker image
FROM registry.access.redhat.com/ubi8/ubi-minimal:latest
WORKDIR /work/
COPY --from=build /work/target/*-runner /work/application

# Set the entry point to execute the native binary
ENTRYPOINT ["./application"]
