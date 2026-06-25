# StudentManagementSystem

A simple Java-based Student Management System demonstrating CRUD operations using JDBC and MySQL. Suitable as a small portfolio project for resumes and GitHub.

## Features
- Add, update, delete, and view student records
- JDBC-based persistence with prepared statements
- DAO pattern for separation of concerns (src/StudentDAO.java)

## Tech Stack
- Java (JDK 8+)
- MySQL (or compatible relational DB)
- JDBC (MySQL Connector/J)

## Project Structure
- src/ — Java source files (Main.java, Student.java, StudentDAO.java, DBConnection.java)

## Prerequisites
- Java JDK installed
- MySQL server running
- MySQL Connector/J (JAR) available on your machine

## Database Setup
Create a database and table (example):

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150),
  phone VARCHAR(20)
);
```

Update the DB connection details in src/DBConnection.java to match your credentials.

## Build & Run (example)
Replace `path\\to\\mysql-connector-java.jar` with the actual path to the connector JAR on Windows.

```powershell
javac -cp ".;path\\to\\mysql-connector-java.jar" -d bin src\\*.java
java -cp "bin;path\\to\\mysql-connector-java.jar" Main
```

Or run from an IDE (IntelliJ/VS Code) — add the Connector/J jar to the project's classpath.

## Usage
- Follow the console prompts in Main to add, update, delete, or list students.

## Notes for Resume / Interview (TCS)
- Demonstrates OOP, JDBC, and use of the DAO pattern for clean separation of concerns.
- Shows end-to-end development: database design, Java backend, and error handling.
- Good talking points: prepared statements for SQL injection prevention and connection handling strategy.

## Next Steps
- Add input validation and unit tests
- Add a simple GUI or web front-end

---
Created for demonstration and portfolio use.
