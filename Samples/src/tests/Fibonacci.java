package tests;

public class Fibonacci {

	public static void main(String[] args) {
		int i = 3;
		int first = 0, second = 1;
	    int out = 0;
	    
	    System.out.println(first);
	    System.out.println(second);
		while (i < 20)
		{ 
		   out = first + second;
		   System.out.println(out);
		   first = second;
		   second = out;
		   i++;
		}
		
	}

}
