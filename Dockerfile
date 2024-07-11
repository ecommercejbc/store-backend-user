# Use the official Eclipse Temurin base image for Java 8
FROM eclipse-temurin:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /deployments

# Copy the Quarkus build output (target/*.jar and target/lib) to the container
COPY target/code-with-quarkus-1.0.0.jar /deployments/code-with-quarkus-1.0.0.jar
COPY target/lib/ /deployments/lib/

# Set the entry point to execute the application
CMD ["java", "-jar", "code-with-quarkus-1.0.0.jar"]
