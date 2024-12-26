FROM maven AS build 

WORKDIR /app

COPY . .

RUN mvn clean install 

FROM openjdk-23-jdk-silm 

WORKDIR /app1

COPY --from=build /app/target/*.jar ./scm.jar

EXPOSE 8080

CMD ["java", "-jar", "scm.jar"]