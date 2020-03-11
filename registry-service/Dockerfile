FROM openjdk:8-jdk-alpine
EXPOSE 8761
ARG JAR_FILE=target/registry-service-*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]