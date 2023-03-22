
/**
 * Used to run phraseAlter and wordGuess game.
 *
 * @author Richard li
 * @version (a version number or a date)
 */
public class Runner{
   public static void main(String[] args){
        WordGuess start = new WordGuess();
        start.playGame(); //Starts wordGuess Game and runs it
        Phrase last = new Phrase();
        last.phraseAlter(); //Starts phraseAlter and runs it
    
   }   
}
