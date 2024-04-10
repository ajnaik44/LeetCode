package com.crr.dsa.tree;

import java.util.Stack;

public class findingmaximumelementinbinarytree {
	
	public  static int  findMax(BinaryTreeNode binaryTreeNode,int max)
	{
		if(binaryTreeNode!=null)
		{
			max = findMax(binaryTreeNode.left, max);
			max = findMax(binaryTreeNode.right, max);
			max = Math.max(max,binaryTreeNode.data);
			
			
		}
		return max;
	}
	public  static int  findMaxWithoutRecursion(BinaryTreeNode binaryTreeNode)
	{
		if(binaryTreeNode==null)
			return 0;
		int max = 0;
		
		Stack<BinaryTreeNode>  stack = new Stack<>();
		stack.add(binaryTreeNode);
		while(!stack.isEmpty())
		{
			BinaryTreeNode current = stack.pop();
			if(current!=null) {
				max =  Math.max(current.data, max);
			}
			if(current.left!=null)
			{
				stack.add(current.left);
			}
			if(current.right!=null)
			{
				stack.add(current.right);
			}
			
		}
		return max;
	}

	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		
	System.out.println(findMaxWithoutRecursion(binaryTreeNode));

	}
}
