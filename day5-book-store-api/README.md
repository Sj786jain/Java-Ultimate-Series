# ✅ Day 5: Book Store API

🚀 This is the fifth project in my **Java Unlimited Series**.  
Here, I built a Spring Boot REST API for managing books in a store.

---

## 📌 Project Overview
- Add new books
- Update book details
- Delete books
- List all books
- Search books by title or author

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot**
- In-memory **HashMap** for storage (no DB yet)
- **REST API** with JSON responses

---

## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Add a new book |
| PUT | `/api/books/{id}` | Update book details |
| DELETE | `/api/books/{id}` | Delete a book |
| GET | `/api/books/search?title=abc` | Search books by title |