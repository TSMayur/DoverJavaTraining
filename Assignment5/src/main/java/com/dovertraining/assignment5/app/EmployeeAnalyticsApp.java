package com.dovertraining.assignment5.app;

import java.util.List;

import com.dovertraining.assignment5.model.Employee;
import com.dovertraining.assignment5.service.EmployeeService;
import com.dovertraining.assignment5.util.DataProvider;

public class EmployeeAnalyticsApp {
    public static void main(String[] args) {
        List<Employee> employees = DataProvider.employees();
        EmployeeService service = new EmployeeService();

        System.out.println("All employees: " + employees);
        System.out.println("Find 103 (loop): " + service.findEmployeeByIdLoop(employees, 103));
        System.out.println("Find 103 (stream): " + service.findEmployeeById(employees, 103));
        System.out.println("Unique locations: " + service.uniqueLocations(employees));
        System.out.println("Map lookup 108: " + service.employeeMap(employees).get(108));
        System.out.println("Salary > 80000: " + service.salaryAbove(employees, 80000));
        System.out.println("IT employees: " + service.byDepartment(employees, "IT"));
        System.out.println("Bangalore employees: " + service.byLocation(employees, "Bangalore"));
        System.out.println("Names: " + service.employeeNames(employees));
        System.out.println("Uppercase names: " + service.uppercaseNames(employees));
        System.out.println("Salary descending: " + service.sortBySalary(employees, true));
        System.out.println("Department then salary: " + service.sortByDepartmentThenSalary(employees));
        System.out.println("Partition experience > 5: " + service.partitionByExperience(employees, 5));
        System.out.println("Highest paid IT: " + service.highestPaidInDepartment(employees, "IT"));
        System.out.println("Second highest paid: " + service.secondHighestPaid(employees));
        System.out.println("Names starting A: " + service.namesStartingWith(employees, "A"));
        System.out.println("Salary 70000 to 100000: " + service.salaryBetween(employees, 70000, 100000));
        System.out.println("Top 3 IT: " + service.topItEmployees(employees, 3));
        System.out.println("Unique designations: " + service.uniqueDesignations(employees));
        System.out.println("All names: " + service.namesJoined(employees));
        System.out.println("Department employee names: " + service.departmentEmployeeNames(employees));
        service.generateEmployeeReport(employees);
    }
}
