
/**
 * Class for therequired phraseAlter method.
 * Method phraseAlter runs required code.
 * @author Richard Li
 * @version 10/21/20
 */
import java.util.Scanner;
public class Phrase{
   
    public void phraseAlter(){
        //Initiate
        Scanner keyboard = new Scanner(System.in);
        System.out.println("________________________________________________________________________________");
        System.out.println("Type in a 5 word phrase with a punctation symbol at the end." );
        String phrase = keyboard.nextLine();
        
        //Split String vales
        int split1 = phrase.indexOf(" ");
        int split2 = phrase.lastIndexOf(" ");
        
        //Spliting String
        String punc =   phrase.substring(phrase.length() - 1);
        String middle = phrase.substring(split1, split2 + 1);
        String word1 =  phrase.substring(0, split1);
        String word5 =  phrase.substring(split2 + 1, phrase.length() - 1);
        
        //Changing CapsLock
        String lCase = word1.substring(0,1).toLowerCase();
        String keep =  word1.substring(1);
        word1 =        lCase + keep;
        String uCase = word5.substring(0,1).toUpperCase();
        keep =         word5.substring(1);
        word5 =        uCase + keep;
        
        //Display sentence with words 1 and 5 changed
        System.out.println(word5 + middle + word1 + punc);
        
        //Find Acronym
        String ac = phrase.substring(0, 1);
        int count = 0; //To find spaces to find first letters of words
        for(int x = 1; x < 5; x++){
            int temp = phrase.indexOf(" ", count+1);
            ac += phrase.substring(temp + 1, temp + 2);
            count=temp;
        }
        ac = ac.toUpperCase();
        
        System.out.println(ac);
        
        //Display phrase with 3 punctuations at the end
        System.out.println(phrase + punc + punc);
        
        //SPECIAL FEATURE Random sequence Acronym
        
        int multiplier = 5; //Used to set random parameters
        String result =  ""; //final result
        char[] shuffle = new char[ac.length()]; //Stores chars to build Acronym
           
        //Filling array
        for(int x = 0; x < 5; x++){
            shuffle[x] = ac.charAt(x);
        }
        
        //Shuffling
        for(int x = 0; x < 5; x++){
            int chose = (int)(Math.random() * multiplier);
            result += shuffle[chose];
            shuffle[chose] = shuffle[multiplier-1];
            multiplier--;
        }
        
        System.out.println(result);
        
        
    }
}
