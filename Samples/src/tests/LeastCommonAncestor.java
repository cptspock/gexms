package tests;

public class LeastCommonAncestor {
	
	
	public BST_Node LCA(BST_Node root, BST_Node n1, BST_Node n2) {
		if (root == null) {
			return null;
		}
		// If root>n1 and root>n2 then lowest common ancestor will be in left
		// subtree.
		if (root.data > n1.data && root.data > n2.data) {
			return LCA(root.left, n1, n2);

		}
		// If root<n1 and root<n2 then lowest common ancestor will be in right
		// subtree.
		else if (root.data <= n1.data && root.data < n2.data) {
			return LCA(root.right, n1, n2);
		}
		// if I am here that means i am at the root which is lowest common
		// ancestor
		return root;
	}
	
	public static void main(String[] args) {
		LeastCommonAncestor LCA = new LeastCommonAncestor();
		BST_Node root = new BST_Node();
		root.data = 8;
		BST_Node node = new BST_Node();
		node.data = 3;
		root.left = node;
		BST_Node node2 = new BST_Node();
		node2.data = 10;
		root.right = node2;
		
		
		BST_Node node3 = new BST_Node();
		node3.data = 1;
		
		BST_Node node4 = new BST_Node();
		node4.data = 6;
		
		node.left = node3;
		node.right = node4;
		
		node2.left = null;
		node2.right = null;
		node3.left = null;
		node3.right = null;
		node4.left = null;
		node4.right = null;
		
		BST_Node lca = LCA.LCA(root, node3, node4);
		System.out.println(lca.data);		
	}
}

class BST_Node {
	public int data;
	public BST_Node left;
	public BST_Node right;
}