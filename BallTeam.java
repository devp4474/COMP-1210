import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
* Represents a team of ball players and includes several specialized methods.
* Methods read in data and produce reports.
*
* Project 10 - BallTeam
* @author Dev Patel - COMP 1210 - 006
* @version 4/13/2022
*/
public class BallTeam {

   // instance variables
   private String teamName;
   private BallPlayer[] roster = new BallPlayer[24];
   private int playerCount;
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   
   // constants
   /**
   * Int representing the max amount of players allowed on team.
   */
   public static final int MAX_PLAYERS = 24;
   /**
   * Int representing max amount of exluded records.
   */
   public static final int MAX_EXCLUDED = 30;
   
   
   // constructor
   /**
   * Constructor sets the fields from above and takes 0 parameters.
   */
   public BallTeam() {
      teamName = "";
      playerCount = 0;
      excludedCount = 0;
   }
   
   /**
   * Takes 0 parameters and returns the team's name.
   * @return teamName returns the team name as a string.
   */
   public String getTeamName() {
      return teamName;
   }
    
    /**
    * Takes 1 string paramter and returns nothing. Sets teamName to teamNameIn.
    * @param teamNameIn represents and stores the teamName as a string.
    */
   public void setTeamName(String teamNameIn) {
      teamName = teamNameIn;
   } 
   
   /**
   * Returns the team's roster as an array.
   * @return roster returns an array of the roster of the team.
   */
   public BallPlayer[] getRoster() {
      return roster;
   }
   
   /** 
   * Returns nothing, takes BallPlayer[] param and sets the roster to rosterIn.
   * @param rosterIn represents and stores the roster array.
   */
   public void setRoster(BallPlayer[] rosterIn) {
      roster = rosterIn;
   }
   
   /**
   * Takes no paramters and returns the player count as an int.
   * @return playerCount returns the number of players as an int.
   */
   public int getPlayerCount() {
      return playerCount;
   }
   
   /**
   * Takes 0 parameters and returns nothing. Sets player count to the param.
   * @param countIn represents and stores the count of players as an int.
   */
   public void setPlayerCount(int countIn) {
      playerCount = countIn;
   }
   
   /**
   * Takes 0 parameters and returns the excluded records as String[].
   * @return excludedRecords returns the String[] of excluded records.
   */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /**
   * Takes 1 paramter and returns nothing. Sets the excludedRecords to param.
   * @param excludedRecordsIn represents and stores excluded records.
   */
   public void setExcludedRecords(String[] excludedRecordsIn) {
      excludedRecords = excludedRecordsIn;
   }
   
   /**
   * Takes 0 paramters and returns the number of excluded records.
   * @return excludedCount returns int of excluded records quantity.
   */
   public int getExcludedCount() {
      return excludedCount;
   }
   
   /**
   * Takes 1 parameter and returns nothing. Sets excludedCount to the param.
   * @param excludedCountIn represents and stores number of excluded records.
   */
   public void setExcludedCount(int excludedCountIn) {
      excludedCount = excludedCountIn;
   }
   
