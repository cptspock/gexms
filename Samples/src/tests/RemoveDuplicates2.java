package tests;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates2 {
	
	public static int[] removeDuplicates(int[] array) {
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0; i<array.length; i++) {
			set.add(Integer.valueOf(array[i]));
		}
		
		int[] result = new int[set.size()];
		int k = 0;
		for (int e : set) {
			result[k++] = e;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {3,5,3,2,8,4,9,8};
		int[] result = RemoveDuplicates2.removeDuplicates(input);
		for (int i=0; i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
