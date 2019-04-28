package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * 
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * 
 */


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LevelOrderBST {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> nodes = new ArrayList<>();
			TreeNode current = null;
			for (int i = 0; i < size; i++) {
				current = queue.remove();
				nodes.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}
			result.add(nodes);
		}
		
		/* if reverse order is needed as in 
		 * [
			  [15,7],
			  [9,20],
			  [3]
		   ]
		
			Add:
			Collections.reverse(result);
		 * 
		 */
		return result;
		
	}

	public static void main(String[] args) {

	}

}
