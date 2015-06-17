package tests;

import java.util.Arrays;
import java.util.Collections;


public class LargestSumArray {
	
	public int findLargestSum(int[] a) {
		int max_ending_here = 0;
		int max_so_far = 0;
		int start = 0;
		int end = 0;
		boolean flag = false;
		
		boolean allnegative = false;
		for (int i=0; i<a.length; i++) {
			if (a[i] < 0) {
				allnegative = true;
			}
			else {
				allnegative = false;
				break;
			}
			
		}
		int[] b = Arrays.copyOf(a, a.length-1);
		if (allnegative) {
			Arrays.sort(b);
			System.out.print(b[b.length -1]);
			return b[b.length -1];
		}
		
		
		
		for (int i=0; i<a.length; i++) {
			max_ending_here += a[i]; // for contiguous product use multiply operator here and change initial value of max_ending_here=1
			if (max_ending_here > 0 && !flag) {
				start = i;
				flag = true;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
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
		int[] a = new int[]{-4,-1,-1,-2,-3};
		System.out.print(new LargestSumArray().findLargestSum(a));

	}

}
