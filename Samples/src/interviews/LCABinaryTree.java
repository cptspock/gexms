package interviews;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 *
 *	Example 1:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	Output: 3
	Explanation: The LCA of nodes 5 and 1 is 3.
	
	Example 2:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
	Output: 5
	Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 
 */
public class LCABinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) 
	            return null;
	        
	        if (root.val == p.val || root.val == q.val)
	            return root;
	        
	        TreeNode left =  lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        
	        if (left != null && right != null)
	            return root;
	        else {
	            return (left != null ? left : right);
	        }
	    }
}
