package com.crr.dsa.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {

	public int data;
	public BinaryTreeNode left, right;
	public BinaryTreeNode() {
	}

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void preOrder(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode != null) {
			System.out.print(binaryTreeNode.data + "   ");
			preOrder(binaryTreeNode.left);
			preOrder(binaryTreeNode.right);
		}
	}

	public void InOrder(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode != null) {

			InOrder(binaryTreeNode.left);
			System.out.print(binaryTreeNode.data + "   ");
			InOrder(binaryTreeNode.right);
		}
	}

	public void postOrder(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode != null) {

			postOrder(binaryTreeNode.left);

			postOrder(binaryTreeNode.right);
			System.out.print(binaryTreeNode.data + "   ");
		}
	}

	public void preOrderIterative(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode current = stack.pop();
			System.out.print(current.data + " ");

			// Push the right child first so that it's processed after the left child.
			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

	public void inOrderIterative(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			// Traverse left subtree and push nodes onto the stack.
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			// Pop a node from the stack, print its data, and move to the right subtree.
			current = stack.pop();
			System.out.print(current.data + " ");

			// Move to the right subtree.
			current = current.right;
		}
	}

	public void postOrderIterative(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryTreeNode> stack1 = new Stack<>();
		Stack<BinaryTreeNode> stack2 = new Stack<>();

		stack1.push(root);

		while (!stack1.isEmpty()) {
			BinaryTreeNode current = stack1.pop();
			stack2.push(current);

			if (current.left != null) {
				stack1.push(current.left);
			}

			if (current.right != null) {
				stack1.push(current.right);
			}
		}

		while (!stack2.isEmpty()) {
			BinaryTreeNode current = stack2.pop();
			System.out.print(current.data + " ");
		}
	}

	public void levelOrder(BinaryTreeNode binaryTreeNode) {
	    if (binaryTreeNode == null) {
	        return;
	    }

	    Queue<BinaryTreeNode> queue = new LinkedList<>();
	    queue.add(binaryTreeNode);

	    while (!queue.isEmpty()) {
	        BinaryTreeNode current = queue.poll();
	        System.out.print(current.data + " ");

	        if (current.left != null) {
	            queue.add(current.left);
	        }

	        if (current.right != null) {
	            queue.add(current.right);
	        }
	    }
	
		
		
	}
	static BinaryTreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		BinaryTreeNode root = new BinaryTreeNode(preorder[preStart]);
		int inRoot = inMap.get(root.data);
		int numsLeft = inRoot - inStart;

		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

		return root;
	}
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(5);
		binaryTreeNode.left.left = new BinaryTreeNode(3);
		binaryTreeNode.left.right = new BinaryTreeNode(4);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		binaryTreeNode.preOrder(binaryTreeNode);
	

	}
}
