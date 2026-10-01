# BlogNest

BlogNest is a RESTful Blog Management System built with Spring Boot. It provides APIs for managing users, categories, and blog posts with validation, exception handling, DTO-based request/response handling, and MySQL database integration.

## Features

* User Management

    * Create user
    * Get user by ID
    * Get all users
    * Update user
    * Delete user
    * Find user by email

* Category Management

    * Create category
    * Get category by ID
    * Get all categories
    * Update category
    * Delete category

* Post Management

    * Create post
    * Get post by ID
    * Get all posts
    * Update post
    * Delete post
    * Get posts by user
    * Get posts by category
    * Search posts

* Input validation using Jakarta Validation

* Global exception handling

* Custom application exceptions

* DTO-based API design

* Entity-to-DTO mapping using ModelMapper

* JPA/Hibernate database integration

* MySQL database

* Layered architecture

* Health check endpoint

## Tech Stack

| Technology         | Usage                 |
| ------------------ | --------------------- |
| Java 25            | Programming Language  |
| Spring Boot 4.1.1  | Backend Framework     |
| Spring Web         | REST APIs             |
| Spring Data JPA    | Data Access           |
| Hibernate          | ORM                   |
| MySQL              | Database              |
| ModelMapper        | Entity/DTO Mapping    |
| Jakarta Validation | Request Validation    |
| Lombok             | Boilerplate Reduction |
| Maven              | Build Tool            |

## Project Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

DTOs are used between the API layer and entity layer.

```text
Client
  ↓
Controller
  ↓
Request DTO
  ↓
Service
  ↓
Repository
  ↓
MySQL
  ↓
Entity
  ↓
Response DTO
  ↓
Client
```

## Project Structure

```text
BlogNest
├── src
│   ├── main
│   │   ├── java
│   │   │   └── in.codehidder.blognest.blognest
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── repository
│   │   │       └── service
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Database Configuration

BlogNest uses MySQL as its database.

Create the database:

```sql
CREATE DATABASE blog_app_db;
```

The application uses the following configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
```

The database password is read from the `DB_PASSWORD` environment variable instead of being hard-coded in the source code.

## Environment Variable

Before running the application, configure:

```text
DB_PASSWORD=your_mysql_password
```

### Windows PowerShell

```powershell
$env:DB_PASSWORD="your_mysql_password"
```

Then start the application.

## Running the Application

### Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate into the project:

```bash
cd BlogNest
```

### Configure Database

Create the MySQL database:

```sql
CREATE DATABASE blog_app_db;
```

Configure the `DB_PASSWORD` environment variable.

### Run using Maven Wrapper

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

The application runs on:

```text
http://localhost:4040
```

## API Overview

### User APIs

```text
POST   /users
GET    /users
GET    /users/{id}
PUT    /users/{id}
DELETE /users/{id}
```

### Category APIs

```text
POST   /categories
GET    /categories
GET    /categories/{id}
PUT    /categories/{id}
DELETE /categories/{id}
```

### Post APIs

```text
POST   /posts
GET    /posts
GET    /posts/{id}
PUT    /posts/{id}
DELETE /posts/{id}
```

Additional post operations include retrieving posts based on users/categories and searching posts.

> API paths may vary depending on the controller mappings in the current implementation.

## Validation and Exception Handling

BlogNest uses Jakarta Validation for validating incoming API requests.

Examples of validation include:

* Required fields
* Email validation
* String length validation
* Request data validation

The project also implements global exception handling using `@RestControllerAdvice`.

Custom exceptions include:

```text
UserAlreadyExistsException
DuplicateMobileNumberException
ResourceNotFoundException
```

Validation errors and application exceptions are returned through structured response DTOs.

## DTO Pattern

The application uses separate DTOs for API requests and responses.

Examples:

```text
UserRequestDto
UserResponseDto

CategoryRequestDto
CategoryResponseDto

PostRequestDto
PostResponseDto
```

This keeps the API layer independent from the database entities and provides better control over the data exposed through REST APIs.

## Health Check

BlogNest contains a health check endpoint to verify application/database availability.

```text
HealthController
    ↓
HealthService
```

## Future Enhancements

Planned improvements for the project may include:

* Spring Security authentication
* JWT-based authorization
* Role-based access control
* Pagination and sorting
* Advanced post search
* Comment management
* Like functionality
* Image/file upload
* Swagger/OpenAPI documentation
* Docker support
* Production deployment

## Author

**Mangesh Patil**

Java Backend Developer | Spring Boot | REST APIs | JPA/Hibernate | MySQL

