package tests;

public class ParentFlow {

	int flowVar = 10;
	
	static{
		System.out.println("Parent static block");
	}
	
	public ParentFlow(){
		System.out.println("ParentFlow constructor");
	}
}
