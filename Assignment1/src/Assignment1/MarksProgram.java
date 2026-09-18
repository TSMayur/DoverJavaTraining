package Assignment1;

import java.util.Scanner;

public class MarksProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Math marks: ");
        double math = scanner.nextDouble();

        System.out.print("Enter Science marks: ");
        double science = scanner.nextDouble();

        System.out.print("Enter English marks: ");
        double english = scanner.nextDouble();

        double total = math + science + english;
        double percentage = total / 3;

        String grade;

        if (percentage > 90) {
            grade = "A+";
        } else if (percentage >= 75) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else {
            grade = "F (Fail)";
        }

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}