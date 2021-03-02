import javax.swing.JOptionPane; // Imports the JOptionPane functionality so we can use it to take input and output data with a graphical interface.

public class StoryMaker { // This is the class name of the program. It is important for it to be
							// identified.

	public static void main(String[] args) { // This is the main method of the program and contains the skeleton of the
												// program.
		// Outputs welcome message at the start of the program.
		// Alternative method of outputting a message would be to use the
		// System.out.println() that outputs to the console within Eclipse.
		JOptionPane.showMessageDialog(null, "Welcome to Story Maker!\n\nPress 'OK' to continue...");

		// These variables store the user input required for completing the story.
		// The String data type is chosen to store the name variables because it can
		// store a combination of characters (words).
		// No other data types are possible for this purpose because they cannot hold
		// multiple characters.

		// Possible to initialise all the variables before taking user input on a
		// separate line of code.

		// JOptionPane features a graphical interface to ask the user for input. This is
		// used to acquire input for the variables below for the story.
		// Alternative method of taking user input would be to use the Scanner method of
		// taking input through the Java console.
		String userName = JOptionPane.showInputDialog("1. Please enter your full name: ");
		String userTreeName = JOptionPane.showInputDialog("2. Please enter the name of a type of tree: ") + " tree";
		// The integer variable was chosen to store the number because it can store a
		// wide range of numbers.
		// float and double data types are also possible choices but were not chosen
		// because the story does not require any numbers with decimals.
		int userNum = Integer
				.parseInt(JOptionPane.showInputDialog("3. Please enter the number of siblings you have: "));
		// Bug: This line of code causes the program to end abruptly if the input given
		// by the user is anything other than a number.

		// String data type chosen to store the story because it can store many words.
		// No other data types are possible for this purpose because they cannot hold
		// multiple words.
		// story variable is initialised with an empty string.
		String story = "";

		// Condition checks if user given number is less than 1. Story changes depending
		// whether condition is true or false.
		// Alternative condition, would be to check if user given number is not greater
		// than or equal to 1. This is similar to the first condition.
		if (userNum < 1) {
			// The story components are added to the story variable.
			story = userName
					+ " was a big strong boy and he really liked to climb trees.\n\nHe was very short and he could not see\nso he climbed up a "
					+ userTreeName + ".\n\nMany years passed and the tree still stood\nand poor " + userName
					+ " cried out:\n\n\"HELP ME!\"\n\n" + userName
					+ " didn't know what to do\nthen he slipped and fell from the tree.\n\nA few days later, "
					+ userName + " woke up\nand couldn't find his money.\n\nHis bank account had $" + userNum
					+ "\nbecause of his medical fees...";
		} else { // A different story is added to the story variable if the first condition above
					// is not true.
			story = userName + " was a big strong boy and he really liked to climb trees.";
			// Additional story line is added if the user given number is larger than 3.
			// Alternative conditional check possible is to check if user given number is
			// not less than or equal to 3.
			if (userNum > 3) {
				story += "\n\nHe also had a big family!";
			}
			// This is the second half of the story being added after checking if the
			// program should add the optional story line above.
			story += "\n\nHe was very short and he could not see\nso he climbed up a " + userTreeName + ".\n\n"
					+ userNum + " years passed and the tree still stood\nand poor " + userName
					+ " cried out:\n\n\"HELP ME!\"\n\nHis siblings heard " + userName
					+ "'s cry\nand they set out to chop the tree.\n\n" + userNum
					+ " days later, they chopped the tree down\nand said good bye to poor Mr.Green.\n\nIn the end, "
					+ userName + " was saved\nand everyone live happily ever after...(except the tree)";
		}

		// This displays the entire story with a graphical interface.
		// Alternative method is using System.out.println() to display the story in the
		// Eclipse console.
		JOptionPane.showMessageDialog(null, story);

	}

}
