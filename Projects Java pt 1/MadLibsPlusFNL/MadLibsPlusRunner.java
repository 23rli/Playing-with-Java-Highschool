
/**
 * Write a description of class MadLibsPlusRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class MadLibsPlusRunner
{
   public static void main(String[] args)
   {
       Scanner feedback = new Scanner(System.in);  //User input scanner
       
       MadLibs game = new MadLibs();// create madllibs game
       game.playGame(); //start above
       
       SimpleFacts fact = new SimpleFacts();  // new simple facts
       fact.showFacts();//start the above
       //feedback question
       System.out.println("Would you like to give feedback? Type it below.");
       String harshFeedback = feedback.next();
       System.out.println("Thank you, have a good day!");
       
   }
}
