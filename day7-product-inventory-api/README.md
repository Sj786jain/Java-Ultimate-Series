# ✅ Day 7: Product Inventory API

🚀 This is the seventh project in my **Java Unlimited Series**.  
I built a Product Inventory REST API using Spring Boot, Spring Data JPA and MySQL.

---

## 📌 Features
- Create, read, update, delete products (CRUD)
- Pagination & sorting for list endpoint
- Search by name (partial, case-insensitive)
- Filter by category (paged)
- Low-stock listing (threshold)
- Adjust stock (add/subtract quantity)
- Validation on create/update requests
- Exception handling with clear error responses

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Data JPA** (Hibernate)
- **MySQL**
- **Jakarta Validation**

---

## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/products` | List products (supports `page`, `size`, `sortBy`, `sortDir`) |
| GET | `/api/v1/products/{id}` | Get product by id |
| POST | `/api/v1/products` | Create product |
| PUT | `/api/v1/products/{id}` | Update product |
| DELETE | `/api/v1/products/{id}` | Delete product |
| GET | `/api/v1/products/search?name=...` | Search by name |
| GET | `/api/v1/products/category/{category}` | Get products by category |
| GET | `/api/v1/products/lowstock?threshold=10` | Get low stock items |
| PATCH | `/api/v1/products/{id}/adjust-stock?delta=-5` | Adjust stock by delta |