import java.util.Scanner;
/**
* User enters amount of cash then number of bills by denomination is displayed. 
*
* Project 2 - ATM
* @author Dev Patel - COMP 1210 - 006
* @version 1/25/2021
*/
public class ATM {
  /**
  * For an amount of cash displays number of bills by denomination.
  * @param args Command line arguments - not used.
  */
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
   
   //variables and stuff
      int amountCash = 0;
      System.out.print("Enter the amount: ");
      amountCash = userInput.nextInt();
      int numTwenties = 0, afterTwenties = 0, numTens = 0, afterTens = 0;
      int numFives = 0, afterFives = 0, numOnes = 0;
      
      
      
   // if else statement   
      if (amountCash > 500) {
         System.out.println("Limit of $500 exceeded!");
      }
      else {
         numTwenties = amountCash / 20;
         afterTwenties = amountCash % 20;
         numTens = afterTwenties / 10;
         afterTens = afterTwenties % 10;
         numFives = afterTens / 5;
         afterFives = afterTens % 5;
         numOnes = afterFives / 1;
      
      //print stuff
         System.out.println("Bills by denomination: ");
         System.out.println("\t$20: " + numTwenties);
         System.out.println("\t$10: " + numTens);
         System.out.println("\t$5: " + numFives);
         System.out.println("\t$1: " + numOnes);
         System.out.print("$" + amountCash + " = (");
         System.out.print(numTwenties + " * $20) + ");
         System.out.print("(" + numTens);
         System.out.print(" * $10) + ");
         System.out.print("(" + numFives);
         System.out.print(" * $5) + ");
         System.out.print("(" + numOnes);
         System.out.println(" * $1)");
      
      }
     
   
   
   }

}