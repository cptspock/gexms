package tests;

public class FinallyTest {

	/**
	 * @param args
	 */
	private static int i; 
	public static void main(String[] args) {
		System.out.println(FinallyTest.getMonthsInYear());

	
	}
	
	public static int getMonthsInYear(){
		//int i = 0;
		try {
		  //i=2;
		  
		} finally {
		  i = 12;
		  System.out.println("finally trumps return.");
		} 
		return i;
	}

}
