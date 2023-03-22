import java.util.*;

/**
 * Object class for students Used to record individual stundet data in the grade
 * book object
 */
public class Student {
    String name;
    int YOG;
    ArrayList<StudentCourse> courses;

    Student(String n, int y) {
        YOG = y;
        name = n;
        courses = new ArrayList<>();
    }

}