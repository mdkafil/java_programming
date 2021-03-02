// "How to Create Array of Objects in Java", Guru99.com, 2019. [Online].
// Available: https://www.guru99.com/array-of-objects.html. [Accessed: 17- Oct- 2019].

// Importing this into our program allows us to display prompts and ask for user input in a graphical method which is much more user friendly compared to the Scanner method which uses the console.
// We need this so that the user can clearly see the list of songs when the program is asked to display them.
import javax.swing.JOptionPane;

// This is the application class of the program. It is the main class that connects all the other objects.
// The code in the program is broken down into multiple methods according to their purpose.
// This is to reduce code repetition and to make the code easier to read and understand compared to a monolithic approach.
// Most of the program operations are found in this class.
public class MusicLibrary {
	// We declare these two variables to store the maximum number of songs and
	// current number
	// of songs.
	// We need to store these values because keeping count of the maximum number of
	// songs lets the program know how much space is left and it is also used to
	// create the number of spaces to store the songs.
	// Storing the current number of songs also lets the program keep track of the
	// current slot of memory(index) that it should be writing to when saving a
	// song. This also lets the program know how many spaces are left by checking
	// the current number of songs with the maximum number of songs.
	private int maxNumSongs;
	private int currentNumSongs;
	// An array of Song objects is declared so that each object in the array can
	// store the name and location of the song. The index of the object is then used
	// to access the stored song accordingly.
	private Song[] songList;
	// The variables above are object member variables of this class. They are
	// declared private so that they are exclusive to the class and are only usable
	// when referring to it with 'this.' in front of the variable name.
	// This prevents other parts of the program using similar variable names
	// interfering with these ones. They are very important and need to be
	// accessible throughout the entire class.

	// This method iterates through the list to find if what the user enters already
	// exists in the program.
	// It has its own method to reduce the number of times this code is repeated in
	// the program.
	// It looks for a match for either title or location of the song based on the
	// option entered into the findOption parameter.
	// Changing the value of the parameter to make the function work slightly
	// different is a better alternative than creating another method just for
	// searching if there is an existing location.
	public int findExisting(int findOption, String item) {
		String temp;
		int i = 0;
		int songFound = 0;
		// Uses if else statements here to decide whether to search for title or
		// location.
		// The first option is to look for an existing title.
		if (findOption == 0) {
			// Uses a while loop to iterate through the Song objects in the list and find
			// out if the specified item already exists or not.
			while (i < this.currentNumSongs && songFound != 1) {
				temp = this.songList[i].getSongTitle();
				if (!temp.equalsIgnoreCase(item))
					i += 1;
				else
					songFound = 1;
			}
		}
		// The second option looks for an existing location.
		else if (findOption == 1) {
			while (i < this.currentNumSongs && songFound != 1) {
				temp = this.songList[i].getSongLocation();
				if (!temp.equalsIgnoreCase(item))
					i += 1;
				else
					songFound = 1;
			}
		}
		return i; // Returns the index of the existing match.
	}

	// This method saves the user inputted title and location of the song.
	// Creates a Song object with the title and location as its parameters.
	// This allows the program to store the details of the songs so they can be
	// recalled in the future.
	// The code is separated into its own method to reduce repetition.
	public void saveSong(String songTitle, String songLocation) {
		this.songList[this.currentNumSongs] = new Song(songTitle, songLocation);
		this.currentNumSongs += 1;
	}

	// This method manipulates the array of songs by copying them to a temporary
	// location
	// and then creating a new and larger array.
	// if else statements are used to allow the user to choose if they would like to
	// increase the array size to store more songs.
	// Next, it uses a while loop to iterate through the temporary list and add each
	// one back to the new expanded array.
	// Alternatively, the built-in ArrayList functions can be used to achieve this
	// but is not allowed by the tutorial requirements.
	public void expandSongRoom() {
		// The prompt messages are stored in the String message variable and then
		// included in the JOptionPane functions because it improves the readability of
		// the text and makes it easier to edit it.
		String message;
		message = "Oops! Looks like you have no more room for new songs";
		message += "\n\nMake room for a new song?";
		message += "\n[1] - Yes";
		message += "\n[2] - No";
		// The choice the user makes is stored as an integer variable to represent the
		// actions 'yes' or 'no'.
		// The program crashes when the numerical value entered is beyond the reaches of
		// the integer data type.
		// The program also crashes when a word is entered instead of a String variable
		// and the program attempts to convert the word to an integer.
		int choice = Integer.parseInt(JOptionPane.showInputDialog(message));
		// if else statements are used here to identify if the user has made a valid
		// choice or not.
		if (choice == 1) {
			String[] tempListTitles = new String[this.maxNumSongs];
			String[] tempListLocations = new String[this.maxNumSongs];
			int i = 0;
			// The while loops below iterates through the array to copy the songs to a
			// temporary location.
			while (i < this.maxNumSongs) {
				tempListTitles[i] = this.songList[i].getSongTitle();
				tempListLocations[i] = this.songList[i].getSongLocation();
				i += 1;
			}
			// The former array is then expanded by creating a new array with a larger size
			// but wiping out all the data previously held.
			this.maxNumSongs += 1;
			this.songList = new Song[this.maxNumSongs];
			// The while loop is again used to re-add all the items copied earlier back into
			// the new expanded array.
			i = 0;
			while (i < this.currentNumSongs) {
				this.songList[i] = new Song(tempListTitles[i], tempListLocations[i]);
				i += 1;
			}
			message = "Song room successfully expanded!";
			message += "\nMaximum number of songs: ";
			JOptionPane.showMessageDialog(null, message + this.maxNumSongs);
		} else if (choice == 2) {

		} else { // An error message if the user makes an invalid choice.
			message = "That wasn't a valid choice";
			JOptionPane.showMessageDialog(null, message);
		}
	}

