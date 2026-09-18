package schoolapp;

public class Student extends Person {
    private int rollNo;
    private String grade;

    public Student(String name, int age, int rollNo, String grade) {
        super(name, age);
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Roll No: " + rollNo);
        System.out.println("Grade: " + grade);
    }
}