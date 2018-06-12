package tests;

import java.util.Iterator;
import java.util.Stack;

/**
 * Sort a given stack 
 * - uses another stack which stores final sorted elements   
 * - uses temp variable
 * - uses iterator for iterating the sorted stack
 */

public class StackSort {
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(30);
		s.push(5);
		s.push(32);
		s = StackSort.sort(s);
		
		Iterator<Integer> iter = s.iterator();
		while (iter.hasNext()){
		    System.out.println(iter.next());
		}
	}
}