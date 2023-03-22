import java.util.*;

/**
 * Runner class cretes user interface while also calling other functions
 * Basically the GUI
 */
public class Runner {

    public static void main(String[] args) {

        // Create GradeBook
        GradeBook life = new GradeBook();
        boolean end = false;

        // never ending loop for interface
        while (!end) {
            inter(life);
        }

    }

    public static void inter(GradeBook life) {

        // Create Menu
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Gradebook");
        System.out.println("Type 1 to display your Gradebook roster");
        System.out.println("Type 2 to add a Student to your Gradebook roster");
        System.out.println("Type 3 to remove a Student from your Gradebook roster");
        int count = keyboard.nextInt();

        switch (count) {

            // Display Grade Book
            case 1: {
                life.display();
                break;
            }

            // Add Student to Grade Book
            case 2: {
                System.out.println("Type in the Name of the student...");
                String name = keyboard.next();
                System.out.println("Type in the YOG of the student...");
                int YOG = keyboard.nextInt();
                life.add(new Student(name, YOG));
                System.out.println("Student added.");
                break;
            }

            // Remove student from grade book
            case 3: {
                life.display();
                System.out.println("Type the index of the Student you wish to remove");
                int ind = keyboard.nextInt();
                if (ind < life.students.size()) {
                    life.remove(life.students.get(ind));
                }
                break;
            }

            default:
                break;

        }

    }
}