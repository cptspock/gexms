package tests;

public class MissingPositiveNumber2 {
	public static void main(String[] args) {
		int[] nums = { 0, 10, 1, -10, -20 };
		if (nums == null || nums.length ==0) System.out.println(1);
		for (int i=0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (num <= nums.length) {
				nums[num-1] = -Math.abs(nums[num-1]);
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				System.out.println( i+1);
			}
		}
	}
	
	
	

}
