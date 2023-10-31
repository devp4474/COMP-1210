import java.io.FileNotFoundException;
/**
* Driver of BallTeam.
*
* Project 10 - BallPlayersPart2
* @author Dev Patel - COMP 1210 - 006
* @version 4/13/2022
*/
public class BallPlayersPart2 {
   
   /**
   * Allows for pass in of file name in command line arguments.
   *     File is then used to generate several reports of the players.
   * @param args Command line argument - used.
   * @throws FileNotFoundException - used.
   */
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else {
         BallTeam team = new BallTeam();
         team.readBallPlayerFile(args[0]);
         
         System.out.println(team.generateReport() + "\n");
         System.out.println(team.generateReportByNumber() + "\n");
         System.out.println(team.generateReportByName() + "\n");
         System.out.println(team.generateReportByEarnings() + "\n");
         System.out.println(team.generateExcludedRecordsReport() + "\n");
         
      }
      
   }
}