package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.tree.BinarySearchTreeNode;

public class FindMinElement {
	
	
	
	
	public static void main(String[] args) {
		// Create a sample binary search tree
		BinarySearchTreeNode root = new BinarySearchTreeNode(20);
		root.left = new BinarySearchTreeNode(5);
		root.right = new BinarySearchTreeNode(25);
		
		root.left.left = new BinarySearchTreeNode(6);
		
		root.left.right = new BinarySearchTreeNode(10);
		root.left.right.right = new BinarySearchTreeNode(17);
		//System.out.println(new FindMinElement().findElement(root,20));
	}
}
