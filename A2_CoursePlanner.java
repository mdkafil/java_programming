import java.io.*; // Enables the program to read/write data to files. This allows the program to save an overview of the study period for future reference.
import javax.swing.JOptionPane; // Enables the program to output messages and take inputs graphically. This is a more user friendly experience than the Scanner method which uses the console.

// The class contains the object creation and the methods of the program.
// Multiple methods allow us to divide the code of the program into more readable and understandable portions and also reduces code repetition compared to the monolithic approach of coding which is not suitable for larger programs.
// The class is named CoursePlanner because it matches the purpose of the program which is to plan the enrolment of units in a course and allocating time for studying.
public class CoursePlanner {

	// This method asks the user to make a choice (yes/no) and returns that choice
	// to the program.
	// A String parameter can also be passed through the method to show different
	// questions above the yes or no options.
	public int getChoice(String message) {
		// Instead of storing the prompt in the message variable, we can insert it
		// directly into JOptionPane.showInputDialog() .
		// However, storing the messages in the message variable makes changing the text
		// and reading it easier.
		message += "\n(1) - Yes";
		message += "\n(2) - No";
		// The user is required to make many choices throughout the program to plan out
		// their studies so this code repeats a lot and is better suited in a method of
		// its own.
		// This uses a numerical input of 1 or 2 to represent yes or no.
		// The choice is then stored as a numerical data type.
		// The program crashes if the user enters a number larger than 2,147,483,647 or
		// less than -2,147,483,647 because that is the storage range for the int data
		// type.
		// The program also crashes if anything other than a number is entered because
		// Integer.parseInt() is unable to convert it from a String to an integer.
		int choice = Integer.parseInt(JOptionPane.showInputDialog(message));
		// JOptionPane.showInputDialog() is used to prompt the user for an input then
		// the while loop checks if the choice is valid or not.
		// If the choice is invalid, the user is shown an error message and is prompted
		// for an input again.
		// This loop is indefinite and goes on until the user has entered a valid
		// choice.
		while (choice < 1 || choice > 2) {
			// The program crashes if the user enters a number larger than 2,147,483,647 or
			// less than -2,147,483,647 because that is the storage range for the int data
			// type.
			// The program also crashes if anything other than a number is entered because
			// Integer.parseInt() is unable to convert it from a String to an integer.
			choice = Integer
					.parseInt(JOptionPane.showInputDialog("ERROR! Please enter a valid choice (1 or 2)\n\n" + message));
		}
		return choice;
	}

	// This method asks the user to enter the number of units the user plans to
	// enrol in and returns that number to the program.
	// This code is in a method of its own because the program always asks the user
	// how many units they are taking and plans their studies around the number of
	// units enroled in.
	public int getNumUnits() {
		int userNum;
		// Instead of storing the prompt in the message variable, we can insert it
		// directly into JOptionPane.showInputDialog() .
		// However, storing the messages in the message variable makes changing the text
		// and reading it easier.
		String prompt = "Enter the number of units:\n(Maximum of 3)";
		// The program crashes if the user enters a number larger than 2,147,483,647 or
		// less than -2,147,483,647 because that is the storage range for the int data
		// type.
		// The program also crashes if anything other than a number is entered because
		// Integer.parseInt() is unable to convert it from a String to an integer.
		userNum = Integer.parseInt(JOptionPane.showInputDialog(prompt));
		// A while loop is used to reptetively ask the user to enter a valid input and
		// only ends when they do so.
		while (userNum < 1 || userNum > 3) {
			// The program crashes if the user enters a number larger than 2,147,483,647 or
			// less than -2,147,483,647 because that is the storage range for the int data
			// type.
			// The program also crashes if anything other than a number is entered because
			// Integer.parseInt() is unable to convert it from a String to an integer.
			userNum = Integer
					.parseInt(JOptionPane.showInputDialog("ERROR! Please enter a valid number (1, 2, 3)\n\n" + prompt));
		}
		return userNum;
	}

