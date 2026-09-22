package com.dovertraining.assignment5.model;

public class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final String designation;
    private final double salary;
    private final int experience;
    private final String location;

    public Employee(int id, String name, String department, String designation,
                    double salary, int experience, String location) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.experience = experience;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return "%d | %s | %s | %s | %.2f | %d years | %s".formatted(
                id, name, department, designation, salary, experience, location);
    }
}
