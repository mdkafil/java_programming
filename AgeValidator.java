import javax.swing.JOptionPane;

public class AgeValidator {
	public static void main(String[] args) {
		int age;
		age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); // Step 1
		while (age < 0) { // Step 2
			age = Integer.parseInt(JOptionPane.showInputDialog("Error! Enter a positive age")); // Step 2.1
		} // Step 2.2
		JOptionPane.showMessageDialog(null, "I see you're " + age + " years old."); // Step 3
	}
}