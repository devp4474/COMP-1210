import java.util.Scanner;
/**
* TrapezohedronApp takes user input and then makes objects.
*
* Project 4 - TrapezohedronApp
* @author Dev Patel - COMP 1210 - 006
* @version 2/10/2022
*/
public class TrapezohedronApp {
   /**
   * Takes user input and plugs into equations from class and then prints.
   * @param args Command line arguments - not used.
   */
   public static void main(String[] args) {
   
   // set up scanner
      Scanner userInput = new Scanner(System.in);
   
   // ask for and get user inputs 
      System.out.println("Enter label, color, and short edge length" 
         + " for a trapezohedron.");
      System.out.print("\tlabel: ");
      String label = userInput.nextLine();
      System.out.print("\tcolor: ");
      String color = userInput.nextLine();
      System.out.print("\tshort edge: ");
      String shortEdge = userInput.nextLine();
      
   // convert string shortEdge into double
      double shortEdgeDouble = Double.parseDouble(shortEdge);
      
      
   // if else for shortEdge > 0
   
      if (shortEdgeDouble > 0) {
         Trapezohedron trap = new Trapezohedron(label, color, 
            +shortEdgeDouble);
         System.out.println("\n" + trap);
      }
      else {
         System.out.println("Error: short edge must be greater than zero.");
      }
   
   }
   
}