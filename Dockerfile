FROM eclipse-temurin:21-jre
WORKDIR /app

# Expect the JAR to be built by Maven before docker build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
