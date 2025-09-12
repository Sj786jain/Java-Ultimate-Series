# ✅ Day 3: Student Management API

🚀 This is the third project in my **Java Unlimited Series**.  
Here, I built a Spring Boot REST API for managing students.

---

## 📌 Project Overview
- Add new students
- Update student details
- Delete student
- Search by name
- List all students

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot**
- In-memory **ArrayList** for storage (no DB yet)
- **REST API** with JSON responses

---

## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Add a new student |
| PUT | `/api/students/{id}` | Update student details |
| DELETE | `/api/students/{id}` | Delete a student |
| GET | `/api/students/search?name=abc` | Search students by name |
