package com.crr.dsa.tree;

public class BinarySearchTreeNode {
	public int data;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	public BinarySearchTreeNode() {
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	public static BinarySearchTreeNode find(BinarySearchTreeNode root, int data) {
		if (root == null)
			return null;
		if (root.data == data)
			return root;
		if (data > root.data)
			return find(root.right, data);
		else
			return find(root.left, data);
	}

	public static BinarySearchTreeNode min(BinarySearchTreeNode root) {
		if (root == null)
			return null;
		if (root.left == null)
			return root;
		return min(root.left);

	}

	public static BinarySearchTreeNode max(BinarySearchTreeNode root) {
		if (root == null)
			return null;
		if (root.right == null)
			return root;
		return max(root.right);

	}

	public static BinarySearchTreeNode insert(BinarySearchTreeNode root, int data) {
	    if (root == null) {
	        return new BinarySearchTreeNode(data);
	    }

	    if (data < root.data) {
	        root.left = insert(root.left, data);
	    } else if (data > root.data) {
	        root.right = insert(root.right, data);
	    }

	    return root;
	}
	public static BinarySearchTreeNode delete(BinarySearchTreeNode root,int data)
	{
		BinarySearchTreeNode temp;
		if(root==null)
			return null ;
		else if(data<root.data)
		{
			root.left =  delete(root.left, data);
		}
		else if(data>root.data)
		{
			root.right = delete(root.right, data);
		}
		else {
			if(root.left!=null && root.right!=null)
			{
				temp = max(root.left);
				root.data =  temp.data;
				root.left =  delete(root.left, root.data);
			}else {
				temp =root;
				if(root.left==null)
					root= root.right;
				if(root.right==null)
					root =  root.left;
			}
		}
	return root;	
	}

	public static void main(String[] args) {
		// Create a sample binary search tree
		BinarySearchTreeNode root = new BinarySearchTreeNode(4);
		root.left = new BinarySearchTreeNode(2);
		root.right = new BinarySearchTreeNode(8);
		
		root.right.left = new BinarySearchTreeNode(5);
		root.right.right = new BinarySearchTreeNode(1);
		root.right.left.right = new BinarySearchTreeNode(7);
		root.right.left.right.left = new BinarySearchTreeNode(6);
		// Test the find method
		int targetValue = 19;
		BinarySearchTreeNode result = find(root, targetValue);

		if (result != null) {
			System.out.println("Found node with value " + targetValue);
		} else {
			System.out.println("Node with value " + targetValue + " not found");
		}
		System.out.println(min(root).data);
		System.out.println(max(root).data);
	//	insert(root, 6);
		delete(root, 8);
		System.out.println("");
	}

}
