package tests;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * comparator to reverse natural order (descending order)
 *
 */
class SmallComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1; //note this (for natural order it is o1 - o2
	}
}

public class FindKthSmallest {
	
	public int findKthSmallest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(new SmallComparator()); // pass comparator to the queue
	    for(int i: nums){
	        q.offer(i);
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}

	public static void main(String[] args) {
		int[] nums = {4, 2, 5, 9, 1, 7};
		System.out.println(new FindKthSmallest().findKthSmallest(nums, 3));
	}
}
