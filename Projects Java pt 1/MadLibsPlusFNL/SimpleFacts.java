
/**
 * Write a description of class SimpleFacts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.lang.Math.*;
public class SimpleFacts
{   
    //Set up numbers
    int sum;
    int[] num = new int[6];
    
    public void showFacts()
    {
       //Ask for numbers + add to sum
       Scanner number = new Scanner(System.in);
       System.out.println("\\l On a different note...");
       
       for(int x=0; x<num.length; x++){
           System.out.println("Type a number");
           num[x]                 = Integer.parseInt(number.next());
           sum+=num[x];
       }
       
       System.out.println("The average of your numbers: " 
                            + String.format("%.2f", (sum/6.0)));  //the avg
       System.out.println("The sum of your numbers: " 
                            + sum); //the sum
       // the min and max
       int min = Math.min(Math.min(num[1],num[2]), 
       Math.min(num[3],Math.min(Math.min(num[4], num[5]),num[0])));
       int max = Math.max(Math.max(num[1],num[2]), 
       Math.max(num[3],Math.max(Math.max(num[4], num[5]),num[0])));
       System.out.println("The smallest number and the largest number: " 
                            + min + ", " +max);
                            
    }
        

}
