package tests;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeForLargestNum {
	public static String largestNumber(int[] nums) {
	    String[] arr = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        arr[i]=String.valueOf(nums[i]);
	    }
	 
	    Arrays.sort(arr, new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: arr){
	        sb.append(s);
	    }
	 
	    while(sb.charAt(0)=='0'&&sb.length()>1)
	        sb.deleteCharAt(0);
	 
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		//int[] nums = {3, 30, 34, 9, 89};
		int[] nums = {39, 38, 37, 73, 0, 9, 42};
		System.out.println(ArrangeForLargestNum.largestNumber(nums));
	}
	
	
}
