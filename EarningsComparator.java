import java.util.Comparator;
/**
* Implements comparator interface and compares 2 ballPlayer's total earnings.
*
* Project 10 - EarningsComparator
* @author Dev Patel - COMP 1210 - 006
* @version 4/13/2022
*/
public class EarningsComparator implements Comparator<BallPlayer> {
   
   
   /**
   * Compares 2 different player's earnings.
   *
   * @param p1 represents and stores information about player 1
   * @param p2 represents and stores information about player 2
   * @return returns a zero if both player's earnings are equal
   *     returns a -1 if player one's earnings are greater and 
   *     returns a 1 if players two's earnings are greater.
   */
   public int compare(BallPlayer p1, BallPlayer p2) {
      double p1Earnings = p1.totalEarnings();
      double p2Earnings = p2.totalEarnings();
      
      if (Math.abs(p1Earnings - p2Earnings) < 0.000001)  {
         return 0;
      } 
      else {
         return p1Earnings > p2Earnings ? -1 : 1;
      }
   
   }

}