import java.util.HashMap;
import java.time.LocalTime;

public class Course {
    //Initialize attributes
    private int courseNumber;
    private static int courseID = 1000;
    private String courseName;
    private LocalTime startTime;
    private LocalTime endTime;
    private HashMap<Integer, Student> roster;

	public Course(String name, LocalTime startTime, LocalTime endTime) {
        this.setCourseID();
        this.setCourseName(name);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.roster = new HashMap<Integer, Student>();
    }
	//Set Course unique Code
	public void setCourseID(){
		courseNumber = courseID;
        courseID++;
	}

	//Get Course unique Codes
	public int getCourseID(){
		return courseNumber;
	}

	//Get Course Name
    public String getCourseName() {
        return this.courseName;
    }

	//Set Course Name
    public void setCourseName(String input){
        this.courseName = input;
    }

	//Get Course Starting time
    public LocalTime getStartTime() {
        return this.startTime;
    }

	//Set Course Starting time
    public void setStartTime(LocalTime input) {
        this.startTime = input;
    }
    
	//Get Course Ending time
    public LocalTime getEndTime(){
        return this.endTime;
    }

	//Set Course Ending time
    public void setEndTime(LocalTime input){
        this.endTime = input;
    }

	//Add students to the Course Roster
    public void addToRoster(Student student) {
        this.roster.put(student.getStudentID(), student);
    }

	//Remove students from the Course Roster
	public void removeFromRoster(Student student){
        if(roster.containsKey(student.getStudentID())) {
            this.roster.remove(student.getStudentID());
        } else {
            System.out.println("Student not found in course %s with course ID %d.".formatted(this.courseName, this.courseNumber));
        }
        System.out.println("--------------------------------------------------");
	}

    //Display the Roster for that course
	public void displayRoster() {
        System.out.println("Students enrolled in course %s with ID: %d".formatted(this.courseName, this.getCourseID()));
        int counter = 1;
        for(Integer id : roster.keySet()) {
            System.out.println("%d. %d".formatted(counter, id));
            counter++;
        }
    }
}