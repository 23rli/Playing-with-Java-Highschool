
public class Tasks {
   /**
    * VERY SILLY METHOD FOR TESTING PURPOSES: adds 2 words to make one
    * 
    * @param word1 the first word
    * @param word2 the second word
    * @return the two words reversed and concatenated
    */
   public String combine(String word1, String word2) {
      return word2 + " " + word1;
   }

   /**
    * EQUALLY SILLY METHOD FOR TESTING PURPOSES:
    * 
    * @param test1  meangingless boolean
    * @param age    age of the user in years
    * @param favNum favorite number of the user
    * @return true is passes my silly test; false otherwise
    */
   public boolean testing(boolean test1, int age, int favNum) {
      if (test1 && age < 7 || favNum == 42) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Takes the input word and prints it numOfTimes number of times.
    * 
    * @param word       is the String to print numOfTimes
    * @param numOfTimes is the number of times word will be printed
    * @return returns a string with word printed numOfTimes
    */
   public String multString(String word, int numOfTimes) {
      String newText = "";
      for (int x = 0; x < numOfTimes; x++) {
         newText += word;
      }

      return newText;
   }

   /**
    * Return if or if not the char ltr occurs more then once in String text
    * 
    * @param ltr  is the char to check in String text
    * @param text is the String to scan to see if ltr occurs more then once
    * @return true or false if char ltr occurs more then once in String text
    */
   public boolean StrongPresence(char ltr, String text) {
      int count = 0;
      for (int x = 0; x < text.length(); x++) {
         if (text.charAt(x) == ltr)
            count++;
      }
      if (count >= 2)
         return true;
      return false;
   }

   /**
    * Check to see if 4 of the numbers have a sum that is less then the largest
    * number
    * 
    * @param one   one of the 5 numbers to be checked
    * @param two   one of the 5 numbers to be checked
    * @param three one of the 5 numbers to be checked
    * @param four  one of the 5 numbers to be checked
    * @param five  one of the 5 numbers to be checked
    * @return returns if the sum of 4 numbers is less then a fifth
    */
   public boolean fourFitInOne(int one, int two, int three, int four, int five) {
      int max = Math.max(Math.max(one, two), Math.max(three, Math.max(four, five)));
      if (max >= one + two + three + four + five - max)
         return true;
      return false;

   }

   /**
    * Determines if the inputed doubles are in order from least ot greatest
    * 
    * @param one a number that's checked for least to greatest order(smallest)
    * @param two a number that's checked for least to greatest order(middle)
    * @param thr a number that's checked for least to greatest order(largest)
    * @return true or false if the line up is least to greatest from one to thr
    */
   public boolean okayLineUp(double one, double two, double thr) {
      if (one <= two && two <= thr)
         return true;
      return false;
   }

   /**
    * Method that goes through multiple booleans to see if the Method caller should
    * answer the phone
    * 
    * @param isMorning is it morning or not? boolean to check
    * @param isMom     is the caller mom or not? boolean to check
    * @param isAsleep  is the reciever asleep? boolean to check
    * @param isGrumpy  is the reciever grumpy? boolean to check
    * @return true or false if the reciever(the method caller) should pick up his
    *         or her phone
    */
   public boolean shouldAnswerCall(boolean isMorning, boolean isMom, boolean isAsleep, boolean isGrumpy) {
      if (!isAsleep) {
         if (isMom)
            return true;
         if (!isMorning && !isGrumpy)
            return true;
      }
      return false;

   }

   /**
    * 
    * @param nBlocked  is the direction north blocked? boolean to check
    * @param sBlocked  is the direction south blocked? boolean to check
    * @param eBlocked  is the direction east blocked? boolean to check
    * @param wBlocked  is the direction west blocked? boolean to check
    * @param power     How much power does your character have. Must have more than
    *                  16 to move.
    * @param direction Which direction the character will go in if it can.
    * @return true or false if the character has enough power, and is going toward
    *         an unblocked direction.
    */
   public boolean canMove(boolean nBlocked, boolean sBlocked, boolean eBlocked, boolean wBlocked, int power,
         String direction) {
      direction = direction.toLowerCase();
      // check power
      if (power > 15) {

         // check directions blocked, if unblcoked and in that direction returns true
         if (direction.equals("n") && !nBlocked) {
            return true;
         } else if (direction.equals("s") && !sBlocked) {
            return true;
         } else if (direction.equals("e") && !eBlocked) {
            return true;
         } else if (direction.equals("w") && !wBlocked) {
            return true;
         }
      }

      // all else returns false
      return false;

   }

   /**
    * Checks to see if the web address can be completed. If it can the method will
    * complete it. Else, the method will tell you that it's a bad address.
    * 
    * @param address The inputted good or bad address to be checked
    * @return returns the completed address, or "bad address" if the address cannot
    *         be completed
    */
   public String fullURL(String address) {
      boolean dot = false; // If input has a dot
      boolean www = false; // If input has the www
      if (address.substring(0, 3).equals("www"))
         www = true;
      for (int x = 0; x < address.length(); x++) {
         if (address.charAt(x) == '.') {
            dot = true;
            break;
         }
      }

      // Return values based on boolean checks above
      if (!dot)
         return "bad address";
      if (www)
         return "http://" + address;
      else
         return "http://www." + address;
   }

   /**
    * The method adds all numbers from 1 to the integer numberOfTerms, each to the
    * power of exponent
    * 
    * @param exponent      is the exponent for every number from 1 to numberOfTerms
    * @param numberOfTerms is the number of terms in which will be powered by
    *                      exponent and added together to be returned by the method
    * @return returns the sum of all numbers from 1 to numberOfTerms, each to power
    *         of exponent
    */
   public int sumOfPowers(int exponent, int numberOfTerms) {
      int ans = 0; // Return value
      for (int x = 0; x < numberOfTerms; x++) {
         ans += Math.pow(x, exponent);
      }
      return ans;
   }

   /**
    * A method that goes through all numbers between min and max and returns those
    * which only have 2 factors(both prime) not including themselves and one.
    * 
    * @param min is the minimum number to be in the method's evaluation
    * @param max is the maximum number to be in the method's evaluation
    * @return the method will return a list of numbers seperated by commas that are
    *         almost primes, if there are none it will return a statement saying
    *         so.
    */
   public String almostPrimes(int min, int max) {
      String ans = ""; // Retrun value, list of numbers
      int count = 0; // Almost primes should only have 2 factors outside of one and
                     // itself. The count is conuting the number of factors

      // Find factors
      for (int x = min; x <= max; x++) {
         double limit = Math.sqrt(x);
         for (int y = 2; y < limit - 1; y++) {
            if (x % y == 0) {
               count++;
            }
         }
         if (count == 2)
            ans += x + ", ";
      }

      // return
      if (ans.equals(""))
         return "No almost primes found!";
      ans = ans.substring(0, ans.length() - 3);
      return "The almost primes are " + ans;
   }

   /**
    * Goes through all number between and including min and max to find out if they
    * are abundant(sum of factors is greater than number), prefect(sum of factors
    * is equal to number), or deficient(sum of factors less then number)
    * 
    * @param min is the minimum number the method will scan
    * @param max is the maximum number the method wih scan
    * @return the string that includes the number of deficient, perfect, and
    *         abundant integers there are between the min and max
    */
   public String greekify(int min, int max) {
      int defic = 0; // # of deficient
      int perf = 0; // # of perfect
      int abun = 0; // # of abundant
      for (int x = min; x <= max; x++) {
         double limit = (x / 2) + 1;
         int total = 0; // Total sum of the factors of an integer
         for (int y = 1; y < limit; y++) {
            if (x % y == 0) {
               total += y;
            }
         }
         // See which category the# fits in
         if (total > x)
            abun++;
         else if (total == x)
            perf++;
         else
            defic++;
      }
      return "There are " + defic + " deficient, " + perf + " perfect, " + abun + " abundant";
   }

   /**
    * The method processes n and sees if it can be created with the sum of distinct
    * powers of three
    * 
    * @param n is the number to be evaluated for the purpose above
    * @return shows the distinct powers of three added together to become n,
    *         however if it is impossible the method will instead return impossible
    */
   public String threePowers(int n) {
      int power = -1; // Storage, previous power to compare to see if new power
                      // this cyce is a duplicate
      boolean first = true; // If this is the first cycle, if so don't add " + " to answer
      String answer = n + " can be made out of the distinct powers of 3: "; // return varibale
      while (n > 0) {
         if (!first)
            answer += " + ";
         int newPow = -1; // Power of the next number

         // find the greatest possible power of three that's able to be in number n
         do {
            newPow++;
         } while (Math.pow(3, newPow) <= n);
         newPow--;
         if (power != newPow)
            power = newPow;
         else
            return "It's impossible!"; // return impossible if power is equal to
                                       // previous power
         first = false;
         answer += (int) Math.pow(3, newPow);
         n -= Math.pow(3, newPow);
      }
      return answer;

   }

   /**
    * This method check one or many numbers to find the number or least number of
    * significant figures. Very useful for Chemistry
    * 
    * @param a One of the numbers to be checked for significant figures
    * @param b One of the numbers to be checked for significant figures
    * @param c One of the numbers to be checked for significant figures
    * @param d One of the numbers to be checked for significant figures
    * @param e One of the numbers to be checked for significant figures
    * @param f One of the numbers to be checked for significant figures
    * @return The least number or number of Significant figures of the numbers
    *         inputted
    */
   public int sigFigCalc(String a, String b, String c, String d, String e, String f) {
      int count = 0; // How many numbers inputed should be scanned
      String[] number = { a, b, c, d, e, f }; // Stores the numbers
      for (int x = 0; x < 6; x++) {
         if (!number[x].equals("0"))
            count++;
      }

      int[] sigFigLengths = new int[count]; // Stores the signigicant figure of each number
      boolean point = false; // whether or not the number has a decimal point

      // Finds if number has a decimal point, if so Sig Fig = length of number minus
      // the dot.
      for (int n = 0; n < count; n++) {
         for (int x = 0; x < number[n].length(); x++) {
            if (number[n].charAt(x) == '.') {
               sigFigLengths[n] = number[n].length() - 1;
               point = true;
               break;
            }
         }
         if (!point) {
            int nPOSF = 0; // Digits not part of the Significant Figure

            for (int x = number[n].length() - 1; x > -1; x--) {
               if (number[n].charAt(x) == '0') {
                  nPOSF++;
               } else {
                  break;
               }
            }

            sigFigLengths[n] = number[n].length() - nPOSF;
         }
         point = false;
      }
      // Finds the number with the smallest SigFig
      int min = sigFigLengths[0];
      for (int x = 1; x < count; x++) {
         min = Math.min(min, sigFigLengths[x]);
      }
      return min;

   }

}
