package com.training.interfaceapp;

import java.util.Scanner;

public class Zomato {
   public static void main(String[] args) {
    PhonePe phonepe = new PhonePe();
    int choice;
    Scanner scanner = new Scanner(System.in);
    
    while(true) {
     System.out.println("Phone Pe Payments....");
     System.out.println("1. Pay via hdfc");
     System.out.println("2. Pay via icici");
     System.out.println("3. exit");
     System.out.println("Enter the choice: ");
     choice = scanner.nextInt();
     switch(choice) {
     case 1:
         phonepe.makePayment(new HDFCPaymentGateway());
         break;
        case 2:
         phonepe.makePayment(new ICICIPaymentGateway());
         break;
        case 3:
         System.exit(1);
     
     }
    }
   }
}
 