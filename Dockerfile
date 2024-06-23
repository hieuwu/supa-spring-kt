FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
# docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .