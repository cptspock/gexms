package tests;

import java.util.Arrays;

public class SmallestEvenNumber {

	private static int findNextSmallestEven(int num) {
		char[] input = Integer.toString(num).toCharArray();
		Arrays.sort(input);
		while(true){
			if(num%2==0)
				num += 2;
			else
				num += 1;
			char[] output = Integer.toString(num).toCharArray();
			Arrays.sort(output);
			if(Arrays.equals(input, output)){
				break;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		//System.out.println(SmallestEvenNumber.findNextSmallestEven(8234961));
		System.out.println(SmallestEvenNumber.findNextSmallestEven(34722641));
	}

}
