FROM openjdk:8-jdk-alpine
EXPOSE 9500
ARG JAR_FILE=target/gateway-service-*.jar
ADD ${JAR_FILE} app.jar
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["java","-jar","/app.jar"]