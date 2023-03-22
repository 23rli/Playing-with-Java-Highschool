import javax.swing.*;

/**
 * 
 *
 * @author Richard Li
 * @version 1.0
 */
public class GUIinteractions {
   public void showIntructions(int selectedTask, JTextArea report, JTextField[] entry) {
      /*
       * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TO ADD NEW METHODS, WRITE
       * INSTRUCTIONS HERE: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       */

      switch (selectedTask) {

         /*
          * CASE 0: "Select" is selected, so don't do anything!
          */
         case 0:
            break;

         /*
          * CASE 1: Mr. Beckwith's SWITCHY METHOD IS SELECTED
          */
         case 1: {
            report.setText("Welcome to Switchy!\n\nPlease enter 2 strings in the first two boxes"
                  + " and I will combine and reverse them for you...");
            break;
         }
         /*
          * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
          */
         case 2: {
            report.setText("Welcome to Testing!\n"
                  + "\nPlease enter y or n in the first box, depending on whether you are sleepy or not"
                  + "\nIn the second box, enter your age" + "\nIn the last box, enter your favorite number"
                  + "\n\n Using my special formula, when you hit submit, "
                  + "\nI will tell you whether you will win the lottery or not");

            entry[0].setText("Are you sleepy?");
            break;
         }

         /*
          * CASE 3: Mult String Method Selected: return the word printed the given number
          * of times
          */
         case 3: {
            report.setText("Enter a word in the first box and a number in the second box."
                  + " Click submit to see the surprise.");
            break;
         }

         /*
          * CASE 4: Strong Presence Method Selected: see if a letter occurs multiple
          * times in a word
          */
         case 4: {

            report.setText("Type in a word in the first box and a letter"
                  + " in the second box to see if your letter has a strong presence in your word");
            break;

         }

         /*
          * CASE 5: Four Fit in One Method Selected: see if everyone ona trip can fit in
          * one car(legally)
          */
         case 5: {
            report.setText("Type in five car capacities(integers each in a different box), "
                  + "to see if all campers can fit in one of the vehicles");
            break;

         }

         /*
          * CASE 6: Okay, Line up Method Selected: see if 3 doubles are in order from
          * least to greatest
          */
         case 6: {
            report.setText("Type in 3 heights(doubles) to see if they line up from least to " + "greatest");
            break;
         }

         /*
          * CASE 7: Should you Answer your Cell Method Selected: Type in 4 yes or no
          * statements to determine if you should pick up a call.
          */
         case 7: {
            report.setText("Type in yes or no(one in each box) for the following"
                  + "\n questions to determine if you should pick up a phone call."
                  + "\n1. Is it Morning? \n2. Is it from your mom? \n3. Are you asleep?" + "\n4. Are you grumpy?");

            break;

         }

         /*
          * CASE 8: Can Move Method Selected: Determines if a character can move in a
          * selected cardinal direction
          */
         case 8: {
            report.setText("Type in the following information to determine if"
                  + " where you can move to. \n first four are yes or no questions"
                  + "\n1. Is north blocked? \n2. Is south blocked?\n3. Is east blocked"
                  + "\n Is west blocked? \n5. What is your current power level?"
                  + "(Must have at least 16 to move) \n6. What direction are you going in?"
                  + "(Type in the capslock first letter of the direction you wish to go)");
            break;

         }

         /*
          * CASE 9: Full URL: returns a full URL if possible
          */
         case 9: {
            report.setText("Type in a web address to be completed(String)");
            break;

         }

         /*
          * CASE 10: Sum of Powers: returns sum of all numbers up to the 2nd typed in
          * integer to the power of the first integer
          */
         case 10: {
            report.setText("Type in 2 integers to see the sum of all the integers"
                  + " from zero to the second inputed number." + "All to the power of the first integer");
            break;

         }

         /*
          * CASE 11: Almost Primes: Returns all numbers inbetween the two inputted that
          * only have 2 prime factors not including 1 and themselves.
          */
         case 11: {
            report.setText("Type in a min and max(integers) so we can find" + "all almost primes between them!!!!!");
            break;

         }

         /*
          * CASE 12: Greekify: Returns a string showing the number of abundant, perfect,
          * and deficient numbers.
          */
         case 12: {
            report.setText("Type in a min and a max(integers) so that we can"
                  + "show you if your greekified(or greek classified) numbers");
            break;

         }

         /*
          * CASE 13: Three Powers: returns if or if not the inputted number can be the
          * sum of distinct powers of three. If yes show powers, if no state Impossible
          */
         case 13: {
            report.setText("Type in a number(integer) to see if it can be the " + "sum of distinct powers of three.");
            break;

         }

         /*
          * CASE 14: Significant Figures Calculator: return the number of sig figs of the
          * number inputted. If multiple are inputted the Method return the smallest
          * number of significant figures.
          */
         case 14: {
            report.setText("This is a significant figure calculator. \n Input 1 number "
                  + "to see how many sigfigs are in it. You can also put multiple numbers(up to six)"
                  + " to see what the smallest amount of sig figs are out of all the inputted numbers.\n"
                  + "If you don't use a box to input a number, please input a '0' there.  Also "
                  + "all numbers that will be scanned for sig figs must be put from the leftmost box."
                  + " If you put 2 numbers with a zero between them it will break the method.");
            break;

         }

         // must leave this in:
         default:
            break;
      }
   }

