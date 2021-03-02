public class RandomNumberGenerator {
 
   public static void main(String[] args) {
	usingMathClass();
   }
 
   static void usingMathClass() {
	double randomDouble = Math.random();
	randomDouble = randomDouble * 6 + 1;
	int randomInt = (int) randomDouble;
	System.out.println(randomInt);
   }
}