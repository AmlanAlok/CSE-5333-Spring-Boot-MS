FROM openjdk:8
ADD build/libs/java-backend-0.0.1-SNAPSHOT.jar java-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "java-backend-0.0.1-SNAPSHOT.jar"]