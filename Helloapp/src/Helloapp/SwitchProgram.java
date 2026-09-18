package Helloapp;

import java.util.Scanner;

public class SwitchProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a color code (R, G, or B): ");
        char color = scanner.next().toUpperCase().charAt(0);

        switch (color) {
            case 'R':
                System.out.println("Red Color");
                break;

            case 'G':
                System.out.println("Green Color");
                break;

            case 'B':
                System.out.println("Blue Color");
                break;

            default:
                System.out.println("Invalid color code. Enter R, G, or B.");
        }

        scanner.close();
    }
}
