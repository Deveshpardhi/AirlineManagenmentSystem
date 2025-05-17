# Airline Management System

## 🚀 Project Overview

This is a Spring Boot-based Airline Management System that provides a platform for managing flight bookings, passenger details, and other airline operations. It is containerized with Docker and has an automated CI/CD pipeline using GitHub Actions.

## 🌐 Features

* Manage flights and passengers.
* Book, cancel, and view bookings.
* Real-time updates for flight statuses.
* Secure login and authentication system.
* Integrated Docker support for easy deployment.
* Automated CI/CD with GitHub Actions.

## 🛠️ Technologies Used

* **Backend:** Java, Spring Boot, Spring MVC, Spring Security
* **Database:** MySQL
* **Containerization:** Docker
* **CI/CD:** GitHub Actions
* **Build Tool:** Maven
* **Java Version:** OpenJDK 17

## 🚀 Getting Started

### Prerequisites

* Docker installed on your system.
* Java 17 installed.
* Maven installed.
* Git installed.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YourUsername/AirlineManagementSystem.git
   cd AirlineManagementSystem
   ```

2. Build the Docker image:

   ```bash
   docker build -t springboot-app .
   ```

3. Run the Docker container:

   ```bash
   docker run -p 8080:8080 springboot-app
   ```

4. Access the application in your browser:

   ```
   http://localhost:8080
   ```

## 🚦 CI/CD Pipeline

* The project uses GitHub Actions for CI/CD.
* The pipeline is triggered on every push or pull request to the `main` or `master` branch.
* It automatically builds the project using Maven and runs test cases.

## 📂 Project Structure

```
├── src/main/java/com/example/airlinemanagementsystem
│   └── controllers
│   └── models
│   └── services
├── src/test/java/com/example/airlinemanagementsystem
│   └── AirlineManagementSystemApplicationTests.java
├── Dockerfile
├── pom.xml
└── README.md
```

## 🚀 Contributing

1. Fork the repository.
2. Create a new branch (`feature/your-feature-name`).
3. Make your changes and commit them.
4. Push to your branch.
5. Create a pull request.

## 📄 License

This project is licensed under the MIT License.
