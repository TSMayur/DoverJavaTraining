package com.training.employee.dao;

import java.math.BigDecimal;
import java.util.List;

import com.training.employee.model.Employee;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findByDepartment(String department);
    List<Employee> salaryGreaterThan(BigDecimal amount);
    List<Employee> salaryBetween(BigDecimal low, BigDecimal high);
    List<Employee> nameContains(String text);
    List<Employee> inDepartments(List<String> departments);
    List<Employee> notInDepartments(List<String> departments);
    List<Employee> orderBySalaryDesc();
    List<Employee> orderByName();
    List<Employee> itSalaryGreaterThan(BigDecimal amount);
    List<String> distinctDepartments();
    List<String> distinctDesignations();
    Object[] salaryStatistics();
    List<Object[]> employeeCountByDepartment();
    List<Object[]> departmentsWithAverageSalaryAbove(BigDecimal amount);
    List<Object[]> nameDepartmentSalaryProjection();
    List<Employee> topHighestPaid(int count);
    List<Employee> salaryAboveOverallAverage();
    List<Employee> salaryAboveDepartmentAverage();
    int increaseDepartmentSalary(String department, BigDecimal percentage);
    int deleteByExperienceLessThan(int years);
}
