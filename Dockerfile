FROM openjdk:11-jdk

VOLUME /tmp

LABEL maintainer="mooh2jj@naver.com"

EXPOSE 8080

ARG JAR_FILE=target/gradle-springboot-test-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

