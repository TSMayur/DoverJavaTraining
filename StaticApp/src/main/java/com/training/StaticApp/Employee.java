package com.training.StaticApp;

public class Employee {
	public Employee(int empID, String name, String designation) {
		  super();
		  this.employeeId = empID;
		  this.employeeName = name;
		  this.Designation = designation;
		  count++;
		 }

    private int employeeId;
    private String employeeName;
    private double salary;
    private String Designation;
    private static int count;
    
    public Employee() {
     setCount(getCount() + 1);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId
                + "\nEmployee Name: " + employeeName
                + "\nSalary: " + salary
                + "\nDesignation: " + Designation;
    }

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Employee.count = count;
	}
}