package Assignment1;


import java.util.Scanner;

public class CircleProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        System.out.println("Area of circle: " + area);
        System.out.println("Perimeter of circle: " + perimeter);

        scanner.close();
    }
}