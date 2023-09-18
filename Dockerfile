# Use a base image with Java 11 (OpenJDK)
FROM openjdk:11-jre-slim

# Set environment variables for the Spring Boot application
ENV APP_HOME /app
ENV JAR_FILE freight-0.0.1-SNAPSHOT.jar

# Create the application directory
RUN mkdir -p $APP_HOME

# Set the working directory
WORKDIR $APP_HOME

# Copy the Spring Boot JAR file into the container
COPY target/$JAR_FILE $APP_HOME/

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "freight-0.0.1-SNAPSHOT.jar"]
