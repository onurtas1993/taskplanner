# Task Planner API

A simple REST API for creating, listing, updating, and deleting tasks. Built with Java 25, Spring Boot, Spring Data JPA, and an in-memory H2 database.

## Run locally

Requirements: Java 25.

```bash
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run`. The API starts at `http://localhost:8080`.

## Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/v1/tasks` | List tasks |
| `POST` | `/api/v1/tasks` | Create a task |
| `PUT` | `/api/v1/tasks/{taskId}` | Update a task |
| `DELETE` | `/api/v1/tasks/{taskId}` | Delete a task |

## Test

```bash
./mvnw test
```
