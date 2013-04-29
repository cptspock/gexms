package tests;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>(2);
		stack.offerFirst(45);
		stack.offerFirst(59);
		stack.offerFirst(2);
		stack.offerFirst(61);
		
		System.out.println(stack);
		
		stack.pollFirst();
		System.out.println(stack);
		
		stack.pollFirst();
		System.out.println(stack);
		
	}

}

/*[61, 2, 59, 45]
[2, 59, 45]
[59, 45]*/