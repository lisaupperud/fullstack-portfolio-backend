# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk
# Set the working directory in the container
WORKDIR /app
# Copy the JAR file into the container named /app and renames it to 'my-spring-app'
COPY build/libs/portfolioAPI-0.0.1-SNAPSHOT.jar portfolio-api.jar
# Expose the port that the application will run on (Must reflect Spring Boot's PORT)
EXPOSE 8080
# Command to run the app
ENTRYPOINT ["java", "-jar", "portfolio-api.jar"]