FROM openjdk:21-jdk-slim

COPY target/*.jar app.jar

EXPOSE 8081

CMD ["java","-jar","/app.jar"]
