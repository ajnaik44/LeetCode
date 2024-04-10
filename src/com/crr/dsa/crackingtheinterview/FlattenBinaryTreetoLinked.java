package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinked {
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.right.right = new TreeNode(4);
	       new FlattenBinaryTreetoLinked().flatten(root);
	       System.out.println();
	}
	 public void flatten(TreeNode root) {
		 TreeNode current = root;
		  flattenHelper(current);
		  List<String> a=new ArrayList<String>();
		System.out.println("leetcode".split("leet")[1]);
	 }
	 public void flattenHelper(TreeNode root) {
		 TreeNode right = null;
		 if(root!=null)
		 {
			 right =  root.right;
			 
			 root.right =  root.left;
			 root.left=null;
			 
			 flattenHelper(root.right);
			 
			 TreeNode temp =  root.right;
			 
			 while(temp!=null && temp.right!=null)
			 {
				 temp = temp.right;
			 }
			 if(temp!=null)
			 temp.right =  right;
			
		 }
	 }
}
