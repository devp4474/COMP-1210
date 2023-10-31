/**
* Derived from BallPlayer class. Adds outfielderFieldingAvg and more methods.
*
* Project 9 - Outfielder
* @author Dev Patel - COMP 1210 - 006 
* @version 4/7/2022
*/
public class Outfielder extends BallPlayer {

   // intance variable
   private double outfielderFieldingAvg;
   
   // construcotr 
   /**
   * Constructor accepts 6 parameters and sets them to corresponding variable.
   * 
* @param numberIn represents and stores the number string 
* @param nameIn represents and stores the name string
* @param positionIn represents and stores the position string
* @param baseSalaryIn represents and stores the salary double
* @param bonusAdjustmentFactorIn represents and stores the BAF double
* @param battingAvgIn represents and stores the battingAvg double
* @param outfielderFieldingAvgIn represents and stores the fielding average
   */
   public Outfielder(String numberIn, String nameIn, String positionIn,
         double baseSalaryIn, double bonusAdjustmentFactorIn, 
         double battingAvgIn, double outfielderFieldingAvgIn)
   {
      super(numberIn, nameIn, positionIn, baseSalaryIn,
         bonusAdjustmentFactorIn, battingAvgIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
   * Takes no parameters and returns the outfielderFieldingAvg as double.
   * @return outfielderFieldingAvg is returned as double.
   */
   public double getOutfielderFieldingAvg() {
      return outfielderFieldingAvg;
   }
   /**
   * Takes 1 parameter and returns nothing. sets outfielderFieldingAvg.
   * @param outfielderFieldingAvgIn represents and stores the outfielder
   *     fielding average.
   */
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn) {
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
   * Calculates and returns an outfielder's total earnings.
   * @return total returns the total earnings.
   */
   public double totalEarnings() {
      double result = baseSalary * bonusAdjustmentFactor * battingAvg
         * outfielderFieldingAvg;
      double total = result + baseSalary;
      return total;
   }

}