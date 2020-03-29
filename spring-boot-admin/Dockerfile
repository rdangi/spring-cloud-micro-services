FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/spring-boot-admin-*.jar
ADD ${JAR_FILE} app.jar
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["java","-jar","/app.jar"]
