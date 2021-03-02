import javax.swing.JOptionPane;


public class MusicLibrary {

	private int maxSongs;
	private Song[] SongList;
	private int currentSongs;
	private String[] songLocations;

	public MusicLibrary(int maximumNumberOfSongs) {

		this.maxSongs = maximumNumberOfSongs;
		this.SongList = new Song[this.maxSongs];
		this.currentSongs = 0;

		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";
		String menuChoiceS = JOptionPane.showInputDialog(menu);
		while (menuChoiceS != null) {
			//menuChoiceS = String
			//menuChoiceI = Int
			int menuChoiceI = Integer.parseInt(menuChoiceS);
			if (menuChoiceI == 1) {
				addSongs();
			} else if (menuChoiceI == 2) {
				displayAllSongs();
			} else if (menuChoiceI == 3) {
				findSongAndPlay();
			} else
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");

			menuChoiceS = JOptionPane.showInputDialog(menu);
		}
	}


	public String getSongTitle() {
		return JOptionPane.showInputDialog("Enter a song title");
	}


	public String getSongLocation(String title) {
		return JOptionPane.showInputDialog("Enter song location for '" + title + "'");
	}


	public void addSongs() {
		if (this.currentSongs != this.maxSongs) {
			String title = getSongTitle();
			String location = getSongLocation(title);
			this.SongList[currentSongs] = new Song(title, location);
			this.currentSongs++;


		} else {
			JOptionPane.showInputDialog("You have reached the maximum Songs");
		}

	}


	public void displayAllSongs() {
		String message = "Song List:\n\n";
		int count = 0;
		while (count < this.currentSongs) {
			message += this.SongList[count].getTitle() + "," + this.SongList[count].getLocation() + "\n";
			count += 1;
		}
		JOptionPane.showMessageDialog(null, message);
		return;
	}


	public void findSongAndPlay() {
		String targetTitle = JOptionPane.showInputDialog("Enter a song title to search");
		int i = 0;
		while (i < this.currentSongs)
			i += 1;

		if (i < this.currentSongs) {

			String os = System.getProperty("os.name").toLowerCase();
			String command;
			if (os.contains("windows"))
				command = "explorer ";
			else if (os.contains("linux"))
				command = "xdg-open ";
			else
				command = "open ";
			try {
				Runtime.getRuntime().exec(command + " \"" + this.songLocations[i] + "\"");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to launch player");
			}

		} else
			JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);
		return;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MusicLibrary ml = new MusicLibrary(100);
	}
}
