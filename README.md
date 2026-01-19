# Springboot Todo Application

Java Rest API made with the Spring Boot framework.  
The application exposes a REST API and server-side rendered views following the MVC (Model–View–Controller) design pattern.

<img width="1920" height="962" alt="image" src="https://github.com/user-attachments/assets/f759ffe6-d850-4a45-b511-6c1932a114ac" />

---

## 📝 Spring Boot Todo App

**This project is a Todo application built with Spring Boot, designed to practice and demonstrate backend fundamentals using clean architecture, RESTful APIs, and server-side rendering following the MVC design pattern.**

The application exposes a REST API for managing todos and also provides Thymeleaf-based views to present the data in a traditional web interface. The backend communicates directly with a PostgreSQL database using JDBC, allowing full control over SQL queries and data mapping.

---

_see how to run near the end_

## 🚀 What this project demonstrates

- Building a RESTful API with Spring Boot using proper HTTP methods (GET, POST, PUT, DELETE)
- Applying the MVC (Model–View–Controller) pattern with a clear separation between:
  - API controllers
  - View controllers
  - Service and repository layers
- Using JDBC with Spring (JdbcTemplate) instead of an ORM to better understand:
  - SQL queries
  - Result mapping with RowMapper
  - Database transactions and error handling
- Integrating PostgreSQL for persistent data storage
- Rendering dynamic HTML pages using Thymeleaf
- Organizing the codebase using a clean, layered architecture

---

## 📌 Features

- Create, read, update, and delete todos
- REST API endpoints for programmatic access
- Server-side rendered views for visual interaction

### Todo fields


Todo fields include:

```
id

title

completed

created_at
```

---

__This project was built as a learning-focused application, emphasizing understanding how Spring Boot works under the hood—especially request handling, database access with JDBC, and MVC-based rendering—rather than relying on high-level abstractions._

---

### How to run

Spring Boot Todo Application
A simple Todo application built with Spring Boot, exposing a REST API and server-side rendered
views using the MVC (Model–View–Controller) pattern.

Tech Stack
- Java 21
- Spring Boot
- Spring JDBC (JdbcTemplate)
- PostgreSQL
- Thymeleaf

Running the Application Locally:

1. Prerequisites
- Java 21
- Maven
- PostgreSQL

2. Start PostgreSQL and create the database
CREATE DATABASE todo_db;

3. Configure database connection
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/todo_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_password

4. Run the application
mvn spring-boot:run

5. Access the application
Web interface: http://localhost:8080/todos
REST API endpoints:
- GET /todos
- POST /todos
- PUT /todos/{id}
- DELETE /todos/{id}

6. Test the API
curl http://localhost:8080/todos

Notes
- PostgreSQL must be running before the application starts
- Database tables are created automatically on startup
- JDBC is used intentionally instead of JPA/Hibernate
