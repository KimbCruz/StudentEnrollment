import java.util.ArrayList;
import java.time.LocalTime;

public class Student {
	//Initialize 
	private static int studentID = 10000001;
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	//Default Constructor
	public Student() {
		this.setStudentID();
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
	
	// Adds a course to the student's schedule
	public void addCourse(Course course) {
		boolean overlap = false;
		// Adds a course to the student's schedule
		for(int i = 0; i < courses.size(); i++) {
			// If course the student is trying to add overlaps with any course in student's schedule, change 'overlap' to true so student cannot add the course
			if(isOverlapping(courses.get(i).getStartTime(), courses.get(i).getEndTime(), course.getStartTime(), course.getEndTime())) {
				overlap = true;
			}
		}
		// If course not already in student's schedule and course does not overlap with other courses, add the course to the student's schedule
		if(!courses.contains(course) && !overlap) {
			courses.add(course);			
		} else {
			System.out.println("Unable to add course. Cannot have course times overlap.");
		}
	}

	// Checks if times overlap
	public boolean isOverlapping(LocalTime s1, LocalTime e1, LocalTime s2, LocalTime e2) {
		return s1.isBefore(e2) && s2.isBefore(e1);
	}

	// Removes a course from student's schedule
	public void removeCourse(Course course) {
		courses.remove(course);
	}

	public void displaySchedule() {
		System.out.println("Courses for student with id: %d".formatted(studentID));
		for(Course course : courses) {
			System.out.println("Course Name: %s".formatted(course.getCourseName()));
			System.out.println("Course Time: %s - %s".formatted(course.getStartTime(), course.getEndTime()));
			System.out.println("------------------------------------------");
		}
	}
}