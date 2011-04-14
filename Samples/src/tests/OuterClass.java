package tests;

public class OuterClass {
	
	public OuterClass(){
		System.out.println("Outer class instantiated");
	}
	
	class NestedClass{
		public NestedClass(){
			System.out.println("Nested class instantiated");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OuterClass outerObject = new OuterClass(); 
		OuterClass.NestedClass nestedClass = outerObject.new NestedClass();

	}

}
