# Bluebik-Global

# About
The goal of this project is to develop a bank application that supports multiple accounts with multiple users, and provides credit and debit functionality to users with appropriate balance limits. The application follows a modular approach with various components such as controllers, services, repositories, and models. The controllers provide Credit and Debit APIs to enable users to carry out credit and debit transactions. Meanwhile, the services are responsible for executing the necessary checks to ensure that the account balance remains within the permitted limits of 0 and 10 million for debit and credit operations, respectively. The repositories facilitate interaction with the database to store and retrieve account and user data, while the models define the entities for accounts and users, as well as their respective attributes.

# Tech Stack
Client: Java, SpringBoot, Spring Data JPA, Eureka Server, Microservices.

RDBMS: MySQL

Testing: Swagger

# Modules
Account Module
Transaction Module
User Module
Eureka Module

# Run Locally
Clone the project
git clone https://github.com/JavaDevShashwat/Bluebik-Global.git

Go to the project resources
src/main/resources and modify the MySQL login details in the application.properties file to match the system on which the application will be executed.

Run the main file
Eureka-Service/src/main/java/com/user/EurekaServiceApplication.java

Start the server
http://localhost:8888/swagger-ui/index.html#/
