package com.dovertraining.assignment5.util;

import java.util.ArrayList;
import java.util.List;

import com.dovertraining.assignment5.model.Employee;

public final class DataProvider {
    private DataProvider() {
    }

    public static List<Employee> employees() {
        return new ArrayList<>(List.of(
                new Employee(101, "Ravi", "IT", "Developer", 75000, 5, "Bangalore"),
                new Employee(102, "Priya", "HR", "Manager", 85000, 8, "Chennai"),
                new Employee(103, "Amit", "IT", "Senior Developer", 95000, 8, "Bangalore"),
                new Employee(104, "Sneha", "Finance", "Analyst", 65000, 4, "Mumbai"),
                new Employee(105, "Rahul", "IT", "Developer", 70000, 4, "Hyderabad"),
                new Employee(106, "Anjali", "HR", "Executive", 55000, 3, "Bangalore"),
                new Employee(107, "Kiran", "Finance", "Manager", 90000, 9, "Chennai"),
                new Employee(108, "Meena", "IT", "Architect", 125000, 12, "Bangalore"),
                new Employee(109, "Arjun", "Sales", "Executive", 60000, 3, "Mumbai"),
                new Employee(110, "Divya", "IT", "Developer", 72000, 5, "Pune"),
                new Employee(111, "Suresh", "Sales", "Manager", 88000, 10, "Bangalore"),
                new Employee(112, "Neha", "HR", "Executive", 58000, 2, "Hyderabad"),
                new Employee(113, "Vijay", "IT", "Senior Developer", 100000, 9, "Pune"),
                new Employee(114, "Pooja", "Finance", "Analyst", 68000, 5, "Bangalore"),
                new Employee(115, "Manoj", "Sales", "Executive", 62000, 4, "Chennai")));
    }
}