   public void getAndShowResults(Tasks tasks, int selectedTask, JTextArea report, JTextField[] entry, Utility util) {
      // Gets entries from boxes, calls methods sending argumentes, and sets text of
      // report with results

      // GET ALL ANSWERS FROM USER: GETTEXT() CAN ONLY RETURN STRINGS, SO CONVERT
      // LATER:
      String arg1 = entry[0].getText();
      String arg2 = entry[1].getText();
      String arg3 = entry[2].getText();
      String arg4 = entry[3].getText();
      String arg5 = entry[4].getText();
      String arg6 = entry[5].getText();

      String resultString; // use this for return values that are Strings
      int resultInt; // use this for return values that are integers
      boolean resultBool; // use this for return values that are booleans

      switch (selectedTask) {
         /*
          * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TO ADD NEW METHODS, CALL THE
          * METHOD HERE, GET THE RESULTS, AND SET THE TEXT OF THE REPORT
          * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
          */

         /*
          * CASE 0: "Select" is selected, so don't do anything!
          */
         case 0:
            break;

         /*
          * CASE 1: Mr. Beckwith's silly SWITCHY METHOD IS SELECTED
          */
         case 1: {
            // call the method, sending arguments, and store the return value into a String
            // (you don't really need this comment)
            resultString = tasks.combine(arg1, arg2);
            // set the display to show/explain the results
            report.setText("Your reverse is " + resultString);
            break;
         }

         /*
          * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
          */
         case 2: {
            // convert y or n answer to a boolean (or use your Utility here!!!)
            boolean sleepy;
            if (arg1.equals("y"))
               sleepy = true;
            else
               sleepy = false;

            // IMPORTANT - ALL args will be Strings, so
            // here's how you can convert age and number Strings to integers:
            int age = Integer.parseInt(arg2);
            int favNum = Integer.parseInt(arg3);

            // get results of method call:
            resultBool = tasks.testing(sleepy, age, favNum);

            if (resultBool) {
               report.setText("Yes, you win!");
            } else {
               report.setText("Awww, you lose...");
            }
            break;
         }

         /*
          * CASE 3: Mult String Method Selected: return the word printed the given number
          * of times
          */
         case 3: {
            // Call Method and get result
            String ans = tasks.multString(arg1, Integer.parseInt(arg2));

            // Show answer
            report.setText(ans);
            break;
         }

         /*
          * CASE 4: Strong Presence: see if a letter occurs multiple times in a word
          */
         case 4: {
            // Call method and get result
            boolean strong = tasks.StrongPresence(arg1.charAt(0), arg2);
            if (strong) {
               // If true, print below
               report.setText("The force of " + arg1 + "has a strong presence in" + arg2);
            } else {
               // If not true print below
               report.setText("The force of " + arg1 + "has a weak(not strong) presence in" + arg2);
            }
            break;
         }

         /*
          * CASE 5: Four Fit in One: see if everyone ona trip can fit in one car(legally)
          */
         case 5: {
            boolean can = tasks.fourFitInOne(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3),
                  Integer.parseInt(arg4), Integer.parseInt(arg5));
            if (can)
               report.setText("Yes, everyone can fit in one vehicle!!!");
            else
               report.setText("No, not everyone can fit in one vehicle...");
            break;
         }

         /*
          * CASE 6: Okay, Line up: see if 3 doubles are in order from least to greatest
          */
         case 6: {
            boolean linedUp = tasks.okayLineUp(Double.parseDouble(arg1), Double.parseDouble(arg2),
                  Double.parseDouble(arg3));
            if (linedUp)
               report.setText("The numbers are lined up from least to greatest!!!");
            else
               report.setText("Oh no! The numbers aren't lined up");
            break;

         }

         /*
          * CASE 7: Should you Answer your Cell: Type in 4 yes or no statements to
          * determine if you should pick up a call.
          */
         case 7: {
            boolean isMorning = util.answeredYes(arg1);
            boolean isMom = util.answeredYes(arg2);
            boolean isAsleep = util.answeredYes(arg3);
            boolean isGrumpy = util.answeredYes(arg4);
            boolean answer = tasks.shouldAnswerCall(isMorning, isMom, isAsleep, isGrumpy);
            if (answer)
               report.setText("You shoud answer this call!");
            else
               report.setText("You shouldn't answer this call!");
            break;

         }

         /*
          * CASE 8: Can Move Method Selected: Determines if a character can move in a
          * selected cardinal direction
          */
         case 8: {
            boolean nBlocked = util.answeredYes(arg1);
            boolean sBlocked = util.answeredYes(arg2);
            boolean eBlocked = util.answeredYes(arg3);
            boolean wBlocked = util.answeredYes(arg4);
            boolean possible = tasks.canMove(nBlocked, sBlocked, eBlocked, wBlocked, Integer.parseInt(arg5), arg6);
            if (possible)
               report.setText("It is possible to go in that direction!");
            else
               report.setText("It is not possible to go in that direction...");
            break;
         }

         /*
          * CASE 9: Full URL: returns a full URL if possible
          */
         case 9: {
            String answer = tasks.fullURL(arg1);
            report.setText(answer);
            break;

         }

         /*
          * CASE 10: Sum of Powers: returns sum of all numbers up to the 2nd typed in
          * integer to the power of the first integer
          */
         case 10: {
            int answer = tasks.sumOfPowers(Integer.parseInt(arg1), Integer.parseInt(arg2));
            report.setText("The sum of all positive numbers less than or equals to " + arg2 + " to the power of " + arg1
                  + " is equal to " + answer);
            break;

         }

         /*
          * CASE 11: Almost Primes: Returns all numbers inbetween the two inputted that
          * only have 2 prime factors not including 1 and themselves.
          */
         case 11: {
            String answer = tasks.almostPrimes(Integer.parseInt(arg1), Integer.parseInt(arg2));
            report.setText(answer);
            break;

         }

         /*
          * CASE 12: Greekify: Returns a string showing the number of abundant, perfect,
          * and deficient numbers.
          */
         case 12: {
            String answer = tasks.greekify(Integer.parseInt(arg1), Integer.parseInt(arg2));
            report.setText(answer);
            break;

         }

         /*
          * CASE 13: Three Powers: returns if or if not the inputted number can be the
          * sum of distinct powers of three. If yes show powers, if no state Impossible
          */
         case 13: {
            String answer = tasks.threePowers(Integer.parseInt(arg1));
            report.setText(answer);
            break;

         }

         /*
          * CASE 14: Significant Figures Calculator: return the number of sig figs of the
          * number inputted. If multiple are inputted the Method return the smallest
          * number of significant figures.
          */
         case 14: {
            int sigFig = tasks.sigFigCalc(arg1, arg2, arg3, arg4, arg5, arg6);
            report.setText("The number of significant figures is " + sigFig);
            break;

         }
         // must leave this in:
         default:
            break;
      }
   }
}
