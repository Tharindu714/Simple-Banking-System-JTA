# 🏦 Simple Banking System with JTA

> A lightweight Java EE backend demonstrating account management and transaction processing with Java Transaction API (JTA).

---

## 📑 Table of Contents

1. [✨ Project Overview](#-project-overview)
2. [📂 Source Structure](#-source-structure)
3. [🛠️ Tech Stack & Dependencies](#️-tech-stack--dependencies)
4. [🚀 Getting Started](#-getting-started)

   * [Prerequisites](#-prerequisites)
   * [Clone & Build](#-clone--build)
   * [Deploy & Run](#-deploy--run)
5. [🔧 Configuration](#-configuration)
6. [📋 REST API Endpoints](#-rest-api-endpoints)
7. [🔄 Transaction Management](#-transaction-management)
8. [🛡️ Error Handling & Validation](#️-error-handling--validation)
9. [📚 Testing](#-testing)
10. [🤝 Contribution](#-contribution)
11. [📜 License](#-license)

---

## ✨ Project Overview

This backend template illustrates a **Simple Banking System** built on Java EE, using **JTA** for managing distributed transactions. It supports:

* **Account Creation**
* **Deposit & Withdrawal**
* **Balance Inquiry**
* **Transaction History**

The system is packaged as a WAR and deploys to any Java EE-compliant server (WildFly, GlassFish, JBoss EAP) with JTA support.

---

## 📂 Source Structure

```
src/main/java/
└── com/yourdomain/banking/
    ├── entity/            # JPA entities (Account, Transaction)
    ├── repository/        # DAO layer using EntityManager
    ├── service/           # Business logic, annotated @Transactional
    ├── resource/          # JAX-RS or Servlet-based API controllers
    ├── config/            # JTA & DataSource configuration
    └── util/              # Validation & helper classes
src/main/resources/
├── META-INF/
│   └── persistence.xml   # JPA persistence unit & JTA settings
├── application.properties # Datasource & JTA properties
└── logback.xml           # Logging configuration
```

---

## 🛠️ Tech Stack & Dependencies

* **Java EE / Jakarta EE**
* **JTA (Java Transaction API)**
* **JPA (Hibernate)**
* **Maven**
* **WildFly / GlassFish** (application server)
* **H2 / MySQL / PostgreSQL** (configurable via JDBC)
* **SLF4J & Logback**
* **JUnit 5 & Arquillian** (for integration testing)

---

## 🚀 Getting Started

### Prerequisites

* JDK 11+
* Maven 3.6+
* Java EE–compliant server (WildFly 21+, GlassFish 5+)
* Git

### Clone & Build

```bash
# Clone repository
git clone https://github.com/Tharindu714/Simple-Banking-System-JTA.git
cd Simple-Banking-System-JTA

# Build WAR
gradlew clean build  # or mvn clean package
```

### Deploy & Run

1. Copy `target/banking-jta.war` to your server’s `deployments/` directory.
2. Start (or restart) the server.
3. Access base URL: `http://localhost:8080/banking-jta/api/v1/`

---

## 🔧 Configuration

### `persistence.xml`

```xml
<persistence-unit name="BankPU" transaction-type="JTA">
  <jta-data-source>java:/jdbc/BankDS</jta-data-source>
  <class>com.yourdomain.banking.entity.Account</class>
  <class>com.yourdomain.banking.entity.Transaction</class>
  <properties>
    <!-- Hibernate dialect, show SQL, etc. -->
  </properties>
</persistence-unit>
```

### `application.properties`

```properties
# DataSource config
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/bankdb
db.user=root
db.password=YourPass

# JTA Settings
ejb.transaction.timeout=300
```

---

## 📋 REST API Endpoints

| Method | Endpoint                             | Description              |
| ------ | ------------------------------------ | ------------------------ |
| POST   | `/api/v1/accounts`                   | Create new bank account  |
| GET    | `/api/v1/accounts/{id}`              | Get account details      |
| POST   | `/api/v1/accounts/{id}/credit`       | Deposit funds            |
| POST   | `/api/v1/accounts/{id}/debit`        | Withdraw funds           |
| GET    | `/api/v1/accounts/{id}/transactions` | List transaction history |

**Payload Example (credit/debit):**

```json
{ "amount": 100.0 }
```

---

## 🔄 Transaction Management

* **Container-Managed:** Services annotated with `@Transactional` use JTA to ensure ACID compliance.
* **Propagation & Isolation:** Default settings (`REQUIRED`, `READ_COMMITTED`); override via annotation attributes.
* **Distributed Transactions:** If integrating JMS or other XA resources, they will participate in the same JTA scope.

---

## 🛡️ Error Handling & Validation

* **Bean Validation (JSR-380):** Entities & DTOs annotated with `@NotNull`, `@Min`, etc.
* **Exception Mappers:** Clean JSON error responses with HTTP status codes (400, 404, 500).

---

## 📚 Testing

* **Unit Tests:** JUnit 5 for service-layer logic.
* **Integration Tests:** Arquillian to deploy WAR to embedded container and test JAX-RS endpoints.

---

## 🤝 Contribution

1. Fork the repo ➡️ create feature branch
2. Commit with clear messages
3. Open a Pull Request against `main`

Please adhere to coding standards and include tests for new features.

---

## 📜 License

MIT © 2025 Tharindu714

---

> ⚙️ Built with JTA & ❤️ by Tharindu714
