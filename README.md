

Overview

This sample project has following implementation:

Building backend REST implementation API :

	1> Listing of account(s) of a user. 2> Listing of transaction details of an account number.
  
  
 
Rest API endpoints
=====================

Method 1#  GetAccounts :: Request Type: GET

Request URL: http://localhost:8081/v1/account/{userId}

Sample URL : http://localhost:8081/v1/account/anz-user-test

Optional request parameters are :
Page number
Page Size

Other Sample URLs :

http://localhost:8081/v1/account/anz-user-test?page=0

http://localhost:8081/v1/account/anz-user-test?page=0&size=10

Method 2# GetTransactions :: Request type: GET

Request URL: http://localhost:8080/v1/account/{accountNumber}/transactions
Sample URL : http://localhost:8081/v1/account/100001/transactions

Optional request parameters are :

Page number

Page Size

Other Sample URLs :

http://localhost:8081/v1/account/100001/transactions?page=0

http://localhost:8081/v1/account/100001/transactions?page=0&size=10

Build / Deployment
=====================

1. Maven is used to build the project.

2. Deployment is done using Spring Boot's embeded Tomcat Apache Server.

 

You can follow the steps below in order to build and run this project in your local machine.

    Project can be cloned from the repository by executing following command in local machine using GIT tools: git clone xxxxxxx
    Run 'mvn clean package' from project root directory.
    Run the project using 'mvn spring-boot:run'.

Prerequisites/ Installation
================================

Following tools/plugins/technologies are used/required to implement, build and run this project.

    Java 1.8
    Spring Boot 2.1.5.RELEASE
	Swagger 2.9.2
	H2 DB
	flywaydb
    JSON
	Lombok
    Mockito API
    Unit test using JUnit
    JUnit code coverage using Jacoco
    Embedded Tomcat
    REST API using JSON request/response
    IntelliJ IDEA
    Github repository
    Windows 10

You need to install, configure and setup above in your system.


Design Specification
===============================
Spring boot Rest implementation

 

Running test(s)[End Point Testing and Mockito/Junit with 90% code coverage]
================================================================================

1. All unit test cases have been covered by using Mockito/Junit API.

2. Application can be tested using in-built Swagger plugin.

    URL : http://localhost:8081/swagger-ui.html

3. The application has been built with the following assumption(s):

   a. Account number is unique for the user.

   b. For creating account and transaction dataset, H2 in-memory database is used which loads the data on application start-up. 
    Refer sql files : 
    
       V1.0.0__create_tables.sql, V1.0.0__insert_data.sql
       
    H2 Database console can be accessed using below URL in browser :
    
      http://localhost:8081/h2
      
        jdbc url = jdbc:h2:mem:testdb, username = sa, password =
