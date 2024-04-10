package com.crr.dsa.leetcode;

public class TreeNode {
	
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		@Override
	    public String toString() {
	        return "TreeNode{" +
	                "val=" + val +
	                ", left=" + left +
	                ", right=" + right +
	                '}';
	    }

		public static TreeNode createTreeFromArray(Integer[] arr){
	        TreeNode root = new TreeNode();
	        return  insertLevelOrder(arr, root, 0);
	    }


	    static TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
	                                 int i)
	    {

	        // Base case for recursion
	        if (i < arr.length) {
	            if(arr[i] == null)
	                return null;
	            TreeNode temp = new TreeNode(arr[i]);
	            root = temp;

	            // insert left child
	            root.left = insertLevelOrder(arr, root.left,
	                     2* i + 1);

	            // insert right child
	            root.right = insertLevelOrder(arr, root.right,
	                     2* i + 2);
	        }
	        return root;
	    }
		
}
