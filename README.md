![Maven Build](https://github.com/rdangi/spring-cloud-micro-services/workflows/Maven%20Build/badge.svg)

# Spring Cloud Micro Services

Proof of concept for a enterprise level Spring cloud project

## Disclaimer

This project is *Proof of concept* (`PoC`) and code quality is not perfect, please before using in production review security concerns among other things

## Build all modules:

### Maven

On each service folder run following command:

```sh
./mvnw spring-boot:run
```

### Docker

Start building docker images for every services, simply run following command on root directory.

> Before running this command, ensure Docker is installed and running in local/development environment.

```shell
./mvnw clean package -Pdocker
```

# Launch services using `docker-compose`

```shell
# Launch docker if build already complete
docker-compose up -d
# Perform build and then launch docker instances
docker-compose up -d --build
```

## URLs:

* Eureka - service-registry : http://localhost:8761/
* Spring Boot Micro-Service - hello-service: http://localhost:8080/hello
* Spring Cloud Gateway - gateway-service : http://localhost:9500/hello
