# EMBL-EBI Assessment

This project is to create REST API to manage person data. API layer provides stores, updates, retrieve and delete operations.

## Solved Problems
1. Unit test cases to ensure the API functionalities without installing locally.
2. Secure the APIs using basic authentication
3. Postman scripts to test the functionality
4. Swagger as API documentation

## Prerequisites
1. Java version 8 or higher
2. Java IDE (Spring Tool Suite, Eclipse or IntelliJ IDEA)
3. Apache Maven
4. H2 Database (as Memory DB)

## Installing
Clone or create Spring Boot project using the given repository

* Click on the project (e.g. embl-ebi) and select configure
* Select convert to maven project
* You can see the converted maven projects in the Project explorer section

(Update the database credentials in the application.properties file before build the embl-ebi project)

embl-ebi module developed as a Spring Boot application with Swagger UI.

## Running Unit Tests
There are few unit test cases have provided to test the APIs
You can access them in src/test/java package in the embl-ebi project

* First clean and build the embl-ebi project
* Go to the PersonControllerTest in src/test/java/
* Right click on test class, "Run as" > Junit test

Given test cases are provided to test all the person management API calls.

## Deployment and Run
Select the embl-ebi project and select Run As -> Spring Boot App

## Verify API functionalities
* Method 1: Using Swagger UI
    - Open a web browser and type http://localhost:8080/swagger-ui.html 
    embl-ebi swagger UI will be loaded in the browser.

* Method 2: Using Postman Scripts
    - Refer the Postman test scripts from project location <<Project-root>>/Resources/Test scripts
    Run the test scripts on Postman tool
    
## Verify Database Entries
Open H2 database console and type http://localhost:8080/h2-console
H2 database console login page will be loaded in the browser.
Use database credentials (*user: sa* and *password: sa*), test the connection click on **Test Connection** button and connect to the database using **Connect** button.

## Special Note
- Entire system architecture has developed in a way which provide loose coupling, scalability, easy maintenance and several other features.
- Authentication and authorization functionality need to be improved.
