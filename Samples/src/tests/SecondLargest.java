package tests;

public class SecondLargest {
	
	public int getSecondLargest(int[] input) {
		int secondLargest = Integer.MIN_VALUE, largest = 0;
		
		if (input.length ==0) throw new IllegalArgumentException("input array is empty");
		
		largest = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] > secondLargest && input[i] < largest) {
				secondLargest = input[i];
			}
			
			else if (input[i] > largest) {
				/*int temp = largest;
				largest = input[i];
				secondLargest = temp;*/
				secondLargest = largest;
				largest = input[i];
				
			}
		}
		
		return secondLargest;
	}
	
	public static void main(String[] args) {
		//int[] input = {-1, 12, 5, 9, 17, 20, 17};
		int[] input = {52, 4,55,43,52,55, 52};
		//int[] input = {-5, Integer.MIN_VALUE, -6, -9, -17, -20, -17};
		
		System.out.print("second largest element is: " + new SecondLargest().getSecondLargest(input));
	}

}
