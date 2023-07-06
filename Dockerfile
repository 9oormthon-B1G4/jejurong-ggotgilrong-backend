FROM openjdk:17

EXPOSE 8080

ARG JAR_FILE=build.libs/jejudong-ggotgilrong-backend-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

ENV TZ=Asiz/Seoul

RUN apt install -y tzdata