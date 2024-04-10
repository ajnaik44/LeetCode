package com.crr.dsa.crackingtheinterview;

public class TreeNode {

	public int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public static void inlineTraversal(TreeNode node)
	{
		if(node!=null) {
		inlineTraversal(node.left);
		System.out.print(node.data + "  ");
		inlineTraversal(node.right);
		}
	}
	static void  preOrderTraversal(TreeNode node) {
		if(node!=null)
		{
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	static void  postOrderTraversal(TreeNode node) {
		if(node!=null)
		{
			
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data);
		}
	}
	 public static void main(String[] args) {
	        // Example tree creation
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(3);
	        root.right = new TreeNode(7);
	        root.left.left = new TreeNode(2);
	        root.left.right = new TreeNode(4);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(8);

	        // Call to inlineTraversal method
	        postOrderTraversal(root);
	    }

}
