package schoolapp;

public class Manager extends Employee {
    private String department;

    public Manager(String name, int employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Salary: " + getSalary());
        System.out.println("Department: " + department);
    }
}