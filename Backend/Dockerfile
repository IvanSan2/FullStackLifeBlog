# Use an official OpenJDK runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the project's JAR file into the container at /app
COPY target/BlogFinalProject-0.0.1-SNAPSHOT.jar /app/BlogFinalProject.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "--enable-preview", "-jar", "BlogFinalProject.jar"]