import java.util.stream.DoubleStream;
import javax.swing.JOptionPane;

public class SalaryCalculator {

	double[] salaries;
	String[] Position;
	int i;
	int array1Filled;
	int array2Filled;
	String Continue;
	// Initializes several variables for use with the application.

	public static void main(String[] args) {
		SalaryCalculator objName;
		objName = new SalaryCalculator();
		objName.Constructor();
		// Calls to a constructor method that initializes the objects that are used.
	}

	public void Constructor() {
		
		
		array1Filled = 0;
		array2Filled = 0;
		// Sets two variables to help with calculating salaries later.

		int amountToProcess = Integer
				.parseInt(JOptionPane.showInputDialog("How many salaries do you want to calculate?"));
		// Asks the user to determine how many elements in the array will be used. If a
		// number higher than 3 is input a crash will occur. A crash will also occur if
		// a non-number character is used.

		if (amountToProcess > 3) {
			amountToProcess = 3;
			JOptionPane.showMessageDialog(null, "Values over 3 are currently not supported.");
		}
		// An error message shows if the user enters a value over 3 and sets the value
		// of amountToProcess to 3 so that the program does not crash.
		else {
			JOptionPane.showMessageDialog(null, "You have input a valid amount of salaries.");
		}
		// The user is informed that they have entered a valid amount of salaries to
		// process and that the application will continue.

		while (amountToProcess <= 0) {
			amountToProcess = Integer.parseInt(JOptionPane.showInputDialog("Please enter a valid amount of salaries."));
			// Asks the user to input a valid number if they input an invalid number. The
			// program crashes if a non-number character was input.
		}

		JOptionPane.showMessageDialog(null, "You are calculating " + amountToProcess + " salaries.");
		// Informs the user of how many salaries they are calculating.

		salaries = new double[amountToProcess]; // Creates an array that is the same size as the number of salaries the
												// user wants to input.
		salaries[0] = Double.parseDouble(JOptionPane.showInputDialog("Please enter salary 1.")); // Asks the user to
																									// assign a value to
																									// the first element
																									// in an array.

		while (amountToProcess >= 2 && array1Filled == 0) {
			// This while loop is to ensure that a crash does not occur if the user chooses
			// to input 1 salary.
			salaries[1] = Double.parseDouble(JOptionPane.showInputDialog("Please enter salary 2.")); // Asks the user to
																										// assign a
																										// value to the
																										// second
																										// element in an
																										// array
			array1Filled = array1Filled + 1;
			// Advances the value of array1Filled by 1 so that the loop fails.
		}

		while (amountToProcess >= 3 && array1Filled == 1) {
			// This while loop is to ensure that a crash does not occur if the user chooses
			// to input 2 or less salaries.
			salaries[2] = Double.parseDouble(JOptionPane.showInputDialog("Please enter salary 3.")); // Asks the user to
																										// assign a
																										// value to the
																										// third element
																										// in an array
			array1Filled = array1Filled + 1;
			// Advances the value of array2Filled by 1 so that the loop fails.
		}

		Position = new String[amountToProcess]; // Creates an array that is the same size as the number of positions the
												// user wants to input.
		Position[0] = JOptionPane.showInputDialog("Please enter Position 1"); // Asks the user to input a position name
																				// that gets stored to an array.

		while (amountToProcess >= 2 && array2Filled == 0) {
			// This while loop is to ensure that a crash does not occur if the user chooses
			// to input 1 position.
			Position[1] = JOptionPane.showInputDialog("Please enter Position 2"); // Asks the user to input a second
																					// position name that gets stored to
																					// an array.
			array2Filled = array2Filled + 1;
			// Advances the value of array2Filled by 1 so that the loop fails.
		}

		while (amountToProcess == 3 && array2Filled == 1) {
			// This while loop is to ensure that a crash does not occur if the user chooses
			// to input 2 positions.
			Position[2] = JOptionPane.showInputDialog("Please enter Position 3"); // Asks the user to input a second
																					// position name that gets stored to
																					// an array.
			array2Filled = array2Filled + 1;
			// Advances the value of array2Filled by 1 so that the loop fails.
		}

		i = 0;
		// Initializes the integer called 'i'.

		double TotalSalary = DoubleStream.of(salaries).sum();
		// Calculates the total salary by getting the sum of all the elements in the
		// array.
		double AverageSalary = TotalSalary / salaries.length;
		// Calculates the average salary by dividing the total salary by how many
		// elements are in the array.

		double SalaryDifference;
		while (i < amountToProcess) {
			// Retrieve and display value at i (current element)
			SalaryDifference = AverageSalary - salaries[i];
			// Calculates the difference between the average salary and the salary at the
			// current element.
			while (SalaryDifference < 0) {
				SalaryDifference = SalaryDifference * -1;
				// If the difference between the salary is negative, then the salary is turned
				// into a positive number.
			}

			System.out.println("Salary at element " + i + " is $" + salaries[i]
					+ " and is different from the average salary by $" + SalaryDifference);
			// Prints out what the salary is at the current element and how much it differs
			// from the average salary.
			System.out.println("Position at element " + i + " is " + Position[i]);
			// Prints out what the position at the current element is.
			i = i + 1;
			// Advances the current element.

			System.out.println("The total salary is: " + TotalSalary + ".");
			// Prints the total salary.
			System.out.println("The average salary is: " + AverageSalary + ".");
			// Prints the average salary.
			
			JOptionPane.showMessageDialog(null, "All calculations completed.");
			// Informs the user that the calculations have been completed.
		}
	}
}

