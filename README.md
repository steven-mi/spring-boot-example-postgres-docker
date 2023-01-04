# Spring Boot Service Example

Example of a small Spring Boot service using Docker, docker-compose, postgresql. This example involves using Spring MVC Testing for basic controller testing, which can be extended to integration or end2end testing by using docker-compose.

## Getting Started

### Start locally with docker-compose

```bash
docker-compose up
```

### Run tests

```bash
mvn clean package -Dspring-boot.run.profiles=test
```

### Start locally without docker-compose

**Start DB with Docker**

```bash
docker run --name postgres_container -p 5455:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=db -d postgres
```

**Compile project**

```bash
mvn clean package
```

**Start project**

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```
