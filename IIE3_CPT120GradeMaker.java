import javax.swing.JOptionPane;

public class CPT120GradeMaker {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Enter your name");
		// double has been used in this case as for decimal values, this data type is generally the default choice,
		// float has not been used here float data type is a single-precision 32-bit
		// IEEE 754 floating point, this data type should never be used for precise values,
        double IIE_total = Double.parseDouble(JOptionPane.showInputDialog("IIE_total"));
		double assignment_total = Double.parseDouble(JOptionPane.showInputDialog("assignment_total"));
		double exam_total = Double.parseDouble(JOptionPane.showInputDialog("exam_total"));
		double non_exam_total = (IIE_total + assignment_total);
		JOptionPane.showMessageDialog(null, "Hello " + name + "!");
		JOptionPane.showMessageDialog(null, "Your non exam totat is " + non_exam_total + "");
		// use int to make sure that cap 50 always remain as integer not decimal.
		int NonExamTotalCap = 50;
		double Difference = (non_exam_total - NonExamTotalCap);
		// conditional loop use -if not exam total is greater than cap 50 it will count as a bonus mark)
		if (non_exam_total < 50) {
			JOptionPane.showMessageDialog(null, "Your bonus mark is " + 0 + "");
		} else if (non_exam_total > 50) {
			JOptionPane.showMessageDialog(null, "Your bonus mark is " + Difference + "");
		}
		double FinalCourseMark = (non_exam_total + exam_total);
		JOptionPane.showMessageDialog(null, "Your Final course Mark is " + Math.round(FinalCourseMark));
		// conditional loop has been use here to sort the final course mark into different ranges of grade.
		if (FinalCourseMark >= 80) {
			JOptionPane.showMessageDialog(null, "Your Grade is HD");
		} else if (FinalCourseMark >= 70 & FinalCourseMark <= 79) {
			JOptionPane.showMessageDialog(null, "Your Grade is DI");
		} else if (FinalCourseMark >= 60 & FinalCourseMark <= 69) {
			JOptionPane.showMessageDialog(null, "Your Grade is CR");
		} else if (FinalCourseMark >= 50 & FinalCourseMark <= 59) {
			JOptionPane.showMessageDialog(null, "Your Grade is PA");
		} else {
			JOptionPane.showMessageDialog(null, "Your Grade is F");
		}
	}

}
