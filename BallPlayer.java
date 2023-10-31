import java.text.DecimalFormat;
/**
* Stores ball player data and provides methods to access the data.
* 
* Project 9 - BallPlayer
* @author Dev Patel - COMP 1210 - 006
* @version 4/6/2022
*/
public abstract class BallPlayer implements Comparable<BallPlayer> {
   // instance variables
   protected String number;
   protected String name;
   protected String position;
   protected double baseSalary;
   protected double bonusAdjustmentFactor;
   protected double battingAvg;
   // class variable
   protected static int count = 0; 
   
   /**
   * Constructor accepts 6 parameters and sets them to corresponding variable.
   *
   * @param numberIn represents and stores the number string 
   * @param nameIn represents and stores the name string
   * @param positionIn represents and stores the position string
   * @param baseSalaryIn represents and stores the salary double
   * @param bonusAdjustmentFactorIn represents and stores the BAF double
   * @param battingAvgIn represent and stores the battingAvg double
   */
   public BallPlayer(String numberIn, String nameIn, String positionIn,
      double baseSalaryIn, double bonusAdjustmentFactorIn, double battingAvgIn)
   {
      number = numberIn;
      name = nameIn;
      position = positionIn;
      baseSalary = baseSalaryIn;
      bonusAdjustmentFactor = bonusAdjustmentFactorIn;
      battingAvg = battingAvgIn;
      count++;          
   }
   
   /**
   * Takes no parameters and returns the number string.
   * @return number returns the number string
   */
   public String getNumber() {
      return number;
   }
   
   /**
   * Takes one string parameter and returns nothing. Sets numberIn to number.
   * @param numberIn represents and stores the number string
   */
   public void setNumber(String numberIn) {
      number = numberIn;   
   }
   
   /**
   * Takes no parameters and returns the name of type string. 
   * @return returns the name string
   */
   public String getName() {
      return name;
   }
   
   /**
   * Takes 1 string parameter and returns nothing. Sets nameIn to name.
   * @param nameIn represents and stores the name string
   */
   public void setName(String nameIn) {
      name = nameIn;
   }
   
   /**
   * Takes no parameters and returns the position of type string.
   * @return returns the position string
   */
   public String getPosition() {
      return position;
   }
   
   /**
   * Takes 1 parameter and returns nothing. Sets positionIn to position.
   * @param positionIn represents and stores the position string
   */
   public void setPosition(String positionIn) {
      position = positionIn;
   }
   
   /**
   * Takes no parameters and returns the baseSalary of type double.
   * @return baseSalary of type double is returned.
   */
   public double getBaseSalary() {
      return baseSalary;
   }
   
   /**
   * Takes 1 parameter and returns nothing. Sets baseSalaryIn to baseSalary.
   * @param baseSalaryIn represents and stores the baseSalary double
   */
   public void setBaseSalary(double baseSalaryIn) {
      baseSalary = baseSalaryIn;
   }
   
   /**
   * Takes no parameters and returns the bonus adjustment factor type double.
   * @return BAF (bonus adjustment factor) of type double is returned.
   */
   public double getBonusAdjustmentFactor() {
      return bonusAdjustmentFactor;
   }
   
   /**
   * Takes 1 parameter and returns nothing. Sets BAFIn to BAF.
   * @param bonusAdjustmentFactorIn represents and stores the BAF.
   */
   public void setBonusAdjustmentFactor(double bonusAdjustmentFactorIn) {
      bonusAdjustmentFactor = bonusAdjustmentFactorIn;
   }
   
   /**
   * Takes no parameters and returns the battingAvg of type double.
   * @return battingAvg is returned as type double
   */
   public double getBattingAvg() {
      return battingAvg;
   }
   
   /**
   * Takes 1 parameter and returns nothings. Sets battingAvgIn to battingAvg.
   * @param battingAvgIn represents and stores the battingAvg double
   */
   public void setBattingAvg(double battingAvgIn) {
      battingAvg = battingAvgIn;
   }
   
   /**
   * Takes no parameters and returns the count of type int.
   * @return count is retured as type int.
   */
   public static int getCount() {
      return count;
   }
   
   /**
   * Resets the count to 0, returns nothing, and takes no parameters.
   */
   public static void resetCount() {
      count = 0;
   }
   
   /**
   * Formats the battingAvg to the ".000" format using DecimalFormat.
   * @return returns the formatted battingAvg in ".000" form.
   */
   public String stats() {
      DecimalFormat df = new DecimalFormat(".000");
      return df.format(getBattingAvg());
   }
   
   /**
   * Organizes information about ball player into one readable string.
   * @return returns the readable string containing info about the ball player.
   */
   public String toString() {
      DecimalFormat cash = new DecimalFormat("$###,###.00");	
      String output =  number + " " + name + " (" + position + ") " + stats()
         + "\nBase Salary: " + cash.format(baseSalary) + " Bonus Adjustment "
         + "Factor: " + bonusAdjustmentFactor
         + "\nTotal Earnings: " + cash.format(totalEarnings()) + " (" 
         + this.getClass() + ")";
      return output;
   }
   
   /**
   * Abstract method, accepts no parameters, and returns double.
   * Is used later to calculate the total Earnings of a player.
   * @return returns the total earnings of a ball player as a double.
   */
   public abstract double totalEarnings();
   
   
   /**
   * Compares 2 different players based on their numbers.
   * @param ballPlayerIn represents and stores ball player data.
   * @return 1 if obj1 is greater, -1 if less, and 0 if equal.
   */
   public int compareTo(BallPlayer ballPlayerIn) {
   // variable name i is used to represent integer in list
      int i = Integer.parseInt(this.getNumber().trim())
         - Integer.parseInt(ballPlayerIn.getNumber().trim());
      if (i == 0) {
         return 0;
      }
      else {
         return i > 0 ? 1 : -1;
      
      }
   
   }
   
   
}