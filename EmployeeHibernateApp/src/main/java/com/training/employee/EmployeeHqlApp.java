package com.training.employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.training.employee.dao.EmployeeDao;
import com.training.employee.dao.impl.EmployeeDaoImpl;
import com.training.employee.model.Employee;
import com.training.employee.util.HibernateUtil;

public class EmployeeHqlApp {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDaoImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Choose HQL question (1-20): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> printEmployees(dao.findAll());
                case 2 -> print(dao.findById(readInt(scanner, "Employee ID: ")));
                case 3 -> printEmployees(dao.findByDepartment(readText(scanner, "Department: ")));
                case 4 -> printEmployees(dao.salaryGreaterThan(readMoney(scanner, "Minimum salary: ")));
                case 5 -> printEmployees(dao.salaryBetween(readMoney(scanner, "Low salary: "), readMoney(scanner, "High salary: ")));
                case 6 -> printEmployees(dao.nameContains(readText(scanner, "Name text: ")));
                case 7 -> printEmployees(dao.inDepartments(List.of("IT", "Finance", "HR")));
                case 8 -> printEmployees(dao.notInDepartments(List.of("Sales", "Marketing")));
                case 9 -> { System.out.println("Salary descending:"); printEmployees(dao.orderBySalaryDesc());
                            System.out.println("\nName ascending:"); printEmployees(dao.orderByName()); }
                case 10 -> printEmployees(dao.itSalaryGreaterThan(BigDecimal.valueOf(75000)));
                case 11 -> { System.out.println("Departments: " + dao.distinctDepartments());
                             System.out.println("Designations: " + dao.distinctDesignations()); }
                case 12 -> printStatistics(dao.salaryStatistics());
                case 13 -> printRows(dao.employeeCountByDepartment());
                case 14 -> printRows(dao.departmentsWithAverageSalaryAbove(BigDecimal.valueOf(70000)));
                case 15 -> printRows(dao.nameDepartmentSalaryProjection());
                case 16 -> printEmployees(dao.topHighestPaid(5));
                case 17 -> printEmployees(dao.salaryAboveOverallAverage());
                case 18 -> printEmployees(dao.salaryAboveDepartmentAverage());
                case 19 -> System.out.println("Updated rows: " + dao.increaseDepartmentSalary(
                        readText(scanner, "Department: "), BigDecimal.TEN));
                case 20 -> System.out.println("Deleted rows: " + dao.deleteByExperienceLessThan(
                        readInt(scanner, "Delete employees with experience less than: ")));
                default -> System.out.println("Choose a number from 1 to 20.");
            }
        } finally {
            HibernateUtil.shutdown();
        }
    }

    private static void printEmployees(List<Employee> employees) { employees.forEach(System.out::println); }
    private static void print(Employee employee) { System.out.println(employee == null ? "Employee not found." : employee); }
    private static void printRows(List<Object[]> rows) {
        rows.forEach(row -> System.out.println(java.util.Arrays.toString(row)));
    }
    private static void printStatistics(Object[] values) {
        System.out.printf("Count=%s, Average=%s, Highest=%s, Lowest=%s, Total=%s%n",
                values[0], values[1], values[2], values[3], values[4]);
    }
    private static String readText(Scanner scanner, String label) { System.out.print(label); return scanner.nextLine(); }
    private static int readInt(Scanner scanner, String label) { System.out.print(label); return scanner.nextInt(); }
    private static BigDecimal readMoney(Scanner scanner, String label) { System.out.print(label); return scanner.nextBigDecimal(); }
}
