import java.util.*;

/**
 * Object class for Student courses in the student object
 */
public class StudentCourse {

    String courseName;
    String courseBlock;

    ArrayList<Integer> grades;

    // Finds average of grades
    public int average() {
        int count = 0;
        for (Integer x : grades) {
            count += x;
        }
        return count / grades.size();
    }
}