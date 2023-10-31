/**
* Derived from BallPlayer class. Adds infielderFieldingAvg and more methods.
*
* Project 9 - Outfielder
* @author Dev Patel - COMP 1210 - 006 
* @version 4/7/2022
*/
public class Infielder extends BallPlayer {

   // intance variables
   private double infielderFieldingAvg;
   
   // constructor
         /**
   * Constructor accepts 6 parameters and sets them to corresponding variable.
   * 
   * @param numberIn represents and stores the number string 
   * @param nameIn represents and stores the name string
   * @param positionIn represents and stores the position string
   * @param baseSalaryIn represents and stores the salary double
   * @param bonusAdjustmentFactorIn represents and stores the BAF double
   * @param battingAvgIn represents and stores the battingAvg double
   * @param infielderFieldingAvgIn represents and stores the fielding average
   */
   public Infielder(String numberIn, String nameIn, String positionIn,
      double baseSalaryIn, double bonusAdjustmentFactorIn, 
      double battingAvgIn, double infielderFieldingAvgIn)
   {
      super(numberIn, nameIn, positionIn, baseSalaryIn,
         bonusAdjustmentFactorIn, battingAvgIn);
      infielderFieldingAvg = infielderFieldingAvgIn;
   
   }
    /**
    * Takes no paramters and returns the infielderFieldingAvg as a double.
    * @return infielderFieldingAvg returns the average as a double.
    */
   public double getInfielderFieldingAvg() {
      return infielderFieldingAvg;
   }
   /**
   * Takes 1 parameter and returns nothing.
   *     Sets the infielderFiledingAvgIn to infielderFieldingAvg.
   * @param infielderFieldingAvgIn represents and stores the infielder's avg
   *     as a double and is used to be set to infielderFieldingAvg.
   */ 
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn) {
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
   /**
   * Calculates and returns an infielder's total earnings.
   * @return total returns the total earnings as a double
   */
   public double totalEarnings() {
      double result = baseSalary * bonusAdjustmentFactor * battingAvg
         * infielderFieldingAvg;
      double total = result + baseSalary;
      return total;
   }


}