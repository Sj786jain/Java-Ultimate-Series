# ✅ Day 8: Employee Directory API  

🚀 This is the eighth project in my **Java Unlimited Series**.  
I built an **Employee Directory REST API** with **pagination, sorting, and search**, plus a lightweight **Bootstrap frontend**.  

---

## 📌 Features  
- Create, read, update, delete employees (CRUD)  
- Pagination & sorting for employee listing  
- Search employees by name (partial, case-insensitive)  
- Simple Bootstrap frontend with add/delete/search/pagination  
- Validation on create/update requests  
- Exception handling with clear error responses  

---

## 🛠 Tech Stack  
- **Java 17**  
- **Spring Boot 3**  
- **Spring Data JPA** (Hibernate)  
- **MySQL**  
- **Jakarta Validation**  
- **Bootstrap 5 + Vanilla JS** frontend  

---

## 🔗 API Endpoints  

| Method | Endpoint | Description |  
|--------|----------|-------------|  
| GET | `/api/employees` | List employees (supports `page`, `size`, `sortBy`, `sortDir`, `name`) |  
| POST | `/api/employees` | Create employee |  
| DELETE | `/api/employees/{id}` | Delete employee |  

---

## 🖥 Frontend  

- Located in `src/main/resources/static/index.html`.  
- Built with **Bootstrap 5** + **Vanilla JS**.  
- Features:  
  - Add new employee form  
  - Delete employee button  
  - Search bar with live filter  
  - Paginated table with **Next** and **Previous** buttons  
