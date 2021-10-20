
### To create a new jar file 
gradle clean build

### To run the packaged application
java -jar ./build/libs/java-backend-0.0.1-SNAPSHOT.jar

### To start application using gradle
gradle bootRun

### To start application using gradle wrapper
./gradlew bootRun

## Dockerize your Application

### To build docker image
docker build -t cse-5333-backend .

### To run docker container
docker run -dp 8080:8080 cse-5333-backend

### To see the list of containers running
docker ps

### To check logs in the container
docker logs <container-id>

### To stop the docker container
docker stop <container-id>

### To tag your docker image
docker tag cse-5333-backend amlanalok/cse-5333-backend

### To login to your docker account
docker login -u <username>

### To push your docker container to the docker hub
docker push amlanalok/cse-5333-backend