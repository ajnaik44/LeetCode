package com.crr.dsa.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LongestZigZagPathinaBinaryTree {

	public int longestZigZag(TreeNode root) {
		int maxNodes = 0;
		if (root == null)
			return maxNodes;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();
			if (temp != null) {
				maxNodes = Math.max(maxNodes, longestZigZagHelper(temp));
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}

		}
		return maxNodes;
	}

	public int longestZigZagHelper(TreeNode current) {
		int max = 0;

		max = Math.max(max, longestTreeNodePath(current, true));
		max = Math.max(max, longestTreeNodePath(current, false));
		return max;

	}

	public int longestTreeNodePath(TreeNode current, boolean direction_right) {
		int counter = 0;
		TreeNode root = current;
		while (root != null) {
			if (root.right == null && direction_right)
				break;
			if (root.right != null && direction_right) {
				root = root.right;
				direction_right = false;
				counter++;

			}

			if (root.left != null && !direction_right) {
				root = root.left;
				direction_right = true;
				counter++;
			}
			if (root.left == null && !direction_right)
				break;
		}
		return counter;
	}

	int pathLength = 0;

	private void dfs(TreeNode node, boolean goLeft, int steps) {
		if (node == null) {
			return;
		}
		pathLength = Math.max(pathLength, steps);
		if (goLeft) {
			dfs(node.left, false, steps + 1);
			dfs(node.right, true, 1);
		} else {
			dfs(node.left, false, 1);
			dfs(node.right, true, steps + 1);
		}
	}

	public int longestZigZagOptimize(TreeNode root) {
		dfs(root, false, 0);
		dfs(root, true, 0);
		return pathLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] root1Array = { 1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1 };

		// TreeNode root1 = TreeNode.createNodeFromArray(root1Array, 0);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);

		root.left.right = new TreeNode(1);

		root.left.right.left = new TreeNode(1);

		root.left.right.left.right = new TreeNode(1);

		LongestZigZagPathinaBinaryTree binaryTree = new LongestZigZagPathinaBinaryTree();
		System.out.println(binaryTree.longestZigZagOptimize(root));

	}

}
