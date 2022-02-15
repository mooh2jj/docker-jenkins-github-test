FROM openjdk:11-jdk

LABEL maintainer="mooh2jj@naver.com"

EXPOSE 8080

ADD build/libs/gradle-springboot-test-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar" ,"/app.jar"]

