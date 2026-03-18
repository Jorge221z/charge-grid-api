# ⚡ ChargeGrid API 

ChargeGrid is a robust backend REST API built to manage an Electric Vehicle (EV) charging network. 
This project serves as the core infrastructure for tracking charging stations, managing their real-time statuses, and recording charging sessions.

## 🛠️ Tech Stack
* **Language:** Kotlin
* **Framework:** Spring Boot 3 / 4
* **Build Tool:** Gradle (Kotlin DSL)
* **Database:** PostgreSQL
* **Persistence:** Spring Data JPA (Hibernate)
* **Infrastructure:** Docker & Docker Compose

## 🚀 Features (MVP)
* **Station Management:** Register, update, and track physical EV charging stations.
* **Status Monitoring:** Real-time state management (`AVAILABLE`, `IN_USE`, `MAINTENANCE`).
* **Session Tracking:** Record charging sessions (start time, end time, and kWh consumed).

## 💻 Prerequisites
To run this project locally, you will need:
* **JDK 21** (e.g., Amazon Corretto 21)
* **Docker** & **Docker Compose** (for the database)
