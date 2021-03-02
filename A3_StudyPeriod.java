// Uses a class as a blueprint for creating study period plans for the user.
// Program can store all the details of a study period and courses taken by the user
// during it.
// All important information and functions relating to study periods are in this class.
// Fulfills the requirement of having multiple classes and relationships between each
// class.
// Alternatively, all of the code below can be stored together with the main functions
// but that would make the code very long and difficult to read. Also, it is not as
// organised.
public class StudyPeriod {
	// Object member variables are used to store all the necessary information for a
	// study period.
	// Courses taken by the user in that study period have their titles stored as a
	// string in a list.
	// All the information below can be accessed easily and does not get reset
	// compared to storing it under a method.
	// Storing this information allows the program to know what courses the user is
	// taking in a specific study period, when the study period commences and what
	// year it commences. Also, keeps track of how many courses have been taken and
	// the maximum courses that can be taken.
	// Alternatively, the courses could be stored as course objects in a list. This
	// would be copying and recreating the exact same course under the study period.
	// However, this is not as good an approach compared to using the course title
	// as a reference and retrieving the actually information from the list of
	// courses.
	private String[] selectedCourses;
	private int currentNumCourses;
	private int maxNumCourses;
	private int studyYear;
	private int studyPeriod;

	// Uses a parameter to let the program choose which course they want to access
	// in the list of selected courses stored in the study period.
	// Lets the program retrieve the different course titles in the study period to
	// display for the user to see when they want to view their plans.
	// Alternatively, the program can access this information without the need for
	// this method if the object member variables were made public but that is not
	// allowed in this assessment.
	public String getCourseTitle(int courseIndex) {
		return this.selectedCourses[courseIndex];
	}

	// This is a set method that allows the program to determine what courses are
	// taken by the user in the study period.
	// Uses an if statement so that it only adds a new course if there is still room
	// to add courses.
	// Lets the program store courses the user plans to take in a particular study
	// period.
	// Fulfills the requirement that one or more classes has set methods (mutators
	// with parameters).
	// Alternatively, the object member variables can be changed without the need
	// for set methods if the variables were set to public. However, it is not
	// allowed in this assessment.
	public void setCourseTitle(String courseTitle) {
		if (this.currentNumCourses < this.maxNumCourses) {
			this.selectedCourses[this.currentNumCourses] = courseTitle;
			this.currentNumCourses += 1;
		}
		return;
	}

	// Below are get methods that access the information of the study period and
	// returns it to be used for other purposes.
	// Allows the programs to display this information to let the user view their
	// plan for each study period.
	// Fulfills the requirement of having get methods.
	// This apporach of using get methods is better because it makes the information
	// readable only compared to making the object member variables public meaning
	// anyone can write or read to it. This protects the information.
	public int getCurrentNumCourses() {
		return this.currentNumCourses;
	}

  public int getMaxNumCourses() {
    return this.maxNumCourses;
  }

	public int getStudyYear() {
		return this.studyYear;
	}

	public int getStudyPeriod() {
		return this.studyPeriod;
	}

	// Uses a constructor method to initialise the object member variables. Uses
	// parameters to specify the minimum information needed to create a study
	// period.
	// Lets the program store the information a user wants to keep about a study
	// period so they can form plans on when they want to. take their chosen courses.
	// Creating a class for a study period is more organised and easier to read
	// compared to storing everything in the main application class as separate
	// lists linked by a similar index number.
	public StudyPeriod(int year, int period) {
		this.currentNumCourses = 0;
		this.maxNumCourses = 3;
		this.studyYear = year;
		this.studyPeriod = period;
		this.selectedCourses = new String[this.maxNumCourses];
		return;
	}
}
