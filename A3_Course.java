// Courses are created using the blueprint of this class.
// This blueprint contains all the relevant information to a course such as its
// title and type.
// It also contains the methods required to access this information.
// This allows the application to create courses following the format of this blueprint.
// It is separate from most of the main application functions and only the most
// important and essential functions for a course are here.
// Fulfills the requirement of having multiple classes with once class per .java file
// and having relationships between each class.
// Alternatively, course information and accessing can be stored together with the
// rest of the program but it would long and messy and not as organised when it comes
// to accessing this information compared to keeping only the most relevant information
// together in one place.
public class Course {
	// Object member variables are used here to store the details of the course.
	// These variables are not reset in contrast to if they were stored in a method.
	// Allows the program to store details of a course and keep all of it together
	// in one place, making it easier to access compared to storing them in many
	// different lists.
	// All the object member variables are delcared here first and initialised later
	// in the constructor method.
	// Fulfills the requirement of having object member variables in all classes
	// that are explicitly private and non-static.
	// Alternatively, information can be declared and initialised in methods then
	// passed from one to another but this is more troublesome compared to the
	// current approach.
	private String courseTitle;
	private double courseCost;
	private String courseExam;
	private int courseType;

	// Below are the accessor methods used to retrieve the information stored
	// privately.
	// This allows other classes of the program to retrieve this information. It
	// uses 'this.' to specify the object member variable and uses 'return' to send
	// that information back.
	// The program then displays the course information so the user can view and
	// select which courses to include in their plan.
	// These methods are kept in this class because they are necessary for accessing
	// the information stored in each course.
	// Fulfills the requirement of having get methods (accessors with return values)
	// in one more classes.
	// Alternatively, the object member variables can be made public and there would
	// be no need for get methods to access them but this is not allowed due to the
	// requirements of the assessment.
	public String getCourseTitle() {
		return this.courseTitle;
	}

	public double getCourseCost() {
		return this.courseCost;
	}

	public String getCourseExam() {
		return this.courseExam;
	}

	public int getCourseType() {
		return this.courseType;
	}

	// Uses a constructor method with parameters so that a course cannot be created
	// without filling in the minimum information about the course.
	// Sets all of the course information when the course is first created and is
	// unchangeable after that.
	// Lets the program store all the course related information in one place under
	// one course index and prevents the information from being written over because
	// there are only get methods to read the information but no set methods to
	// change it.
	// All the object member variables are declared here.
	// Fulfills the requirement for all classes to have one constructor and have
	// parameters that take minimum information required for creating and object of
	// that class.
	// Alternatively, the course can be created without any information and then use
	// set methods to write information to that course but this is not allowed by
	// the asessment requirements.
	public Course(String title, double cost, String exam, int type) {
		this.courseTitle = title;
		this.courseCost = cost;
		this.courseExam = exam;
		this.courseType = type;
		return;
	}
}
