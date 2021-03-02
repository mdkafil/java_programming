
// "Insertion sort", En.wikipedia.org, 2019. [Online].
// Available: https://en.wikipedia.org/wiki/Insertion_sort. [Accessed: 29- Oct- 2019].

import javax.swing.JOptionPane;
import java.io.*;

// This is the main application class and it contains the blueprint of the program's
// main functions.
// It has several methods that allow the user to add, view and select courses as well
// as plan out their study periods by selecting a date and adding courses to it.
// The main functions of the program are below while more specific functions such as
// course and study period information and the methods to access those information are
// stored in their own classes.
// Fulfills the requirement of the program to have a main application class and for
// identifiers and names to be appropriate to their purpose.
// Separating the different functions and variables into different classes is a good
// approach that keeps the code of the program organised and easy to find things compared
// to keeping everything together in one class where it is messy.
public class DegreePlanner {
	// Object member variables store the information to help keep track of how many
	// courses and study periods have been added in the program.
	// Also keeps track of the maximum number of courses and periods that can be
	// created.
	// These variables are declared outside of the method so that they can be
	// accessed by any of the methods and their information is not reset when the
	// method ends.
	// They are declared private so that it requires specification to refer to these
	// variables.
	// Fulfills the requirement of creating object member variables in all classes.
	// This approach is more efficient than creating these variables in the methods
	// and passing their values each and every time through every method.
	private StudyPeriod[] studyPeriodList;
	private int currentNumPeriods;
	private int maxNumPeriods;

	private Course[] courseList;
	private int currentNumCourses;
	private int maxNumCourses;

	// These object member variables store the index range that a user can choose
	// when selecting a course under a type of category.
	// This is because different catagories may contain different index ranges of
	// courses which the user can select from.
	// They are declared here because I did not know how to return more than one
	// type of data type in the method itself.
	private int minCourseChoice;
	private int maxCourseChoice;

