# Use the Maven image with JDK 21 to build the application
FROM maven:3.9.5-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application, skipping tests
RUN mvn clean package -DskipTests

# Use OpenJDK 21 for the runtime environment
FROM openjdk:21-jdk-slim

# Set the working directory for the runtime image
WORKDIR /app

# Copy the packaged JAR from the build stage
COPY --from=build /app/target/practise-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the application will run on
EXPOSE 8080

# Set environment variables for MongoDB connection
ENV MONGO_URI=mongodb+srv://DivyanshuAhirrao:Dadu%401699@roamingo.jodfp.mongodb.net/?retryWrites=true&w=majority&appName=Roamingo

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
