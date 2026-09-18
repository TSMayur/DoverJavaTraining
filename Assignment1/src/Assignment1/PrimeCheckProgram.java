package Assignment1;
import java.util.Scanner;
public class PrimeCheckProgram {
	
public static void main(String[] args) {
	
	 Scanner scanner = new Scanner(System.in);

     System.out.print("Enter a number: ");
     int number = scanner.nextInt();

     boolean isPrime = number > 1;

     for (int i = 2; i < number; i++) {
         if (number % i == 0) {
             isPrime = false;
             break;
         }
     }
     
     if(isPrime) {
     
     System.out.print("The given number is prime");
     }
     else {
    	 System.out.print("Not Prime");
         
     }
     scanner.close();
}

}
