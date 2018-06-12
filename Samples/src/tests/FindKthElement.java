package tests;

import java.util.Set;
import java.util.TreeSet;

public class FindKthElement {

	public int findKthElement(int[] a, int k) {
		Set<Integer> set = new TreeSet();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		int count = 0;
		for (Integer r : set) {
			if (count == k - 1) // k = 3  (count=0,1,2,3)
				return r;
			else count++;
		}
		return count;		
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{12, 3, 17, 0, 9, 6, 100};  // 12, 3, 17, 0, 9, 6, 100 // 0 3 6 9 12 17 100   // 0 1 2 3 4 5 6
		System.out.println(new FindKthElement().findKthElement(a, 3));
	}	
}