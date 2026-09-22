package com.dovertraining.assignment5.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.dovertraining.assignment5.model.Employee;

public class EmployeeService {
    public Employee findEmployeeByIdLoop(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }

    public Optional<Employee> findEmployeeById(List<Employee> employees, int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public Set<String> uniqueLocations(List<Employee> employees) {
        return employees.stream().map(Employee::getLocation).collect(Collectors.toSet());
    }

    public Map<Integer, Employee> employeeMap(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
    }

    public List<Employee> salaryAbove(List<Employee> employees, double salary) {
        return employees.stream().filter(e -> e.getSalary() > salary).toList();
    }

    public List<Employee> byDepartment(List<Employee> employees, String department) {
        return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase(department)).toList();
    }

    public List<Employee> byLocation(List<Employee> employees, String location) {
        return employees.stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).toList();
    }

    public List<Employee> experiencedMoreThan(List<Employee> employees, int years) {
        return employees.stream().filter(e -> e.getExperience() > years).toList();
    }

    public List<String> employeeNames(List<Employee> employees) {
        return employees.stream().map(Employee::getName).toList();
    }

    public Set<String> departments(List<Employee> employees) {
        return employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
    }

    public List<String> uppercaseNames(List<Employee> employees) {
        return employees.stream().map(e -> e.getName().toUpperCase()).toList();
    }

    public List<Employee> sortBySalary(List<Employee> employees, boolean descending) {
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary);
        return employees.stream().sorted(descending ? comparator.reversed() : comparator).toList();
    }

    public List<Employee> sortByExperience(List<Employee> employees, boolean descending) {
        Comparator<Employee> comparator = Comparator.comparingInt(Employee::getExperience);
        return employees.stream().sorted(descending ? comparator.reversed() : comparator).toList();
    }

    public List<Employee> sortByDepartmentThenSalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())).toList();
    }

    public long count(List<Employee> employees) { return employees.stream().count(); }
    public Optional<Employee> highestPaid(List<Employee> employees) { return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)); }
    public Optional<Employee> lowestPaid(List<Employee> employees) { return employees.stream().min(Comparator.comparingDouble(Employee::getSalary)); }
    public double totalSalary(List<Employee> employees) { return employees.stream().mapToDouble(Employee::getSalary).sum(); }
    public double averageSalary(List<Employee> employees) { return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0); }

    public Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.toList()));
    }

    public Map<String, Long> countByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.counting()));
    }

    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.averagingDouble(Employee::getSalary)));
    }

    public Map<Boolean, List<Employee>> partitionByExperience(List<Employee> employees, int years) {
        return employees.stream().collect(Collectors.partitioningBy(e -> e.getExperience() > years));
    }

    public Optional<Employee> findByName(List<Employee> employees, String name) {
        return employees.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Employee> highestPaidInDepartment(List<Employee> employees, String department) {
        return byDepartment(employees, department).stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    public Map<String, Optional<Employee>> highestPaidByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public List<Employee> earningAboveAverage(List<Employee> employees) {
        double average = averageSalary(employees);
        return salaryAbove(employees, average);
    }

    public List<Employee> topPaid(List<Employee> employees, int count) {
        return sortBySalary(employees, true).stream().limit(count).toList();
    }

    public Optional<Employee> secondHighestPaid(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst();
    }

    public Map<String, DoubleSummaryStatistics> departmentSalaryReport(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new,
                Collectors.summarizingDouble(Employee::getSalary)));
    }

    public List<Employee> namesStartingWith(List<Employee> employees, String prefix) { return employees.stream().filter(e -> e.getName().startsWith(prefix)).toList(); }
    public List<Employee> salaryBetween(List<Employee> employees, double min, double max) { return employees.stream().filter(e -> e.getSalary() >= min && e.getSalary() <= max).toList(); }
    public List<Employee> bangaloreExperienced(List<Employee> employees) { return byLocation(employees, "Bangalore").stream().filter(e -> e.getExperience() > 5).toList(); }
    public Optional<String> departmentWithHighestAverageSalary(List<Employee> employees) { return averageSalaryByDepartment(employees).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey); }
    public Optional<String> locationWithMostEmployees(List<Employee> employees) { return employees.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey); }
    public List<Employee> topItEmployees(List<Employee> employees, int count) { return topPaid(byDepartment(employees, "IT"), count); }
    public Set<String> uniqueDesignations(List<Employee> employees) { return employees.stream().map(Employee::getDesignation).collect(Collectors.toSet()); }
    public Optional<Employee> longestServing(List<Employee> employees) { return employees.stream().max(Comparator.comparingInt(Employee::getExperience)); }
    public double totalItSalary(List<Employee> employees) { return totalSalary(byDepartment(employees, "IT")); }
    public boolean anySalaryAbove(List<Employee> employees, double salary) { return employees.stream().anyMatch(e -> e.getSalary() > salary); }
    public boolean allHaveMinimumExperience(List<Employee> employees, int years) { return employees.stream().allMatch(e -> e.getExperience() >= years); }
    public boolean hasEmployeeNamed(List<Employee> employees, String name) { return employees.stream().anyMatch(e -> e.getName().equalsIgnoreCase(name)); }
    public String namesJoined(List<Employee> employees) { return employees.stream().map(Employee::getName).collect(Collectors.joining(", ")); }
    public Optional<Employee> firstSalaryAbove(List<Employee> employees, double salary) { return salaryAbove(employees, salary).stream().findFirst(); }
    public Map<String, List<String>> departmentEmployeeNames(List<Employee> employees) { return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.mapping(Employee::getName, Collectors.toList()))); }

    public void generateEmployeeReport(List<Employee> employees) {
        System.out.println("\n========== EMPLOYEE ANALYTICS DASHBOARD ==========");
        System.out.println("Total employees: " + count(employees));
        System.out.printf("Average salary: %.2f%n", averageSalary(employees));
        System.out.println("Highest paid: " + highestPaid(employees).orElse(null));
        System.out.println("Lowest paid: " + lowestPaid(employees).orElse(null));
        System.out.println("Count by department: " + countByDepartment(employees));
        System.out.println("Count by location: " + employees.stream().collect(Collectors.groupingBy(Employee::getLocation, LinkedHashMap::new, Collectors.counting())));
        System.out.println("Experience > 5: " + experiencedMoreThan(employees, 5));
        System.out.println("Top 3 salaries: " + topPaid(employees, 3));
        System.out.println("Average salary by department: " + averageSalaryByDepartment(employees));
        System.out.println("Department salary statistics: " + departmentSalaryReport(employees));
    }
}
