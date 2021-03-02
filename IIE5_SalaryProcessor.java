import javax.swing.JOptionPane;

public class SalaryProcessor
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		double[] salaries;
		salaries = new double[3]; 
		String [] Job;
		Job = new String[salaries.length];
		int totalSalary = 0;
		int averageSalary;

		
		int i = 0;
		while (i < salaries.length) 
		{
			Job[i] = JOptionPane.showInputDialog("enter a Job title");
			salaries [i] = Integer.parseInt(JOptionPane.showInputDialog("enter a salary"));
			System.out.println( Job[i] + " Salary is $" + salaries[i]);
			
			
			totalSalary += salaries[i];
			i = i + 1;
		}
		
		averageSalary = totalSalary / salaries.length;
		
		System.out.println("the total salary is " + totalSalary );
		System.out.println("the average salary is " + averageSalary);
		
		int k = 0;
		while (k < salaries.length) 
		{
			int different = (int) (salaries[k] - averageSalary);
			System.out.println( Job[k] + " Salary is "+ different+ " from the average" );
			
			k = k + 1;
		}
		
	}

}
