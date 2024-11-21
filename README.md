# GrowWealth Backend Project README

# Overview
The GrowWealth Backend is a Spring Boot application designed to manage user data and provide real-time market information for the front-end application {GrowWealthUI}.
 This README provides essential information for setting up, understanding, and contributing to the project.

# Key Features

- User authentication and management
- Real-time market data integration using Polygon.io API
- Secure password storage with BCryptPasswordEncoder

# Future Development
- Expanded Data Integration: The backend will be integrated with additional APIs for managing various asset types such as Business Holdings, Real Estate, etc.
- User Profile Management: The app will support user profile editing and other personalized features.
- JWT Authentication: Future updates may include the addition of JWT for stateless authentication and better user session management.
- Deployment: This backend will be deployed on a cloud platform (e.g., Heroku or AWS), and continuous integration will be set up for automated testing and deployment.


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


# Deployment
- This application is ready to be deployed on a cloud server or local server.
- Instructions for deployment will be added once ready to go live.
- For local development, ensure that you have MySQL installed and configured correctly. You can then deploy this Spring Boot application using Gradle.

# Security
- The application uses Spring Security for user authentication. Passwords are securely stored using BCryptPasswordEncoder to ensure that user credentials are never stored in plaintext.
- CSRF protection is disabled to allow the front-end React app to interact without additional headers.
- CORS configuration is enabled for local development (allowing requests from http://localhost:3000).

# Contribution Guidelines
Fork the repository and create a pull request for contributions.
Follow coding standards and guidelines.

# License
This project is licensed under the MIT License.
--------------------------------------------------------------------------------------------------------------------
Fork and let me know what you think 
