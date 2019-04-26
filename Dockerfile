FROM openjdk:8
ADD target/recommander.jar recommander.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "recommander.jar"]