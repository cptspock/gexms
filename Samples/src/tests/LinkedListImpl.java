package tests;

public class LinkedListImpl {

	Node head;

	// adds to the tail of the node
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

	public void addToHead(Node node) {
		node = head;
		head = node;
	}

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void traverse() {
		if (head == null) {
			System.out.println("Null list");
		} else {
			Node current = head;
			while (current != null) {
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}

	/**
	 * removes last element in the linked list
	 */
	public void remove() {
		Node current = this.head;
		Node previous = null;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(null);
	}

	/**
	 * Removes head of linked list
	 */
	public void remove2() {
		Node temp = this.head.getNext();
		this.head.setNext(null);
		this.head.setData(null);
		this.head = temp;

	}

	/**
	 * reverse a linked list given the head of the list using recursion
	 * 
	 * @param current
	 * @return
	 */
	public Node reverseList(Node current) {
		if (current == null)
			return null;
		if (current.getNext() == null)
			return current;

		Node next = current.getNext();
		current.setNext(null);
		Node reverseRest = reverseList(next);
		next.setNext(current);
		return reverseRest;

	}

	// easier to remember than recursion
	public void reverseListNoRecursion() {

		Node current = this.head;
		Node pre = null;
		Node incoming = null;

		while (current != null) {
			incoming = current.getNext(); // store incoming item
			current.setNext(pre); // swap nodes
			pre = current; // increment also pre
			
			current = incoming; // increment current
		}
		
		this.head = pre; // pre is the latest item where
	}

	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		Node head = new Node();
		head.setData(10);
		list.add(head);

		Node node2 = new Node();
		node2.setData(20);
		list.add(node2);

		Node node3 = new Node();
		node3.setData(30);
		list.add(node3);

		// list.remove();
		list.traverse();

		// Node head2 = list.reverseList(head);
		// list.traverse();

		list.reverseListNoRecursion();
		
		list.traverse();
	}
}
