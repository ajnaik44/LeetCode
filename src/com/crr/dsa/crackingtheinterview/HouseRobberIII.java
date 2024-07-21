package com.crr.dsa.crackingtheinterview;

public class HouseRobberIII {
	 public int[] helper(TreeNode node) {
	        // return [rob this node, not rob this node]
	        if (node == null) {
	            return new int[] { 0, 0 };
	        }
	        int left[] = helper(node.left);
	        int right[] = helper(node.right);
	        // if we rob this node, we cannot rob its children
	        int rob = node.val + left[1] + right[1];
	        // else, we free to choose rob its children or not
	        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

	        return new int[] { rob, notRob };
	    }

	    public int rob(TreeNode root) {
	        int[] answer = helper(root);
	        return Math.max(answer[0], answer[1]);
	    }
	    public static void main(String[] args) {
	    	HouseRobberIII houseRobberIII = new HouseRobberIII();
	        // Create a sample binary tree
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.right = new TreeNode(4);
	        root.right.right = new TreeNode(1);

	        // Call helper method to get the result
	        int[] result = houseRobberIII.helper(root);

	        System.out.println("Maximum amount of money that can be robbed: " + Math.max(result[0], result[1]));
	    }

}
