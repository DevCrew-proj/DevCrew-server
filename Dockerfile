FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/devcrew-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080


ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar", "--spring.config.location=classpath:/application.yml,classpath:/application-prod.yml"]
