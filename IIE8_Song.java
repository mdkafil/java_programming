// This class has variables and accessor methods relating to a song.
// Details regarding songs are kept separate from the application class MusicLibrary to not only make the code easier to read as a part of object oriented programming but to keep certain methods and variables exclusive to this class and requires MusicLibrary to get special permission to access it.
public class Song {
	// The title and location of each song is stored as a private object member
	// variable in each Song object.
	// This keeps the information stored specifically to that song object.
	// Only objects in this class can access these private variables.
	private String songTitle;
	private String songLocation;

	// These accessor methods allow the main application class to access the title
	// and location stored in the song object.
	// They only allow the program to read this data but not write to it.
	public String getSongTitle() {
		return this.songTitle;
	}

	public String getSongLocation() {
		return this.songLocation;
	}

	// This is the constructor method of the Song class.
	// It accepts two parameters when creating the song object because the
	// requirement states the song object cannot be created without a title and a
	// location.
	public Song(String songTitle, String songLocation) {
		this.songTitle = songTitle;
		this.songLocation = songLocation;
	}

}
