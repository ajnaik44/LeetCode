package com.crr.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem9 {
	public static void levelOrderRevers(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null)
			return;
		Stack<BinaryTreeNode> s = new Stack<>();
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(binaryTreeNode);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.right != null)
				q.offer(tmp.right);
			if (tmp.left != null)
				q.offer(tmp.left);

			s.push(tmp);
		}
		System.out.println("sss");
		while (!s.isEmpty()) {
			System.out.print(s.pop().data + " ");
		}

	}

	public static int maxDepth(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null)
			return 0;
		int left = maxDepth(binaryTreeNode.left);
		int right = maxDepth(binaryTreeNode.right);
		return (left > right) ? left + 1 : right + 1;
	}

	public static int minDepth(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null)
			return 0;
		int left = maxDepth(binaryTreeNode.left);
		int right = maxDepth(binaryTreeNode.right);
		return Math.min(left, right) + 1;
	}

	public static int maxDepthWithoutRecursion(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return 0;
		}

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(binaryTreeNode);
		int depth = 0;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

			depth++;
		}

		return depth;
	}

	public static BinaryTreeNode deepestnode(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null)
			return null;

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(binaryTreeNode);
		BinaryTreeNode tmp = null;
		while (!q.isEmpty()) {
			tmp = q.poll();

			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return tmp;

	}

	public static BinaryTreeNode deletedeepestnode(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null)
			return null;

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(binaryTreeNode);
		BinaryTreeNode tmp = null;
		while (!q.isEmpty()) {
			tmp = q.poll();

			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return tmp;

	}

	public static void deletingAnelement(BinaryTreeNode binaryTreeNode, int data) {
		BinaryTreeNode prev = binaryTreeNode;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.add(binaryTreeNode);
		BinaryTreeNode deepnode = null;
		while(!stack.isEmpty())
		{
			prev = stack.pop();
			if(prev.data==data)
			{
				deepnode = deepestnode(binaryTreeNode);
				prev.data = deepnode.data;	
			}else if(prev.left!=null)
			{
				stack.add(prev.left);
			}
			else if(prev.right!=null)
			{
				stack.add(prev.right);
			}
		}
		
		
		
			deleteDeepestNode(binaryTreeNode, deepnode);
			}
	public static void deleteDeepestNode(BinaryTreeNode root,BinaryTreeNode deepestNode)
	{
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		BinaryTreeNode temp=null;
		while(!queue.isEmpty())
		{
			temp =  queue.peek();
			queue.remove();
			if(temp==deepestNode)
			{
				temp=null;
				return;
			}
			if(temp.right!=null)
			{
				if(temp.right==deepestNode)
				{
					temp.right=null;
					return;
				}else {
					queue.add(temp.right);
				}
			}
			
			if(temp.left!=null)
			{
				if(temp.left==deepestNode)
				{
					temp.left=null;
					return;
				}else {
					queue.add(temp.left);
				}
			}
			
		}
	}
	public static BinaryTreeNode traverse(BinaryTreeNode root, int data) throws Exception {

		if (root != null) {

			traverse(root.left, data);
			if (root.left != null && root.left.data == data && root.left.left == null && root.left.right == null) {
				root.left = null;
				throw new Exception("");
			}

			traverse(root.right, data);
			if (root.left != null && root.right.data == data && root.right.left == null && root.right.right == null) {
				root.right = null;
				throw new Exception("");
			}

		}
		return root;
	}

	public static void deleteNode(BinaryTreeNode root, int dataToDelete) {
	    if (root == null) {
	        return;
	    }

	    // If the root node itself needs to be deleted
	    if (root.data == dataToDelete) {
	        if (root.left == null && root.right == null) {
	            root = null;
	            return;
	        }
	    }

	    deleteNodeHelper(root, dataToDelete);
	}

	private static BinaryTreeNode deleteNodeHelper(BinaryTreeNode node, int dataToDelete) {
	    if (node == null) {
	        return null;
	    }

	    if (dataToDelete < node.data) {
	        node.left = deleteNodeHelper(node.left, dataToDelete);
	    } else if (dataToDelete > node.data) {
	        node.right = deleteNodeHelper(node.right, dataToDelete);
	    } else {
	        // Node with the dataToDelete value found
	        if (node.left == null) {
	            return node.right; // Node with one child or no child
	        } else if (node.right == null) {
	            return node.left; // Node with one child or no child
	        }

	        // Node with two children, get the inorder successor (smallest in the right subtree)
	        node.data = minValue(node.right);

	        // Delete the inorder successor
	        node.right = deleteNodeHelper(node.right, node.data);
	    }

	    return node;
	}

	private static int minValue(BinaryTreeNode node) {
	    int minValue = node.data;
	    while (node.left != null) {
	        minValue = node.left.data;
	        node = node.left;
	    }
	    return minValue;
	}

	
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);

		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.left.left.left = new BinaryTreeNode(7);
		// levelOrderRevers(binaryTreeNode);
		deletingAnelement(binaryTreeNode, 1);
		new BinaryTreeNode(1).InOrder(binaryTreeNode);
		System.out.println();
	}
}
