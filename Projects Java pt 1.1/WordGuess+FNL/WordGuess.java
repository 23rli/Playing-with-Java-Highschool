
/**
 * The class holds the method playGame which is run to start the wordGuess game.
 * The WordGuess game is completely run within the method  playGame();
 *
 * @author Richard Li
 * @version 10/21/20
 */
import java.util.Scanner;

public class WordGuess
{
    public void playGame(){
        
        //Setup
        String[] words =    new String[]{"penguin", "robin", "ostrich", "peacock", "kingfisher"}; //Guess words
        Scanner letter =    new Scanner(System.in);
        boolean game =      true; //Game status
        boolean eEFir =     true; //Easter Egg only ONE time
        int tries =         10;   //Tries
        int rounds =        1;    //Rounds
        int selection =     (int)(Math.random() * words.length);
        int length =        words[selection].length();
        char[] tracker  =   new char[length]; //SPECIAL FEATURE:underlines/shows guessed letters for display, UPDATED EACH ROUND 
        char[] guessed =    new char[26];     //Guessed letters
        String guess =      words[selection];
        for(int x = 0; x < length; x++){
            tracker[x] = '_'; //Display setup
        }
        
        //Game Explanation
        rules(length);
        
        //Start Game
        while(game){
            //Initial Setup - Display
            System.out.println("_______________________________________________" + 
            "____________________________________________________");
            System.out.println("Round: " + rounds + "              " +
            "          Tries: " + tries + "\n");
            
            for(int x = 0; x < length; x++){
                System.out.print(tracker[x] + " ");
                
            }
            System.out.println("\nGuess a letter");
            String answer = letter.next();
            answer = answer.toLowerCase();
            
            //Easter Egg
            if(answer.equals("?") && eEFir){
                eEFir = false;
                String reveal = guess.substring(2,guess.length()-1); //find middle of word to be guessed
                
                System.out.println("Easter Egg Achieved!!!\n Revealing middle of" + 
                " guessed word, adding 3 tries!\n\n P.S. This only works once...");
               
                //reveal middle of word ot be guessed
                for(int x = 2; x < guess.length() - 3; x++){
                    tracker[x] = reveal.charAt(x-2);
                
                }
                tries += 3;
                
            //Letter Guessing
            }else if(answer.length() == 1){
                char temp = answer.charAt(0);
                boolean exist =    false; // Does the letter show up in the word to be guessed
                boolean preGuess = false; //Has the char been typed before
                for(int x = 0; x < 26; x++){
                    if(temp == guessed[x]) preGuess = true;
                }
                
                //Check if guessed before
                if(!preGuess){
                    //Check if letter is in word to be guessed
                    for(int x = 0; x < length; x++){
                        if(guess.charAt(x) == temp ){
                            //Check if guessed right
                            tracker[x] = temp;
                            System.out.println(temp + " exists at: " + x);
                            exist = true;
                            
                            
                        }
                    }
                    //If it doesn't exist
                    if(!exist){
                        System.out.println("Oh no! " + temp + 
                        " does not show up in the word, tries -1.");
                        tries--;
                    }
                    //If letter has been guessed before
                }else{
                    System.out.println("You have already guessed this letter before...");
                }
                //check if game completed
                game = false;
                for(int x=0; x<guess.length(); x++){
                    if(guess.charAt(x) != tracker[x]) game = true;
                }
                
                
                
            // Hints
            }else if(answer.equals("hint")){
                // Print display
                for(int x = 0; x < length; x++){
                    System.out.print(tracker[x] + " ");
                }
                System.out.println("");
                for(int x = 0; x < length; x++){
                    System.out.print(x + " ");
                }
                System.out.println("Type in the number of the letter that you wish to know.");
                
                //Get the letter the player wishes to reveal and reveal it
                String hintLetter = letter.next();
                int x =             Integer.parseInt(hintLetter);
                tracker[x] =        guess.charAt(x);
                tries =             tries - 3; 
                
                System.out.println("The letter you wished to reveal is: "
                + guess.charAt(x) );
                System.out.println("You revealed this letter at the cost of 3 points.");
                
            //Word Guessing(guessing more thanone character at one time)
            }else{
                //Is the answer
                if(answer.equals(guess)){
                    System.out.println("You got the word right!");
                    game = false;
                //Isn't the answer
                }else{
                    System.out.println("You guessed the wrong word... tries - 1.");
                    tries--;
                }
            }
            //Finishing checks before round resets, check if game completed, update rounds
            
            if(tries <= 0) game = false;
            if(game)rounds++;
            if(game) System.out.println("We now start the next round.");
            
            
        }
      
        //Game ended failed
        if(tries <= 0){
            System.out.println("GAME OVER");
            System.out.println("You ran out of tries...");
            System.out.println("The word was " + guess);
        //Game ended Success
        }else{
            System.out.println("Good job, you finished the game in " + rounds
            + " rounds, with " + tries + " tries left!\n\n\n\n\n");
        }
        System.out.println();
        
        Phrase f = new Phrase();
        f.phraseAlter();
      
       
      
    }
    
    //Rules display at beginning of game
    public void rules(int length){
        Utility u = new Utility();
        System.out.println("Hi let's play a game of Word Guess.\n");
        u.sleepIt(1);
        System.out.println("The rules are simple:\n");
        System.out.println("1. You need to guess the word before you run out of tries.");
        System.out.println("You have 10 tries, if you guess correctly" + 
        " no tries will  be deducted.");
        System.out.println("You can either guess the full word, or individual letter.\n");
        u.sleepIt(3);
        System.out.println("2. You can get hints to help identify your word.");
        System.out.println("By typing in 'hint' the system will reveal" + 
        " a letter of your choice to you for 3 tries.");
        System.out.println("you can choose the character you wish to reveal by typing " + 
        "in its corresponding number which will be below it.\n");
        u.sleepIt(3);
        System.out.println("The goal is to finish the game with the most amount" +
        "of tries possible,\n as well as in the least amount of rounds possible");
        System.out.println("Good Luck! and have a fun time playing the game!\n\n\n\n\n");
        u.sleepIt(3);
        
    }
}
        
   

