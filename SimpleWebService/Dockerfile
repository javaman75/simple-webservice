# Use a base Java image
FROM openjdk:11-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the Java application JAR file to the container
COPY target/SimpleWebService-1.0-SNAPSHOT-jar-with-dependencies.jar  /app/SimpleWebService-1.0-SNAPSHOT-jar-with-dependencies.jar

# Expose the port on which your Java application listens
EXPOSE 8080

# Start the Java application when the container starts
CMD ["java", "-jar", "SimpleWebService-1.0-SNAPSHOT-jar-with-dependencies.jar"]