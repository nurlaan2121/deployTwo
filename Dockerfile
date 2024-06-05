# Stage 1: Build stage
FROM openjdk:21 as build
WORKDIR /app

# Install necessary tools
RUN microdnf install findutils

# Copy source files and give execution permission to gradlew
COPY . ./
RUN chmod +x gradlew

# Build the project
RUN ./gradlew build -x test

# Verify the contents of the build/libs directory
RUN ls -la /app/build/libs/

# Stage 2: Create the final image
FROM openjdk:21-slim
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/*.jar ./project.jar

# Set the command to run the application
CMD ["java", "-jar", "project.jar"]

# Expose the application port
EXPOSE 2024
