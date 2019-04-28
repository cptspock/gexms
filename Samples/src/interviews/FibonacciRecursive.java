package interviews;

/**
 * 1, 1, 2, 3, 5, 8, 13
 * @author ace
 *
 */
public class FibonacciRecursive {

	public int getFibonacci(int n) {
		if (n <= 0) return 0;
		else if (n <= 2) return 1;
		else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}
	public static void main(String[] args) {
		System.out.println(new FibonacciRecursive().getFibonacci(0));

	}

}
