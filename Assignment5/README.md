# Assignment 5 – Employee Analytics with Java Collections and Stream API

A Maven-based Java application that turns a list of employees into practical business analytics. The project uses the Java Collections Framework and Stream API to filter, transform, sort, aggregate, group, partition, and safely search employee data.

## Features

### Collections

- Stores 15 employees in a `List<Employee>`.
- Builds a `Set<String>` of unique employee locations and designations.
- Builds a `Map<Integer, Employee>` for direct lookup by employee ID.
- Uses `Map<String, List<Employee>>` and `Map<String, List<String>>` for department reports.

### Stream API operations

- `filter`, `map`, `mapToDouble`, `sorted`, `distinct`, `limit`, `skip`, `count`
- `min`, `max`, `sum`, `average`, `findFirst`, `anyMatch`, `allMatch`
- `Collectors.groupingBy`, `partitioningBy`, `counting`, `averagingDouble`, `maxBy`, `summarizingDouble`, and `joining`
- `Optional<Employee>` for safe employee searches

### Analytics included

- Employees by salary, department, location, and experience
- Highest paid, lowest paid, second highest paid, and top three paid employees
- Salary total and average
- Count and average salary by department
- Department salary summary statistics: count, total, average, minimum, maximum
- Highest paid employee per department
- Above-average earners
- Employees with names starting with a given prefix
- Location with the most employees
- Department with the highest average salary
- A complete employee analytics dashboard

## Project structure

```text
src/main/java/com/dovertraining/assignment5/
+-- model/Employee.java             Employee data model
+-- util/DataProvider.java          Sample data for 15 employees
+-- service/EmployeeService.java    Collections and Stream API operations
+-- app/EmployeeAnalyticsApp.java   Console application

src/test/java/com/dovertraining/assignment5/service/
+-- EmployeeServiceTest.java        JUnit 5 tests
```

## Run in Eclipse

1. **File ? Import ? Maven ? Existing Maven Projects**.
2. Select the `Assignment5` folder.
3. Open `EmployeeAnalyticsApp.java`.
4. Right-click ? **Run As ? Java Application**.

## Run tests

In Eclipse, right-click `EmployeeServiceTest.java` and select **Run As ? JUnit Test**.

With Maven installed:

```cmd
cd C:\Users\10097444\Desktop\DoverTraining\Assignment5
mvn test
```

## Sample data

The application contains 15 employees across IT, HR, Finance, and Sales, working in Bangalore, Chennai, Mumbai, Hyderabad, and Pune.
