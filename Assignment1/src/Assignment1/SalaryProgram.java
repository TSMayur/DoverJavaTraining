package Assignment1;


import java.util.Scanner;

public class SalaryProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        double da = basicSalary * 0.10;
        double hra = basicSalary * 0.15;
        double netSalary = basicSalary + da + hra;

        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("Net Salary: " + netSalary);

        scanner.close();
    }
}