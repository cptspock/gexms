package tests;

public class Factorial {

	private double factorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("the real place where the exception is thrown");
			
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public double caller(int n) {
		return factorial(n);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new Factorial().caller(-99));
		} catch (IllegalArgumentException iae) {
			// p.printStackTrace();
			// StackTraceElement[] peas = p.getStackTrace();
			iae.printStackTrace();
			System.out.println("Factorial will not be calculated");
		}

		// to demonstrate that if u catch an exception, execution of the program
		// continues
		System.out.println("proceeding after exception");
	}

}
