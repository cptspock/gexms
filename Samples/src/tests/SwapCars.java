package tests;

// A Java program to demonstrate that we can swap two
// objects be swapping members.

// A car with number class Car
class Car {
	int no;

	Car(int no) {
		this.no = no;
	}
}

public class SwapCars {

	// A class that uses Car objects

	// To swap c1 and c2
	public static void swap(Car c1, Car c2) {
		int temp = c1.no;
		c1.no = c2.no;
		c2.no = temp;
	}

	// Driver method
	public static void main(String[] args) {
		Car c1 = new Car(1);
		Car c2 = new Car(2);
		
		// direct swap
		Car temp = new Car(0);
		temp = c1;
		c1 = c2;
		c2 = temp;
		
		System.out.println("c1.no = " + c1.no);
		System.out.println("c2.no = " + c2.no);

		swap(c1, c2);
		System.out.println("c1.no = " + c1.no);
		System.out.println("c2.no = " + c2.no);
	}
}