// pyramid

import javax.swing.JOptionPane;
import java.lang.Math;

public class CPT120GradeMaker {

	public static void main(String[] args) {
    int number=20;
    
    for(int i=0; i<number; i++){
        for(int j=i; j<number; j++)
            System.out.print("");
        for(int k=1; k<i*2; k++)
            System.out.print("#");
    System.out.println();
    }
    
	
	}

}