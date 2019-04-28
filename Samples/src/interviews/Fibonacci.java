package interviews;

import java.util.Scanner;

public class Fibonacci {

	public void printFibonacci(int countofNumbersToPrint) {
		int i = 1;
		double first = 0, second = 1;
	    double out = 0;
	  
	    /*System.out.println("Enter the limit: ");
	    Scanner in = new Scanner(System.in);
        String times = in.nextLine();
        in.close();
        */
	    //int number = Integer.parseInt(times);
        
	    System.out.println(second); // for the first element in the series
		while (i < countofNumbersToPrint)
		{ 
		   out = first + second; // careful about overflow hence can go with long or double type
		   System.out.println(out);
		   first = second;
		   second = out;
		   i++;
		}
	}
	
	
	public static void main(String[] args) {
		new Fibonacci().printFibonacci(100);
	}

}
