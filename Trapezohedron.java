import java.text.DecimalFormat;
/**
* Stores label, color, and short edge length of a trapezohderon.
*
* Project 4 - Trapezohedron
* @author Dev Patel - COMP 1210 - 006
* @version 2/9/2022
*/
public class Trapezohedron {

   // instance variables
   private String label = "";
   private String color = "";
   private double shortEdge = 0.0;
   
   // constructor
   
   /**
   * Accepts 3 parameters representing the label, color, and short edge length.
   *  
   * @param labelIn stores the label
   * @param colorIn stores the color
   * @param shortEdgeIn stores the short edge length
   */
   public Trapezohedron(String labelIn, String colorIn, double shortEdgeIn) {
   
      setLabel(labelIn);
      setColor(colorIn);
      setShortEdge(shortEdgeIn);
   }
   
   /**
   * Accepts no parameters and returns a string representing the label field.
   * @return returns the label
   */
   public String getLabel() {
      return label;
   }
   
   /**
   * Takes a string parameter and returns a boolean.
   * If string isn't null then it is trimmed and string and method return true.
   * If false then it returns false and the label field is not set.
   * 
   * @param labelIn takes the label
   * @return returns true if not null and false if the string is null
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * Takes no parameters and returns a string representing the color field.
   * @return returns the color.
   */
   public String getColor() {
      return color;
   }
   
   /**
   * Takes a string parameter and returns a boolean.
   * If string is not null then it is true and trimmed.
   * If string is null then it returns false.
   * 
   * @param colorIn is the inputted color as a string.
   * @return returns true is not null and false if string is null.
   */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         colorIn = colorIn.trim();
         color = colorIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * Takes no parameters and returns a double represnting the short edge.
   * @return returns the shortEdge 
   */
   public double getShortEdge() {
      return shortEdge;
   }
   
   /**
   * Takes double parameter and return true if greater than 0 and false if not.
   * 
   * @param shortEdgeIn is the shortEdge parameter
   * @return Returns true if greater than 0 and false if not.
   */
   public boolean setShortEdge(double shortEdgeIn) {
      if (shortEdgeIn > 0) {
         shortEdge = shortEdgeIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * Accepts no paramters and calculates the double value of edge length.
   * Calculates by using the short edge length and plugging into given formula.
   * 
   * @return returns the value for edgeLengthAntiprism
   */
   public double edgeLengthAntiprism() {
      double edgeLengthAntiprism = shortEdge / (((Math.sqrt(5)) - 1) / 2);
      return edgeLengthAntiprism;
   }
   
   /**
   * Takes no parameters and calculates and return the length of the long edge.
   * @return reutrns the longEdge length
   */
   public double longEdge() {
      double longEdge = 0;
      longEdge = (((Math.sqrt(5) + 1) / 2) * edgeLengthAntiprism());
      return longEdge;
   }
   
   
   /**
   * Takes no paramters and calculate and returns the value of the srufaceArea.
   * @return returns the surfaceArea 
   */
   public double surfaceArea() {
      double surfaceArea = (Math.sqrt((25 / 2.0) * (5
         + Math.sqrt(5))) * Math.pow(edgeLengthAntiprism(), 2));
      return surfaceArea;
   }
   
   /**
   * Calculates and returns the value of the volume.
   * @return returns the volume value
   */
   public double volume() {
      double volume = 0;
      volume = ((5.0 / 12) * (3 
         + Math.sqrt(5)) * (Math.pow(edgeLengthAntiprism(), 3)));
      return volume;
   }
   
   /**
   * Returns a string containing information about the Trapezohedron object.
   * @return output returns readable string of information about Trap. object.
   */
   public String toString() {
      // decimal format
      DecimalFormat df = new DecimalFormat("#,##0.0###");
      
      // add to string
      String output = "";
      output = "Trapezohedron \"" + label + "\" is \"" + color + "\""
         + " with 20 edges and 12 vertices."
         + "\n\tedge length antiprism = " 
         + df.format(edgeLengthAntiprism()) + " units"
         + "\n\tshort edge = " + df.format(shortEdge) + " units"
         + "\n\tlong edge = " + df.format(longEdge()) + " units"
         + "\n\tsurface area = " + df.format(surfaceArea()) + " square units"
         + "\n\tvolume = " + df.format(volume()) + " cubic units";
      return output;
     
   }
 
}