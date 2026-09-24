# LMS DB App

A Maven Java application for working with the `lms_db` MySQL database using JDBC, prepared statements, DAO interfaces, DAO implementations, service interfaces, and service implementations.

## Database functionality

### Company CRUD

The Company module follows this layered design:

```text
CompanyClientApp
? CompanyService / CompanyServiceImpl
? CompanyDao / CompanyDaoImpl
? MySQL lms_db.company table
```

Available operations:

- List all companies
- Find a company by ID
- Insert a company
- Update a company
- Delete a company

All SQL uses `PreparedStatement` in `dao/impl/CompanyDaoImpl.java`.

### User insert

`UserDaoImpl` inserts users using a prepared statement into the `user` table.

### Database properties

Database settings are loaded from:

```text
src/main/resources/db.properties
```

Set your local MySQL password there before running database applications:

```properties
db.url=jdbc:mysql://localhost:3306/lms_db
db.username=root
db.password=your_mysql_password
```

`db.properties` is excluded from Git. Use `db.properties.example` as the template when cloning the project.

## IO Parser Assignment — September 24, 2026

The Student Import module demonstrates file parsing, inheritance through interfaces, runtime polymorphism, JDBC, and batch inserts.

Supported input files:

```text
students.csv  ? CsvStudentParser
students.xml  ? XmlStudentParser
students.json ? JsonStudentParser
```

Flow:

```text
StudentImportApp
? StudentParserFactory
? StudentParser interface
? CSV / XML / JSON parser implementation
? StudentService / StudentServiceImpl
? StudentDao / StudentDaoImpl
? lms_db.students table
```

`StudentDaoImpl` automatically creates the table when importing:

```sql
CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

### Run the parser assignment

1. Run `app/StudentSampleFilesApp.java` to create sample files in `C:\dover_data`.
2. Set `db.properties` with your MySQL password.
3. Run `app/StudentImportApp.java`.
4. The default import is `C:\dover_data\students.csv`.

To import another file, add a program argument:

```text
C:\dover_data\students.xml
```

or:

```text
C:\dover_data\students.json
```

## Run in Eclipse

1. Import as **Maven ? Existing Maven Projects**.
2. Right-click the Maven project ? **Maven ? Update Project**.
3. Run one of these classes:

```text
CompanyClientApp.java
app/StudentSampleFilesApp.java
app/StudentImportApp.java
```

## Package structure

```text
com.dovertraining.lmsdbapp
+-- app       Application entry points
+-- dao       DAO interfaces
+-- dao.impl  JDBC / PreparedStatement implementations
+-- models    Company, User, Role, Student models
+-- parsers   CSV, XML, and JSON student parsers
+-- services  Service interfaces
+-- services.impl
+-- utils     Database connection configuration
```
