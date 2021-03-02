import javax.swing.JOptionPane;

public class PointsTracker {

	public static void main(String[] args) {

		// Initialize variable for player name and empty array structures for games and
		// points scored.
		String player = JOptionPane.showInputDialog("What is the Player's name?");
		int numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("How many games did they play?"));
		while (numberOfGames < 0) {
			// Make sure the user is entering a positive integer as you can't play a
			// negative number of basketball games.
			numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer:"));
		}
		// Initialize arrays to hold the game date and points scored, and make them
		// equal in length to the number of games played.
		int pointsScored[];
		String gameDate[];
		pointsScored = new int[numberOfGames];
		gameDate = new String[numberOfGames];

		// Populate the arrays with data retrieved from the user.
		int i = 0;
		// loop over the array the numberOfGames times, ask the user to enter
		// information for both the date and points scored. If the user enters the wrong
		// data type the program will crash
		while (i < numberOfGames) {
			gameDate[i] = JOptionPane.showInputDialog("Enter the game date (dd/mm):");
			pointsScored[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the points scored:"));
			i++;
		}

		// Calculate the average points scored by summing the pointsScored array and
		// dividing by numberOfGames.
		i = 0;
		int totalPoints = 0; // contains the summation of the pointsScored array.
		// loop over the array and add the current value to the totalPoints variable.
		while (i < numberOfGames) {
			totalPoints = totalPoints + pointsScored[i];
			i++;
		}
		// calculate average points, double is used to account for
		// decimal places in average points.
		double averagePoints = totalPoints / numberOfGames;

		// loop over the arrays and print the points scored on each date.
		i = 0;
		System.out.println("Points scored for " + player);
		while (i < numberOfGames) {
			System.out.println(pointsScored[i] + " points on " + gameDate[i]);
			i++;
		}
		// Print the average points.
		System.out.println(
				"Over " + numberOfGames + " games, " + player + " averaged " + averagePoints + " points per game.");
		// Get the best and worst game statistics to print
		// String bestAndWorstGame = getBestAndWorstGame(pointsScored, gameDate,
		// numberOfGames);
		PointsTracker sortedPPG = new PointsTracker();
		String bestAndWorstGame = sortedPPG.getBestAndWorstGame(pointsScored, gameDate, numberOfGames);
		System.out.println(bestAndWorstGame);

	}

	public String getBestAndWorstGame(int points[], String dates[], int arraySize) {
		// method to receive array of integers and arrange in ascending order.
		// James, "Java: SelectionSort animated demo with code", YouTube, 2019.
		// [Online]. Available: https://www.youtube.com/watch?v=cqh8nQwuKNE. [Accessed:
		// 08- Oct- 2019]. Video used as help with selection sorting algorithm. 
		// instead of returning a string it might be more useful to return the sorted
		// arrays, but am unsure of how to return two values. Maybe 2 separate methods
		// are required.

		int i = 0; // initialize loop counters.
		int j = 0;
		int minValue = 0; // set the minimum value to compare as zero
		int minIndex = 0; // set the index of the minimum value to zero initially
		int pointsToSwap; // temporarily hold value to rearrange in the array
		String dateToSwap;

		while (i < arraySize) {
			// this while loop loops over the entire points array and assigns a minimum
			// value and index that is later compared to other array values.
			minValue = points[i];
			minIndex = i;
			j = i;
			while (j < arraySize) {
				// loop from index j to the end of the array, so only over values not already
				// tested
				if (points[j] < minValue) {
					// if the next value is smaller than the current minimum, assign a new minimum
					// value and index.
					minValue = points[j];
					minIndex = j;
				}
				j++;
			}
			if (minValue < points[i]) {
				// if the new minimum value found is smaller than the spot we are up to in the
				// array, switch the places of the two values.
				pointsToSwap = points[i];
				points[i] = points[minIndex];
				points[minIndex] = pointsToSwap;
				dateToSwap = dates[i];
				dates[i] = dates[minIndex];
				dates[minIndex] = dateToSwap;

			}
			i++;
		}
		// return a string stating the highest points scored lowest points scored.
		String bestAndWorstGame = "The best game was on " + dates[arraySize - 1] + " with " + points[arraySize - 1]
				+ " points.\nThe worst game was on " + dates[0] + " with " + points[0] + " points.";
		return bestAndWorstGame;
	}

}
