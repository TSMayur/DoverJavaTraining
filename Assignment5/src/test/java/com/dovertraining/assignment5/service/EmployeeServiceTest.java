package com.dovertraining.assignment5.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dovertraining.assignment5.model.Employee;
import com.dovertraining.assignment5.util.DataProvider;

class EmployeeServiceTest {
    private EmployeeService service;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        service = new EmployeeService();
        employees = DataProvider.employees();
    }

    @Test void findsEmployeeById() { assertEquals("Amit", service.findEmployeeById(employees, 103).orElseThrow().getName()); }
    @Test void findsUniqueLocations() { assertEquals(5, service.uniqueLocations(employees).size()); }
    @Test void filtersHighSalaries() { assertEquals(6, service.salaryAbove(employees, 80000).size()); }
    @Test void findsItEmployees() { assertEquals(6, service.byDepartment(employees, "IT").size()); }
    @Test void mapsNames() { assertEquals(15, service.employeeNames(employees).size()); }
    @Test void sortsHighestSalaryFirst() { assertEquals(125000, service.sortBySalary(employees, true).getFirst().getSalary()); }
    @Test void countsEmployees() { assertEquals(15, service.count(employees)); }
    @Test void calculatesTotalSalary() { assertEquals(1168000, service.totalSalary(employees)); }
    @Test void calculatesAverageSalary() { assertEquals(77866.66666666667, service.averageSalary(employees), 0.0001); }
    @Test void groupsByDepartment() { assertEquals(4, service.groupByDepartment(employees).size()); }
    @Test void partitionsExperience() { assertEquals(6, service.partitionByExperience(employees, 5).get(true).size()); }
    @Test void findsSecondHighestSalary() { assertEquals("Vijay", service.secondHighestPaid(employees).orElseThrow().getName()); }
    @Test void validatesMatches() { assertTrue(service.anySalaryAbove(employees, 100000)); assertTrue(service.allHaveMinimumExperience(employees, 2)); assertFalse(service.hasEmployeeNamed(employees, "Nobody")); }
}
