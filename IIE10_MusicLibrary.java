import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class MusicLibrary {
private int maxNumSongs;
	
	private String[] songTitles;
	private String[] songLocations;
	private int currentNumSongs;

	public MusicLibrary() {
		this.maxNumSongs = 3;
		this.songTitles = new String[maxNumSongs];
		this.songLocations = new String[maxNumSongs];
		this.currentNumSongs = 0;
		loadSong();
		showMenu();
	}

	public static void main(String[] args) {
		int MaxNumSongs=100;
		MusicLibrary ml;
		ml = new MusicLibrary(); // Simple constructor method
		ml.showMenu(); // Call menu using Object
	}

	public void showMenu() {

		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";
		String menuChoiceString = JOptionPane.showInputDialog(menu);
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);
			if (menuChoiceInt == 1) {
				choice1(); // Call Module1
			} else if (menuChoiceInt == 2) {
				choice2(); // Call Module2
				// Code continues on next page...
			} else if (menuChoiceInt == 3) {
				choice3(); // Call Module3
			} else
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");

			menuChoiceString = JOptionPane.showInputDialog(menu);
		}
	}
	public void loadSong(){

	       BufferedReader inFile = null;
	       int lineNum;
	      
	       try{
	            inFile = new BufferedReader(new FileReader("c:/Users/radib/eclipse-workspace/MusicLibrary/song.csv"));
	            lineNum=0;
	            String currLine =inFile.readLine();
	            while(currLine != null){
	            String[] songAttributes = currLine.split(",");
	            this.songTitles[this.maxNumSongs]=new String (songAttributes[0]);
	            System.out.println(currLine);
	            lineNum++;
	            this.currentNumSongs +=1;
	            currLine=inFile.readLine();
	           }
	            inFile.close();
	           }catch (Exception e) {
	           System.out.println(e.getMessage());
	}
	}
	
	public void saveSongs(Song[] songNew){
        BufferedWriter outFile = null;
        try{
        BufferedReader inFile = new BufferedReader (new FileReader("c:/Users/radib/eclipse-workspace/MusicLibrary/song.csv"));
        int lines=0;
        while(inFile.readLine() !=null)
        lines++;
        while(lines<this.currentNumSongs){
             outFile.write(songNew[lines].getsongTitle()+","+songNew[lines].getsongLocation()+"\n");
             lines++;
         }
         inFile.close();
         outFile.close();
         }catch (Exception e) {
         System.out.println(e.getMessage());
         }
}

	public void choice1() {
		if (currentNumSongs < maxNumSongs) {
			String title = JOptionPane.showInputDialog("Enter a song title");
			int i = 0;
			while (i < currentNumSongs && !songTitles[i].equalsIgnoreCase(title))
				i += 1;
			if (i < currentNumSongs)
				JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");
			else {
				String location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
				songTitles[currentNumSongs] = title;
				songLocations[currentNumSongs] = location;
				currentNumSongs += 1;
			}
		}
		JOptionPane.showMessageDialog(null, "Oops! Looks like you have no more room for new songs");
	}

	public void choice2() {
		String message = "Song List:\n\n";
		int i = 0;
		while (i < currentNumSongs) {
			message += songTitles[i] + "," + songLocations[i] + "\n";
			i += 1;
		}
		JOptionPane.showMessageDialog(null, message);
	}

	public void choice3() {
		String targetTitle = JOptionPane.showInputDialog("Enter a song title to search");
		int i = 0;
		while (i < currentNumSongs && !songTitles[i].equalsIgnoreCase(targetTitle))
			i += 1;

		if (i < currentNumSongs) {
			// ---------------------------------------------------------------
			// For ITP, you do not need to understand how the code segment below works.
			String os = System.getProperty("os.name").toLowerCase();
			String command;
			if (os.contains("windows"))
				command = "explorer ";
			else if (os.contains("linux"))
				command = "xdg-open ";
			else
				command = "open ";
			try {
				Runtime.getRuntime().exec(command + " \"" + songLocations[i] + "\"");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to launch player");
			}
			// ---------------------------------------------------------------
		} else
			JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);
	}
}



