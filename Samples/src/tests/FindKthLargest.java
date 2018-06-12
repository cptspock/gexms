package tests;

import java.util.PriorityQueue;

public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
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
		System.out.println(new FindKthLargest().findKthLargest(nums, 2));

	}

}
