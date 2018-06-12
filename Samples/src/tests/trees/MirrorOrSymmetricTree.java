package tests.trees;

//Java program to check if binary tree is symmetric or not
class Node 
{
 int key;
 Node left, right;

 Node(int item) 
 {
     key = item;
     left = right = null;
 }
}

class BinaryTree
{
	Node root;

 // returns true if trees with roots as root1 and root2 are mirror
 boolean isMirror(Node node1, Node node2) 
 {
     // if both trees are empty, then they are mirror image
     if (node1 == null && node2 == null)
         return true;

     // For two trees to be mirror images, the following three
     // conditions must be true
     // 1 - Their root node's key must be same
     // 2 - left subtree of left tree and right subtree
     //      of right tree have to be mirror images
     // 3 - right subtree of left tree and left subtree
     //      of right tree have to be mirror images
     if (node1 != null && node2 != null && node1.key == node2.key)
         return (isMirror(node1.left, node2.right)
                 && isMirror(node1.right, node2.left));

     // if neither of the above conditions is true then
     // root1 and root2 are mirror images
     return false;
 }

 // returns true if the tree is symmetric i.e
 // mirror image of itself
 boolean isSymmetric(Node node) 
 {
     // check if tree is mirror of itself
     return isMirror(root, root);
 }

 // Driver program
 public static void main(String args[]) 
 {
     BinaryTree tree = new BinaryTree();
     
     // construct the tree 
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(2);
     tree.root.left.left = new Node(3);
     tree.root.left.right = new Node(4);
     tree.root.right.left = new Node(4);
     tree.root.right.right = new Node(3);
     
     boolean output = tree.isSymmetric(tree.root);
     if (output == true)
         System.out.println("1");
     else
         System.out.println("0");
 }
}
class BinaryTreeLCA{
    Node root;
     
    /* Function to find LCA of n1 and n2. The function assumes that both
       n1 and n2 are present in BST */
    Node lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;
 
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);
 
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.key < n1 && node.key < n2) 
            return lca(node.right, n1, n2);
 
        return node;
    }
 
    /* Driver program to test lca() */
    public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
        BinaryTreeLCA tree = new BinaryTreeLCA();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
 
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
 
        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
 
        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
 
    }
}