	// This method asks users to choose if they prefer to study on weekends or not
	// and advises the user how many hours they should put in for each day of study.
	// A numerical parameter is passed to the method so the method knows how many
	// units the user is taking.
	// The prompt for asking the user how many units they are taking are in a
	// separate method to make the methods reusable through out the program for
	// different combinations of functions.
	// This method specifically calculates the number of hours a user has to spend
	// studying based on the number of units they enrol in.
	public String getStudyHrs(int numOfUnits) {
		// Whether the user studies on weekends or not is stored as a 1 or 2 to
		// represent yes or no.
		// This is stored as the integer data type because choosing a smaller data type
		// such as byte causes the program to crash when the user enters a number that
		// is larger than the maximum value the data type can hold.
		int weekends, studyHrs;
		// The number of hours to study is calculated as the integer data type in
		// studyHrs but the result is stored as a String data type in advisedHrs so it
		// can be added to the final message varialbe which is a String.
		// This is to avoid an error which occurs when an integer value is assigned to a
		// String variable.
		String prompt, advisedHrs;

		studyHrs = numOfUnits * 12;

		prompt = "Study on weekends?";
		// Calls the getChoice method to ask the user a yes or no question.
		weekends = getChoice(prompt);

		advisedHrs = "You are advised to study for ";
		// Uses if else statements to calculate the hours of studying based on whether
		// the use will study on weekends or not.
		if (weekends == 1) {
			advisedHrs += (studyHrs / 7);
		} else if (weekends == 2) {
			advisedHrs += (studyHrs / 5);
		}
		advisedHrs += " hours a day.";
		return advisedHrs;
	}

