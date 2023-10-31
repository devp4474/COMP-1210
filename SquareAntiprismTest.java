import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;

 /**
 * Tests the methods of the SquareAntiprism.
 *
 * Project 7A - SquareAntiprismTest
 * @author Dev Patel - COMP 1210 - 006
 * @version 3/17/2022
 */
public class SquareAntiprismTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
   * Tests the getLabel method.
   */
   @Test public void getLabelTest() {
      SquareAntiprism ex1 = new SquareAntiprism("Small Example", 1.25); 
      Assert.assertEquals("Small Example", ex1.getLabel());
   }
   
   /**
   * Tests the setLabel method.
   */
   @Test public void setLabelTest() {
      SquareAntiprism ex2 = new SquareAntiprism("Another Example", 1.25);
      ex2.setLabel("Hello");
      Assert.assertEquals("Hello", ex2.getLabel()); 
   }
   /**
   * Test the setLabel method with a null input.
   */
   @Test public void setLabelTestNull() {
      SquareAntiprism a = new SquareAntiprism("Example", 3);
      Assert.assertEquals(false, a.setLabel(null));
   }
   
    /**
    * Tests the getEdge method.
    */
   @Test public void getEdgeTest() {
      SquareAntiprism ex3 = new SquareAntiprism("Small Example", 1.25);
      Assert.assertEquals(1.25, ex3.getEdge(), 0.000001); 
   }  
   
   /**
   * Tests the setEdge method.
   */
   @Test public void setEdgeTest() {
      SquareAntiprism ex4 = new SquareAntiprism("Small Example", 1.25);
      ex4.setEdge(4.0);
      Assert.assertEquals(4.0, ex4.getEdge(), 0.000001);
      Assert.assertEquals(false, ex4.setEdge(-4)); 
   }
   
   /**
   * Tests the height method.
   */
   @Test public void heightTest() {
      SquareAntiprism ex5 = new SquareAntiprism("Small Example", 1.25);
      double numerator = Math.pow(1 / (Math.cos(Math.PI / 16)), 2);
      double height = (Math.sqrt(1 - (numerator / 4))) * 1.25;
      Assert.assertEquals(height, ex5.height(), 0.000001);
   }
   
    /**
    * Tests the surfaceArea method.
    */
   @Test public void surfaceAreaTest() {
      SquareAntiprism ex6 = new SquareAntiprism("Small Example", 1.25);
      double parantheses = (((Math.cos(Math.PI / 8)) / (Math.sin(Math.PI / 8)))
         + Math.sqrt(3));
      double surfaceArea = 4 * parantheses * Math.pow(1.25, 2);
      Assert.assertEquals(surfaceArea, ex6.surfaceArea(), 0.000001);
   }
   
   /**
   * Tests the volume method.
   */
   @Test public void volumeTest() {
      SquareAntiprism ex7 = new SquareAntiprism("Small Example", 1.25);
      double sqrt = Math.sqrt(4 * (Math.pow(Math.cos(Math.PI / 16), 2)) - 1);
      double fraction = (Math.pow(1.25, 3)) / (12 * (Math.pow((Math.sin(Math.PI 
         / 8)), 2)));
      double vol = 8 * sqrt * (Math.sin((3 * Math.PI) / 16)) * fraction;
      Assert.assertEquals(vol, ex7.volume(), 0.000001);
   }
   
   /**
   * Tests the toString method.
   */
   @Test public void toStringTest() {
      SquareAntiprism ex8 = new SquareAntiprism("Small Example", 1.25);
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
       
      double numerator = Math.pow(1 / (Math.cos(Math.PI / 16)), 2);
      double height = (Math.sqrt(1 - (numerator / 4))) * 1.25;
      
      double parantheses = (((Math.cos(Math.PI / 8)) / (Math.sin(Math.PI / 8)))
         + Math.sqrt(3));
      double surfaceArea = 4 * parantheses * Math.pow(1.25, 2);
      
      double sqrt = Math.sqrt(4 * (Math.pow(Math.cos(Math.PI / 16), 2)) - 1);
      double fraction = (Math.pow(1.25, 3)) / (12 * (Math.pow((Math.sin(Math.PI 
         / 8)), 2)));
      double vol = 8 * sqrt * (Math.sin((3 * Math.PI) / 16)) * fraction;
      
      output = "SquareAntiprism \"Small Example\" with edge of " + 1.25
         + " units has:"
         + "\n\theight = " + df.format(height) + " units"
         + "\n\tsurface area = " + df.format(surfaceArea) + " square units"
         + "\n\tvolume = " + df.format(vol) + " cubic units";
      Assert.assertEquals(output, ex8.toString());
   }
   
   /**
   * Tests the getCount method.
   */
   @Test public void getCountTest() {
      SquareAntiprism ex8 = new SquareAntiprism("Small Example", 1.25);
      ex8.resetCount();
      SquareAntiprism ex9 = new SquareAntiprism("Small Example", 1.25);
      Assert.assertEquals(1, ex8.getCount());
   }
   
   /**
   * Tests the resetCount method.
   */
   @Test public void resetCountTest() {
      SquareAntiprism ex10 = new SquareAntiprism("Small Example", 1.25);
      ex10.resetCount();
      Assert.assertEquals(0, ex10.getCount(), 0.000001);
   }
   
   /**
   * Tests the equals() method.
   */
   @Test public void equalsTest() {
      SquareAntiprism ex11 = new SquareAntiprism("Small Example", 1.25);
      SquareAntiprism ex12 = new SquareAntiprism("Small Example", 1.25);
      SquareAntiprism ex13 = new SquareAntiprism("Small Example", 40);
      SquareAntiprism a = new SquareAntiprism("Test Example", 8);
      SquareAntiprism b = new SquareAntiprism("Test Example", 4);
      SquareAntiprism c = new SquareAntiprism("Test", 5);
      
      Object x = new Object();
      Assert.assertEquals(false, ex11.equals(x));
      
      Assert.assertEquals(true, ex11.equals(ex12));
      Assert.assertEquals(false, ex12.equals(ex13));
      Assert.assertEquals(false, ex11.equals(a));
      Assert.assertEquals(false, ex11.equals(b));
      Assert.assertEquals(false, ex11.equals(c));
      
   }
   
   /**
   * Tests the hash code method.
   */
   @Test public void hashCodeTest() {
      SquareAntiprism ex14 = new SquareAntiprism("Small Example", 1.25);
      Assert.assertEquals(0, ex14.hashCode(), 0.000001);
   }
   
    /**
    * Test the compareTo method with the first obj having the smaller volume.
    */
   @Test public void compareTo1() {
      SquareAntiprism obj1 = new SquareAntiprism("Small Example", 1.25);
      SquareAntiprism obj2 = new SquareAntiprism("Large Example", 50.0);
      
      Assert.assertTrue(obj1.compareTo(obj2) < 0);
   }
   
    /**
    * Tests the compareTo method with two objects with the same volume. 
    */
   @Test public void compareTo2() {
      SquareAntiprism obj3 = new SquareAntiprism("Small Example", 1.25);
      SquareAntiprism obj4 = new SquareAntiprism("Small Example 2", 1.25);
      
      Assert.assertTrue(obj3.compareTo(obj4) == 0);
   }
    
    /**
    * Tests the compareTo method with the first object having larger volume.
    */
   @Test public void comopareTo3() {
      SquareAntiprism obj5 = new SquareAntiprism("Large Example", 50.0);
      SquareAntiprism obj6 = new SquareAntiprism("Small Example", 1.25);
      
      Assert.assertTrue(obj5.compareTo(obj6) > 0);
   }

}
