import java.util.Comparator;
/**
* Implements comparator interface and compares two BallPlayer's names.
*
* Project 10 - NameComparator
* @author Dev Patel - COMP 1210 - 006
* @version 4/13/2022
*/
public class NameComparator implements Comparator<BallPlayer> {
   
   
   /**
   * Compares 2 different player's names.
   *
   * @param p1 represents and stores information about player 1
   * @param p2 represents and stores information about player 2
   * @return returns a zero if the two string are equal
   *         returns a -1 if p1 is greater and a 1 is p2 is greater.
   */
   public int compare(BallPlayer p1, BallPlayer p2) {
      
      int compareP1 = p1.getName().indexOf(" ");
      int compareP2 = p2.getName().indexOf(" ");
      
      String p1Name = (p1.getName().substring(compareP1 + 1)
         + p1.getName().substring(0, compareP1).toUpperCase());
         
      String p2Name = (p2.getName().substring(compareP2 + 1)
         + p2.getName().substring(0, compareP2).toUpperCase());
      
      return p1Name.compareTo(p2Name);
   }
   
}