import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
* Presents the user with a menu with 8 choices to implement on objects.
*
* Project 6 - TrapezohedronListMenuApp
* @author Dev Patel - COMP 1210 - 006
* @version 2/24/2022
*/
public class TrapezohedronListMenuApp {
   
   /**
   * Prints list of options with the action code and description of each.
   *
   * @param args not used
   * @throws FileNotFoundException if the file cannot be opened
   */
   public static void main(String[] args) throws FileNotFoundException {
   
      String listName = "*** no list name assigned ***";
      ArrayList<Trapezohedron> myList = new ArrayList<Trapezohedron>();
      TrapezohedronList tList = new TrapezohedronList(listName, myList);
      String fileName = "no file name";
      
      // some instance variables
      String label = "";
      String color = "";
      double edge = 0;
      
      String code = "";
      // scanner
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Trapezohedron List System Menu\n"
         + "R - Read File and Create Trapezohedron List\n"
         + "P - Print Trapezohedron List\n"
         + "S - Print Summary\n"
         + "A - Add Trapezohedron\n"
         + "D - Delete Trapezohedron\n"
         + "F - Find Trapezohedron\n"
         + "E - Edit Trapezohedron\n"
         + "Q - Quit");         
      
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         
         switch (codeChar) {
         
            case 'R': // reads in the file and creates the TrapezohedronList
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               tList = tList.readFile(fileName);
               
               System.out.println("\tFile read in and Trapezohedron List "
                  + "created\n");
               break;
               
            case 'P': // prints the trapezohedron list
               System.out.println("\n" + tList.toString());
               break;
            
            case 'S': //prints the summary
               System.out.println("\n" + tList.summaryInfo() + "\n");
               break;
            
            case 'A': // adds a trapezohedron to the list
               
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               System.out.print("\tColor: ");
               color = scan.nextLine();
               
               System.out.print("\tShort Edge: ");
               edge = Double.parseDouble(scan.nextLine());
               
               tList.addTrapezohedron(label, color, edge);
               System.out.println("\t*** Trapezohedron added ***\n");
               break;
               
            case 'D': // deletes a trapezohedron
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               Trapezohedron outputDelete = tList.deleteTrapezohedron(label);
               if (outputDelete != null) {
               
                  System.out.println("\t\"" + outputDelete.getLabel()
                     + "\" deleted\n");
               }
               else {
                  
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F': // finds the trapezohedron
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               if (tList.findTrapezohedron(label) != null) {
                  System.out.println(tList.findTrapezohedron(label).toString()
                     + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'E': // edits the trapezohedron
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               System.out.print("\tColor: ");
               color = scan.nextLine();
               
               System.out.print("\tShort Edge: ");
               edge = Double.parseDouble(scan.nextLine());
               
               if (tList.findTrapezohedron(label) != null) {
                  tList.editTrapezohedron(label, color, edge);
                  System.out.println("\t\"" + label + "\" successfully"
                     + " edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q': // quits the program
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
         }
         
      } while (!code.equalsIgnoreCase("Q"));     
   }

}