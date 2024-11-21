# GrowWealth Backend Project README

# Overview
The GrowWealth Backend is a Spring Boot application designed to manage user data and provide real-time market information for the front-end application {GrowWealthUI}.
 This README provides essential information for setting up, understanding, and contributing to the project.

# Key Features

- User authentication and management
- Real-time market data integration using Polygon.io API
- Secure password storage with BCryptPasswordEncoder

# Future Development
- JWT Authentication: Planned for future releases to enhance security and enable stateless authentication.
- Integration of additional financial sections like Business Holdings, Real Estate, etc

# Related Projects
Front-end Repository: https://github.com/pmaan08/GrowWealthUI

# Technology Stack

- Java: Version `17`
- Spring Boot: '3.3.4'
- Build Tool: Gradle 
- Database: MySQL
- API Inetgration: Polygon.io for financial market data

# Setup and Installation
 
- In bash
### `git clone https://github.com/pmaan08/GrowWealth.git`

- Build the Project:
### `mvn clean install`

- Run the Application:
### `mvn spring-boot:run`

{[Note]: Set database connection details and API keys in application.properties}

# API Documentation

- Authentication Endpoints:
### `POST /api/signup`
### `POST /api/login`

- Data Fetching:
### `GET /api/clients`

# Contribution Guidelines
Fork the repository and create a pull request for contributions.
Follow coding standards and guidelines.

# License
This project is licensed under the MIT License.
--------------------------------------------------------------------------------------------------------------------
Fork and let me know what you think 
