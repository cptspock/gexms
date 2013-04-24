package tests;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(45);
		stack.push(59);
		stack.push(2);
		stack.push(61);
		
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		
	}

}
