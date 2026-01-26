```springboot-todo-app```

# Spring Boot REST API using JDBC, PostgreSQL, and Jakarta Bean Validation

<img width="1920" height="962" alt="image" src="https://github.com/user-attachments/assets/f759ffe6-d850-4a45-b511-6c1932a114ac" /> <hr>
## 📝 Overview

This project is a RESTful Todo API built with Spring Boot 3.
It implements CRUD operations over a PostgreSQL database using Spring JDBC (JdbcTemplate) instead of an ORM.

The application follows a layered architecture separating controllers, services, repositories, and DTOs.
Incoming requests are validated using Jakarta Bean Validation before being processed.

## 🧱 Architecture

The project is structured as:

```Controller → Service → Repository → PostgreSQL```

---

| Layer | Responsibility |
|------|----------------|
| Controller | API endpoints, request validation, HTTP responses |
| Service | Business logic |
| Repository | SQL queries and JDBC access |
| DTOs | API request objects |
| Models | Database entities |

---

## 🗄 Database

PostgreSQL is used for persistence.

Table: todos

```
CREATE TABLE todos (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  completed BOOLEAN NOT NULL DEFAULT false,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

## 🔐 Validation

Request bodies are validated using Jakarta Bean Validation:

```

@NotBlank
@Size(min = 1, max = 100)
String title

```

Invalid requests return 400 Bad Request automatically.

## 📡 REST API

---

**Create Todo**

POST /api/todos

Request

```
{
  "title": "Learn Spring Boot"
}

```

Response — 201 Created

```
{
  "id": 1,
  "title": "Learn Spring Boot",
  "completed": false,
  "createdAt": "2026-01-26T14:32:10"
}
```

---

**Get All Todos**

GET /api/todos

Response — 200 OK

```
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "completed": false,
    "createdAt": "2026-01-26T14:32:10"
  }
]
```

---

**Get Todo by ID**

GET /api/todos/{id}

Response — 200 OK

```
{
  "id": 1,
  "title": "Learn Spring Boot",
  "completed": false,
  "createdAt": "2026-01-26T14:32:10"
}
```


Response — 404 Not Found
If the ID does not exist.

---

**Update Todo**

PUT /api/todos/{id}

Request

```
{
  "title": "Learn Spring Boot deeply",
  "completed": true
}
```


Response — 200 OK

```
{
  "id": 1,
  "title": "Learn Spring Boot deeply",
  "completed": true,
  "createdAt": "2026-01-26T14:32:10"
}
```

---

**Delete Todo**

DELETE /api/todos/{id}

Response — 204 No Content

## 🛠 How to run locally
**1. Requirements**

```
Java 17+

Maven

PostgreSQL
```

**2. Create database**
CREATE DATABASE todos_db;

**3. Configure Spring Boot**

```
application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/todos_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver

```

**4. Run the application**
mvn spring-boot:run


Server will start at:


```
http://localhost:8080

```

**5. Test API**

Example using curl:

```

curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Build a REST API"}'

```
