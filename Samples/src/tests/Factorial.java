package tests;


public class Factorial {
	
	private double factorial(int n) throws IllegalArgumentException{
		if (n < 0) throw new IllegalArgumentException("is this really allowed wow");
		if (n <= 1) return 1;
		else return n*factorial(n-1);
	}
	
	public double caller(int n) throws IllegalArgumentException{
		return factorial(n);
	}
	
	
	public static void main(String[] args){
		try{
			System.out.println(new Factorial().caller(-99));	
		}
		catch (IllegalArgumentException p){
			//p.printStackTrace();
			//StackTraceElement[] peas = p.getStackTrace();
			System.out.println("Error: Factorial of negative is invalid operation");
		}
				
	}

}
