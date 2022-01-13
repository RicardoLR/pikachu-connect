
pokemon-convert
---------------

Client Rest -> Soap service


#### Run from dockerhub or with gradlew

```sh
$ docker run -it -p 8081:8081 -d openkuberich/pokemon-convert:v1

$ git clone https://github.com/RicardoLR/pikachu-connect
$ cd pikachu-connect
$ ./gradlew clean build
$ ./gradlew bootrun
```

#### Test endpoints Locally

```sh
$ sh local.test.sh
```

#### view data base "h2"

```sh
Go to -> http://localhost:8081/api/v1/pokemon/h2

> change url to "jdbc:h2:mem:testdb"

# select table
$ SELECT * FROM APP_TRACE 
```

### Tech

* [Spring boot 2.x](https://spring.io/projects/spring-boot)
* [Groovy 2.4.15](http://groovy-lang.org/)
* [Jaeger](https://www.jaegertracing.io/)
* [Jacoco](https://www.jacoco.org/jacoco/trunk/doc/)
* [Docker](https://docs.docker.com/)

### Requisitos

* java 8
* [Docker](https://docs.docker.com/install/)








