# 🏥 Hospital Management System (Spring Boot Backend)

A secure RESTful backend built using Spring Boot for managing hospital operations including user authentication and patient records.

---

## 🚀 Features

* 🔐 User Authentication (Register & Login)
* 🛡️ JWT-based Security
* 👨‍⚕️ Patient Management (CRUD)
* 🗄️ MySQL Database Integration
* ⚙️ Layered Architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA (Hibernate)
* MySQL
* JWT (io.jsonwebtoken)
* Maven

---

## 📁 Project Structure

```
com.bridgelabz.hms
│
├── controller
│   ├── AuthController
│   └── PatientController
│
├── service
│   ├── AuthService
│   └── PatientService
│
├── repository
│   ├── UserRepository
│   └── PatientRepository
│
├── entity
│   ├── User
│   └── Patient
│
├── config
│   ├── JwtService
│   ├── JwtAuthenticationFilter
│   └── SecurityConfig
│
└── HmsApplication
```

---

## 🔑 API Endpoints

### 🔐 Auth APIs

| Method | Endpoint           | Description     |
| ------ | ------------------ | --------------- |
| POST   | /api/auth/register | Register user   |
| POST   | /api/auth/login    | Login & get JWT |

---

### 👨‍⚕️ Patient APIs (Protected)

| Method | Endpoint                 | Description       |
| ------ | ------------------------ | ----------------- |
| GET    | /api/patient/all         | Get all patients  |
| POST   | /api/patient/add         | Add patient       |
| GET    | /api/patient/{id}        | Get patient by ID |
| PUT    | /api/patient/update/{id} | Update patient    |
| DELETE | /api/patient/delete/{id} | Delete patient    |

---

## 🔐 Authentication

1. Register user
2. Login → get JWT token
3. Use token in requests:

```
Authorization: Bearer <your_token>
```

---

## ⚙️ Database Configuration

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Run the Application

```
mvn clean install
mvn spring-boot:run
```

---

## 🧪 Testing

* Use Postman
* Login → get JWT
* Add token in Authorization header
* Access protected APIs

---

## 📌 Author

Barnam Das

---

## 🏁 Status

✅ UC1–UC8 Completed
✅ JWT Security Implemented
✅ Full CRUD Working

---
