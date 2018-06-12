package tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous
 * segments of the array (max_ending_here is used for this). And keep track of
 * maximum sum contiguous segment among all positive segments (max_so_far is
 * used for this). Each time we get a positive sum compare it with max_so_far
 * and update max_so_far if it is greater than max_so_far
 *
 */

public class LargestSumArray {

	public int findLargestSum(int[] a) {
		
		// logic to handle all negative numbers in the array
		boolean allnegative = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				allnegative = true;
			} else {
				allnegative = false;
				break;
			}

		}
		if (allnegative) {
			Arrays.sort(a);
			System.out.println(a[a.length - 1]);
			return a[a.length - 1];
		}
		
		int max_ending_here = 0;
		int max_so_far = 0;
		boolean flag = false;
		
		int start = 0;
		int end = 0;
		
		
		for (int i = 0; i < a.length; i++) {
			max_ending_here += a[i]; 	// for contiguous product use multiply
										// operator here and change initial
										// value of max_ending_here=1
			if (max_ending_here > 0 && !flag) {   
				start = i;
				flag = true;   //flag is used to indicate that we have begun tracking the index
			}
			if (max_ending_here < 0) {
				max_ending_here = 0; // if total sum is negative, reset it to 0
				flag = false;
			}
			else if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				end = i;
			}
		}
		System.out.println("start = " + start);
		System.out.println("end = " + end);
		return max_so_far;
	}

	public static void main(String[] args) {
		int[] a = new int[] {-2, -3, 4, -1, -2, 1, 5, -3}; // {4,3,1,5,2}
		//int[] a = new int[] {-2, -3, -4, -1, -2, -3};
		System.out.println(new LargestSumArray().findLargestSum(a));
	}
}