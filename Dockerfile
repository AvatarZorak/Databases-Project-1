FROM openjdk:21
COPY target/Databases-Project-1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]