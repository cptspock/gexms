package tests;

public class FlowTest extends ParentFlow {

	public static int globalVar = 10;
	static {
		System.out.println("FlowTest static block");
	}

	public FlowTest() {
		System.out.println("FlowTest constructor");
		System.out.println("flowVar= " + flowVar);
	}

	static {
		System.out.println("2nd FlowTest static block");
	}

	public static void main(String args[]) {
		new FlowTest();

		String a = "Marillion";
		String b = "Marillion";

		System.out.println(a.equals(b)); // will be true since content is same
		System.out.println(a == b);      // will be true again since strings with
									     // same value will be referenced by only ONE object
		if (a == b)
			System.out.println("Yes"); // will be true since content is same

		a = b;
		System.out.println(a.equals(b));
		System.out.println(a == b);

		String c = "Nevermore";
		String d = new String("Nevermore"); //this will force JVM to create a new object and hence c==d will be FALSE here

		System.out.println(c.equals(d));
		System.out.println(c == d);
		if (c == d)
			System.out.println("Yes");

		c = d;
		System.out.println(c.equals(d));
		System.out.println(c == d);

	}

}
