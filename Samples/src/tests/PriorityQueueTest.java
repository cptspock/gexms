package tests;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(20);
		q.offer(5);
		q.offer(7);
		
		/**
		 * iterator will not print the queue in sorted order, since it stores 
		 * in partially sorted heap order. you have to remove elements in a loop to sort them
		 */
		Iterator<Integer> i = q.iterator(); 
		while (i.hasNext()){
			System.out.println(i.next());
		}
		while (q.size() > 0){
			System.out.println(q.poll());
		}
		
		/*System.out.println(q.peek());
		System.out.println(q.peek());
		System.out.println(q.peek());*/
		
	}

}
