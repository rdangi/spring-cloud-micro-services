![Maven Build](https://github.com/rdangi/spring-cloud-micro-services/workflows/Maven%20Build/badge.svg)

# Spring Cloud Micro Services

Proof of concept for a enterprise level Spring cloud project.

> This project uses Docker for setting up easily. 
> Before running, please ensure docker is installed and running in local/development environment.

## Disclaimer

This project is *Proof of concept* (`PoC`) and code quality is not perfect, please before using in production review security concerns among other things

## Technology Stack
This project demonstrates usage of following technologies. 

* Spring
* Spring Cloud
* Spring cloud Config server 
* Spring cloud Eureka Service Registry and Discovery
* Spring cloud Gateway
* Redis cache
* Docker
* Maven

## Build

### Maven

To build the project use below maven commands

```sh
./mvnw clean package
# to run unit tests
./mvnw clean package
```

### Build Docker images

Start building docker images for every services, simply run following command on root directory.

```shell
./mvnw clean package -Pdocker
```

## Launch services in development environment

### Using Maven

On each service folder run following command:

```sh
./mvnw spring-boot:run
```

# Using `docker-compose`

```shell
docker-compose build
docker-compose run start-dependencies
docker-compose up
# or if you want to rebuild
docker-compose up --build
```

## Application URLs in development environment

* Eureka - service-registry : http://localhost:8761/
* Spring Boot Micro-Service - hello-service: http://localhost:8080/hello
* Spring Cloud Gateway - gateway-service : http://localhost:9500/hello
