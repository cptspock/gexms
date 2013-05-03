package tests;

public class LinkedList {

	Node head;
	
	public void add(Node node){
		if (head == null) {
			head = node;
			head.setNext(null);
		}
		
		Node current = head;
		while (current.getNext()!= null){
		    current = current.getNext();
		}
		current.setNext(node);
		node.setNext(null);
	}
	
	public void traverse(Node head){
		if (head == null) {
			System.out.println("Null list");
			return;
		}
		else {
			Node current = head;
			while (current!= null){
				System.out.println(current.getData());
			    current = current.getNext();
			}
		}
	}
	
	/**
	 * removes last element in the linked list
	 */
	public void remove(){
		Node current = this.head;
		Node previous = null;
		while (current.getNext()!= null){
			previous = current;
		    current = current.getNext();
		}
		previous.setNext(null);
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = new Node();
		head.setData(10);
		list.add(head);
		
		Node node2 = new Node();
		node2.setData(20);
		list.add(node2);

		Node node3 = new Node();
		node3.setData(30);
		list.add(node3);
		
		list.remove();
		list.traverse(head);
	}
}
