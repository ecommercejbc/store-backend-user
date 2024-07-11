FROM eclipse-temurin:8-jdk-alpine
ENV TZ=America/Lima
EXPOSE 8080
RUN mkdir -p /formatos
COPY formatos/* /formatos/
# Ajustar la ruta del archivo JAR según lo generado por Maven
COPY target/quarkus-app/quarkus-run.jar /deployments/quarkus-app/quarkus-run.jar
WORKDIR /deployments
CMD ["java", "-jar", "quarkus-app/quarkus-run.jar"]