   /**
   * Reads files to create rosters.
   * @param fileNameIn represnts and stores the file name string.
   * @throws FileNotFoundException - used.
   */
   public void readBallPlayerFile(String fileNameIn)
      throws FileNotFoundException
   {
   
      // reads file name
      Scanner scanFile = new Scanner(new File(fileNameIn));
      // sets the team name
      teamName = scanFile.nextLine().trim();
      
      String line = null;
      while (scanFile.hasNext()) {
         
         // reads lines
         line = scanFile.nextLine();
         Scanner lineScan = new Scanner(line);
         lineScan.useDelimiter(",");
         
         // player read
         char category = lineScan.next().charAt(0);
         BallPlayer player;
         
         
         switch (category) {
            case 'O':
               player = new Outfielder(lineScan.next(), lineScan.next(), 
                  lineScan.next(), lineScan.nextDouble(),
                  lineScan.nextDouble(), lineScan.nextDouble(),
                  lineScan.nextDouble());
               break;
            case 'I':
               player = new Infielder(lineScan.next(), lineScan.next(), 
                  lineScan.next(), lineScan.nextDouble(),
                  lineScan.nextDouble(), lineScan.nextDouble(),
                  lineScan.nextDouble());
               break;
            case 'P':
               player = new Pitcher(lineScan.next(), lineScan.next(), 
                  lineScan.next(), lineScan.nextDouble(),
                  lineScan.nextDouble(), 
                  lineScan.nextDouble(), lineScan.nextInt(),
                  lineScan.nextInt(), lineScan.nextDouble());
               break;
            case 'R':
               player = new ReliefPitcher(lineScan.next(), lineScan.next(),
                  lineScan.next(), lineScan.nextDouble(),
                  lineScan.nextDouble(), 
                  lineScan.nextDouble(), lineScan.nextInt(),
                  lineScan.nextInt(), lineScan.nextDouble(),
                  lineScan.nextInt());
               break;
            default:
               if (excludedCount < MAX_EXCLUDED) {
                  excludedRecords[excludedCount++] = "*** invalid category"
                     + " *** " + line + "\n";
               }  
               continue;
         
         
         }
         if (playerCount < MAX_PLAYERS) {
            roster[playerCount++] = player;
         }
         else if (excludedCount < MAX_EXCLUDED) {
            excludedRecords[excludedCount++] = line;
         }
         
      }
      
   }
   /**
   * Generates team report according to the roster.
   * @return output is readable team report string.
   */
   public String generateReport() {
      String output = "";
      output += "---------------------------------------"
         + "\nTeam Report for " + teamName
         + "\n---------------------------------------";
      for (BallPlayer player : roster) {
         if (player != null) {
            output += "\n\n" + player;
         }
      }
      return output;
   }
   /**
   * Generates a team report like above but organized by player's numbers.
   * @return output is readable team report string organized by number.
   */
   public String generateReportByNumber() {
   
      BallPlayer[] byNumber = Arrays.copyOf(roster, playerCount);
      Arrays.sort(byNumber);
   
   
      
      String output = "";
      output += "---------------------------------------"
         + "\nTeam Report for " + teamName + " (by Number)"
         + "\n---------------------------------------";
         
      for (BallPlayer player : byNumber) {
         if (player != null) {
            output += "\n" + player.getNumber() + " " + player.getName()
               + " " + player.getPosition() + " " + player.stats();
         }
      }
      return output;  
   }
   /**
   * Generates a team report like above but organized by player names.
   * @return output is readable team report string organized by names.
   */
   public String generateReportByName() {
      BallPlayer[] byName = Arrays.copyOf(roster, playerCount);
      Arrays.sort(byName, new NameComparator());
      
      String output = "";
      output += "---------------------------------------"
         + "\nTeam Report for " + teamName + " (by Name)"
         + "\n---------------------------------------";
      for (BallPlayer player : byName) {
         if (player != null) {
            output += "\n" + player.getNumber() + " " + player.getName()
               + " " + player.getPosition() + " " + player.stats();
         }
      }
      return output; 
   }
   /**
   * Generates a team report like above but organized by player earnings.
   * @return output is readable team report organized by earnings.
   */
   public String generateReportByEarnings() {
      DecimalFormat df = new DecimalFormat("$###,###.00");
      
      BallPlayer[] byEarnings = Arrays.copyOf(roster, playerCount);
      Arrays.sort(byEarnings, new EarningsComparator());
      
      String output = "";
      output += "---------------------------------------"
         + "\nTeam Report for " + teamName + " (by Earnings)"
         + "\n---------------------------------------";
      for (BallPlayer player : byEarnings) {
         if (player != null) {
            output += "\n" + df.format(player.totalEarnings())
               + " " + player.getNumber() + " " + player.getName() 
               + " " + player.getPosition() + " " + player.stats();
         }
      }
      return output;
   }
   
   /**
   * Generates excluded records report.
   * @return output readable string of excluded records.
   */
   public String generateExcludedRecordsReport() {
      String output = "";
      output += "---------------------------------------"
         + "\nExcluded Records Report"
         + "\n---------------------------------------";
      for (String excluded : excludedRecords) {
         if (excluded != null) {
            output += "\n" + excluded;
         }
      }
      return output;
   }

}