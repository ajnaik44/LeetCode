package com.crr.dsa.tree;

import java.util.Stack;

public class Searchinganelementinbinarytree {

	public static BinaryTreeNode search(BinaryTreeNode binaryTreeNode, int element) {
	    if (binaryTreeNode == null) {
	        return null; // Element not found in the tree
	    }

	    if (binaryTreeNode.data == element) {
	        return binaryTreeNode; // Element found, return the node
	    }

	    // Recursively search in the left and right subtrees
	    BinaryTreeNode leftResult = search(binaryTreeNode.left, element);
	    if (leftResult != null) {
	        return leftResult; // Element found in the left subtree
	    }

	    return search(binaryTreeNode.right, element); // Search in the right subtree
	}
	public static BinaryTreeNode searchwithoutRecursion(BinaryTreeNode binaryTreeNode, int element) {
	    Stack<BinaryTreeNode>  stack =  new Stack<>();
	    if(binaryTreeNode==null)
	    	return null;
	    stack.add(binaryTreeNode);
	    while(!stack.isEmpty())
	    {
	    	BinaryTreeNode current =  stack.pop();
	    	if( current.data== element)
	    		return current;
	    	if(current.right!=null)
	    	{
	    		stack.add(current.right);
	    	}
	    	 if(current.left!=null)
	    	{
	    		stack.add(current.left);
	    	}
	    }
	    return null;
	}
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		System.out.println(searchwithoutRecursion(binaryTreeNode, 4).data);

	}
}
