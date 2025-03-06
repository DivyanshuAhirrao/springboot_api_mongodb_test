# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from target/ to the container
COPY target/*.jar app.jar

# Expose port 8080 (default for Spring Boot)
EXPOSE 8080

# Define environment variable for MongoDB connection
ENV MONGO_URI=mongodb+srv://DivyanshuAhirrao:Dadu%401699@roamingo.jodfp.mongodb.net/?retryWrites=true&w=majority&appName=Roamingo

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
