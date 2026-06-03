# Quiz App - Microservices Architecture

A distributed Spring Boot backend application for managing questions and playing quizzes. This project was recently re-architected from a monolithic structure to a microservices architecture using Spring Cloud.

## 🚀 Architecture Overview
The application is broken down into independent, scalable services:
* **Service Registry (Eureka):** Acts as a central directory for the microservices. All services register themselves here, allowing for dynamic service discovery.
* **API Gateway:** A centralized entry point (built with Spring Cloud Gateway) that routes incoming client requests to the appropriate underlying microservice.
* **Question Service:** Manages the database operations for questions (adding, fetching, filtering by category).
* **Quiz Service:** Handles quiz generation, fetching, and scoring. It communicates declaratively with the Question Service using **OpenFeign** to fetch necessary data.

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot
* **Microservices:** Spring Cloud (Netflix Eureka, Spring Cloud Gateway, OpenFeign)
* **Database Access:** Spring Data JPA / Hibernate
* **Utilities:** Lombok

## ✨ Features
* **Decoupled Logic:** Independent domain services that can scale and be maintained separately.
* **Service Discovery:** Automatic registration and resolution of service instances via Eureka.
* **API Routing:** Clean and manageable endpoint routing through a single Gateway.
* **Synchronous Inter-Service Communication:** Seamless data fetching between the Quiz and Question services using Feign Clients.

## 📂 Microservices Structure
Typically, a project like this is structured into separate modules or repositories:
* `service-registry/`: The Eureka Server application.
* `api-gateway/`: The API Gateway application.
* `questionservice/`: Manages `/question/**` endpoints and its own database context.
* `quizservice/`: Manages `/quiz/**` endpoints, evaluates scores, and utilizes Feign to interact with `questionservice`.

## ⚙️ Setup and Run Local Environment
1. Clone the repository:
   ```bash
   git clone https://github.com/Harsh-bot-1603/QuizApplication.git
   ```
2. Ensure you have **Java (JDK 17+)** and **Maven** installed.
3. Update the `application.properties` or `application.yml` files in both the `questionservice` and `quizservice` with your database connection details.
4. **Boot Sequence:** To ensure proper registration, start the applications in the following order:
   * **1. Service Registry** (typically runs on `http://localhost:8761`)
   * **2. API Gateway** 
   * **3. Question Service**
   * **4. Quiz Service**
5. Once everything is running, direct all your HTTP requests to the **API Gateway** port (e.g., `http://localhost:8080/question/allQuestions` or `http://localhost:8080/quiz/create`).
