Application Tracking System

A backend service for tracking job applications, built with Spring Boot. This project is a personal portfolio build focused on production-style backend patterns: layered architecture, persistent storage, and secured REST APIs.

Tech Stack
Language: Java
Framework: Spring Boot
Build Tool: Gradle
Persistence: Spring Data JPA
Database: PostgreSQL
Security: Spring Security
Testing: MockMvc, unit tests
Features
CRUD API for managing job application records
PostgreSQL-backed persistence via Spring Data JPA
Secured endpoints using Spring Security
Layered architecture (Controller → Service → Repository)
Roadmap
GraphQL API — expose application data via a GraphQL endpoint alongside/instead of REST
Spring AI — integrate Spring AI for AI-assisted features (e.g., application summarization, smart tagging, or status insights)
Getting Started
Prerequisites
Java (JDK 17+ recommended)
PostgreSQL running locally or accessible via connection string
Gradle (or use the included Gradle wrapper)
Setup
Clone the repository
Configure your PostgreSQL connection in src/main/resources/application.properties (or application.yml):
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<your_db_name>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
Build the project:
bash
./gradlew build
Run the application:
bash
./gradlew bootRun
Authentication

This project uses Spring Security. By default, Spring Boot auto-configures HTTP Basic Auth with a generated password printed to the console at startup:

Using generated security password: <generated-uuid>

Use this alongside username user when testing endpoints (e.g., in Postman, set Authorization type to Basic Auth). A custom SecurityFilterChain / JWT-based auth is planned as the project evolves.

API Overview

Update this section with actual endpoints as they're finalized.

Method	Endpoint	Description
GET	/applications	List all job applications
GET	/applications/{id}	Get a single application by ID
POST	/applications	Create a new application record
PUT	/applications/{id}	Update an existing application
DELETE	/applications/{id}	Delete an application record
Project Structure
src/main/java/.../
├── controller/   # REST controllers
├── service/      # Business logic
├── repository/   # Spring Data JPA repositories
├── model/        # Entity classes
└── config/       # Security and app configuration