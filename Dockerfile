FROM eclipse-temurin:8-jdk-alpine
ENV TZ=America/Lima
EXPOSE 8080

# Adjust the COPY command to include quarkus-run.jar and the lib directory
COPY ./target/code-with-quarkus-1.0.0.jar /deployments/code-with-quarkus-1.0.0.jar
COPY ./target/lib/ /deployments/lib/
WORKDIR /deployments
CMD ["java", "-jar", "code-with-quarkus-1.0.0.jar"]
