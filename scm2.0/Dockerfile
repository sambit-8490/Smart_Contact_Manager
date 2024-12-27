# Stage 1: Build
FROM maven:3.8.8-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar scm.jar

EXPOSE 8080

CMD ["java", "-jar", "scm.jar"]
