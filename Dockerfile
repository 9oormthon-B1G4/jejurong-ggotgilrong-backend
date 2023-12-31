FROM openjdk:17

EXPOSE 8080

ARG JAR_FILE=build/libs/jejudong-ggotgilrong-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]