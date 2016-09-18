# Rest-Rent-API 

This project provides Backend APIs for properties rental websites , IOS and Android devices.

## Getting Started

### Prerequisites

- [Git](https://git-scm.com/) Source Code Management
- [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) JDK 1.8
- [Spring Boot](http://projects.spring.io/spring-boot/) Get App up and running as quickly as possible.
- [Maven 3](https://maven.apache.org/download.cgi) Maven Build Tool
- [Junit 4](http://junit.org/junit4/) Unit Testing Tool
- [Mysql](https://www.mysql.com/) - Databse
- [Swagger](http://swagger.io/swagger-ui/) - Swagger UI is a dependency-free collection of HTML, Javascript, and CSS assets that dynamically generate beautiful documentation and sandbox from a Swagger-compliant API.

### Run Test Cases

1. Run `mvn clean install` to install dependencies.

2. Run `mvn clean test` to run Junit test cases.

### Testing Coverage Report

Run `mvn jacoco:report` to generate the code coverage report after executing the unit test cases.
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/18-09-16/Jacoco.png)

### Run Rent Api Application
Run `mvn spring-boot:run` to start Rest Rent APi service. After server starting, type `http://localhost:8080/api/swagger-ui.html` to check the APIs in the Swagger Pages.
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/18-09-16/Swagger.PNG)


