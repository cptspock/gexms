package interviews;

import tests.Node;

public class CircularList {
	
	Node head;

	public void add(Node node) {
		if (head == null) {
			head = node;
			head.setNext(null);
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
			node.setNext(null);
		}
	}

	public boolean hasLoop(Node first) {

	    if(first == null) // list does not exist..so no loop either.
	        return false;

	    Node slow, fast; // create two references.

	    slow = fast = first; // make both refer to the start of the list.

	    while(true) {
	    	
	        slow = slow.getNext();          // 1 hop.

	        if(fast.getNext() != null)
	            fast = fast.getNext().getNext(); // 2 hops.
	        else
	            return false;          // next node null => no loop.

	        if(slow == null || fast == null) // if either hits null..no loop.
	            return false;

	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return true;
	    }
	}
	
	public void traverse(Node head) {
		if (head == null) {
			System.out.println("Null list");
			return;
		} else {
			Node current = head;
			while (current != null) {
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}
	
	public static void main(String[] args) {
		CircularList list = new CircularList();
		
		Node head = new Node();
		head.setData(10);
		list.add(head);

		Node node2 = new Node();
		node2.setData(20);
		list.add(node2);

		Node node3 = new Node();
		node3.setData(30);
		list.add(node3);
		
		Node node4 = new Node();
		node4.setData(40);
		list.add(node4);
		
		Node node5 = new Node();
		node5.setData(50);
		list.add(node5);
		
		node5.setNext(node3);
		
		System.out.print(list.hasLoop(head));
		
		//list.traverse(head);

	}
}
