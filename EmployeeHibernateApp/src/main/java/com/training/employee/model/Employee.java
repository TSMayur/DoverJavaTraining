package com.training.employee.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    private String designation;
    private BigDecimal salary;
    private int experience;
    private String email;
    @Column(name = "joining_date")
    private LocalDate joiningDate;

    public Employee() {}

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public BigDecimal getSalary() { return salary; }
    public int getExperience() { return experience; }
    public String getEmail() { return email; }
    public LocalDate getJoiningDate() { return joiningDate; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setEmail(String email) { this.email = email; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    @Override
    public String toString() {
        return "%d | %s | %s | %s | %s | %d years".formatted(
                id, name, department, designation, salary, experience);
    }
}
