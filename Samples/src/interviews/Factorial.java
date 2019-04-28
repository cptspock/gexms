package interviews;

public class Factorial {

	// note the use of long to support very big numbers as a result of calculating factorial
	private long factorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("Factorial is not defined");
			
		else if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public long caller(int n) {
		return factorial(n);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new Factorial().caller(20));
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
