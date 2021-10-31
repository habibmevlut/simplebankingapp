# Simple Banking

This application was generated using SpringBoot , you can find documentation and help at https://spring.io/projects/spring-boot.


## Development

Before you can build this project, you must install and configure the following dependencies on your machine:
   * Docker
 
## Using Docker to creat DB
 
    sudo docker run -d --name BankEteration -p 5432:5432 -e POSTGRES_USER=BankEteration -e POSTGRES_PASSWORD=admin postgres:latest
##### When running this docker code docker prepare a container which is containing a Postgres DB.
  ![image](https://user-images.githubusercontent.com/13496352/139600125-dbb05596-65ab-47d9-945a-89edd9e561b9.png)
##### Then in this application I used Liquibase DB management technology, when project started all tables created automatically by Liquibase. As you can see.
DB properties
![image](https://user-images.githubusercontent.com/13496352/139600585-a7318e95-3780-4eb4-ae7c-810429692782.png)
![image](https://user-images.githubusercontent.com/13496352/139600638-c1e8db37-b0f3-4a64-b270-605de9010a3e.png)




### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#using-boot-devtools)

