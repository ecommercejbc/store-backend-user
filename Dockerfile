FROM eclipse-temurin:8-jdk-alpine
ENV TZ=America/Lima
EXPOSE 8080
RUN mkdir -p /formatos
COPY formatos/* /formatos/
# Ensure the Quarkus build directory exists and is correctly referenced
COPY target/code-with-quarkus-1.0.0 /deployments/quarkus-app
WORKDIR /deployments
CMD ["java", "-jar", "quarkus-app/code-with-quarkus-1.0.0.jar"]
