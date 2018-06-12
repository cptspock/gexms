package tests;

// BST is a binary tree where left node is always less than the root and right is always greater than root
/**
 * You should be able to easily implement the following algorithms prior to your interview:
 * » In-Order: Traverse left node, current node, then right [usually used for binary search
 * trees]
 * » Pre-Order: Traverse current node, then left node, then right node.
 * » Post-Order: Traverse left node, then right node, then current node.
 * » Insert Node: On a binary search tree, we insert a value v, by comparing it to the root. If 
 *   v > root, we go right, and else we go left. We do this until we hit an empty spot in the tree.
 *
 */
public class BST {
	private BSTNode root;

	public BST() {
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public void insert(BSTNode nodeToAdd) {
		root = insert(root, nodeToAdd);
	}

	// note that first node which is inserted will always be root (not self balancing)
	private BSTNode insert(BSTNode currentNode, BSTNode nodeToAdd) {
		if (currentNode == null)
			return nodeToAdd;
		else {
			
			int compare = nodeToAdd.getData().compareTo(currentNode.getData());
			if (compare < 0) // if nodeToAdd < currentNode
				currentNode.setLeft(insert(currentNode.getLeft(), nodeToAdd));
			else if (compare > 0) // if nodeToAdd > currentNode
				currentNode.setRight(insert(currentNode.getRight(), nodeToAdd));
			else {
				System.out.println(nodeToAdd.getData() + " already exists"); 
			}
		}
		return currentNode;
	}

	public void inOrderTraverse(BSTNode currentNode) {
		if (currentNode == null)
			return;
		inOrderTraverse(currentNode.getLeft());
		System.out.println(currentNode.getData());
		inOrderTraverse(currentNode.getRight());
	}

	public void preOrderTraverse(BSTNode currentNode) {
		if (currentNode == null)
			return;
		System.out.println(currentNode.getData());
		preOrderTraverse(currentNode.getLeft());
		preOrderTraverse(currentNode.getRight());
	}

	public void postOrderTraverse(BSTNode currentNode) {
		if (currentNode == null)
			return;
		postOrderTraverse(currentNode.getLeft());
		postOrderTraverse(currentNode.getRight());
		System.out.println(currentNode.getData());
	}

	public static void main(String[] args) {
		BST bst = new BST();
		
		BSTNode node7 = new BSTNode();
		node7.setData(12);
		bst.insert(node7);
		System.out.println("inserting 12");
		
		
		BSTNode node1 = new BSTNode();
		node1.setData(10);
		bst.insert(node1);
		System.out.println("inserting 10");
		// bst.setRoot(node1);
		//System.out.println(bst.getRoot().getData());

		BSTNode node2 = new BSTNode();
		node2.setData(20);
		bst.insert(node2);
		System.out.println("inserting 20");
		//System.out.println(bst.getRoot().getRight().getData());

		BSTNode node3 = new BSTNode();
		node3.setData(5);
		bst.insert(node3);
		System.out.println("inserting 5");
		//System.out.println(bst.getRoot().getLeft().getData());

		BSTNode node4 = new BSTNode();
		node4.setData(7);
		bst.insert(node4);
		System.out.println("inserting 7");
		// System.out.println(bst.getRoot().getLeft().getRight().getData());

		BSTNode node5 = new BSTNode();
		node5.setData(15);
		bst.insert(node5);
		System.out.println("inserting 15");
		//System.out.println(bst.getRoot().getRight().getLeft().getData());

		BSTNode node6 = new BSTNode();
		node6.setData(9);
		bst.insert(node6);
		System.out.println("inserting 9");
		
		System.out.println("in order traverse:");
		bst.inOrderTraverse(bst.getRoot());

		System.out.println("pre order traverse:");
		bst.preOrderTraverse(bst.getRoot());

		System.out.println("post order traverse:");
		bst.postOrderTraverse(bst.getRoot());
	}
}

