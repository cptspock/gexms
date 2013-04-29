package tests;

public class BST {
	private Node root;

	public BST() {
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(Node nodeToAdd) {
		root = insert(root, nodeToAdd);
	}

	private Node insert(Node currentNode, Node nodeToAdd) {
		if (currentNode == null)
			return nodeToAdd;
		else {
			int compare = nodeToAdd.getData().compareTo(currentNode.getData());
			if (compare < 0)
				currentNode.setLeft(insert(currentNode.getLeft(), nodeToAdd));
			if (compare > 0)
				currentNode.setRight(insert(currentNode.getRight(), nodeToAdd));
			if (compare == 0) {
				System.out.println(nodeToAdd.getData() + " already exists");
			}
		}
		return currentNode;
	}

	public void inOrderTraverse(Node currentNode) {
		if (currentNode == null)
			return;
		inOrderTraverse(currentNode.getLeft());
		System.out.println(currentNode.getData());
		inOrderTraverse(currentNode.getRight());
	}

	public void preOrderTraverse(Node currentNode) {
		if (currentNode == null)
			return;
		System.out.println(currentNode.getData());
		preOrderTraverse(currentNode.getLeft());
		preOrderTraverse(currentNode.getRight());
	}

	public void postOrderTraverse(Node currentNode) {
		if (currentNode == null)
			return;
		postOrderTraverse(currentNode.getLeft());
		postOrderTraverse(currentNode.getRight());
		System.out.println(currentNode.getData());
	}

	public static void main(String[] args) {
		BST bst = new BST();
		Node node1 = new Node();
		node1.setData(10);
		bst.insert(node1);
		// bst.setRoot(node1);
		System.out.println(bst.getRoot().getData());

		Node node2 = new Node();
		node2.setData(20);
		bst.insert(node2);
		System.out.println(bst.getRoot().getRight().getData());

		Node node3 = new Node();
		node3.setData(5);
		bst.insert(node3);
		System.out.println(bst.getRoot().getLeft().getData());

		Node node4 = new Node();
		node4.setData(7);
		bst.insert(node4);
		// System.out.println(bst.getRoot().getLeft().getRight().getData());

		Node node5 = new Node();
		node5.setData(15);
		bst.insert(node5);
		System.out.println(bst.getRoot().getRight().getLeft().getData());

		System.out.println("in order traverse:");
		bst.inOrderTraverse(bst.getRoot());

		System.out.println("pre order traverse:");
		bst.preOrderTraverse(bst.getRoot());

		System.out.println("post order traverse:");
		bst.postOrderTraverse(bst.getRoot());
	}
}
