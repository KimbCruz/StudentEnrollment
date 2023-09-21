import java.util.HashMap;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    //Initialize Scanner
    public static Scanner kb = new Scanner(System.in);
    public static HashMap<Integer, Student> student = new HashMap<Integer, Student>();

    //Ask professor if they want to remove/add a student or view course roster
    public static void professorMenu(){
        //Ask professor for valid courseID
        //Ask professor if they want to remove/add a student or view course roster
        
    }
    
    //Asks the student if they want to remove/add/view their schedule
    public void studentMenu() {
        Student user = new Student();
        int sID = 0;
        //Ask for valid studentID or ask if they are a new Student
        System.out.println("Are you a new student? Y/N");
        sID = kb.nextInt();
        
        //Ask student to add a course
        System.out.println("Do you want to add a course to your schedule? Y/N" );
        //Ask student to remove a course
        System.out.println("Do you want to remove a course to your schedule? Y/N" );
        //Ask student to view schedule
        System.out.println("Do you want to view view your schedule? Y/N" );
    }
    public static void main(String[] args) {
    // Create student objects
    Student st1 = new Student();
    Student st2 = new Student();
    Student st3 = new Student();
    Student st4 = new Student();
    Student st5 = new Student();
    Student st6 = new Student();
    
    //Create Course Objects
    Course course1 = new Course("CSC123", LocalTime.of(9, 00), LocalTime.of(10, 15));
    Course course2 = new Course("PHY132", LocalTime.of(12, 30), LocalTime.of(13, 45));
    Course course3 = new Course("CSC331", LocalTime.of(10, 00), LocalTime.of(11, 15));
    Course course4 = new Course("CSC371", LocalTime.of(12, 00), LocalTime.of(13, 15));

    st1.addCourse(course1);
    course1.addToRoster(st1);
    st1.addCourse(course4);
    course4.addToRoster(st1);
    

    st2.addCourse(course2);
    course2.addToRoster(st2);
    st2.addCourse(course3);
    course3.addToRoster(st2);

    st3.addCourse(course3);
    course3.addToRoster(st3);
    st3.addCourse(course4);
    course4.addToRoster(st3);

    st4.addCourse(course1);
    course1.addToRoster(st4);
    
    st5.addCourse(course2);
    course2.addToRoster(st5);

    st6.addCourse(course4);
    course4.addToRoster(st6);
        String choice = " ";
        System.out.println("Are you a student or professor? (S for student, P for professor): ");
        while (choice.equals(" ") || !choice.equals("P") || !choice.equals("S")){
            choice = kb.nextLine().toUpperCase();
        }
        boolean flag = false;
        
        switch(choice) {
            case "S":
                studentMenu();
                break;
            case "P":
                break;
            default:
                System.out.println("Invalid answer, enter Y or N");
        }
    }
    

        
        // //Add Course to Student
        // st1.addCourse(course1);
        // st1.addCourse(course2);
        // st2.addCourse(course2);
        // st2.addCourse(course3);
        // st2.addCourse(course4);

        // //Create a AVLTree to store course information
        // AVLTree tree = new AVLTree();
        // // Insert some keys into the tree
        // tree.root = tree.insert(tree.root, course1.getCourseID());
        // tree.root = tree.insert(tree.root, course2.getCourseID());
        // // Print the tree in-order
        // // System.out.println("Print the AVL-tree in-order");
        // // tree.inOrderTraversal(tree.root);

        // //Create a HashMap to store studentID with Student obj
        // HashMap<Integer, Student> student = new HashMap<Integer, Student>();
        // student.put(st1.getStudentID(), st1);
        // student.put(st2.getStudentID(), st2);

        // //Add the student to the corresponding course
        // course1.addToRoster(st1);
        // course2.addToRoster(st1);
        // course2.addToRoster(st2);
        // course3.addToRoster(st2);
        // course4.addToRoster(st2);

        // //Print Student course Schedule to view
        // System.out.println("Print Student course Schedule to view");
        // st1.displaySchedule();
        // st2.displaySchedule();

        // // //Print Course Roster Schedule to view
        // System.out.println("Print Course Roster Schedule to view");
        // course1.displayRoster();
        // course2.displayRoster();
        // course3.displayRoster();
        // course4.displayRoster();

        // // //Print Removed Course from Student 
        // System.out.println("Print Removed Course from Student");
        // st1.removeCourse(course1);
        // st1.displaySchedule();

        // // //Print Removed Student from Course Roster
        // System.out.println("Print Removed Student from Course Roster");
        // course1.removeFromRoster(st2);
        // course1.displayRoster();

        // // //Print Added Course from Student
        // System.out.println("Print Added Course from Student");
        // st1.addCourse(course4);
        // st2.displaySchedule();
    
}
