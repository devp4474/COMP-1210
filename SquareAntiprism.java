import java.text.DecimalFormat;
/**
* Stores the label and edge of a square antiprism and also has various methods.
* Includes methods to get and set the above fields and to calculate equations.
*
* Project 7A - Square Antiprism
* @author Dev Patel - COMP 1210 - 006
* @version 3/16/2022
*/
public class SquareAntiprism {

   // instance variables
   private String label = "";
   private double edge = 0;
   
   // class variable
   private static int count = 0;
   
   // constructor
   /**
   * Accepts 2 parameters representing the label and edge.
   * Also increments the count evertime a SquareAntiprism is constructed.
   *
   * @param labelIn represents and stores the label string
   * @param edgeIn represents and stores the edge value
   */
   public SquareAntiprism(String labelIn, double edgeIn) {
      setLabel(labelIn);
      setEdge(edgeIn);
      
      count++;
   }
   
   /**
   * Takes no parameters and returns the label string. 
   * @return returns the label string
   */
   public String getLabel() {
      return label;
   }
   
   /**
   * Takes a string parameter and returns a boolean value.
   * If the parameter is null then it returns false and if not then the 
   * parameter is trimmed, assigned to label and true is returned.
   *
   * @param labelIn represents the string value of label
   * @return if the labelIn is not null then returns true and trims the string
   *     and if labelIn is false then the method returns false
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
   * Takes no parameters and returns the edge (double).
   * @return returns the double edge
   */
   public double getEdge() {
      return edge;
   }
   
   /**
   * Takes a string parameter and returns a boolean value.
   * True is returned if the value is non-negatvie and false otherwise.
   * If true then the valeu of edgeIn is assigned to edge.
   *
   * @param edgeIn represents the double value of edge
   * @return returns true if edgeIn is a non-negative and false if otherwise.
   */
   public boolean setEdge(double edgeIn) {
      if (edgeIn >= 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false;
      }
   } 
   
   /**
   * Takes no parameters and equates the height of the square antiprism.
   * @return returns the calculated height of the antiprism as double.
   */ 
   public double height() {
      
      double numerator = Math.pow(1 / (Math.cos(Math.PI / 16)), 2);
      double height = (Math.sqrt(1 - (numerator / 4))) * edge;
      return height;
   }
   
   /**
   * Takes no parameters and equates the surface area of the antiprism.
   * @return returns the surface area of antiprism as double
   */
   public double surfaceArea() {
   
      double parantheses = (((Math.cos(Math.PI / 8)) / (Math.sin(Math.PI / 8)))
         + Math.sqrt(3));
      double surfaceArea = 4 * parantheses * Math.pow(edge, 2);
      
      return surfaceArea;
   }
   
   /**
   * Takes no parameters and equates the volume of the antiprism.
   * @return returns the volume as a double
   */
   public double volume() {
      
      double sqrt = Math.sqrt(4 * (Math.pow(Math.cos(Math.PI / 16), 2)) - 1);
      double fraction = (Math.pow(edge, 3)) / (12 * (Math.pow((Math.sin(Math.PI 
         / 8)), 2)));
      double volume = 8 * sqrt * (Math.sin((3 * Math.PI) / 16)) * fraction;
      
      return volume;
   }
   
   /**
   * Returns a string containing all the information about the antiprism.
   * @return returns a readable string composed of info about antirpism.
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      output = "SquareAntiprism \"" + label + "\" with edge of " + edge
         + " units has:"
         + "\n\theight = " + df.format(height()) + " units"
         + "\n\tsurface area = " + df.format(surfaceArea()) + " square units"
         + "\n\tvolume = " + df.format(volume()) + " cubic units";
         
      return output;
   }
    
    /**
    * static method that returns the int representing the count field.
    * @return returns the count value as an int
    */
   public static int getCount() {
      return count;
   }
   
    /**
    * Static method that resets the count field to zero.
    */
   public static void resetCount() {
      count = 0;
   }
    
    /**
    * Instance method used by JUnit when two objects are checked for equality.
    * @param obj is of type object
    * @return returns false if object is not a SquareAntiprism
    *    returns true if object has the same fields as SqaureAntiprism
    */
   public boolean equals(Object obj) {
      
      if (!(obj instanceof SquareAntiprism)) {
         return false;
      }
      else {
         SquareAntiprism d = (SquareAntiprism) obj;
         return (label.equalsIgnoreCase(d.getLabel())
            && (Math.abs(edge - d.getEdge()) < .000001));
      }
   }
   /**
   * This method is required by Checkstyle is the equal mathod is implemented.
   * @return returns 0 as an int
   */
   public int hashCode() {
      return 0;
   }
    /**
    * Compares two object's volumes and returns a certain integer.
    * @param obj is a square antiprism type object.
    * @return returns 0 if the two volumes are equal to each other
    *    returns negative if the this.volume() is less than the other
    *    returns positive if the obj.volume() is less than this.volume().
    */
   public int compareTo(SquareAntiprism obj)  {
      if (Math.abs(this.volume() - obj.volume()) < 0.000001) {
         return 0;
      }
      else if (this.volume() < obj.volume()) {
         return -1;
      }
      else {
         return 1;
      }
      
   }

}
   
   

