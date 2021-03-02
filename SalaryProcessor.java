import javax.swing.JOptionPane;

public class SalaryProcessor {
	public static void main(String[] args) {
		int numSalaries = Integer.parseInt(JOptionPane.showInputDialog("How many salaries?")); // Step 1
		double total = 0; // Step 2
		double salary;
		int counter = 0; // Step 3
		while (counter < numSalaries) { // Step 4
			salary = Double.parseDouble(JOptionPane.showInputDialog("Enter a salary " + counter)); // Step 4.1
			total = total + salary; // Step 4.2
			counter = counter + 1; // Step 4.3
		} // Step 4.4
		JOptionPane.showMessageDialog(null, "Total: " + total); // Step 5
	}
}