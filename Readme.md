# All links for this application

React Frontend: https://github.com/AmlanAlok/react-chat-feature/tree/attempt-1

Chat Server: https://github.com/AmlanAlok/CSE-5333-Chat-Server-NodeJS

Spring Backend: https://github.com/AmlanAlok/CSE-5333-Spring-Boot-MS



# TO RUN ANYWHERE

## We have the docker image on docker hub

amlanalok/cse-5333-backend

## Run the below command to run our docker image

docker run -dp 8080:8080 amlanalok/cse-5333-backend

# To run locally

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
docker build --platform linux/amd64 -t cse-5333-backend .

##### The docker build command generates an image intended for the same architecture where the docker image was built. 
##### My machine is the Mac M1 which has the M1 Apple silicon chip which has the arm64/v8 architecture.
##### The GCP VM has amd64 architecture. Due to this mismatch, images generated with the default docker build command will not work on other architectures.
##### Hence, I must use the --platform flag which takes the value of the intended architecture  for which the image is being built.

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

### Use commands from the below link to install Docker on Ubuntu 18.04 LTS
https://docs.docker.com/engine/install/ubuntu/

### Run the application docker image using the below command
sudo docker run -dp 8080:8080 amlanalok/cse-5333-backend

### Command to connect the GCP Compute Engine
gcloud compute ssh cloud-project-vm-1 --zone=us-west1-b

