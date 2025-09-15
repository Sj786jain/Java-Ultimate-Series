# ✅ Day 6: Combined API (Students + Courses + Books + Users)

🚀 This is the sixth project in my **Java Unlimited Series**.  
Here, I built a Spring Boot REST API combining Students, Courses, Books, and Users — all connected to a MySQL database.

---

## 📌 Project Overview
- Manage **Students**, **Courses**, **Books**, and **Users** in one API
- Perform full CRUD operations for each entity
- MySQL database integration using Spring Data JPA
- Pre-loaded data using `db.sql`

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (database)
- **REST API** with JSON responses

---

## 🔗 API Endpoints

### 🧑‍🎓 Students
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Add new student |
| PUT | `/api/students/{id}` | Update student details |
| DELETE | `/api/students/{id}` | Delete student |

### 📚 Courses
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/courses` | Get all courses |
| GET | `/api/courses/{id}` | Get course by ID |
| POST | `/api/courses` | Add new course |
| PUT | `/api/courses/{id}` | Update course details |
| DELETE | `/api/courses/{id}` | Delete course |

### 📖 Books
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Add new book |
| PUT | `/api/books/{id}` | Update book details |
| DELETE | `/api/books/{id}` | Delete book |

### 👤 Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Add new user |
| PUT | `/api/users/{id}` | Update user details |
| DELETE | `/api/users/{id}` | Delete user |