# Springboot Todo Application
Java Rest API made with the Springboot framework, has a REST API and views for presenting data in the MVC design-pattern.

<img width="1920" height="962" alt="image" src="https://github.com/user-attachments/assets/f759ffe6-d850-4a45-b511-6c1932a114ac" />

<hr>

Check it out live [here]()

## 📝 Spring Boot Todo App

**This project is a Todo application built with Spring Boot, designed to practice and demonstrate backend fundamentals using clean architecture, RESTful APIs, and server-side rendering following the MVC design pattern.**

The application exposes a REST API for managing todos and also provides Thymeleaf-based views to present the data in a traditional web interface. The backend communicates directly with a PostgreSQL database using JDBC, allowing full control over SQL queries and data mapping.

### 🚀 What this project demonstrates

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
- Rendering dynamic HTML pages using Thymeleaf, passing data from controllers to views
- Organizing the codebase using a clean, layered architecture for maintainability and clarity

### 📌 Features

Create, read, update, and delete todos

REST API endpoints for programmatic access

Server-side rendered views for visual interaction

Todo fields include:

```
id

title

completed

created_at
```

<hr>

__This project was built as a learning-focused application, emphasizing understanding how Spring Boot works under the hood—especially request handling, database access with JDBC, and MVC-based rendering—rather than relying on high-level abstractions._
