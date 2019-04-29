package interviews;

public class ShiftArray {

	public void shiftArray(int[] nums, int shift) {
		int size = nums.length;
		shift = shift % size;
		for (int j = 0; j < shift; j++) {
			int temp = nums[0];
			for (int i = 0; i < size; i++) {
				if (i == size - 1) nums[i] = temp;
				else nums[i] = nums[i + 1];
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		new ShiftArray().shiftArray(nums, 4);
	}

}
