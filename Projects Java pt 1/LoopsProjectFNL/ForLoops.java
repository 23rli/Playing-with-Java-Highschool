/**
 * Class contains all methods refered to in ForLoopsRunner
 *
 * @author (Richard Li)
 * @version (11/12/20)
 */

import java.util.*;
public class ForLoops
{   
    // Counts and Returns the # odf vowels in a phrase   
    public void countVowels() 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in a phrase to be evaluated for the number of vowels.");
        String toCount   = keyboard.nextLine();  //Recieve input
        toCount          = toCount.toLowerCase(); //Modify for uniformity 
        String toCheck   = "aeiou";
        int vowels       = 0; //Answer
        for(int x = 0; x < toCount.length(); x++){
            for(int y = 0; y < 5; y++){
                if(toCount.charAt(x) == toCheck.charAt(y)){ //Check if vowel
                    vowels++; 
                    break;
                }
            }
        }
        System.out.println("There are " + vowels + " vowels.");
    }

    //Reverses and returns the letter order of the input
    public void reverseIt()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in a phrase to reverse");
        String toReverse = keyboard.nextLine(); 
        String reverse   = ""; //Answer
        for(int x = toReverse.length() - 1; x >= 0; x--){ // Reverse index the string
            reverse += toReverse.charAt(x); //add to answer
        }
        System.out.println("The reverse of " + toReverse + " is " + reverse);
    }

    //Encrypts and returns the given phrase
    public void encrypt()
    {  
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in a phrase to be encrypted.");
        String toEncrypt = keyboard.nextLine(); 
        String encrypted = ""; //Answer
        int shift        = 7; //number of ASCII digits to shift
        for(int x = 0; x < toEncrypt.length(); x++){
            boolean lowCas = true;
            if(toEncrypt.charAt(x) <= 'Z') lowCas = false; // check casing
            int shifted = toEncrypt.charAt(x) + shift; //Shift

            // If shifted goes over
            if(lowCas && shifted > 'z') shifted -= 26;
            else if(!lowCas && shifted > 'Z') shifted -= 26;

            encrypted += (char)shifted; //Add shifted to answer
        }
        System.out.println("The encrypted phrase: " + encrypted);  
    }

    //Print out a 5 by 5 checker board
    public void showBoard()
    {
        boolean cross = true; //Print cross or O
        for(int x = 0; x < 5; x++){ //Vertical
            for(int y = 0; y < 5; y++){ //Horozontal
                if(cross){
                    System.out.print("X ");
                }else{
                    System.out.print("O ");
                }
                cross = !cross; //Change boolean for alternating symbols
            }
            System.out.println();
        } 
    }

    /**
     * 
     * Finds and returns all prime numbers between the inputed minimum and maximum
     */
    public void showPrimes()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("The code will show all prime numbers between minimum and maximum.");
        System.out.println("Type in a number to be the minimum.");
        int min = Integer.parseInt(keyboard.nextLine()); //Min integer
        System.out.println("Type in a number to be the maximum.");
        int max = Integer.parseInt(keyboard.nextLine()); //Max integer
        String primes = ""; //Answer

        for(int x = min; x <= max; x++){
            boolean isPrime = true; //Used to show if prime at end of code
            int limit    = (int)Math.sqrt(x); //Don't need to go past square root otherwise duplicates
            boolean numIsEven = true; //Is num even
            for(int y = 2; y <= limit; y++){
                if(numIsEven){ //If Num even = not prime
                    if(x%y == 0){
                        isPrime = false;
                        break;
                    }else{ //Not even  = check all odd numbers till limit V
                        numIsEven = false;
                    }
                }else if(y%2 == 0){ 
                }else{
                    if(x%y == 0){
                        isPrime = false;
                        break;
                    }
                }
            }

            if(isPrime) primes += (x + ", "); //Add to answer

        }

        System.out.println("The primes between " + min + " and " + max + " are " + primes);
        ;
    }

    //Starts the Guess for dollars mini gambling game. Plays till player tells it to stop
    public void guessForDollars()
    {
        //Instructions
        System.out.println("Let's Gamble!");
        System.out.println("The rules are simple:");
        System.out.println("You start the game with $1000, the goal of the game \n being to end with the greatest amount of money you can win.");
        System.out.println("At the start of each round, you'll bet an amount \n You will also be shown the min and max numbers you can guess from.");
        System.out.println("From there, if you guess within 50 Integers, your bet doubles, 25 and it triples,\n" + 
            " 10 and it quadrouples, hit it right on the nail and it goes up by a factor of 10.");
        System.out.println("Any other result and you lose twice of what you bet.");
        System.out.println("Good Luck and have fun!");

        //Setup base variables
        Scanner keyboard = new Scanner(System.in);
        int round = 0;  
        int money = 1000; 
        boolean gameInPlay = true; //Do we stop game?
        while(gameInPlay){
            //Setup game and recieve player guess
            int min    = (int)(Math.random()*500);
            int max    = 500 + (int)(Math.random()*500);
            int theNum = min + (int)(Math.random() *(max-min));
            round++;
            System.out.println("__________________________________________________________________________________");
            System.out.println("Round " + round + "                                           " + 
                "                    You have $" + money+ "\n\n");
            System.out.println("The smallest possible number is " + min + "\nThe largest possible number is " + max);
            System.out.println("How much would you like to bet?");
            int bet = keyboard.nextInt();
            System.out.println("Give your best guess:");
            int playerGuess = keyboard.nextInt();
            //Send response to guess 
            int diff = playerGuess - theNum;
            if(diff < 0) diff *= -1;
            if(diff != 0) System.out.println("\nYou got within " + diff + " of the right number.");

            //Calculate winnings
            if(diff > 50){
                bet *= -2;
                money += bet;
                System.out.println("You lost $" + (bet * -1));
                System.out.println("Your total is now $" + money);
            }else if(diff > 25){
                bet *= 2;
            }else if(diff > 10){
                bet *= 3;
            }else if(diff>0){
                bet *= 4;
            }else{
                bet *= 10;
            }
            if(bet > 0){
                money += bet;
                System.out.println("You gained $" + bet);
                System.out.println("Your total is now $" + money);
            }

            //Reset for next round, or end game
            System.out.println("\n\n\n Do you wish to end the game?(Type in 'YES' or 'NO')");

            String ans = keyboard.next();

            if(ans.equals("YES")){
                gameInPlay = false;
                System.out.println("\nYou have ended the game with total of " + money + " dollars.");
            }
        }
    }

    //Generate a Bingo Board
    public void generateBingoBoard()
    {  
        boolean first = true; //If first line, print bingo boolean
        String[] bingo = {"B  ","I  ", "N  ", "G  ", "O"};
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 5; y++){
                if(first) System.out.print(bingo[y]); //print out BINGO
                else{ //Randomly pick and print numbers to fill the board
                    if(y == 0){ 
                        int temp = 1 + (int)(Math.random() * 15);
                        if(temp < 10) System.out.print(temp + "  ");
                        else System.out.print(temp + " ");
                    }else if(y == 1){
                        int temp = 16 + (int)(Math.random() * 15);
                        System.out.print(temp + " ");
                    }else if(y == 2){
                        int temp = 31 + (int)(Math.random() * 15);
                        System.out.print(temp + " ");
                    }else if(y == 3){
                        int temp = 46 + (int)(Math.random() * 15);
                        System.out.print(temp + " ");
                    }else{
                        int temp = 61 + (int)(Math.random() * 15);
                        System.out.print(temp + " ");
                    }
                }
            }
            first = false;
            System.out.println();
        }
    }

    /**
     * THESE 3 ARE HONORS ONLY:
     */

    // Finds and Returns all consonants in the inputed phrase
    public void countConsonants()
    {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Type in a phrase to be evaluated for the number of consonants");
      String toCount   = keyboard.nextLine(); 
      toCount          = toCount.toLowerCase(); //Set for uniformity of case
      String toCheck   = "aeiou";
      int consonants       = 0;
      for(int x = 0; x < toCount.length(); x++){
         if(toCount.charAt(x) != toCheck.charAt(0) && toCount.charAt(x) != toCheck.charAt(1) && 
            toCount.charAt(x) != toCheck.charAt(2) && toCount.charAt(x) != toCheck.charAt(3) && 
            toCount.charAt(x) != toCheck.charAt(4) ){ //If checks if NOT vowels
            consonants++;
         }
      }
      System.out.println("There are " + consonants + " consonants.");
   }

   //Create a checker board with an exclamation point center as well as dimensions based on input
   public void showFancyBoard()
   {  
      //get dimensions from user:
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Type in a number to decide the dimensions of the board you wish to create.");
      int dim = keyboard.nextInt();

      boolean cross = true; //tracks whether X or O
      //odd dimension starts has a different middle than even:
      if(dim % 2 == 1){ 
         //DRAW THE BOARD!
         for(int x = 0; x < dim; x++){
            for(int y = 0; y < dim; y++){
                //middle spot in odd board, middle 4 in even are !
               if(dim % 2 == 1)
                if(x == dim/2 && y == dim/2)  //odd, middle spot
               else
                 if(x == dim/2 - 1 && y == dim/2 - 1 || x == dim/2 - 1 && y == dim/2 ||
                x == dim/2 && y == dim/2 - 1 || x == dim/2 && y == dim/2){ //center character is different
                  System.out.print("! ");
               }else if(cross){
                  System.out.print("X ");
               }else{
                  System.out.print("O ");
               }
               cross = !cross; //alternate X and 0
            }
            System.out.println();
         }
      }else{ //If dimesions even
         for(int x = 0; x < dim; x++){
            for(int y = 0; y < dim; y++){
               if(x == dim/2 - 1 && y == dim/2 - 1 || x == dim/2 - 1 && y == dim/2 ||
                x == dim/2 && y == dim/2 - 1 || x == dim/2 && y == dim/2){ //Checks for all 4 middle spots
                  System.out.print("! ");
               }else if(cross){
                  System.out.print("X ");
               }else{
                  System.out.print("O ");
               }
               cross = !cross; //Alternate X and 0
            }
            System.out.println();

         }    

      }   
   }

   //Reverse the letter ordering of every word in the given phrase
   public void reverseByWord()
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Type in a phrase to reverse by word.");
      String toReverse = keyboard.nextLine(); 
      String hold      = toReverse; //Display Input at end
      String reverse   = "";  //Answer
      while(toReverse.length() > 0){ //Keeps going til there is nothing left in Input
         int endSubIndex = toReverse.indexOf(" "); //Find index of next space
         String temp = ""; //Used to store next word
         if(endSubIndex != -1) temp = toReverse.substring(0,endSubIndex); //Next space used to create substring of Input
         else temp = toReverse.substring(0); //If last word take whole string
         for(int x = temp.length() - 1; x >= 0; x--){
            reverse += temp.charAt(x); //Reverse the substring and add to ans
         }
         reverse += " "; //Add a space between words
         if(endSubIndex != -1) toReverse = toReverse.substring(endSubIndex + 1); // Deletes word as to not repeat
         else toReverse = ""; //If last word, toReverse is empty
      }
      System.out.println("The reverse of " + hold + " is " + reverse);
   }
}
