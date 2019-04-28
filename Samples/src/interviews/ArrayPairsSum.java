package interviews;

import java.util.Arrays;

public class ArrayPairsSum {

	public static void prettyPrint(int[] random, int k) {
		System.out.println("input int array : " + Arrays.toString(random));
		System.out
				.println("All pairs in an array of integers whose sum is equal to a given value "
						+ k);
		printPairsUsingTwoPointers(random, k);
	}

	// Read more:
	// http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz3cyL9Rmqc
	public static void main(String args[]) {
		prettyPrint(new int[] { 12, 14, 17, 15, -11, 19, 20, -11 }, 9);
		prettyPrint(new int[] { 1,-2,8,1,4,-3,3,5,6}, 6);
	}

	/**
	 * * Given a number finds two numbers from an array so that the sum is equal
	 * to that number k. * @param numbers * @param k
	 */
	public static void printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}

		// Read more:
		// http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz3cyL3gM6u
	}
}