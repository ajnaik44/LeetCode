package com.crr.dsa.crackingtheinterview;

public class FirstCommonAncestor {
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = findCommonAncestor(root.left, p, q);
        TreeNode right = findCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // Nodes p and q are found in separate subtrees, root is the common ancestor
        }

        return (left != null) ? left : right; // Return the non-null node if only one node is found
    }
	public static void main(String[] args) {
	    // Creating a binary tree
	    TreeNode root = new TreeNode(3);
	    root.left = new TreeNode(5);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(6);
	    root.left.right = new TreeNode(2);
	    root.right.left = new TreeNode(0);
	    root.right.right = new TreeNode(8);
	    root.left.right.left = new TreeNode(7);
	    root.left.right.right = new TreeNode(4);
	   
	    
	   
	   
	    // Find the common ancestor
	    
	    
	    System.out.println("Common Ancestor: " + findCommonAncestor(root, root.left.right.left, root.left.right.right).data);
	}
}
