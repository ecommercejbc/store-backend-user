# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /work

# Copy the Quarkus build output (target/quarkus-app) to the container
COPY target/quarkus-app /work/

# Set the entry point to execute the application
ENTRYPOINT ["java", "-jar", "/work/quarkus-run.jar"]
