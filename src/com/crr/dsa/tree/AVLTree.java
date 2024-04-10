package com.crr.dsa.tree;

class AVLTreeNode {
	int data;
	int height;
	AVLTreeNode left, right;

	public AVLTreeNode(int data) {
		this.data = data;
		this.height = 1; // Initialize height to 1 for a new node
		this.left = this.right = null;
	}
}

public class AVLTree {
	private AVLTreeNode root;

	public AVLTree() {
		root = null;
	}

	private int height(AVLTreeNode node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int getBalance(AVLTreeNode node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	private void updateHeight(AVLTreeNode node) {
		node.height = 1 + Math.max(height(node.left), height(node.right));
	}

	private AVLTreeNode singleRotateLeft(AVLTreeNode x) {
		AVLTreeNode w = x.right;
		x.right = w.left;
		w.left = x;
		updateHeight(x);
		updateHeight(w);
		return w;
	}

	private AVLTreeNode singleRotateRight(AVLTreeNode y) {
		AVLTreeNode x = y.left;
		y.left = x.right;
		x.right = y;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private AVLTreeNode doubleRotateLeftRight(AVLTreeNode z) {
		z.left = singleRotateLeft(z.left);
		return singleRotateRight(z);
	}

	private AVLTreeNode doubleRotateRightLeft(AVLTreeNode z) {
		z.right = singleRotateRight(z.right);
		return singleRotateLeft(z);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private AVLTreeNode insert(AVLTreeNode node, int data) {
		if (node == null)
			return new AVLTreeNode(data);

		if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		else
			return node; // Duplicate data not allowed

		updateHeight(node);

		int balance = getBalance(node);

		// Perform necessary rotations
		if (balance > 1) {
			if (data < node.left.data)
				return singleRotateRight(node);
			else
				return doubleRotateLeftRight(node);
		}
		if (balance < -1) {
			if (data > node.right.data)
				return singleRotateLeft(node);
			else
				return doubleRotateRightLeft(node);
		}

		return node;
	}

	public void printInOrder() {
		inOrder(root);
	}

	private void inOrder(AVLTreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();

		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.insert(40);
		avlTree.insert(50);
		avlTree.insert(25);

		System.out.println("In-order Traversal of AVL Tree:");
		avlTree.printInOrder();
	}
}
