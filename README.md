# Simple Banking

This application was generated using SpringBoot , you can find documentation and help at https://spring.io/projects/spring-boot.


## Development

Before you can build this project, you must install and configure the following dependencies on your machine:
   * Docker
 
## Using Docker to creat DB
 
    sudo docker run -d --name BankEteration -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin postgres:latest
##### When running this docker code docker prepare a container which is containing a Postgres DB

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#using-boot-devtools)

