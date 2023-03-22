
/**
 * Write a description of class Utility here.
 *
 * @author Richard Li
 * @version 1.0
 */
public class Utility {
    public void sleepIt(double seconds) {

        long milliseconds = 1000 * (long) (seconds);
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Error SleepIt");
        }
    }

    public boolean answeredYes(String res) {
        res = res.toLowerCase();
        if (res.equals("yes") || res.equals("y") || res.equals("yah") || res.equals("yup") || res.equals("ok")) {
            return true;
        }
        return false;
    }
}
