FROM eclipse-temurin:8-jdk-alpine
ENV TZ=America/Lima
EXPOSE 8080

# Ajustar la ruta del archivo JAR según lo generado por Maven
COPY target/quarkus-app/code-with-quarkus-1.0.0.jar  /deployments/code-with-quarkus-1.0.0.jar
WORKDIR /deployments
CMD ["java", "-jar", "quarkus-app/code-with-quarkus-1.0.0.jar"]
