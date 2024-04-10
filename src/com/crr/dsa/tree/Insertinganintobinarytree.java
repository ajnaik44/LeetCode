package com.crr.dsa.tree;

import java.util.Stack;

public class Insertinganintobinarytree {
	public static void insert(BinaryTreeNode binaryTreeNode, int data) {
		if (binaryTreeNode == null)
			return;

		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.add(binaryTreeNode);
		while (!stack.isEmpty()) {
			BinaryTreeNode current = stack.pop();
			if (current.right != null) {
				stack.add(current.right);
			} else {
				BinaryTreeNode tmp = new BinaryTreeNode(data);
				current.right = tmp;
				break;
			}
			if (current.left != null) {
				stack.add(current.left);
			} else {
				BinaryTreeNode tmp = new BinaryTreeNode(data);
				current.left = tmp;
				break;
			}
		}
	}

	public static BinaryTreeNode insertRecusive(BinaryTreeNode binaryTreeNode, int data) {
		if (binaryTreeNode == null)
			return new BinaryTreeNode(data);

		if (data < binaryTreeNode.data) {
			binaryTreeNode.left = insertRecusive(binaryTreeNode.left, data);
		} else {
			binaryTreeNode.right = insertRecusive(binaryTreeNode.right, data);
		}
		return binaryTreeNode;

	}

	public static int size(BinaryTreeNode binaryTreeNode, int size) {

		if (binaryTreeNode != null) {
			size = size + 1;
			size = size(binaryTreeNode.left, size);
			size = size(binaryTreeNode.right, size);
		}
		return size;
	}
	public static int sizeAnotherway(BinaryTreeNode binaryTreeNode) {

	int leftcount =  binaryTreeNode.left==null?0:sizeAnotherway(binaryTreeNode.left);
	int rightcount =  binaryTreeNode.right==null?0:sizeAnotherway(binaryTreeNode.right);
	return leftcount+rightcount+1;
	}

	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);
		insertRecusive(binaryTreeNode, 8);
		//new BinaryTreeNode(1).InOrder(binaryTreeNode);
		System.out.println(sizeAnotherway(binaryTreeNode));
	}
}
