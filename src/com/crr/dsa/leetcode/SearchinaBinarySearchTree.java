package com.crr.dsa.leetcode;

public class SearchinaBinarySearchTree {
	 public TreeNode searchBST(TreeNode root, int val) {
	        if(root==null)
	        	return root;
	        if(root.val==val)
	        	return root;
	    if(val > root.val)
	       return  searchBST(root.right, val);
	    else
	       return searchBST(root.left, val);
	    }
	 public static void main(String[] args) {
		 Integer[] root1Array = { 4,2,7,1,3};

		 TreeNode root1 = TreeNode.createTreeFromArray(root1Array);

		 SearchinaBinarySearchTree  SearchinaBinarySearchTree =  new SearchinaBinarySearchTree();
		System.out.println(SearchinaBinarySearchTree.searchBST(root1,2));
	}
}
