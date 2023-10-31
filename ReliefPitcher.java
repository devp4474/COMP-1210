/**
* Derived from Pitcher class. Adds saves and alters the total earnings formula.
*
* Project 9 - ReliefPitcher
* @author Dev Patel - COMP 1210 - 006 
* @version 4/7/2022
*/
public class ReliefPitcher extends Pitcher {

   // intance variable
   private int saves;
   
   // constructor
   /**
   * Constructor accepts 10 parameters and sets them to corresponding variable.
   *
   * @param numberIn represents and stores the number string 
   * @param nameIn represents and stores the name string
   * @param positionIn represents and stores the position string
   * @param baseSalaryIn represents and stores the salary double
   * @param bonusAdjustmentFactorIn represents and stores the BAF double
   * @param battingAvgIn represent and stores the battingAvg double
   * @param winsIn represents nad stores the wins int
   * @param lossesIn represents and stores the losses int
   * @param eraIn represents and stores the era double
   * @param savesIn represents and stores the saves int
   */
   public ReliefPitcher(String numberIn, String nameIn, String positionIn,
      double baseSalaryIn, double bonusAdjustmentFactorIn, 
      double battingAvgIn, int winsIn, int lossesIn, double eraIn,
      int savesIn)
   {
      super(numberIn, nameIn, positionIn, baseSalaryIn,
         bonusAdjustmentFactorIn, battingAvgIn, winsIn, lossesIn, eraIn);
      wins = winsIn;
      losses = lossesIn;
      era = eraIn;
      saves = savesIn;
   }
   /**
   * Takes 0 parameters and returns the saves as an int.
   * @return saves returns saves value as int
   */
   public int getSaves() {
      return saves;
   }
   /**
   * Takes 1 parameter and returns nothing. Sets savesIn to saves.
   * @param savesIn represents and stores the saves int value
   */
   public void setSaves(int savesIn) {
      saves = savesIn;
   }
   /**
   * Calculates and returns a relief pitcher's total earnings.
   * @return total earnings is returned as double
   */
   public double totalEarnings() {
      double result = baseSalary * bonusAdjustmentFactor * (1 / (1 + era))
         * ((wins - losses + saves) / 30.0);
      double total = baseSalary + result;
      return total;  
   }
   /**
   * Arranges info about wins, losses, saves, and era into readable string.
   * @return output returns the readable string.
   */
   public String stats() {
      String output = wins + " wins, " + losses + " losses, " + saves
         + " saves, " + era + " ERA";
      return output;
   
   }
   
   



}