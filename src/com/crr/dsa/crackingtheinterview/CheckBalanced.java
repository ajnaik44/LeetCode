package com.crr.dsa.crackingtheinterview;

public class CheckBalanced {
	public static int findHeight(TreeNode node,int height)
	{
		if(node==null)
			return height;
		int Leftheight =  Math.max(findHeight(node.left, height+1),height);
		int rightheight =  Math.max(findHeight(node.right, height+1),height);
		return Math.max(Leftheight, rightheight);
	}
	static int checkHeight(TreeNode root) {
	    if (root == null) return -1;

	    int leftHeight = checkHeight(root.left);
	    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

	    int rightHeight = checkHeight(root.right);
	    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

	    int heightDiff = leftHeight - rightHeight;
	    if (Math.abs(heightDiff) > 1) {
	        return Integer.MIN_VALUE; // Found error -> pass it back
	    } else {
	        return Math.max(leftHeight, rightHeight) + 1;
	    }
	}

	 static boolean isBalancedOld(TreeNode root) {
	    return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
     
        root.right = new TreeNode(3);
     
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Calculate the height of the binary tree
        int height = findHeight(root.left, 0);
        int heightright = findHeight(root.right, 0);
        
        // Print the height
        System.out.println(isBalanced(root) );
    }
	 public static  boolean isBalanced(TreeNode root) {
	        if (root == null) {
	            return true; // An empty tree is considered balanced
	        }
	        return Math.abs(height(root.left) - height(root.right)) <= 1
	                && isBalanced(root.left)
	                && isBalanced(root.right);
	    }

	    private static int height(TreeNode node) {
	        if (node == null) {
	            return 0;
	        }
	        return 1 + Math.max(height(node.left), height(node.right));
	    }
}
