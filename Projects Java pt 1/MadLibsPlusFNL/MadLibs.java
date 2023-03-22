
/**
 * Write a description of class MadLibs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class MadLibs
{
   String name;
   String catName;
   int numOfCats;
   String financialSit;
   String lifeProb;
   int debt;
   String articleClothesTop;
   String articleClothesBottom;
   int santa;
   String santas;
   int miracles;
   String miracle;
   String randomEnd;
   
   public void playGame()
   {
      Scanner keyboard =  new Scanner(System.in); //Input setup
       //Questions
      String[] prompts = new String[]{"What's your name?:", 
           "What the name of you imaginary pet(name):",
           "a negative adjective:", "a problem in life(noun):",
           "An article of clothing(Top, Ex: like a shirt):", 
           "An article of clothing(Bottom, Ex: like pants):",
           "Do you believe in Santa?(press 1 for yes, 0 for no):", 
           "Do you believe in Miracles?(press 1 for yes, 0 for no):",
           "How do you want you die(adjective):", 
           "Write an obscenely large number(Integer):",
           "How many years do you want to go to school for(Integer):"};
       //Asking for answers
      System.out.println(prompts[0]);
      name                 = keyboard.next();
      System.out.println("We will now start our game of Madlibs!");
      System.out.println("A simple but funny word game of fill in the blanks.");
      System.out.println(prompts[1]);
      catName              = keyboard.next();
      System.out.println(prompts[2]);
      financialSit         = keyboard.next();
      System.out.println(prompts[3]);
      lifeProb             = keyboard.next();
      System.out.println(prompts[4]);
      articleClothesTop    = keyboard.next();
      System.out.println(prompts[5]);
      articleClothesBottom = keyboard.next();
      System.out.println(prompts[6]);
     
       //Start of user influenced storyline.
      if(santa == 1) {
         santas = "\"Oh Yeah, I almost forgot, Also, since you believe in santa, he'll pay off your debt.  Toodles\"";
      }else {
         santas = "\"Oh Yeah, I almost forgot, Also,since you did not believe in santa. "
            +"\n You will never rest in peace due to leaving a ton\n of debt and increasing government taxes. Toodeles. \n";
      }
      System.out.println(prompts[7]);
      miracles             = Integer.parseInt(keyboard.next());
      if(miracles == 1){
         miracle = "You believe in miracles, thus you won't sufflocate \n under the cats." +
            " Thus as you ponder your fate you hear the voice again, it says,";
      }else{
         miracle = "You do not believe in miracles, thus you shall sufflocate under the cats.\n" + 
            " Thus as you ponder your not so" + randomEnd + "death." + "  You hear the voice again, it says,";
      }
      System.out.println(prompts[8]);
      randomEnd            = keyboard.next();
      System.out.println(prompts[9]);
      numOfCats            = Integer.parseInt(keyboard.next());
      System.out.println(prompts[10]);
      debt                 = Integer.parseInt(keyboard.next());
      debt*=100000;
       
       // The story
      System.out.println("Once upon a time there was a person called "
         + name + ".\n" +"He/She was a a middle aged person" +
         " who was struggling financially.\n" +"He/She's " + financialSit + 
         " was so bad that they got extremely depressed.\n" +"She/He, had over " 
         + debt +" in debt, and suffered from" + lifeProb + ".\n" +
         "So, while he/she was sitting on her/his couch\n" + 
         "in " +articleClothesTop + " and " + articleClothesBottom + 
         " stroking his/her cat\n"+ catName +
         " in the middle of his/her rundown apartment." +"  \nHe'She wished for " 
         + numOfCats + " cats, because " + "she's/he's old and lonely and poor."
         + "  \nAs such, some random diety decided to drop " +
         numOfCats + " cats in " + name +"'s apartment" +
         "  As such, \nas the man laid there in his pile of cat,\n"+
         "the force sent to him/her a thought saying, ");
      System.out.println(miracle);
      System.out.println(santas);
      System.out.println("So as you ponder your fate... the deity leaves to \n" +
         "deliver news and grant wishes to the next 543234 people");
      System.out.println("THE END!!!  What an amazing story right?...");
       
       
       
       
       
       
       
       
       
      
        
   
       
       
       
       
   }
}