	// This method uses the concept of writing data to an external file to allow the
	// program to save any results generated from planning for a study period.
	public void saveOverview(String overview) {
		int choice = 0;
		// Uses if else statements and input taking to let the user decide if they want
		// to save their results to an external files after their study plan has been
		// generated.
		// Asking for a confirmation allows the user to choose if they want to overwrite
		// their previous file or not.
		String prompt = "\n\nSave overview to text file?";
		choice = getChoice(overview + prompt);
		if (choice == 1) {
			BufferedWriter outFile = null;
			try {
				outFile = new BufferedWriter(new FileWriter("overview.txt"));
				outFile.write(overview);
				outFile.close();
				JOptionPane.showMessageDialog(null,
						"File successfully saved as overview.txt!\n(Replaces any old data)");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	// This method is option 1 from the main menu separated into its own method to
	// improve readabiliy of the program code.
	// It takes in the users course details and preferences using JOptionPane and
	// stores each data in arrays so the unit name, unit cost, and required exam
	// info are linked to each other using the array index number.
	// The while loop is then used to iterate through the array and output all the
	// data in a compiled overview messsage.
	// The user is then asked if they want to save the overview in an external file
	// using the writing functionalities of Java.
	public void planUnits() {
		int numOfUnits = getNumUnits();
		String courseDetails = "";
		int choice = 0;
		// These arrays are important for storing the details of the course units
		// entered by the user.
		// Alternatively, the results could have been added to a String data type
		// message variable and then outputted at the end.
		// However, storing the details in arrays enables the program to manipulate and
		// iterate through the details which is much more difficult with a String
		// variable.
		String[] unitName = new String[numOfUnits];
		// The cost of each unit is stored as a double data type in the list because the
		// costs may include decimals (cents).
		// This is a better alternative than float because it is unlikely the program
		// will need to store numbers that large.
		double[] unitCost = new double[numOfUnits];
		String[] unitExam = new String[numOfUnits];

		int i = 0;
		// Uses a while loop to repeatedly prompt the user to input details.
		// This is a definite loop based on the number of units the user planned to
		// enrol in.
		// The number of repetitions is kept track of by the integer variable i which
		// increases each time an iteration is complete.
		while (i < numOfUnits) {
			// The user is prompted to enter the name of the unit they plan to enrol in and
			// stores this as a String data type which meets the requirement for taking in
			// at least one String input and storing it in a suitable variable.
			unitName[i] = JOptionPane
					.showInputDialog("Enter the name of the unit:\n(" + (numOfUnits - i) + " entries remaining)");
			unitCost[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the cost of the unit:"));
			choice = getChoice("Does the unit include any invigilated exams?");
			// If else statements are used to assign a "yes" or "no" to the list index based
			// on the user's choice of 1 or 2.
			if (choice == 1)
				unitExam[i] = "Yes";
			else if (choice == 2)
				unitExam[i] = "No";
			i += 1;
		}
		// The total cost of each unit is stored as a double data type because the costs
		// may include decimals (cents).
		// This is a better alternative than float because it is unlikely the program
		// will need to store numbers that large.
		double totalCost = 0.0;
		i = 0;
		while (i < numOfUnits) {
			// This while loop iterates through the cost of each unit and creates a sum.
			totalCost += unitCost[i];
			i += 1;
		}

		i = 0;
		while (i < numOfUnits) {
			// This while loop iterates through all 3 of the lists to compile all the
			// details in an organised manner to present to the user the overview of the
			// units they plan to enrol in for the study period.
			courseDetails += unitName[i];
			courseDetails += "\nCost: $" + unitCost[i];
			courseDetails += "\nExam: " + unitExam[i] + "\n\n";
			i += 1;
		}
		courseDetails += "Total cost: $" + totalCost;

		String message = "Study Period Overview\n\n";
		// All those details are then added to the final message before presenting.
		message += courseDetails;
		// The program also gets the recommended number of hours of study based on the
		// number of units the user is planning to enrol in and add this to the final
		// message.
		message += "\n" + getStudyHrs(numOfUnits);
		// The program asks the user if they wish to save this to an external file.
		saveOverview(message);
	}

	// This method includes the instructions for option 2 which calculates the
	// recommended number of hours of study.
	// It is separated from the constructor method because it improves the
	// readability of that code block.
	public void planHours() {
		int numOfUnits = getNumUnits();
		String message = getStudyHrs(numOfUnits);
		JOptionPane.showMessageDialog(null, message);
	}

	// This is the constructor method (or the main menu) and primarly deals with the
	// selection of a function when the program first starts.
	// All the other processes dealing with the arrays or calculations and such are
	// stored in their own methods so our code is more organised and easier to
	// understand.
	// Some portions of code are also made reusable by creating a method for them.
	public CoursePlanner() {
		int choice = 0;
		String tempInput, menu;
		// The menu message is stored in its own String variable because it is easier to
		// read and edit than putting it in the JOptionPane.showInputDialog() function.
		menu = "What would you like to do?\n";
		menu += "(1) - Plan for a study period\n";
		menu += "(2) - Calculate time needed for studies\n\n";
		menu += "Press Cancel to exit the program";
		tempInput = JOptionPane.showInputDialog(menu);
		// This while loop is used to bring the main menu back indefinitely after
		// completing the selected option until the user presses the Cancel button or
		// the program crashes.
		while (tempInput != null) {
			// The program crashes if the user enters a number larger than 2,147,483,647 or
			// less than -2,147,483,647 because that is the storage range for the int data
			// type.
			// The program also crashes if anything other than a number is entered because
			// Integer.parseInt() is unable to convert it from a String to an integer.
			choice = Integer.parseInt(tempInput);
			// The program uses if/else/else if statements to carry out the correct menu
			// option chosen by the user.
			// An error message is displayed using else when the user enters an invalid
			// choice.
			if (choice == 1) {
				planUnits();
			} else if (choice == 2) {
				planHours();
			} else {
				JOptionPane.showMessageDialog(null, "ERROR! Please enter a valid input (1 or 2)");
			}
			tempInput = JOptionPane.showInputDialog(menu);
		}
	}

	// This is the main method where the programs runs the code through first.
	// The constructor method is initialised here.
	// The program then runs the code in the constructor method.
	public static void main(String[] args) {
		CoursePlanner func;
		func = new CoursePlanner();
	}

}

// There are no other bugs in the program besides inputting a word when the program asks for a numerical input and attempts to convert the String to an integer data type. We are not able to overcome this at the moment because we cannot check if the inputted data type is correct before attempting to convert the data type.
