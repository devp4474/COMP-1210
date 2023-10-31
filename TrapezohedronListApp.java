import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
* Reads the name of the data file entered by user and reads list name and data.
* Also creates Trapezohedron ojects and then prints the objects and summary.
*
* Project 5 - TrapezohedronListApp
* @author Dev Patel - COMP 1210 - 006
* @version 2/16/2022
*/
public class TrapezohedronListApp {
   /**
   * Reads file with Trapezohedron data, creates list, and prints list.
   * @param args - not used.
   * @throws FileNotFoundException requried by Scanner for File
   */
   public static void main(String[] args) throws FileNotFoundException {
   
      ArrayList<Trapezohedron> myList = new ArrayList<Trapezohedron>();
      
      // scan for user input of file name and assign to fileName
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();
      
      
      Scanner scanFile = new Scanner(new File(fileName));
      String trapezohedronListName = scanFile.nextLine();
               
      while (scanFile.hasNext()) {
      
         String label = scanFile.nextLine();
         String color = scanFile.nextLine();
         double shortEdge = Double.parseDouble(scanFile.nextLine());
         
         Trapezohedron t = new Trapezohedron(label, color, shortEdge);
         myList.add(t);
      }
      scanFile.close();
      
      TrapezohedronList myTrapezohedronList = new TrapezohedronList(
         trapezohedronListName, myList);
         
      System.out.println(myTrapezohedronList.toString());
      System.out.println();
      System.out.println(myTrapezohedronList.summaryInfo());
      
   
   }
}