package tests;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		for (int i = 0; i < 5; i++) {
			a[i] = i+1;
		}
		a[5] = 6;
		a[6] = 8;
		a[7] = 9;
		a[8] = 10;
		
        System.out.println("missing number: " + new MissingNumber().findMissing(a));
			
		
			

	}
	
	public int findMissing(int[] nums) {
		int total = 0;
		total = (10*11)/2; // sum of all numbers including missing number
		for (int i = 0; i < 9; i++)
			total -= nums[i];
		return total;
		
		
	}

}
