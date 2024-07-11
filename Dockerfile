# Use JRE for runtime
FROM eclipse-temurin:11-jre-alpine

# Set the timezone
ENV TZ=America/Lima

# Expose the default Quarkus port
EXPOSE 8080

# Create a directory for your mounted volumes or additional configs
RUN mkdir -p /formatos
COPY formatos/* /formatos/

# Copy your Quarkus application build output directory
COPY target/quarkus-app /deployments/quarkus-app

# Set the working directory to where we copied the app
WORKDIR /deployments

# Command to execute the Quarkus application
CMD ["java", "-jar", "quarkus-app/quarkus-run.jar"]
