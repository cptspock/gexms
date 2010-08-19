package tests;

public class ParentFlow {

	static int flowVar = 10;
	
	static{
		int st1 = 100;
		System.out.println("Parent static block, value of st1=" + st1);
	}
	
	public ParentFlow(){
		System.out.println("ParentFlow constructor");
	}
}
