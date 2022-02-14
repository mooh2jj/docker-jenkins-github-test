FROM openjdk:11-jdk

VOLUME /tmp

LABEL maintainer="mooh2jj@naver.com"

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} /

ENTRYPOINT ["java","-jar","/app.jar"]

