# CRUD Operations Using JDBC

A Java-based application that demonstrates **CRUD (Create, Read, Update, Delete) operations** using JDBC (Java Database Connectivity) and an Oracle database. The project follows a repository-based approach to execute SQL queries and manage student records.

## 📌 Project Overview

This project demonstrates how Java applications interact with an Oracle database using JDBC. It allows users to insert, retrieve, update, and delete student records from a database table.

The project uses `PreparedStatement` for parameterized SQL queries and `ResultSet` to retrieve records.

## ✨ Features

- **Create:** Insert new student records into the database.
- **Read:** Fetch a student record using its ID.
- **Update:** Modify a student's name, email, and age using the student ID.
- **Delete:** Delete a student record using its ID.
- **Database Connectivity:** Connect Java to Oracle using `DriverManager`.
- **Prepared Statements:** Execute parameterized SQL queries.
- **Resource Management:** Use try-with-resources to close database resources automatically.
- **Row Mapping:** Convert database records into Java `Student` objects.

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- Oracle Database
- SQL
- Maven
- IntelliJ IDEA
- Git and GitHub

## 📂 Project Structure

```text
jdbcProject/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── App.java
│                   ├── model/
│                   │   └── Student.java
│                   └── repositery/
│                       └── StudentRepository.java
├── pom.xml
└── README.md
```

## 🗄️ Database Setup

### 1. Create the Database Table

Connect to your Oracle database using the appropriate database user, such as `HR`, and execute:

```sql
CREATE TABLE crudstudentEx11 (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE,
    age NUMBER(3)
);
```

### 2. Verify the Table

```sql
DESC crudstudentEx11;
```

### 3. Configure Database Connectivity

Update the connection details in `StudentRepository.java`:

```java
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String pass = "your_password";
```

Replace `your_password` with your actual Oracle database password.

**Note:** The JDBC URL above assumes an Oracle XE database using the `XE` service name. Change it if your Oracle installation uses a different service name.

## 🔄 CRUD Operations

### 1. Create — Insert a Student

```java
studrepo.createStudentUser(
    new Student(42L, "Vaibhav", "vaibhav@gmail.com", 73)
);
```

### 2. Read — Retrieve a Student

```java
studrepo.getStudentUser(8L);
```

The method retrieves a student by ID and maps the result into a `Student` object.

### 3. Update — Modify a Student

```java
studrepo.updateStudentUser(
    new Student("Arjun", "arj@gmail.com", 19),
    8L
);
```

This updates the name, email, and age of the student whose ID is `8`.

### 4. Delete — Remove a Student

```java
studrepo.deleteStudentUser(8L);
```

This deletes the student record with ID `8`.

**Important:** These are example calls. Ensure the IDs and email addresses are appropriate for your existing database records. The email column is unique, so duplicate email values are rejected.

## ▶️ How to Run the Project

1. Install a compatible JDK and Oracle Database.
2. Open the project in IntelliJ IDEA.
3. Configure the Oracle JDBC dependency in `pom.xml`.
4. Create the `crudstudentEx11` table in Oracle.
5. Update the database URL, username, and password.
6. Open `App.java`.
7. Uncomment the CRUD method you want to test.
8. Run the `App` class and check the console output.

## 💡 Key Concepts Demonstrated

- JDBC connection using `DriverManager`
- `Connection`, `PreparedStatement`, `Statement`, and `ResultSet`
- Parameterized SQL queries
- SQL `INSERT`, `SELECT`, `UPDATE`, and `DELETE`
- Java constructors, encapsulation, getters, and setters
- Repository and model classes
- Exception handling using `SQLException`
- Automatic resource management using try-with-resources

## 🚀 Future Improvements

- Implement a menu-driven console interface.
- Add input validation and better exception handling.
- Implement retrieval of all student records.
- Add logging instead of relying only on console messages.
- Move database credentials into configuration files or environment variables.
- Add unit tests for repository methods.
 

 
