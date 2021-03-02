import javax.swing.JOptionPane;

public class Myself {
	public static void main(String[] args) {
//      Wijesinghe, G. (2019). MyApps Portal. [online] Rmit.instructure.com. 
//		Available at: https://rmit.instructure.com/courses/56609/assignments/373780 
//		[Accessed 2 Sep. 2019].
		
		//The programme below displays a message about me
		String message;
		message = "";
		message = message + "Hello world!\n";
		message = message + "My Name is Radib Ahmed\n";
		message = message + "I like to play cricket with my friends on my holidays\n";
		message = message + "I like to spend my time with my two year old son\n";
		
	//Explanation about Variable,Class,Code block and Method
		message = message + "Variable\n";
		message = message + "Objects store their state in fields. However, the Java programming language also uses the term \"variable\" as well. Java programming has four type of variables.\n";
		message = message + "Class\n";
		message = message + "A class is a blueprint or prototype from which objects are created. This section defines a class that models the state and behaviour of a real-world object. It intentionally focuses on the basics, showing how even a simple class can cleanly model state and behaviour.\n";
		message = message + "Block\n";
		message = message + "A block is a group of zero or more statements between balanced braces and can be used anywhere a single statement is allowed.\n";
		message = message + "Method!\n";
		message = message + "A method in Java is a block of statements that has a name and can be executed by calling (also called invoking) it from some other place in your program. Along with fields, methods are one of the two elements that are considered members of a class. \n";
		
		JOptionPane.showMessageDialog(null, message);
	}
}