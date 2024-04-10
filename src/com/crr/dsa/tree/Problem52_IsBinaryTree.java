package com.crr.dsa.tree;

public class Problem52_IsBinaryTree {

	public static BinarySearchTreeNode findLowestCommonAncestor(BinarySearchTreeNode root, int n1, int n2) {
		if (root == null)
			return null;

		if (n1 < root.data && n2 < root.data) {
			return findLowestCommonAncestor(root.left, n1, n2);
		} else if (n1 > root.data && n2 > root.data) {
			return findLowestCommonAncestor(root.right, n1, n2);
		} else {
			// The current node is the lowest common ancestor
			return root;
		}
	}

	public static int findShortestPath(BinarySearchTreeNode root, int n1, int n2) {
		if (root == null)
			return -1;

		// Find the lowest common ancestor of n1 and n2
		BinarySearchTreeNode lca = findLowestCommonAncestor(root, n1, n2);

		if (lca == null)
			return -1;

		// Calculate the distance from lca to n1 and n2
		int distance1 = findDistanceFromNode(lca, n1);
		int distance2 = findDistanceFromNode(lca, n2);

		// The shortest path between n1 and n2 is the sum of the distances to the lowest
		// common ancestor
		return distance1 + distance2;
	}

	public static int findDistanceFromNode(BinarySearchTreeNode node, int target) {
		if (node == null)
			return -1;

		if (node.data == target)
			return 0;

		if (target < node.data) {
			return 1 + findDistanceFromNode(node.left, target);
		} else {
			return 1 + findDistanceFromNode(node.right, target);
		}
	}

	public static BinarySearchTreeNode lca(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b) {
		if (root == null)
			return root;
		if (root == a || root == b)
			return root;
		if (Math.max(a.data, b.data) < root.data)
			return lca(root.left, a, b);
		if (Math.min(a.data, b.data) > root.data)
			return lca(root.right, a, b);
		else
			return root;
	}

	public static boolean isBinary(BinarySearchTreeNode root) {
		return isBinaryUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinaryUtil(BinarySearchTreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data <= min || node.data >= max) {
			return false;
		}

		return isBinaryUtil(node.left, min, node.data) && isBinaryUtil(node.right, node.data, max);
	}

	public static boolean isBinaryCheck(BinarySearchTreeNode root) {
		return isBinary(root);
	}

	static int min = Integer.MIN_VALUE;

	public static boolean isBST(BinarySearchTreeNode root) {
		if (root == null)
			return true;
		if (!isBST(root.left))
			return false;
		if (root.data < min)
			return false;
		min = root.data;
		return isBST(root.right);
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(20);
		root.left = new BinarySearchTreeNode(10);
		root.right = new BinarySearchTreeNode(30);
		root.left.left = new BinarySearchTreeNode(5);
		root.left.right = new BinarySearchTreeNode(15);
		root.right.left = new BinarySearchTreeNode(25);
		root.right.right = new BinarySearchTreeNode(35);

		int n1 = 25;
		int n2 = 35;
		System.out.println(isBinary(root));
		int shortestPath = findShortestPath(root, n1, n2);

		if (shortestPath != -1) {
			System.out.println("Shortest path between " + n1 + " and " + n2 + " is " + shortestPath);
		} else {
			System.out.println("Nodes " + n1 + " and " + n2 + " not found in the BST.");
		}
		BinarySearchTreeNode ans = lca(root, root.right.left, root.right.right);
		System.out.println(isBST(root));
	}
}
