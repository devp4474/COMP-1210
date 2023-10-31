import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
* Takes coded ticket number input and then extracts info from it.
*
* Project 3 - Basketball Ticket
* @author Dev Patel - COMP 1210 - 006
* @version 2/1/2022
*/
public class BasketballTicket {
/**
* Extracts data from ticket code. 
* @param args Command line arguments - not used.
*/ 

   public static void main(String[] args) {
      
   // take ticket code input         
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter ticket code: ");
      String ticket = userInput.nextLine();
      ticket = ticket.trim();
   // if statement for 28 char min
      if (ticket.length() < 29) {
         System.out.println("\n*** Invalid Ticket Code ***");
         System.out.println("Ticket code must have at least 28 characters.");
      }
      else {
      //  variables and formatting for each data type
      
         // price
         String stringPrice = ticket.substring(0, 6);
         DecimalFormat pr = new DecimalFormat("$#,##0.00");
         double price = Double.parseDouble(stringPrice) / 100; 
         // discount
         String sdiscount = ticket.substring(6, 8);
         double discount = Double.parseDouble(sdiscount) / 100;
         DecimalFormat percentage = new DecimalFormat("0%");
         
         // cost calculations
         
         double amountOff = price * discount;
         double cost = price - amountOff;
         // time
         String hour = ticket.substring(8, 10);
         String minutes = ticket.substring(10, 12);
         String time = hour + ":" + minutes;
         
         // date
         String month = ticket.substring(12, 14);
         String day = ticket.substring(14, 16);
         String year = ticket.substring(16, 20);
         String date = month + "/" + day + "/" + year;
         
         // section
         String section = ticket.substring(20, 23);
         // row
         String row = ticket.substring(23, 25);
         // seat
         String seat = ticket.substring(25, 27);
         // prize number
         Random number = new Random();
         int prize = number.nextInt(1000000);
         // ticket description
         String description = ticket.substring(27, ticket.length()); 
         
         System.out.println("\nTicket: " + description);
         
         System.out.println("Date: " + date + "   Time: " + time);
         
         System.out.println("Section: " + section + "   Row: " + row
            + "   Seat: " + seat);
         
         System.out.println("Price: " + pr.format(price) + "   Discount: " 
            + percentage.format(discount) + "   Cost: " + pr.format(cost));
         //print prize number     
         System.out.println("Prize Number: " + prize);      
         
         
      
      
      }
   
   }


}