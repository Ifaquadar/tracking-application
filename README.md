# Application Tracking System

A backend service for tracking job applications, built with Spring Boot. This project is a personal portfolio build focused on production-style backend patterns: layered architecture, persistent storage, and secured REST APIs.

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Gradle
- **Persistence:** Spring Data JPA
- **Database:** PostgreSQL
- **Security:** Spring Security (Basic Auth, configurable via environment variables)
- **HTTP Client:** Spring WebFlux (WebClient) — used for outbound AI API calls
- **AI Integration:** NVIDIA NIM API (Nemotron model) for AI-assisted features
- **Testing:** MockMvc, unit tests

## Features

- CRUD API for managing job application records
- PostgreSQL-backed persistence via Spring Data JPA
- Secured endpoints using Spring Security with configurable Basic Auth credentials
- AI-assisted application summarization via NVIDIA Nemotron integration
- Layered architecture (Controller → Service → Repository → Config → DTO)

## Roadmap

- [ ] **GraphQL API** — expose application data via a GraphQL endpoint alongside/instead of REST
- [ ] **Spring AI** — migrate AI integration to the Spring AI framework for a more standardized model-provider abstraction
- [ ] **JWT-based authentication** — replace Basic Auth with token-based auth
- [ ] **Role-based access control** — introduce distinct roles (e.g., `USER`, `ADMIN`) for finer-grained authorization

## Getting Started

### Prerequisites

- Java (JDK 17+ recommended)
- PostgreSQL running locally or accessible via connection string
- Gradle (or use the included Gradle wrapper)

### Setup

1. Clone the repository
2Build the project:
   ```bash
   ./gradlew build
   ```
4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

### Authentication

This project uses a custom Spring Security configuration (`SecurityConfig`) with HTTP Basic Auth.

**All endpoints (GET and POST alike) require authentication.** In Postman, set Authorization type to **Basic Auth** with your configured username/password. JWT-based auth is planned as the project evolves (see Roadmap).

### AI Integration (NVIDIA Nemotron)

The `/api/ai/summarize` endpoint uses NVIDIA's NIM API to generate AI-assisted summaries of job application text.

Set your NVIDIA API key before running:
```bash
export NVIDIA_API_KEY=nvapi-xxxxxxxxxxxxxxxxxxxx
```

Get a key from [build.nvidia.com](https://build.nvidia.com) by creating an account and generating a key from a Nemotron model's page.

## API Overview

> Update this section with actual endpoints as they're finalized.

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/applications` | List all job applications |
| GET    | `/applications/{id}` | Get a single application by ID |
| POST   | `/applications` | Create a new application record |
| PUT    | `/applications/{id}` | Update an existing application |
| DELETE | `/applications/{id}` | Delete an application record |
| POST   | `/api/ai/summarize` | Generate an AI summary of application text (NVIDIA Nemotron) |

## Project Structure

```
src/main/java/.../
├── controller/   # REST controllers
├── service/      # Business logic (incl. NemotronService)
├── repository/   # Spring Data JPA repositories
├── model/        # Entity classes
├── dto/          # Response DTOs (e.g., NemotronResponse)
└── config/       # Security (SecurityConfig) and app configuration
```

## License

Personal portfolio project — not currently licensed for external use.