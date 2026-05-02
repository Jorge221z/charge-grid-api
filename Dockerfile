# Use a lightweight Java 21 Corretto image
FROM amazoncorretto:21-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Fat JAR from your build folder into the container
# Local environment
COPY build/libs/charge-grid-api-0.0.1-SNAPSHOT.jar app.jar
# Production environment
#COPY charge-grid-api-0.0.1-SNAPSHOT.jar app.jar



# Expose the port Spring Boot runs on
EXPOSE 8080

# Command to execute the app
ENTRYPOINT ["java", "-jar", "app.jar"]