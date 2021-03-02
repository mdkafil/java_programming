import javax.swing.JOptionPane;

public class TypeDemo {

	public static void main(String[] args) {
		//The program below displays about me
				String message;
				int age=2147483647;
				message = "";
				message += "Hello world!\n";
				message += "I am Radib Ahmed,\n";
				message +="My age is:"+age+"\n";
				message += "My son name is Arham Ahmed,\n";
			    long month=Long.MAX_VALUE;
			    message+="His age is:"+month+"\n";
			    short year=Short.MAX_VALUE;
			    message+="My father age  is:"+year+"\n";
			    byte address=Byte.MAX_VALUE;
			    message += "I live in Melbourne,\n";
			    message+= "My house number is:"+address+"\n";
			    double height=Double.MAX_VALUE;
			    message+="My height is:"+height+"\n";
			    float weight=Float.MAX_VALUE;
			    message+="My weight is:"+weight+"\n";
			    boolean student=true;
			    message+="I am studying at RMIT :"+student+"\n";
			    char capitalR='R';
			    message+="RMIT start with letter :"+capitalR+"\n";
			    
			    JOptionPane.showMessageDialog(null, message);
			    
			    age=2147483647;
			    age+=1;
			    message = "";
				message += "Hello world!\n";
				message += "I am Radib Ahmed,\n";
				message +="My age is:"+age+"\n";
				message += "My son name is Arham Ahmed,\n";
				month=Long.MAX_VALUE;
				month+=1;
				message+="His age is:"+month+"\n";	
				year=Short.MAX_VALUE;
				year+=1;
				message+="My father age  is:"+year+"\n";
				address=Byte.MAX_VALUE;
				address+=1;
			    message += "I live in Melbourne,\n";
			    message+= "My house number is:"+address+"\n";
			    height=Double.MAX_VALUE;
			    height+=Double.MAX_VALUE;
			    message+="My height is:"+height+"\n";
			    weight=Float.MAX_VALUE;
			    weight+=Float.MAX_VALUE;
			    message+="My weight is:"+weight+"\n";
			    boolean teacher=false;
			    message+="I am a teacher at RMIT :"+teacher+"\n";
				char capitalA='A';
			    message+="My son name start with :"+capitalA+"\n";
			    
			    JOptionPane.showMessageDialog(null, message);
			    
			    
			    
			   		
	
				
	}

}
