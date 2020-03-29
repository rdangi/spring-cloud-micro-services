FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/hello-service-*.jar
ADD ${JAR_FILE} app.jar
ENV SPRING_PROFILES_ACTIVE=docker,dev
ENTRYPOINT ["java","-jar","/app.jar"]