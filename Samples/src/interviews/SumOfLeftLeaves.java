package interviews;

/**
 * 
	    3
	   / \
	  9  20
	    /  \
	   15   7

	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */

public class SumOfLeftLeaves {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}
