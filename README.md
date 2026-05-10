# SmartExpenseTrackerAPI

SmartExpenseTrackerAPI is a simple Spring Boot REST API project used to manage daily expenses and budget records.

This project helps users:
- Add expenses
- View all expenses
- Get expense by ID
- Delete expenses
- Manage budget limits

---

# Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

---

# Project Structure

src/main/java
│
├── controller
├── service
├── repository
├── entity
├── dto
└── exception

---

# Features

## Expense APIs

### Add Expense

POST /expenses

Example JSON:

{
  "title": "Food",
  "amount": 500,
  "category": "Restaurant",
  "date": "2026-05-07"
}

---

### Get All Expenses

GET /expenses

---

### Get Expense By ID

GET /expenses/{id}

Example:

GET /expenses/1

---

### Delete Expense

DELETE /expenses/{id}

---

# Budget APIs

### Add Budget

POST /budget

### Get Budget

GET /budget

---

# Database Configuration

Update application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3307/smartexpensetracker
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

# How to Run Project

## 1. Clone Repository

git clone https://github.com/aryanpm28/SmartExpenseTrackerAPI.git

---

## 2. Open Project

Open project in:
- IntelliJ IDEA
OR
- VS Code

---

## 3. Configure MySQL

Create database:

CREATE DATABASE smartexpensetracker;

---

## 4. Run Application

Run:

mvn spring-boot:run

OR run main class:

SmartExpenseTrackerApiApplication.java

---

# API Testing

Use Postman to test APIs.

Base URL:

http://localhost:8080

---

# Project Flow

Client Request
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
MySQL Database

# Author

Aryan Patil
