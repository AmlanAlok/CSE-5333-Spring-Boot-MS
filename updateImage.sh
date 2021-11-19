#!/bin/bash
echo "String script"

echo "Building jar file"
gradle clean build

echo "Building docker image"
docker build --platform linux/amd64 -t cse-5333-backend .

echo "tagging docker iamge"
docker tag cse-5333-backend amlanalok/cse-5333-backend

echo "Pushing image to Docker Hub"
docker push amlanalok/cse-5333-backend

echo "Docker image has been successfully pushed"