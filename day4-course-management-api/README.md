✅ Day 4: Course Management API

🚀 This is the fourth project in my Java Unlimited Series.
Here, I built a Spring Boot REST API for managing courses.

📌 Project Overview

Add new courses
Update course details
Delete courses
Search courses by name
List all courses

🛠 Tech Stack

Java 17
Spring Boot
In-memory ArrayList for storage (no DB yet)

REST API with JSON responses

🔗 API Endpoints
Method	Endpoint	Description
GET	/api/courses	Get all courses
GET	/api/courses/{id}	Get course by ID
POST	/api/courses	Add a new course
PUT	/api/courses/{id}	Update course details
DELETE	/api/courses/{id}	Delete a course
GET	/api/courses/search?name=abc	Search courses by name