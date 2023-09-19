import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Student {
	private static int studentID = 10000001;
	private HashMap<Integer, Course> students;
	private ArrayList<Course> courses;
	
	public Student() {
		this.setStudentID();
//		students.put(this.getStudentID(), this.getCourses());
	}
	
	// Returns student's ID number
	public int getStudentID() {
		return studentID;
	}

	// Sets student's ID number
	public void setStudentID() {
		// Increments student ID by one for every student that is added
		// Ensures student IDs are unique
		studentID = studentID++;
	}
	
	public void addCourse(Course course) {
		// Adds a course to the student's schedule
		Course c = new Course();
		if(c.getCourses().contains(course)) {
			courses.add(course);			
		}
	}

//	public HashMap<Integer, Course> getCourses() {
//		
//	}
//	
//	// Adds a course to the student's schedule
//	public void addCourse(Course input) {
//		courses.put(studentID, input);
//	}
//	
//	// Displays all the courses the student is enrolled in
//	public void displayCourses() {
//		for (Entry<Integer, Course> course : courses.entrySet()) {
//			System.out.println(course);
//		}
//	}
}
