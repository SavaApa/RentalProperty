FROM openjdk:17-jdk
ARG JAR_FILE=/target/*.jar
COPY ./target/RentalProperty.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]