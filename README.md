# Enterprise Level Web Application
An enterprise level Spring Boot web application built using Java 17, Spring Framework 3.5, and Gradle. The application includes full CRUD functionality, API documentation via Swagger, in memory and production ready database support, containerized deployment, and robust unit testing.

## Tech Stack
Language: Java 17
Framework: Spring Boot 3.5
Build Tool: Gradle
IDE: Eclipse IDE
Database: H2 (Development), MariaDB (Production)
API Documentation: Swagger
Testing: JUnit 5
API Testing:  Postman
Containerization: Docker

##  Getting Started
### Prerequisites
Java 17
Gradle
Docker
Eclipse IDE (optional)
MariaDB (for production)
Postman (for API testing)

###  Project Setup
Clone the Repository: git clone https://github.com/pavan110201/Tech_Store.git
Build the Application: ./gradlew clean build
Run Locally with H2: ./gradlew bootRun
Access Swagger UI: 
Navigate to: http://localhost:8080/swagger-ui/index.html

### Docker Deployment
Build Docker Image for Database: docker run --name techdb -e MYSQL_ROOT_PASSWORD=your_pwd -e MYSQL_ DATABASE=techdb mariadb
Run the following command to build the Docker image: docker build -t techstorebackend
Run our Spring Boot container and link the MariaDB container: docker run -p 8080:8080 --name techapp --link techdb:mariadb -d  techwarehousebackend
For production, ensure your MariaDB container is running and update the application properties.yml.

### Testing
Run unit tests with: ./gradlew test

### Database Configuration:
For Development:
Uses H2 in-memory database by default.
Accessible at: http://localhost:8080/h2-console
Credentials: defined in application.yml

For Production:
Update your application-prod.yml with MariaDB credentials and JDBC URL.

### API Documentation:
Swagger UI: http://localhost:8080/swagger-ui/index.html
OpenAPI Docs: http://localhost:8080/v3/api-docs



















