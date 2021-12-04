#!/bin/bash
echo "String script"

echo "Building jar file"
gradle clean build

echo "Building docker image"
docker build -t cse-5333-backend .

echo "deleting all running containers"
docker rm -vf $(sudo docker ps -aq)

echo "running docker container"
docker run -dp 8080:8080 cse-5333-backend

docker ps
echo "ran docker container"