	// Uses BufferedReader and FileReader to load information from a .csv file.
	// Uses a while loop to go through every line of information in the file.
	// Allows the program to pick up from where it left off last time so the user
	// does not have to keep entering the courses again when they want to plan for a
	// study period.
	// Fulfills the requirement of only using BufferedReader + FileReader when
	// reading
	// and follows concepts shown in Tutorial 10 lesson.
	// Fulfills the requirement of using only .txt or .csv files placed in the
	// current folder.
	// Alternatively, course details can be stored in separate lines and a counter
	// can keep track of how many lines have been parsed. After parsing the required
	// lines of all the information, the counter is reset and the program knows it's
	// parsing another set of information.
	public void loadCourseList() {
		BufferedReader inFile = null;
		int lineNum = 0;
		try {
			inFile = new BufferedReader(new FileReader("courseList.csv"));
			lineNum = 0;
			String currLine = inFile.readLine();
			while (currLine != null) {
				String[] courseDetails = currLine.split(",");
				this.courseList[this.currentNumCourses] = new Course(courseDetails[0],
						Double.parseDouble(courseDetails[1]), courseDetails[2], Integer.parseInt(courseDetails[3]));
				this.currentNumCourses += 1;
				lineNum += 1;
				currLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return;
	}

	// Uses BufferedWriter and FileWriter to write information to a .csv file.
	// Uses a while loop to add every course from the course list to the file in a
	// new line for each course.
	// Allows the program to save the courses added by the user so they do not have
	// to keep entering the courses again when they want to plan for a study period.
	// Fulfills the requirement of only using BufferedWriter + FileWriter when
	// writing and follows concepts shown in Tutorial 10 lesson.
	// Fulfills the requirement of using only .txt or .csv files placed in the
	// current folder.
	// Alternatively, course details can be stored in separate lines and a counter
	// can keep track of how many lines have been parsed. After parsing the required
	// lines of all the information, the counter is reset and the program knows it's
	// parsing another set of information.
	public void saveCourseList() {
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter("courseList.csv"));
			int i = 0;
			while (i < this.currentNumCourses) {
				outFile.write(this.courseList[i].getCourseTitle() + "," + this.courseList[i].getCourseCost() + ","
						+ this.courseList[i].getCourseExam() + "," + this.courseList[i].getCourseType() + "\n");
				i += 1;
			}
			outFile.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return;
	}

	// Uses BufferedReader and FileReader to load information from a .csv file.
	// Uses a while loop to go through every line of information in the file.
	// Allows the program to pick up from where it left off last time so the user
	// can see the its previously planned study periods.
	// Fulfills the requirement of only using BufferedReader + FileReader when
	// reading
	// and follows concepts shown in Tutorial 10 lesson.
	// Fulfills the requirement of using only .txt or .csv files placed in the
	// current folder.
	// Alternatively, study period details can be stored in separate lines and a
	// counter can keep track of how many lines have been parsed. After parsing the
	// required lines of all the information, the counter is reset and the program
	// knows it's parsing another set of information.
	public void loadPlan() {
		BufferedReader inFile = null;
		int lineNum = 0;
		try {
			inFile = new BufferedReader(new FileReader("plan.csv"));
			lineNum = 0;
			String currLine = inFile.readLine();
			while (currLine != null) {
				String[] planDetails = currLine.split(",");
				this.studyPeriodList[this.currentNumPeriods] = new StudyPeriod(Integer.parseInt(planDetails[0]),
						Integer.parseInt(planDetails[1]));
				int currentNumCourses = Integer.parseInt(planDetails[2]);
				int courseIndex = 0;
				while (courseIndex < currentNumCourses) {
					this.studyPeriodList[this.currentNumPeriods].setCourseTitle(planDetails[3 + courseIndex]);
					courseIndex += 1;
				}
				this.currentNumPeriods += 1;
				lineNum += 1;
				currLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return;
	}

	// Uses BufferedWriter and FileWriter to write information to a .csv file.
	// Uses a while loop to add every study period from the study periods planned to
	// the file in a new line for each course.
	// Allows the program to save the study periods planned by the user so they do
	// not have to keep planning the study periods again when they want to view
	// their plans.
	// Fulfills the requirement of only using BufferedWriter + FileWriter when
	// writing and follows concepts shown in Tutorial 10 lesson.
	// Fulfills the requirement of using only .txt or .csv files placed in the
	// current folder.
	// Alternatively, study periods can be stored in separate lines and a counter
	// can keep track of how many lines have been parsed. After parsing the required
	// lines of all the information, the counter is reset and the program knows it's
	// parsing another set of information.
	public void savePlan() {
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter("plan.csv"));
			int i = 0;
			while (i < currentNumPeriods) {
				int courseIndex = 0;
				String selectedCourses = "";
				while (courseIndex < this.studyPeriodList[i].getCurrentNumCourses()) {
					selectedCourses += "," + this.studyPeriodList[i].getCourseTitle(courseIndex);
					courseIndex += 1;
				}
				outFile.write(this.studyPeriodList[i].getStudyYear() + "," + this.studyPeriodList[i].getStudyPeriod()
						+ "," + this.studyPeriodList[i].getCurrentNumCourses() + selectedCourses + "\n");
				i += 1;
			}
			outFile.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return;
	}

	// This method takes in an argument for a message and the range of options the
	// user can choose from.
	// It used in the program many times to get a user's decision and to store the
	// information chosen about a course or a study period.
	// Prevents the program from crashing by being able to identify if what the user
	// has entered is a valid choice or not.
	// Created as its own method to reduce the repetition of code as this function
	// is carried out very frequently in the program.
	// Finally, it returns the decision made by the user back to the program if it
	// is valid.
	// Fulfills the requirements of using an if statements and while loops
	// appropriately.
	// Since using Integer.parseInt() causes a crash when it attempts to convert non
	// numerical values to an integer.
	// The program keeps the user inputed choice as a String and instead converts
	// the integers to strings and checks if those match with the choice.
	public String getUserChoice(String message, int minChoice, int maxChoice) {
		String tempInput = JOptionPane.showInputDialog(message);
		int i = minChoice;
		String option = Integer.toString(i);
		// Uses while loops to check every possible option if it is with what the user
		// has chosen.
		// This allows the program to take in any type of String input and identify if
		// it is a valid choice.
		// Also, indefinitely prompts the user to enter a valid choice until they do or
		// until they press cancel.
		while (tempInput != null && !option.equalsIgnoreCase(tempInput)) {
			while (i <= maxChoice && !option.equalsIgnoreCase(tempInput)) {
				i += 1;
				option = Integer.toString(i);
			}
			// Uses an if statement to display an error message letting the user know what
			// valid choices they can enter.
			if (i > maxChoice) {
				JOptionPane.showMessageDialog(null,
						"ERROR! Please enter a valid choice between " + minChoice + " and " + maxChoice + ".");
				tempInput = JOptionPane.showInputDialog(message);
				i = minChoice;
				option = Integer.toString(i);
			}
		}
		return tempInput;
	}

	// This method finds the index of the course that matches the title and returns
	// the index to the program.
	// Allows the program to find the course and display that specific course's
	// information after the index is found.
	public int getCourseIndex(String courseTitle) {
		int courseIndex = 0;
		// Uses a while loop to check every course title in the course list.
		while (courseIndex < this.currentNumCourses
				&& !this.courseList[courseIndex].getCourseTitle().equalsIgnoreCase(courseTitle))
			courseIndex += 1;
		return courseIndex;
	}

	// This method displays a menu showing the different course types and allows the
	// user to select a type.
	// It then returns the users choice to the program.
	// Separated as its own method so that it can be used whenever the program needs
	// to bring up this menu.
	// For example, when selecting the type of course the user is adding or when the
	// user wants to view certain types of courses when planning a study period.
	// This is a better approach than including this menu many times in the code
	// because it reduces repetition.
	public String getUserCourseType(String message) {
		String menu = "";
		menu += "Enter subject type:\n";
		menu += "[0] - Foundation Subjects\n";
		menu += "[1] - Core Subjects - Level 1\n";
		menu += "[2] - Core Subjects - Level 2\n";
		menu += "[3] - Core Subjects - Level 3\n";
		menu += "[4] - Electives\n";
		menu += "\n" + message;
		String choice = getUserChoice(menu, 0, 4);
		return choice;
	}

	// Uses a while loop to go through the list of courses and sorts them by their
	// type (from highest to lowest).
	// This keeps the list organised and puts courses of a lower level type at the
	// top of the list and other courses taken much later at the bottom of the list.
	// This is important because the program accepts user input of courses as a
	// range of numbers for example 1 to 5.
	// However, when a new course is added to for example a foundation type, the
	// courses are unsorted and may display a random assortment of numbers but the
	// program accepts a range from the smallest to the largest number.
	// This opens up room to unexpected program behaviour when the user enters a
	// number not displayed but is within the range of accepted numbers.
	// Sorts courses by their type using insertion sort algorithm.
	// Taken from list of approved topics for bonus option B2, 2.3.7 Sequence
	// Sorting, Insertion Sort.
	// Fulfills the requirement of incorporating an algorithm from the approved list
	// into the program.
	// Alterntively, other sorting algorithms such as bubble sort or selection sort
	// may be used here but insertion sorting is the fastest of the 3 for nearly
	// sorted lists.
	public void sortCourses() {
		int i = 1, k;
		Course tempCourse;
		while (i < this.currentNumCourses) {
			k = i;
			while (k > 1 && this.courseList[k].getCourseType() < this.courseList[k - 1].getCourseType()) {
				tempCourse = this.courseList[k];
				this.courseList[k] = this.courseList[k - 1];
				this.courseList[k - 1] = tempCourse;
				k -= 1;
			}
			i += 1;
		}
		return;
	}

	// Uses a while loop to iterate through the list of courses added by the user.
	// Stores the details of each course in a String variable.

	// This method displays courses depending on the course type.
	// This allows the program to get the information of all the courses of that
	// course type so the user can view and choose courses.
	// Also allows the program to create a navigatable menu along with the
	// getCourseType() method.
	// It is made a method because it can be reused in different ways in the
	// program.
	// In one instance it used for displaying the courses only.
	// In another instance it is used to display the courses but also tells the
	// program which courses can be chosen by the user.
	// Using this numebered range of options to choose the course to add into the
	// study period is a better option that requires less typing compared to typing
	// the entire course title to select it.
	public String getCoursesFrom(int courseType) {
		String message = "";
		if (courseType == 0) {
			message = "Foundation Subjects";
		} else if (courseType == 1) {
			message = "Core Subjects - Level 1";
		} else if (courseType == 2) {
			message = "Core Subjects - Level 2";
		} else if (courseType == 3) {
			message = "Core Subjects - Level 3";
		} else if (courseType == 4) {
			message = "Electives";
		}
		message += "\n" + createBorder();
		int i = 0;
		int counter = 0;
		this.minCourseChoice = 0;
		this.maxCourseChoice = 0;
		// Uses a while loop to check every course.
		while (i < this.currentNumCourses) {
			// Uses if statement to check if it's the type specified, then adds its
			// information to the message variable.
			if (courseType == this.courseList[i].getCourseType()) {
				message += (i + 1) + ". " + this.courseList[i].getCourseTitle() + "\n";
				message += "Cost: $" + this.courseList[i].getCourseCost() + "\n";
				message += "Exam: " + this.courseList[i].getCourseExam() + "\n\n";
				counter += 1;
				// Uses an if/else if statement to determine the smallest course and the largest
				// course index. This is set as the range of options the user can choose from
				// when selecting a course.
				if (counter == 1) {
					this.minCourseChoice = i + 1;
				} else if (counter > 1) {
					this.maxCourseChoice = i + 1;
				}
			}
			i += 1;
		}
		// Uses an if statement to add to the message that no courses have been added
		// yet if the courses of that type do not exist.
		if (counter == 0) {
			message += "No courses of this type have been added yet.";
		}
		message += createBorder();
		return message;
	}

	// This method allows the user to plan for a number of courses for a study
	// period.
	// It is separated into its own method so that it can be used repeatedly for the
	// user to add many courses to a subject.
	// This is a better approach than leaving the code in the study period planning
	// method because it takes up a lot of space and will make the code hard to read
	// and understand.
	public String selectCoursesFor(int periodIndex) {
		int currentNumCourses = this.studyPeriodList[periodIndex].getCurrentNumCourses();
		String entriesLeft = "You can select up to "
				+ (this.studyPeriodList[periodIndex].getMaxNumCourses() - currentNumCourses) + " more courses.";
		String message = "\n(Press cancel to finish)";
		String userType = getUserCourseType(entriesLeft + message);
		// Uses an if statement to check if the user has pressed cancel so the process
		// can be skipped.
		if (userType != null) {
			int courseType = Integer.parseInt(userType);
			message = getCoursesFrom(courseType);
			message += "Choose a course:\n";
			message += entriesLeft;
			String userChoice = getUserChoice(message, this.minCourseChoice, this.maxCourseChoice);
			if (userChoice != null) {
				int courseChoice = Integer.parseInt(userChoice) - 1;
				int courseExists = 0;
				int i = 0;
				// Uses a while loop to check every study period and stops when it is found that
				// the specified course exists.
				while (i <= this.currentNumPeriods && courseExists != 1) {
					int courseIndex = 0;
					// Uses a while loop to check every course in the study period and stops when it
					// is found that the specified course exists.
					while (courseIndex < this.studyPeriodList[i].getCurrentNumCourses() && courseExists != 1) {
						// Uses an if statement to let the program know the specified course exists if
						// it has found a course with a matching title.
						if (this.studyPeriodList[i].getCourseTitle(courseIndex)
								.equalsIgnoreCase(this.courseList[courseChoice].getCourseTitle())) {
							courseExists = 1;
						}
						courseIndex += 1;
					}
					i += 1;
				}
				// Uses if/else statements to output an error message if the course is found
				// existing or saves the course title to the study period if it has not already
				// been taken.
				if (courseExists == 1) {
					JOptionPane.showMessageDialog(null, "ERROR! That course has already been chosen before.");
				} else {
					this.studyPeriodList[periodIndex].setCourseTitle(this.courseList[courseChoice].getCourseTitle());
				}
			}
		}
		return userType;
	}

	// This method gets the courses planned for a particular study period.
	// It takes in an argument that specifies which study period is to be accessed
	// and to display the courses planned for it.
	// Organised as a method in the program to reduce repetition of code every time
	// the program needs to carry out this functionality.
	// Fulfills the requirement of using while loops appropriately for repetition
	// and loop condition describes all situations under which the loop will repeat
	// and condition failing eventually.
	public String getStudyPeriodCourses(int periodIndex) {
		String message = "";
		int i = 0;
		int currentNumCourses = this.studyPeriodList[periodIndex].getCurrentNumCourses();
		// Uses a while loop to add all of the course information for that study period
		// to a String variable before it is returned to the program.
		while (i < currentNumCourses) {
			String courseTitle = this.studyPeriodList[periodIndex].getCourseTitle(i);
			int courseIndex = getCourseIndex(courseTitle);
			message += (i + 1) + ". " + this.courseList[courseIndex].getCourseTitle() + "\n";
			message += "Cost: $" + this.courseList[courseIndex].getCourseCost() + "\n";
			message += "Exam: " + this.courseList[courseIndex].getCourseExam() + "\n\n";
			i += 1;
		}
		return message;
	}

	// This method creates a presentable way to display the dates of a study period.
	// Stores the information in a String variable and returns it to the program to
	// be used.
	// Allows the user to see their study plans clearly and to know which courses
	// commence under which dates.
	// Separated as a method of its own to reduce code repetition whenever the
	// program needs to carry out this function.
	// Previously, this method was kept in the Study Period class but it was decided
	// that it was better to move it to the degree planner class because it was not
	// relevant enough to the functions of a Study Period.
	public String getStudyPeriodDate(int periodIndex) {
		int year = this.studyPeriodList[periodIndex].getStudyYear();
		int period = this.studyPeriodList[periodIndex].getStudyPeriod();
		String message = "Study Period " + period + " (";
		// Uses if/else if/else statements to determine which months to display based on
		// the study period chosen.
		if (period == 1) {
			message += "Mar " + year + " - May";
		} else if (period == 2) {
			message += "Jun " + year + " - Aug";
			;
		} else if (period == 3) {
			message += "Sep " + year + " - Nov";
		} else if (period == 4) {
			message += "Dec " + year + " - Feb";
			year += 1;
		}
		message += " " + year + ")\n";
		return message;
	}

	// This method helps make information displayed more readable when it is
	// formatted
	// neatly.
	// It is created as a method of its own to reduce code repetition every time the
	// program needs to create a border.
	// Fulfills the requirement of consistent formatting and including only relevant
	// comments and code.
	public String createBorder() {
		String message = "";
		int counter = 0;
		// Uses a while loop to create a long line of dashes which is used for
		// separating information displayed.
		// Fulfills the requirement of using while loops appropriately for repetition.
		// Alternatively, we can type out the full border and store it in the String
		// variable but that would be tedious.
		// It is far easier to create a while loop to create the border based on the
		// numerical value set to how long it should be.
		while (counter <= 30) {
			message += "-";
			counter += 1;
		}
		message += "\n";
		return message;
	}

	// Uses JOptionPane to get course details from the user then creates a Course
	// object to store the information about that course.
	// This lets the program store course information and can be selected by the
	// user
	// when they want to plan out their studies.
	// Separated from the main menu and made into its own method to make code more
	// neat and organised.
	// Alternatively, code can be left in main menu and it still works but it is
	// harder to understand the program when reading the code.
	public void addCourse() {
		// Uses if/else if/else statements to progress through the process of adding a
		// course or to decide when to cancel the ongoing process.
		// Uses if/else if/else statements to output error messages and to interpret
		// user choices.
		// Fulfills the requirement of having all code reachable and having at least one
		// reachable else if statement.
		if (this.currentNumCourses < this.maxNumCourses) {
			String message, tempInput, title, exam = "";
			int i, userChoice, type;
			double cost;
			message = "Enter a course title:";
			title = JOptionPane.showInputDialog(message);
			// Uses an indefinite while loop so the user can keep adding courses until they
			// press cancel.
			// This lets the user add courses more easily for the program to store.
			while (title != null) {
				i = getCourseIndex(title);
				if (i < this.currentNumCourses) {
					JOptionPane.showMessageDialog(null, "There is already a course titled '" + title + "'");
				} else {
					message = "Enter the course enrolment cost:";
					tempInput = JOptionPane.showInputDialog(message);
					if (tempInput != null) {
						// Program crashes here when the user enters a non-numerical value because when
						// it attempts to convert the user input to a double type it fails because it
						// only works on numerical values.
						cost = Double.parseDouble(tempInput);
						if (cost < 0.0) {
							JOptionPane.showMessageDialog(null, "ERROR! Please enter a positive numerical value.");
							tempInput = JOptionPane.showInputDialog(message);
						} else {
							message = "Does this course include an invigilated exam?\n";
							message += "[1] - Yes\n";
							message += "[2] - No";
							tempInput = getUserChoice(message, 1, 2);
							if (tempInput != null) {
								userChoice = Integer.parseInt(tempInput);
								if (userChoice == 1) {
									exam = "Yes";
								} else if (userChoice == 2) {
									exam = "No";
								}
								tempInput = getUserCourseType("");
								if (tempInput != null) {
									type = Integer.parseInt(tempInput);
									this.courseList[this.currentNumCourses] = new Course(title, cost, exam, type);
									this.currentNumCourses += 1;
									if (currentNumCourses > 1) {
										sortCourses();
									}
									saveCourseList();
								} else {
									message = "The addition of the course '" + title + "' was cancelled.";
									JOptionPane.showMessageDialog(null, message);
								}
							} else {
								message = "The addition of the course '" + title + "' was cancelled.";
								JOptionPane.showMessageDialog(null, message);
							}
						}
					} else {
						message = "The addition of the course '" + title + "' was cancelled.";
						JOptionPane.showMessageDialog(null, message);
					}
				}
				message = "Enter a course title:\n";
				message += "(Press cancel to finish)";
				title = JOptionPane.showInputDialog(message);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ERROR! There is no more room to add new courses.");
		}
		return;
	}

	// This method allows the user to view the courses that have been added to the
	// course list.
	// Separated from the main menu method to keep code more organised and clean.
	// Fulfills the requirement of using if/else statements and while loops
	// appropriately.
	public void viewCourses() {
		// Uses if/else statements to check if there are any courses to display or not.
		if (currentNumCourses > 0) {
			String message = "(Press cancel to return to main menu)";
			String choice = getUserCourseType(message);
			// Uses a while loop to indefinitely bring the course selection menu up until
			// the user presses cancel to return to the main menu.
			// Alternatively, there needn't be any while loop and the program will return to
			// the main menu immediately after the user has viewed a type of course.
			// However, this may be a hassle to the user to have to select view course every
			// time if they wanted to view other courses in that session.
			while (choice != null) {
				int courseType = Integer.parseInt(choice);
				String courses = getCoursesFrom(courseType);
				JOptionPane.showMessageDialog(null, courses);
				choice = getUserCourseType(message);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ERROR! There are no existing courses. Please add a course.");
		}
		return;
	}

	// This method allows the user to plan their studies by selecting different
	// choices and then displaying and saving it.
	// This block of code has been separated from the main menu because it is very
	// big and messy.
	// Fulfills the requirements of while loops and if/else if/else statements.
	// Separating the code here into its own method makes the code more organised
	// and easy to find certain parts.
	public void planStudy() {
		// Uses if/ else statements to progress through the planning and deciding when
		// to cancel the planning process.
		if (currentNumCourses > 0) {
			int i = this.currentNumPeriods;
			String message = "Enter year of study:";
			String tempInput = getUserChoice(message, 2019, 2119);
			if (tempInput != null) {
				int year = Integer.parseInt(tempInput);
				message = "Study Periods\n";
				message += "[1] : Mar - May\n";
				message += "[2] : June - Aug\n";
				message += "[3] : Sep - Nov\n";
				message += "[4] : Dec - Feb\n\n";
				message += "Enter study period:";
				tempInput = getUserChoice(message, 1, 4);
				if (tempInput != null) {
					int period = Integer.parseInt(tempInput);
					int periodIndex = 0;
					int periodExists = 0;
					// Uses a while loop to look through every study period planned and see if that
					// period has been planned for already or not.
					// Two separate conditions: while condition and if condition because when
					// combined, Java tries
					// to find the year from the current period's object before it is created.
					while (periodIndex < i && periodExists != 1) {
						// Uses if/else statements to display error messages if a study period already
						// exists or if a course has not been selected.
						if (this.studyPeriodList[periodIndex].getStudyYear() == year
								&& this.studyPeriodList[periodIndex].getStudyPeriod() == period) {
							periodExists = 1;
						}
						periodIndex += 1;
					}
					if (periodExists == 1) {
						message = "ERROR! There is already a plan in " + year + " for Study Period " + period + ".";
						JOptionPane.showMessageDialog(null, message);
					} else {
						this.studyPeriodList[i] = new StudyPeriod(year, period);
						tempInput = "";
						// Uses a while loop to prompt the user to add a course until they do not want
						// to add anymore, or if they haven't added any, or if they have reached the
						// limit.
						while (tempInput != null && this.studyPeriodList[i]
								.getCurrentNumCourses() < this.studyPeriodList[i].getMaxNumCourses()
								|| this.studyPeriodList[i].getCurrentNumCourses() < 1) {
							tempInput = selectCoursesFor(i);
							if (tempInput == null && this.studyPeriodList[i].getCurrentNumCourses() < 1) {
								JOptionPane.showMessageDialog(null, "ERROR! You must select at least 1 course.");
							}
						}
						this.currentNumPeriods += 1;
						savePlan();
						message = getStudyPeriodDate(i);
						message += createBorder();
						message += getStudyPeriodCourses(i);
						message += createBorder();
						JOptionPane.showMessageDialog(null, message);
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "ERROR! Please add a course before planning for a study period.");
		}
		return;
	}

	// Allows the program to display all the study periods chosen by the user and
	// the courses chosen for that period.
	// Separated from the constructor class and made as its own method to make the
	// code more organised and structured.
	// Alternatively, it could have been left in the constructor method but would
	// make the code difficult to read.
	public void viewPlan() {
		// Uses if/ else statements to decide whether to show the study plan or to
		// display an error message if there are no plans that have been made.
		if (currentNumPeriods > 0) {
			String message = "Plan\n";
			int i = 0;
			int courseIndex = 0;
			// Uses a while loop to get all the study periods planned for and adds them to
			// the String variable message.
			while (i < this.currentNumPeriods) {
				message += createBorder();
				message += getStudyPeriodDate(i);
				message += createBorder();
				message += getStudyPeriodCourses(i);
				i += 1;
			}
			JOptionPane.showMessageDialog(null, message);
		} else {
			JOptionPane.showMessageDialog(null,
					"ERROR! There are no existing plans. Please make plans for a study period.");
		}
		return;
	}

	// This is the constructor method of the main application class.
	// It has a parameter to decide how many courses it should create in the list.
	// Initialises all of the object member variables in the constructor.
	// Stores the main menu messages in a String variable then outputs the variable
	// when asking for user input.
	// Allows the user to select what they want to do, whether it is to add a new
	// course to the list, view the course list, plan for a study period, or view
	// the plans made.
	// Fulfills the requirement of every method having return as the final
	// statement.
	// Alternatively, the main functions of the program such as adding courses, etc.
	// can be included here but it would make the code hard to read because of all
	// the bulk of it so it makes sense to separate the code into separate methods.
	public DegreePlanner(int maxNumCourses) {
		this.maxNumCourses = maxNumCourses;
		this.courseList = new Course[this.maxNumCourses];
		this.currentNumCourses = 0;
		loadCourseList();

		this.maxNumPeriods = 40;
		this.studyPeriodList = new StudyPeriod[this.maxNumPeriods];
		this.currentNumPeriods = 0;
		loadPlan();

		this.minCourseChoice = 0;
		this.maxCourseChoice = 0;
		String menu = "DegreePlanner v0.1\n";
		menu += "[1] Add course\n";
		menu += "[2] View course list\n";
		menu += "[3] Plan study period\n";
		menu += "[4] View plan\n";
		String tempInput = getUserChoice(menu, 1, 4);
		// Uses a while loop to bring the user back to the main menu after completing
		// each task until the user presses cancel.
		// Fulfills the requirement for using while loops appropriately and exclusively
		// for repetition.
		while (tempInput != null) {
			int menuChoice = Integer.parseInt(tempInput);
			// Uses if/ else-if/ else statements to carry out different functions based on
			// the choice that the user makes.
			// Fulfills the requirement of using if/else/else if appropriately and
			// exclusively for non-repeating conditonal execution.
			if (menuChoice == 1) {
				addCourse();
			} else if (menuChoice == 2) {
				viewCourses();
			} else if (menuChoice == 3) {
				planStudy();
			} else if (menuChoice == 4) {
				viewPlan();
			} else
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");
			tempInput = getUserChoice(menu, 1, 4);
		}
		return;
	}

	// This is the main method of the program and the first line declares and
	// creates an object of the application class and takes in an argument for the
	// number of courses it should create in the list.
	// Fulfills the requirement of the main method only having one line to create an
	// object of the main application class.
	// Alternatively, all code can be under the main method but it would turn into a
	// huge mess because of the large amounts of code. So, it is better to separate
	// code into different methods each according to its purpose.
	public static void main(String[] args) {
		DegreePlanner plan = new DegreePlanner(100);
	}
}

// No other bugs in this program besides when the user tries to enter a word instead of a numerical value when the program asks for the course enrolment course and it tries to convert the word into the data type double.
