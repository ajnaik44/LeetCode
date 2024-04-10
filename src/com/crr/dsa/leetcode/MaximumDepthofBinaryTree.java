package com.crr.dsa.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static int maxDepthOptimize(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }

	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    int depth = 0;

	    while (!queue.isEmpty()) {
	        int levelSize = queue.size();

	        for (int i = 0; i < levelSize; i++) {
	            TreeNode node = queue.poll();

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


	public static  int maxDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<MaximumDepthofBinaryTree.TreeNode>();
		int counter = 0;
		if (root != null) {

			queue.add(root);
			queue.add(null);
		}
		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();

			if (temp != null) {
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			} else {
				counter++;
				if(!queue.isEmpty())
					queue.add(null);
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		System.out.println(maxDepthOptimize(head));
	}
}
