package threads;


public class FirstThreadingExample {
	public static void main(String[] args) {
		// The second argument is a delay between
		// successive outputs. The delay is
		// measured in milliseconds. "10", for
		// instance, means, "print a line every
		// hundredth of a second".
		ExampleThread mt = new ExampleThread("A", 310);
		ExampleThread mt2 = new ExampleThread("B", 250);
		ExampleThread mt3 = new ExampleThread("C", 300);
		mt.start();
		mt2.start();
		mt3.start();
	}
}