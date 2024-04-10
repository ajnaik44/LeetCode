package com.crr.dsa.tree;

import java.util.Stack;

public class Problemnumberofleaves15 {

	
	public static int findNumberOfLeaves(BinaryTreeNode binaryTreeNode)
	{
		Stack<BinaryTreeNode>  stack = new Stack<>();
		stack.add(binaryTreeNode);
		int counter=0;
		while(!stack.isEmpty())
		{
			BinaryTreeNode current = stack.pop();
			if(current!=null)
			{
				if(current.left!=null)
				{
					stack.add(current.left);
				}
				if(current.right!=null)
				{
					stack.add(current.right);
				}
				if(current.left==null && current.right==null)
				{
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static int findNumberOfFullNodes(BinaryTreeNode binaryTreeNode)
	{
		Stack<BinaryTreeNode>  stack = new Stack<>();
		stack.add(binaryTreeNode);
		int counter=0;
		while(!stack.isEmpty())
		{
			BinaryTreeNode current = stack.pop();
			if(current!=null)
			{
				if(current.left!=null)
				{
					stack.add(current.left);
				}
				if(current.right!=null)
				{
					stack.add(current.right);
				}
				if(current.left!=null && current.right!=null)
				{
					System.out.println(current.data);
					counter++;
				}
			}
		}
		return counter;
	}
	public static int findNumberOfhalfNodes(BinaryTreeNode binaryTreeNode)
	{
		Stack<BinaryTreeNode>  stack = new Stack<>();
		stack.add(binaryTreeNode);
		int counter=0;
		while(!stack.isEmpty())
		{
			BinaryTreeNode current = stack.pop();
			if(current!=null)
			{
				if(current.left!=null)
				{
					stack.add(current.left);
				}
				if(current.right!=null)
				{
					stack.add(current.right);
				}
				if(current.left==null && current.right!=null)
				{
					System.out.println(current.data);
					counter++;
				}
				if(current.left!=null && current.right==null)
				{
					System.out.println(current.data);
					counter++;
				}
			}
		}
		return counter;
	}
	public static boolean structurallyIdentical(BinaryTreeNode b1, BinaryTreeNode b2) {
	    if (b1 == null && b2 == null) {
	        return true;
	    }
	    
	    if (b1 != null && b2 != null) {
	        if (b1.data != b2.data) {
	            return false;
	        }
	        
	        boolean left = structurallyIdentical(b1.left, b2.left);
	        boolean right = structurallyIdentical(b1.right, b2.right);
	        
	        return left && right; // Use && (logical AND) here to ensure both subtrees are identical.
	    }
	    
	    return false; // One tree is null while the other is not, so they are not structurally identical.
	}
	public static int diameterOfTree(BinaryTreeNode root)
	{
		int left,right,diameter=0;
		if(root == null)
			return 0;
		left =  diameterOfTree(root.left);
		right =  diameterOfTree(root.right);
		if(left+right>  diameter)
			diameter = left+right;
		return 	Math.max(left, right)+1;
	}
	public static int width(BinaryTreeNode root)
	{
		int max =0;
		int height = Problem9.maxDepth(root);
		for(int k=0;k<=height;k++)
		{
			int tmp = width(root,k);
			max = Math.max(max, tmp);
		}
		return max;
	}
	public static int width(BinaryTreeNode root, int depth)
	{
		if(root==null)
			return 0;
		else {
			if(depth==0)
				return 1;
			else {
				return width(root.left, depth-1)+width(root.right,depth-1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		System.out.println(width(binaryTreeNode));
		
	}

}
