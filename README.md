![Maven Build](https://github.com/rdangi/spring-cloud-micro-services/workflows/Maven%20Build/badge.svg)

# Spring Cloud Micro Services

Proof of concept for a enterprise level Spring cloud project

## Disclaimer

This project is *Proof of concept* (`PoC`) and code quality is not perfect, please before using in production review security concerns among other things

## Build all modules:

### Maven

On each service folder run following command:

```sh
mvn spring-boot:run
```

### Docker

Start building docker images for every services, simply run following command on root directory

```shell
mvn clean package -Pdocker
```

Launch services using `docker-compose`

```shell
docker-compose up -d
# For development envioronment 
docker-compose up -d --build
```

## URLs:

* Eureka - service-registry : http://localhost:8761/
* Spring Boot Micro-Service - hello-service: http://localhost:8080/hello
* Spring Cloud Gateway - gateway-service : http://localhost:9500/hello
