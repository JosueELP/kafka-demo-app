# Spring Kafka Demo App

This is a Spring Boot app with a demo of the implementation of Apache Kafka configuration in order to Send and Receive a simple String message from a Topic.

## Requirements
- Java 21 (You can download it the JDK from IntelliJ IDEA)
- Docker (for the Kafka Server)
- Postman/Insomnia or any other API testing tool.

## How to run it
First, let's set up the docker container that will run our Kafka Server.

### Setting up Kafka with Docker
The instructions are pretty clear from the docker image: https://hub.docker.com/r/apache/kafka
But let's simplify it, after you have installed docker, run the following command:

`docker run -d -p 9092:9092 --name kafka-broker apache/kafka:latest`

This will download the image from Apache Kafka and create (and run) a container called kafka-broker.

Now, let's create our example topic, first, execute the following command:

`docker exec --workdir /opt/kafka/bin/ -it broker sh`

This will open the shell from the container itself, so now we have to create the kafka topic, in this case, this app is configured to use the topic: topic_example_demo

`./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic topic_example_demo`

That's it!, we have created our kafka server from a docker container with out kafka topic, remember to have up and running this container while running our Spring Boot App.

### Running the App
I strongly recommend to open this project using IntelliJ IDEA, as it will download and configure the project itself.

Make sure to create a new Run Configuration to start the app with the following env variable: `SPRING_PROFIlES_ACTIVE=default`

### Testing the endpoint
The endpoint itself is: `http://localhost:8080/send`
It is a POST endpoint and you have to pass it as Body a simple JSON like this:

```
{
  "message": "My first message in Kafka"
}
```

The endpoint should return a 200 OK response and you should see in the LOG TERMINAL from the Spring Boot App both the message sent and message received from Kafka.
