package com.crr.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem22 {
	public static int maxSumofLevel(BinaryTreeNode root) {
	
		if(root==null)
			return 0;
		Queue<BinaryTreeNode> stack =  new LinkedList();
		stack.add(root);
		stack.add(null);
		int sum=0,max=0;
		while(!stack.isEmpty())
		{
			BinaryTreeNode current = stack.poll();
			if(current!=null)
			{
				sum+=current.data;
				if(current.left!=null)
				{
					stack.add(current.left);
				}
				if(current.right!=null)
				{
					stack.add(current.right);
				}
			}else {
				max=  Math.max(sum, max);
				sum=0;
				if(stack.peek()!=null)
					stack.add(null);
			}
		}
		return max;
	}
	 public static void printRootToLeafPaths(BinaryTreeNode root) {
	        List<Integer> path = new ArrayList<>();
	        printRootToLeafPaths(root, path);
	    }

	    private static void printRootToLeafPaths(BinaryTreeNode node, List<Integer> path) {
	        if (node == null) {
	            return;
	        }

	        // Add the current node's data to the path
	        path.add(node.data);

	        // If it's a leaf node, print the path
	        if (node.left == null && node.right == null) {
	            printPath(path);
	        } else {
	            // Otherwise, continue traversing the left and right subtrees
	            printRootToLeafPaths(node.left, path);
	            printRootToLeafPaths(node.right, path);
	        }

	        // Remove the current node's data from the path to backtrack
	        path.remove(path.size() - 1);
	    }

	    private static void printPath(List<Integer> path) {
	        for (int i = 0; i < path.size(); i++) {
	            System.out.print(path.get(i));
	            if (i < path.size() - 1) {
	                System.out.print(" -> ");
	            }
	        }
	        System.out.println();
	    }
	

	   public static boolean hasPathum(BinaryTreeNode root,int sum)
	   {
		   if(root==null)
			   return false;
		   if(root.left==null && root.right==null && root.data==sum)
			   return true;
		   else
			   return hasPathum(root.left, sum-root.data) || hasPathum(root.right, sum - root.data);
	   }

	   public static int addBT(BinaryTreeNode root)
	   {
		   if(root==null)
			   return 0;
		   else 
			   return (root.data+ addBT(root.left) +  addBT(root.right));
	   }
	   
	   
	   public static BinaryTreeNode mirror(BinaryTreeNode root)
	   {
		   Queue<BinaryTreeNode> queue=  new LinkedList<>();
		   queue.add(root);
		   while(!queue.isEmpty())
		   {
			BinaryTreeNode current =  queue.poll();
				if(current!=null)
				{
					if(current.left!=null ||  current.right!=null)
					{
						BinaryTreeNode temp =  current.right;
						current.right= current.left;
						current.left = temp;
					}
					if(current.left!=null)
					{
						queue.add(current.left);
					}
					if(current.right!=null)
					{
						queue.add(current.right);
					}
				}
			   
		   }
		   
		   return root;
	   }
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		
		//System.out.println(hasPathum(binaryTreeNode,8));
		//System.out.println(addBT(binaryTreeNode));
		new BinaryTreeNode(1).InOrder(binaryTreeNode);
		mirror(binaryTreeNode);
		System.out.println();
		new BinaryTreeNode(1).InOrder(binaryTreeNode);
	}

}
