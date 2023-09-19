import java.util.ArrayList;
import java.util.HashMap;

public class Course {
	private int courseID = 1000;
	private String courseName;
	private ArrayList<String> courses;
	
	public Course() {
		
	}
	
	// Course constructor
	public Course(String courseName) {
		// Generates a unique course ID
		this.setCourseID();
		// Sets the course name to the input of the 'courseName' parameter
		this.setCourseName(courseName);
	}
	
	// Returns the course ID
	public int getCourseID() {
		return this.courseID;
	}
	
	// Sets the course ID
	public void setCourseID() {
		// Increments the course ID by two every time a new course gets created
		// Ensures course IDs are unique
		courseID += 2;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String input) {
		this.courseName = input;
	}
	
	public ArrayList<String> getCourses() {
		return this.courses;
	}
}
