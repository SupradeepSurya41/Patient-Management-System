# Patient Management System — Java Spring Boot Microservices

A production-grade, cloud-ready Patient Management System built with Java and Spring Boot using a distributed microservices architecture. This project demonstrates advanced backend engineering skills across service design, inter-service communication, event-driven architecture, JWT security, and cloud infrastructure.

---

## Architecture Overview

The system is composed of five independently deployable microservices:

| Service | Role |
|---|---|
| **Patient Service** | REST CRUD API with PostgreSQL, gRPC client, Kafka producer |
| **Billing Service** | gRPC server for billing account management |
| **Auth Service** | JWT authentication with Spring Security |
| **Analytics Service** | Kafka consumer for real-time event processing |
| **API Gateway** | Unified entry point with JWT validation filter |

---

## Tech Stack

- **Java & Spring Boot** — Core framework for all services
- **Spring Cloud Gateway** — API Gateway and routing
- **Spring Security + JWT** — Stateless authentication & authorization
- **gRPC & Protocol Buffers** — Synchronous inter-service communication
- **Apache Kafka** — Asynchronous event streaming
- **PostgreSQL** — Relational persistence for Patient and Auth services
- **AWS CDK + LocalStack** — Infrastructure as code, locally emulated
- **Docker** — Containerized deployment for all services
- **Maven** — Build and dependency management

---

## Services

### Patient Service
- Full CRUD REST API for patient records
- Communicates with Billing Service via gRPC on patient creation
- Publishes patient events to Kafka using Protobuf serialization
- PostgreSQL-backed with JPA/Hibernate

### Billing Service
- gRPC server implementing the billing contract defined in `.proto` files
- Creates billing accounts when new patients are registered

### Auth Service
- Login endpoint returning signed JWT tokens
- Token validation endpoint consumed by the API Gateway
- BCrypt password hashing, Spring Security configuration
- PostgreSQL-backed user store

### Analytics Service
- Kafka consumer subscribed to patient event topics
- Deserializes Protobuf messages for downstream analytics processing

### API Gateway
- Routes all incoming traffic to appropriate microservices
- Enforces JWT validation via a custom `GatewayFilterFactory`

---

## Running Locally

Each service has its own `Dockerfile`. Set the required environment variables per service before running.

### Patient Service ENV
```
BILLING_SERVICE_ADDRESS=billing-service
BILLING_SERVICE_GRPC_PORT=9005
SPRING_DATASOURCE_URL=jdbc:postgresql://patient-service-db:5432/db
SPRING_DATASOURCE_USERNAME=admin_user
SPRING_DATASOURCE_PASSWORD=password
SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_SQL_INIT_MODE=always
```

### Auth Service ENV
```
SPRING_DATASOURCE_URL=jdbc:postgresql://auth-service-db:5432/db
SPRING_DATASOURCE_USERNAME=admin_user
SPRING_DATASOURCE_PASSWORD=password
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_SQL_INIT_MODE=always
```

---

## Key Engineering Highlights

- Designed and implemented both **synchronous (gRPC)** and **asynchronous (Kafka)** communication patterns within the same system
- Built **JWT authentication from scratch** with gateway-level enforcement across all protected routes
- Provisioned cloud infrastructure using **AWS CDK** deployed locally via **LocalStack**
- Wrote **integration tests** covering end-to-end auth and patient workflows
- Applied **DTO-based data contracts**, global exception handling, and input validation throughout

---

## Author

**Supradeep Surya**
- GitHub: [@SupradeepSurya41](https://github.com/SupradeepSurya41)

> *Built by following a Java/Spring microservices course and customized with personal modifications. Original course by Chris Blakely.*
