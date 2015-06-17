package tests;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum
 * jump length at that position. Your goal is to reach the last index in the
 * minimum number of jumps. For example: Given array A = [2,3,1,1,4] The minimum
 * number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.)
 * 
 */
public class Jumper {

	public static void main(String[] args) {
		//int[] nums = { 2, 1, 3, 1, 4 };
		int[] nums = { 2, 5, 9, 1, 3 };
		System.out.println(new Jumper().jump(nums));

	}

	public int max(int[] a) {
		int max = a[0];
		int i = 0;
		for (i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		for (int j = 0; j < a.length; j++) {
			if (a[j] == max)
				return j;
		}
		return i;

	}
	
	 public int jump(int[] A) {
	        if (A.length < 2) {
	            return 0;
	        }
	        int steps = 0;
	        int distance = 0;
	        int update = 0;
	        for (int i = 0; i < A.length - 1; i++) {
	            if (i + A[i] > distance) {
	                distance = i + A[i];
	            }
	            if (i == update) {
	                steps++;
	                update = distance;
	                if (distance >= A.length - 1) {
	                break;
	            }
	            }
	        }
	        return steps ;
	    }
	
	public int jump3(int[] A) {
        int rightMost=A[0];
        int step=A[0];
        int jump=1;
        if(A.length<=1)
            return 0;
        for(int i=1;i<A.length;++i){
            if(i==A.length-1)
                return jump;
            if(i+A[i]>rightMost)
                rightMost=i+A[i];
            step--;
            if(0==step){
                jump++;
                step=rightMost-i;
            }
        }
        return jump;
    }

	public int jump2(int[] nums) {
		int start = nums[0];
		int length = nums.length;
		int count = 0;
		if (start >= length)
			return 1;
		else {
			int index = 0;
			int post = 0;
			int[] temp = new int[nums.length];
			while (index < length) {
				if (nums[index] > 1) {
					post = index + nums[index];
					if (post >= length)
						post = post - index + 1;
					else {
						for (int i = index + 1; i <= post; i++) {
							temp[i] = nums[i];
						}
						post = max(temp);
					}
					index = index + post;
					count++;
				}
			}

		}
		return count;
	}

}
