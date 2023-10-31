import java.util.Scanner;
/**
* Program reads input values for xyz then uses them in an expression.
*
* Project 2- Three Variable Expression
* @author Dev Patel - COMP 1210 - 006
* @version 1/25/2021
*/
public class ThreeVariableExpression { 

/**
* Program gets values for xyz and plugs them into expression.
* @param args Command line arguments - not used.
*/
   public static void main(String[] args) {
      
      Scanner userInput = new Scanner(System.in);
      double x = 0, y = 0, z = 0;
      double xMath = 0, yMath = 0, zMath = 0, numerator = 0, denominator = 0;
      double result = 0;
      
      System.out.println("result = (3.5x - 7.75) (2.85y + 6.0) (1.5z - 3.1)"
         + " / xyz");
      //ask user for variable values
      System.out.print("\tx = ");
      x = userInput.nextDouble();
      System.out.print("\ty = ");
      y = userInput.nextDouble();
      System.out.print("\tz = ");
      z = userInput.nextDouble();
      
      //if xyz = 0
      if (x * y * z == 0) {
         System.out.println("result is \"undefined\"");
      }
      else {
      
      //math
         xMath = (3.5 * x) - 7.75;
         yMath = (2.85 * y) + 6.0;
         zMath = (1.5 * z) - 3.1;
         numerator = xMath * yMath * zMath;
         denominator = x * y * z;
         result = numerator / denominator;
         
         System.out.println("result = " + result);
      
      }
      
   }

}