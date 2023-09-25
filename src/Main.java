import java.util.HashMap;
import java.util.InputMismatchException;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    //Create Course Objects
    public static final Course course1 = new Course("CSC123", LocalTime.of(9, 00), LocalTime.of(10, 15));
    public static final Course course2 = new Course("PHY132", LocalTime.of(12, 30), LocalTime.of(13, 45));
    public static final Course course3 = new Course("CSC331", LocalTime.of(10, 00), LocalTime.of(11, 15));
    public static final Course course4 = new Course("CSC371", LocalTime.of(12, 00), LocalTime.of(13, 15));

    private static boolean programRunning = true;
    
    //Initialize Scanner
    public static Scanner kb = new Scanner(System.in);
    public static HashMap<Integer, Student> student = new HashMap<Integer, Student>();
    public static HashMap<Integer, Course> c = new HashMap<Integer, Course>();
    public static void main(String[] args) {
        // Create student objects
        Student st1 = new Student();       //StudentID: 10000001
        Student st2 = new Student();       //StudentID: 10000002
        Student st3 = new Student();       //StudentID: 10000003
        Student st4 = new Student();       //StudentID: 10000004
        Student st5 = new Student();       //StudentID: 10000005
        Student st6 = new Student();       //StudentID: 10000006

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

        //Add students to Hashmap
        student.put(st1.getStudentID(), st1);
        student.put(st2.getStudentID(), st2);
        student.put(st3.getStudentID(), st3);
        student.put(st4.getStudentID(), st4);
        student.put(st5.getStudentID(), st5);

        //Create AVLTREE for Courses
        AVLTree treeCourse = new AVLTree();
        treeCourse.root = treeCourse.insert(treeCourse.root, course1.getCourseID());
        treeCourse.root = treeCourse.insert(treeCourse.root, course2.getCourseID());
        treeCourse.root = treeCourse.insert(treeCourse.root, course3.getCourseID());
        treeCourse.root = treeCourse.insert(treeCourse.root, course4.getCourseID());

        //Create course hashmap
        c.put(course1.getCourseID(), course1);
        c.put(course2.getCourseID(), course2);
        c.put(course3.getCourseID(), course3);
        c.put(course4.getCourseID(), course4);

        while(programRunning) {
            boolean flag = false;
            //Ask user if they are a Student or a Professor
            char choice;
            System.out.println("Welcome! Are you a student or professor? (S for Student, P for Professor, E to Exit): ");
            while(!flag) {
                choice = kb.next().charAt(0);
                //Check validity
                //Choose if it is a Student or Professor
                switch(Character.toUpperCase(choice)) {
                    case 'S':
                    //Access Student Menu
                        studentMenu();
                        flag = true;
                        break;
                    case 'P':
                        professorMenu();
                        flag = true;
                        break;
                    case 'E':
                    try {
                        System.out.println("Exiting Program...");
                        Thread.sleep(2000, 2000);
                        System.out.println("Program has exited successfully.");
                    } catch(InterruptedException ie) {};
                        programRunning = false;
                        break;
                    default:
                        System.out.println("Error.");
                        flag = false;
                }
            }
        }
    } 
    
    //Checking validity
    public static String response(String ans){
        // Check if it is a valid response for Yes or No
        // UpperCase valid response
        String temp = ans.toUpperCase();
        if(!(temp.equals("Y")|| temp.equals("N") || temp.equals("S") || 
        temp.equals("P")) ){
            System.out.println("Invalid response please input correctly:");
            ans = kb.nextLine();
            response(ans);
            // Check if it is a valid response for Student or Professor
        }
        //Return the valid response
        return temp;
    }

    //Picks corresponding Course
    public static void pickingCourse(int code, int sID, int decision){
        //To add a course
        if(decision == 1){
            switch(code){
            case 1000:
                student.get(sID).addCourse(course1);
                course1.addToRoster(student.get(sID));
                break;
            case 1001:
                student.get(sID).addCourse(course2);
                course2.addToRoster(student.get(sID));
                break;
            case 1002:
                student.get(sID).addCourse(course3);
                course3.addToRoster(student.get(sID));
                break;
            case 1003:
                student.get(sID).addCourse(course4);
                course4.addToRoster(student.get(sID));
                break;
            }
        //To remove a course
        } else{
            switch(code){
            case 1000:
                student.get(sID).removeCourse(course1);
                course1.removeFromRoster(student.get(sID));
                wait("Removing student from course...", "Successfully removed student with ID %d from course.".formatted(student.get(sID).getStudentID()), 2000);
                System.out.println("------------------------------------------------------------");
                break;
            case 1001:
                student.get(sID).removeCourse(course2);
                course2.removeFromRoster(student.get(sID));
                wait("Removing student from course...", "Successfully removed student with ID %d from course.".formatted(student.get(sID).getStudentID()), 2000);
                System.out.println("------------------------------------------------------------");
                break;
            case 1002:
                student.get(sID).removeCourse(course3);
                course3.removeFromRoster(student.get(sID));
                wait("Removing student from course...", "Successfully removed student with ID %d from course.".formatted(student.get(sID).getStudentID()), 2000);
                System.out.println("------------------------------------------------------------");
                break;
            case 1003:
                student.get(sID).removeCourse(course4);
                course4.removeFromRoster(student.get(sID));
                wait("Removing student from course...", "Successfully removed student with ID %d from course.".formatted(student.get(sID).getStudentID()), 2000);
                System.out.println("------------------------------------------------------------");
                break;
            }
        }
    }

    public static void wait(String start, String end, int ms) {
        try {
            System.out.println(start);
            //sending the actual Thread of execution to sleep X milliseconds
            Thread.sleep(ms);
            System.out.println(end);
        } catch(InterruptedException ie) {}
    }

    //Asks the Professor if they want to create new student and/or remove/add/view their schedule
    public static void professorMenu() {
        //Ask professor for valid courseID
        //Ask professor if they want to remove/add a student or view course roster  
        char ans = ' ';
        int choice = 0;
        int rep;
        boolean pMenu = true;
        
        System.out.println("Are you a professor? Y/N");
        ans = kb.next().charAt(0);
        if(Character.toUpperCase(ans) == 'Y'){
            // user = new Student();
            
            while(pMenu) {
                System.out.println("1. Do you want to add a student to your course roster?" );
                //Ask student to remove a course
                System.out.println("2. Do you want to remove a student from your course roster?" );
                //Ask student to view schedule
                System.out.println("3. Do you want to view the course roster?" );
                //clear the buffer
                choice = kb.nextInt();
                pMenu = false;
            }
                switch(choice){
                    case 1:
                        System.out.println("What is the courseID of the course you want to add to");
                        rep = kb.nextInt();
                        //checks if reply exist
                        boolean e = c.containsKey(rep);
                        if(e) {
                            //Print course schedule
                            c.get(rep).displayRoster();
                            System.out.println("Enter the studentID you want to add:");
                            //clear buffer
                            kb.nextLine();
                            int sid = kb.nextInt();
                            pickingCourse(rep, sid, 1);
                            //Print updated course schedule
                            // c.get(rep).displayRoster();
                            pMenu = true;
                        } else{
                            System.out.println("Returning to Professor Menu");
                            // professorMenu();
                            pMenu = true;
                        }
                        
                    break;
                    case 2:
                        System.out.println("What is the courseID of the course you want to remove to");
                        rep = kb.nextInt();
                        //checks if reply exist
                        e = c.containsKey(rep);
                        if(e){
                            //Print course schedule
                            c.get(rep).displayRoster();
                            System.out.println("Enter the studentID you want to remove:");
                            //clear buffer
                            kb.nextLine();
                            int sid = kb.nextInt();
                            pickingCourse(rep, sid, 2);
                            //Print updated student schedule
                            // c.get(rep).displayRoster();
                            pMenu = true;
                        } else{
                            System.out.println("Returning to Professor Menu");
                            // professorMenu();
                            pMenu = true;
                        }
                        
                    break;
                    case 3:
                        System.out.println("What is the courseID of the course you want to view");
                        rep = kb.nextInt();
                        //Print course schedule
                        //checks if reply exist
                        e = c.containsKey(rep);
                        kb.nextLine();
                        if(e){
                            c.get(rep).displayRoster();
                        }else{
                            System.out.println("Invalid input returning to Professor Menu");
                            professorMenu();
                        }
                        
                    break;
                    default:
                    System.out.println("Invalid input returning to Professor Menu");
                    professorMenu();

                }
        } else if(Character.toUpperCase(ans) == 'N'){
            System.out.println("Unauthorized Access.");
            studentMenu();
            }
    }
    //Asks the student if they want to create new student and/or remove/add/view their schedule
    public static void studentMenu(){
        Student user;
        int sID = 0;
        char ans;
        int choice = 0;
        boolean mainReturningStudentMenu = false;
        boolean validID = false;

        //Ask if they are a new Student
        System.out.println("Are you a new student? Y/N");
        ans = kb.next().charAt(0);
        if(Character.toUpperCase(ans) == 'Y'){
            user = new Student();
            student.put(user.getStudentID(), user);
            System.out.println("Here is a unique Student ID for you to login and add/remove/view your courses: " + user.getStudentID() + "\n\nReturning to Student Menu...");
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ie) {}
            studentMenu();
        } else if(Character.toUpperCase(ans) == 'N'){
            //Ask for valid studentID
            while(!validID) {
                System.out.println("Please enter your Student ID");
                try {
                    sID = kb.nextInt();
                    validID = true;
                } catch(InputMismatchException im) {
                    System.out.println("Invalid input. Please enter only integer values.");
                    sID = kb.nextInt();
                }
            }
            boolean exists = student.containsKey(sID);
            if(exists){
                mainReturningStudentMenu = true;
                do {
                    //Ask student to add a course
                    System.out.println("1. Add a course to your schedule" );
                    //Ask student to remove a course
                    System.out.println("2. Remove a course from your schedule?" );
                    //Ask student to view schedule
                    System.out.println("3. View your schedule?\nEnter number:" );
                    choice = kb.nextInt();
                    mainReturningStudentMenu = false;
                } while(mainReturningStudentMenu);
                
                switch(choice){
                    case 1:
                        System.out.println("Enter the class code you want to add:");
                        System.out.println("Code: 1000 -> CSC123 9:00am - 10:15am\nCode: 1001 -> PHY132 12:30pm - 1:45pm\nCode: 1002 -> CSC331 10:00am-11:15am\nCode: 1003 -> CSC371 12:00pm - 1:15pm");
                        //reset buffer
                        // kb.nextLine();
                        //Course code
                        int t = kb.nextInt();
                        //check if that is a valid course code
                        boolean e = c.containsKey(t);
                        if(e) {
                            //Determine which course to add
                            pickingCourse(t, sID, 1);
                            System.out.println("Successfully Added CSC123 to Schedule");
                            mainReturningStudentMenu = true;
                        } else {
                            System.out.println("Invalid Input. Returning to Student Menu.");
                            studentMenu();
                            System.out.println();
                        }
                    break;
                    case 2:
                        System.out.println("Enter the class code you want to remove:");
                        System.out.println("Code: 1000 -> CSC123 9:00am - 10:15am\nCode: 1001 -> PHY132 12:30pm - 1:45pm\nCode: 1002 -> CSC331 10:00am-11:15am\nCode: 1003 -> CSC371 12:00pm - 1:15pm");                        //reset buffer
                        kb.nextLine();
                        //Course code
                        t = kb.nextInt();
                        //check if that is a valid course code
                        e = c.containsKey(t);
                        if(e){
                            //Determine which course to add
                            pickingCourse(t, sID, 2);
                            //Print updated student schedule
                            student.get(sID).displaySchedule();
                        } else{
                            System.out.println("Invalid input returning to Student Menu");
                            studentMenu();
                            System.out.println();
                        }
                    break;
                    case 3:
                        //Print student schedule
                        student.get(sID).displaySchedule();
                    break;
                    default:
                    System.out.println("Invalid input returning to Student Menu");
                    studentMenu();
                    System.out.println();
                }
                //If student does not exists
            } else{
                kb.nextLine();
                System.out.println("Invalid StudentID returning to the Student Menu");
                studentMenu();
                
            }
        }
    }
}