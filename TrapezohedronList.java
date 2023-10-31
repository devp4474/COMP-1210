import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
* Stores the name of the list and an ArrayList of Trapezohedron objects.
* Includes methods that return the name of the list and a number of objects.
*
* Project 5 - TrapezohedronList
* @author Dev Patel - COMP 1210 - 006
* @version 2/16/2022
*/
public class TrapezohedronList {

   
   // instance variables
   private String listName;
   private ArrayList<Trapezohedron> tList;
   
   // constructor
   /**
   * Creates a TrapezohedronList object with two parameters.
   * One parameter is the user input for listName and other is the arrayList.
   * 
   * @param listNameIn is the user input list name
   * @param tListIn array list that is assigned to tList
   */
   public TrapezohedronList(String listNameIn, ArrayList<Trapezohedron> tListIn)
   {
      
      listName = listNameIn;
      tList = tListIn;
   
   }
    
    /**
    * Returns a string representing the name of the list.
    * @return listName returns the list name
    */
   public String getName() {
      return listName;
   }
   
    /**
    * Returns an int representing the number of Trapezohedrons.
    * @return tList.size() returns the number of Trapezohedrons
    */
   public int numberOfTrapezohedrons() {
      return tList.size();
   }
   
    /**
    * Method calculates the total Surface Area of all the trapezohedrons.
    * Using a while loop it adds all the values to totalSA.
    * 
    * @return totalSA returns total surface area for all Trapezohedron objects
    */
   public double totalSurfaceArea() {
      double totalSA = 0;
      
      // while loop adds surfaceArea totals together and increments index 
      int index = 0;
      while (index < tList.size()) {
         totalSA += tList.get(index).surfaceArea();
         index++;
      }
      
      return totalSA;
   
   }
   
    /**
    * Method calculates the totalVolume by adding all of the values of volume.
    * Using a while loop it adds all the volume values into totalV.
    * 
    * @return totalV returns total volume of all Trapezohedron objects
    */
   public double totalVolume() {
      double totalV = 0;
      
      int index = 0;
      while (index < tList.size()) {
         totalV += tList.get(index).volume();
         index++;
      }
      return totalV;
   }
   
    /**
    * Calculates the average surface area by dividing total SA by tList size.
    * 
    * @return avgSA returns the average surface area of the Trapezohedrons
    */
   public double averageSurfaceArea() {
      double avgSA = 0;
      int index = 0;
      while (index < tList.size()) {
         avgSA += (tList.get(index).surfaceArea()) / tList.size();
         index++;
      }
      
      return avgSA;
   }
   
    /**
    * Calculates the average volume by dividing total volume by size of list.
    * 
    * @return avgVolume returns the average volume of the Trapezohedrons
    */
   public double averageVolume() {
      double avgVolume = 0;
      int index = 0;
      while (index < tList.size()) {
      
         avgVolume += (tList.get(index).volume()) / tList.size();
         index++;
      }
      
      return avgVolume;
   }
    /**
    * Compiles everyhting into a readable string in order to print.
    * @return result returns readable string for printing
    */
   public String toString() {
      String result = listName + "\n";
      
      int index = 0;
      while (index < tList.size()) {
         result += "\n" + tList.get(index).toString() + "\n";
         index++;
      }
      return result;
   }
   
    /**
    * Puts togethes values and strings for the summary information.
    * Adds all calculated results from above into a string meant for printing
    * 
    * @return returns  summary of all the averages and totals
    */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      output = "----- Summary for " + listName + " -----"
         + "\nNumber of Trapezohedrons: " + tList.size()
         + "\nTotal Surface Area: " + df.format(totalSurfaceArea())
         + " square units \nTotal Volume: " + df.format(totalVolume())
         + " cubic units \nAverage Surface Area: "
            + df.format(averageSurfaceArea())
         + " square units \nAverage Volume: " + df.format(averageVolume())
            + " cubic units";
         
      return output;
      
   }
   
   // part 6 below!!
    
    /**
    * Returns the array list of Trapezohedron objects.
    * @return tList retursn the list
    */
   public ArrayList<Trapezohedron> getList() {
   
      return tList;
   }
    
    /**
    * Reads in the trapezohedron data from file and creates objects.
    * 
    * @param listNameIn for the file name to read
    * @return trapList returns the list of new trapezohedrons
    * @throws FileNotFoundException if the file cannot be opened
    */
   public TrapezohedronList readFile(String listNameIn) 
                               throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(listNameIn));
      
      
      ArrayList<Trapezohedron> newListName = new ArrayList<Trapezohedron>();
      
      String trapListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      trapListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
      
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Trapezohedron trapObject = new Trapezohedron(label, color, edge);
         tList.add(trapObject);
      }
      
      TrapezohedronList trapList = new TrapezohedronList(trapListName, tList);
      return trapList;
      
   }
    /**
    * Adds a trapezohedron objects to list.
    * 
    * @param labelIn label of the trapezohedron
    * @param colorIn color of the trapezohedron
    * @param edgeIn is the length of the short edge of the trapezohedron
    */
   public void addTrapezohedron(String labelIn, String colorIn, double edgeIn)
   {
      // t is the new trapezohhedron object that is added to the List
      Trapezohedron t = new Trapezohedron(labelIn, colorIn, edgeIn);
      tList.add(t);
      
   }
   /**
   * Takes label of a Trapezohedron as a string parameter.
   * Then returns corrresponding Trapezohedron object if found in list.
   *
   * @param labelIn is the label of the trapezohedron
   * @return t returns the trap object if found in list
   */
   public Trapezohedron findTrapezohedron(String labelIn) {
   // t is used here again for the trap object being looked for in list
      for (Trapezohedron t : tList) {
         if (t.getLabel().equalsIgnoreCase(labelIn)) {
            return t;
         }
      }
      return null;
   
   }
   
   /**
   * Takes string as the parameter that reprsents the label of the trap.
   * Then returns the Trapezohedron if it is found and deletes it.
   *
   * @param labelIn is the label of the trapezohedron
   * @return tList.remove(index) returns the list after the object is deleted
   */
   public Trapezohedron deleteTrapezohedron(String labelIn) {
      int index = tList.indexOf(findTrapezohedron(labelIn));
   
      if (index >= 0) {
         return tList.remove(index);
      }
      else {
         return null;
      }
   
   }
    /**
    * Takes 3 parameters and uses the label to find the corresponding object.
    * If found it sets the values of color and edge to the parameter values.
    *
    * @param labelIn is the label of the trapezohedron
    * @param colorIn is the color of the trapezohedron
    * @param edgeIn is the short edge length of the trapezohedron
    * @return result either true or false depending on if the object was found
    */
   public boolean editTrapezohedron(String labelIn, String colorIn, 
                                                      double edgeIn) {
                                                          
      boolean result = false;
      for (Trapezohedron trapObject : tList) {
         if (trapObject.getLabel().equalsIgnoreCase(labelIn)) {
            trapObject.setColor(colorIn);
            trapObject.setShortEdge(edgeIn);
            result = true;
            break;
            
         }
      } 
      return result;                                                      
   
   }
   
}