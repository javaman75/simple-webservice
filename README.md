## Compile 
This is a simple web-service using Apache libraries.

1. Go to the root directory ./SimpleWebService
2. mvn clean package
3. Go inside /target and look for a jar file named `SimpleWebService-1.0-SNAPSHOT-jar-with-dependencies.jar`


## How to run it locally

    % java -jar target/SimpleWebService-1.0-SNAPSHOT-jar-with-dependencies.jar

## How to create a docker image
    % docker build -t simple-webservice .    

## How to run the in docker
    % docker run -p 8080:8080 simple-webservice

## How to test
Open your local browser and use this URL `http://localhost:8080/hello`    

## How to push it to DockerHub
    % docker login
    % docker tag simple-webservice cohenj/simple-webservice:latest
    % docker push cohenj/simple-webservice:latest

## How to pull the image
    % docker pull cohenj/simple-webservice:latest


## Repos.
    Source code = https://github.com/javaman75/simple-webservice

    Image repo =  https://hub.docker.com/r/cohenj/simple-webservice/tags


## Repo GitHub creation
    % echo "# simple-webservice" >> README.md
    % git init
    % git add README.md
    % git commit -m "first commit"
    % git branch -M main
    % git remote add origin https://github.com/javaman75/simple-webservice.git
    % git push -u origin main
