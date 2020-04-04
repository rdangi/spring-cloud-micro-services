![spring-boot-docker-image](https://user-images.githubusercontent.com/2969035/77563922-4f230180-6e98-11ea-8ca8-515cd7abc79d.png)

# Spring Cloud Micro Services with Docker

Proof of concept for a enterprise level Spring cloud project.

> This project uses Docker for setting up easily. 
> Before running, please ensure docker is installed and running in local/development environment.

![Maven Build](https://github.com/rdangi/spring-cloud-micro-services/workflows/Maven%20Build/badge.svg)

## Disclaimer

This project is *Proof of concept* (`PoC`) and code quality is not perfect, please before using in production review security concerns among other things

## Technology Stack
This project demonstrates usage of following technologies. 

* Spring Boot
* Spring Cloud Gateway
* Spring cloud Config server 
* Netflix Eureka Service Registry and Discovery
* Netflix Hystrix Circuit breaker
* Zipkin for distributed tracing
* Elastic Search + Logstash + Kibana + Beats for log aggregation, visualization and analytics
* Redis cache
* Docker
* Maven

## Build

### Maven

To build the project use below maven commands

```sh
./mvnw clean package
```

### Build Docker images

Start building docker images for every services, simply run following command on root directory.

```shell
./mvnw clean package -Pdocker
```

## Launch services in development environment

### Using Maven

Then On each service folder run following command:

```sh
./mvnw spring-boot:run
```

### Using `docker-compose`

Before running the docker compose, please ensure at least 4GB is allocated for docker. 
As it is starting up many services to setup the entire app, it needs more memory.
 
```shell
docker-compose up -d
# or if you want to rebuild
docker-compose up -d --build
```

## Application URLs in development environment

* Eureka - service-registry : http://localhost:8761/
* Spring Boot Micro-Service - hello-service: http://localhost:8080/hello
* Spring Cloud Gateway - gateway-service : http://localhost:9500/hello
* Hystrix Dashboard - http://localhost:8080/hystrix/ --> Then enter `http://localhost:8080/actuator/hystrix.stream` as the stream value --> click on Monitor stream
* Spring boot admin Dashboard - http://localhost:9000
* Zipkin - http://localhost:9411
* Kibana Dashboard - http://localhost:5601
