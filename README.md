# SmartExpenseTrackerAPI

SmartExpenseTrackerAPI is a Spring Boot REST API project used to manage expenses, income, and monthly budgets.

The project allows users to:
- Add expenses and income
- Update and delete expenses
- View all expenses
- Search expenses by category
- Track budget limits
- Calculate total income, expense, and balance
- Use pagination
- Secure APIs using JWT Authentication

---

# Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT Authentication
- MySQL
- Maven
- Lombok
- Postman

---

# Features

## Expense APIs

### Add Expense

POST /expenses


Example JSON:

{
  "title": "Pizza",
  "amount": 500,
  "type": "EXPENSE",
  "category": "Food"
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

### Update Expense

PUT /expenses/{id}

---

### Delete Expense

DELETE /expenses/{id}

---

### Search By Category

GET /expenses/category/Food

---

### Pagination

GET /expenses/pagination?page=0&size=5


---

# Budget APIs

### Add Budget

POST /expenses/budget


Example JSON:

{
  "category": "Food",
  "amount": 5000,
  "month": 5,
  "year": 2026
}


---

# Authentication API

### Login

POST /auth/login?username=aryan

Returns JWT Token.

---

# Database Configuration

Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3307/smartexpensetracker
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

# How To Run Project

## 1. Clone Repository

git clone https://github.com/aryanpm28/SmartExpenseTrackerAPI.git

---

## 2. Open Project

Open project in:
- VS Code
- IntelliJ IDEA

---

## 3. Create MySQL Database

CREATE DATABASE smartexpensetracker;

---

## 4. Run Application

mvn spring-boot:run

OR run:

SmartExpenseTrackerApiApplication.java

---

# API Testing

Use Postman to test APIs.

Base URL:

http://localhost:8080

---

# Project Structure

src/main/java/com/example/SmartExpenseTrackerAPI
│
├── AuthController.java
├── Budget.java
├── BudgetRepository.java
├── Expense.java
├── ExpenseController.java
├── ExpenseDTO.java
├── ExpenseRepository.java
├── ExpenseService.java
├── GlobalExceptionHandler.java
├── JwtUtil.java
├── ResourceNotFoundException.java
├── SecurityConfig.java
├── SmartExpenseTrackerApiApplication.java
└── User.java

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

---

# Author

Aryan Patil
