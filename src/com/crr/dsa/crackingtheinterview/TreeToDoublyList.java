package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.tree.BinarySearchTreeNode;

public class TreeToDoublyList {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(5);
		root.right = new TreeNode(25);
		
		root.left.left = new TreeNode(6);
		
		root.left.right = new TreeNode(10);
		root.left.right.right = new TreeNode(17);
		new TreeToDoublyList().formCirDLL(root);
	}
	TreeNode head,tail;
	    public TreeNode treeToDoublyList(TreeNode root) {
	        if(root==null)
	        return root;
	        formCirDLL(root);
	        head.left =  tail;
	        tail.right =  head;
	        return head;
	        
	        
	    }
	    
	      public void formCirDLL(TreeNode root) {
	      if(root==null)
	        return;
	       
	       formCirDLL( root.left);
	        if(head==null)
	        {
	            head = root;
	        }
	        else {
	        tail.right =  root;
	        root.left =  tail;   
	        }
	        tail =  root;
	        formCirDLL( root.right);
	      
	      }
	    
}
