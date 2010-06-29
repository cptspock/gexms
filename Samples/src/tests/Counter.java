package tests;

public class Counter {
	void count(int counter) {
		if (counter == 0)
			return;
		else {
			System.out.println("hello" + counter);
			count(--counter);
			System.out.println("" + counter);
			return;
		}
	}
	
	public static void main(String[] args){
		new Counter().count(4);
	}
}
