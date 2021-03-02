import javax.swing.JOptionPane;

public class RenovationProjectManager {
	//Constructor method has been created here
	public RenovationProjectManager () {
		method1();
		method2();
	}
	public void method1() {
	//Method 1
	// double has been used in this case as for decimal values, this data type is generally the default choice,
	double costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
	String tempInput = JOptionPane.showInputDialog("Enter a wall name");
	double height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
	double length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
	double wallArea = height * length;
	double cost = wallArea * costPerSqm;
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + tempInput + " wall of " + wallArea + " sq.m. is $" + cost);
	}
	public void method2() {
	//Method 2
	double costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
	String wallNames = "";
	double wallArea = 0;
	double cost = 0;
	String tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
	while (tempInput != null) {
	double height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
	double length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
    wallArea += height * length;
    wallNames += tempInput + ", ";
    tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
}
    cost = wallArea * costPerSqm;
    JOptionPane.showMessageDialog(null,
    "Cost to paint " + wallNames + "wall(s) of " + wallArea + " sq.m. is $" + cost);
	}
		public static void main(String[] args) {
			new RenovationProjectManager ();

		}
	}
