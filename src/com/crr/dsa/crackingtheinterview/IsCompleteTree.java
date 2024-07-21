package com.crr.dsa.crackingtheinterview;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
	public static void main(String[] args) {
		IsCompleteTree mainClass = new IsCompleteTree();

		// Example 1: Complete binary tree
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);

		System.out.println(mainClass.isCompleteTree(root1)); // should return true

		// Example 2: Incomplete binary tree
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.right.right = new TreeNode(6);

		System.out.println(mainClass.isCompleteTree(root2)); // should return false
	}

	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean nullNodeFound = false;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == null) {
				nullNodeFound = true;
			} else {
				if (nullNodeFound) {
					return false;
				}
				q.offer(node.left);
				q.offer(node.right);
			}
		}
		return true;
	}

}
