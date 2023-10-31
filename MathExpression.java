import java.util.Scanner;
import java.text.DecimalFormat;
/**
* Program solves for the result of a specified expressiion using methods.
*
* Project 3 - Math Expression
* @author Dev Patel - COMP 1210 - 006
* @version 2/1/2022
*/
public class MathExpression {
/**
* Solves for the rsult of a specific expression.
* @param args Command line arguments - not used.
*/
   public static void main(String[] args) {
   
   // declare variables
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double denominator = 0;
      double numerator = 0;
      double underSqrt = 0;
      double result = 0;
      String stringResult = "";
      int decPos = 0;
      // x to raised to the powers of 2,3,4 and 5
      double x2 = 0, x3 = 0, x4 = 0, x5 = 0;
      
   
   // ask for value for x
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      // math stuff
   // denominator
      denominator = Math.abs(x) + 3;
      // x raised to powers
      x2 = Math.pow(x, 2);
      x3 = Math.pow(x, 3);
      x4 = Math.pow(x, 4);
      x5 = Math.pow(x, 5);
   // square root
      underSqrt = Math.abs(3 + (3 * x) + (3 * x2) + (3 * x3) + (3 * x4));
      numerator = Math.sqrt(underSqrt) + (3 * x5);
      
      result = numerator / denominator;
      
      
      
   // left and right of decimal point
      
      // convert double to string
      
      stringResult = Double.toString(result);
      decPos = stringResult.indexOf(".");
      String firstHalf = stringResult.substring(0, decPos);
      String secondHalf = stringResult.substring(decPos, +
         +stringResult.length() - 1);
      int lenFirst = firstHalf.length();
      int lenSecond = secondHalf.length();
      
   // formmatted result
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      
     
   
   
   // print stuff
      System.out.println("Result: " + result);
      System.out.println("# of characters to left of decimal point: " 
         + +lenFirst);
      System.out.println("# of characters to right of decimal point: "
         + +lenSecond);
      System.out.println("Formatted Result: " + df.format(result));
   }


}