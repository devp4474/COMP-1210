/**
 * Derived from BallPlayer. Adds wins, losses, era, and more.
 * 
 * Project 9 - Pitcher
 * @author Dev Patel - COMP 1210 - 006
 * @version 4/7/2022
 */
public class Pitcher extends BallPlayer {
   
   // intance variables
   protected int wins;
   protected int losses;
   protected double era;
   
   // constructor
   /**
   * Constructor accepts 9 parameters and sets them to corresponding variable.
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
   */
   public Pitcher(String numberIn, String nameIn, String positionIn,
      double baseSalaryIn, double bonusAdjustmentFactorIn, 
      double battingAvgIn, int winsIn, int lossesIn, double eraIn)
   {
      super(numberIn, nameIn, positionIn, baseSalaryIn,
         bonusAdjustmentFactorIn, battingAvgIn);
      wins = winsIn;
      losses = lossesIn;
      era = eraIn;
   }   
    /**
    * Takes 0 parameters and returns the number of wins as an int.
    * @return wins returns the int number of wins
    */
   public int getWins() {
      return wins;
   }
   /**
   * Takes 1 parameter and returns nothing. Sets winsIn to wins.
   * @param winsIn represents and stores the win int
   */
   public void setWins(int winsIn) {
      wins = winsIn;
   }
   /**
   * Takes 0 parameters and returns the number of losses as an int.
   * @return losses returns the number of losses as int
   */
   public int getLosses() {
      return losses;
   }
    /**
    * Takes 1 parametr and returns nothing. Sets lossesIn to losses.
    * @param lossesIn represents and stores the losses int
    */
   public void setLosses(int lossesIn) {
      losses = lossesIn;
   }
    
    /**
    * Takes 0 parametrs and returns the doube era.
    * @return era reutrns the era as a double
    */
   public double getEra() {
      return era;
   }
    
    /**
    * Takes 1 paramter and returns nothing. Sets eraIn to era.
    * @param eraIn represents and stores the era double
    */
   public void setEra(double eraIn) {
      era = eraIn;
   }
    
    /**
    * Calculates and returns the total earnings of a pitcher.
    * @return total earnings of pitcher as double
    */
   public double totalEarnings() {
      double total = (getBaseSalary() * getBonusAdjustmentFactor()
         * (1 / (1 + era)) * ((wins - losses) / 25.0)) + getBaseSalary();
      return total;
   }
   
   /**
   * Arranges the number of wins, losses, and ERA into a readable string.
   * @return returns the string of the wins, losses, and era
   */
   public String stats() {
      String output = wins + " wins, " + losses + " losses, " + era + " ERA";
      return output;
   }
   
   

}