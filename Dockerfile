FROM openjdk:17-jdk-alpine
MAINTAINER douglasbello.com
COPY target/redis-problem-0.0.1-SNAPSHOT.jar redis-problem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/redis-problem-0.0.1-SNAPSHOT.jar"]