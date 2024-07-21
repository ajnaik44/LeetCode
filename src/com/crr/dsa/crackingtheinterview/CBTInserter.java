package com.crr.dsa.crackingtheinterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {

	public static void main(String[] args) {
		// Create an initial binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		

		// Initialize CBTInserter with the root of the binary tree
		CBTInserter cbtInserter = new CBTInserter(root);

		// Insert new nodes and print the parent node's value
		System.out.println(cbtInserter.insert(3)); // Should print 3
		System.out.println(cbtInserter.insert(4)); // Should print 4

		// Get the root of the tree and print its structure
		TreeNode updatedRoot = cbtInserter.get_root();
		printTree(updatedRoot);
	}

	// Helper method to print the tree in level order
	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		System.out.println();
	}

// Definition for a binary tree node
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// CBTInserter class definition

	TreeNode root;
	Deque<TreeNode> deque;

	public CBTInserter(TreeNode root) {
		this.root = root;
		deque = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// BFS to populate deque
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left == null || node.right == null)
				deque.offerLast(node);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	public int insert(int v) {
		TreeNode node = deque.peekFirst();
		deque.offerLast(new TreeNode(v));
		if (node.left == null)
			node.left = deque.peekLast();
		else {
			node.right = deque.peekLast();
			deque.pollFirst();
		}

		return node.val;
	}

	public TreeNode get_root() {
		return root;
	}

}
