import java.util.*;

/**
 * Object class Gradebook hat stores all students and their courses and grades
 */
public class GradeBook {
    ArrayList<Student> students; // Store Students

    // Constructor
    GradeBook() {
        students = new ArrayList<>();
    }

    // Display Gradebook Object
    public void display() {
        for (int x = 0; x < students.size(); x++) {
            System.out.println(students.get(x).name);
        }

    }

    // Add Student
    public void add(Student x) {
        students.add(x);
    }

    // Remove Student
    public void remove(Student x) {
        students.remove(x);
    }
}