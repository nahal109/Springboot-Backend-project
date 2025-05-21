# Springboot-Backend-project

## Overview
This project is a backend application built with Spring Boot. It follows a clear layered structure and includes important features like creating, reading, updating, and deleting data (CRUD). It supports
pagination, transaction management, and handles errors, exceptions, response  properly. The project connects to databases MySQL using Hibernate. API documentation is done with Swagger
and postman. This project shows industry level best practices. 

## Features
- Standard Spring MVC layered architecture
- CRUD operations with repository and service layers
- Model mapping using ModelMapper and MapStruct
- Pagination and non-paginated GET methods
- Transaction management using `@Transactional`
- Enum type handling
- JSON data handling
- Swagger/postman API integration for documentation
- Exception handling with custom exceptions
- Custom native queries using Spring Data JPA
- Hibernate mappings (One-to-One, One-to-Many, Many-to-One)
- Use of ResponseEntity for HTTP responses
- Random ID generation for entities
- Business logic implementation at the service layer
- Support for MySQL databases

## Technology Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- MySQL
- ModelMapper / MapStruct
- Swagger/postman
- Maven (depending on build tool)
- Lombok (optional for boilerplate code reduction)