	// This method is used for adding songs. It is separated by from the main menu
	// to make the code easier to read and understand.
	public void addSong() {
		// if else statements are used below to change what the program does based on
		// whether the song title exists already or if the location entered already has
		// the same song.
		if (this.currentNumSongs < this.maxNumSongs) {
			String title, location;
			String message = "Enter a song title";
			title = JOptionPane.showInputDialog(message);
			int i = findExisting(0, title); // Checks if the song title exists.
			if (i < this.currentNumSongs) { // If the song title exists...
				JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");

				location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
				i = findExisting(1, location); // Checks if the location exists.
				if (i < this.currentNumSongs) { // If the location exists...
					i = 0;
					int songFound = 0;
					while (i < this.currentNumSongs && songFound != 1) {
						String tempTitle = this.songList[i].getSongTitle();
						String tempLocation = this.songList[i].getSongLocation();
						if (!tempTitle.equalsIgnoreCase(title) || !tempLocation.equalsIgnoreCase(location))
							i += 1;
						else
							songFound = 1;
					}
					if (i < this.currentNumSongs) { // If the song exists in that same location, the song is not saved.
													// (Outcome D)
						JOptionPane.showMessageDialog(null,
								"There is already a song titled '" + title + "' in that location");
					} else
						saveSong(title, location); // If song does not exist in the same location, the song is saved.
													// (Outcome B)
				} else
					saveSong(title, location); // If the song title exists but the location does not exist, the song is
												// saved. (Outcome C)
			} else { // If the song title does not exist, the song is saved. (Outcome A)
				location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
				saveSong(title, location);
			}
		} else {
			// Calls this method to increase the room in the array if the list is full.
			expandSongRoom();
		}
	}

	// This method shows a list of all the current songs stored using the while loop
	// to iterate through the list and display the songs inside.
	public void listSong() {
		String message = "Song List:\n\n";
		int i = 0;
		while (i < this.currentNumSongs) {
			message += this.songList[i].getSongTitle() + "," + this.songList[i].getSongLocation() + "\n";
			i += 1;
		}
		JOptionPane.showMessageDialog(null, message);
	}

	// This method calls another method to check if the user chosen song exists in
	// the array.
	// Then it uses if else statements to carry out the function if the song exists
	// or output an error message if the song could not be found.
	public void findSong() {
		String message = "Enter a song title to search";
		String targetTitle = JOptionPane.showInputDialog(message);
		int i = findExisting(0, targetTitle);

		if (i < this.currentNumSongs) {
			// ---------------------------------------------------------------
			// For ITP, you do not need to understand how the code segment below works.
			String os = System.getProperty("os.Title").toLowerCase();
			String command;
			if (os.contains("windows"))
				command = "explorer ";
			else if (os.contains("linux"))
				command = "xdg-open ";
			else
				command = "open ";
			try {
				Runtime.getRuntime().exec(command + " \"" + this.songList[i].getSongLocation() + "\"");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to launch player");
			}
			// ---------------------------------------------------------------
		} else
			JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);
	}

	// This is the constructor method of the MusicLibrary class.
	// The private member variables are initialised in the constructor method.
	// The code for the main menu is here because it is the first method to run
	// after the main method.
	// 100 Song object slots are created in the song list but not yet initialised.
	public MusicLibrary(int maxNumSongs) {
		this.maxNumSongs = maxNumSongs;
		this.songList = new Song[this.maxNumSongs];
		this.currentNumSongs = 0;
		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";
		String menuChoiceString = JOptionPane.showInputDialog(menu);
		// The while loop keeps bringing up the menu after each process is complete
		// until the user presses Cancel or the program crashes.
		// Separates each segment of code as a method according to its function and
		// calls the method when required to compared to including all of the code here
		// (monolithic).
		// This makes the code easier to read.
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);
			if (menuChoiceInt == 1) {
				addSong();
			} else if (menuChoiceInt == 2) {
				listSong();
			} else if (menuChoiceInt == 3) {
				findSong();
			} else
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");
			menuChoiceString = JOptionPane.showInputDialog(menu);
		}
	}

	// This is the main method which the program runs through first.
	// The object for this class is created here and the constructor method is
	// instantiated.
	// It passes the integer value to the constructor method.
	public static void main(String[] args) {
		MusicLibrary ml = new MusicLibrary(100);
		return;
	}

}

// There are no other bugs in the program besides inputting a word when the program asks for a numerical input and attempts to convert the String to an integer data type. We are not able to overcome this at the moment because we cannot check if the inputed data type is correct before attempting to convert the data type.
