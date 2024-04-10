package com.crr.dsa.tree;

public class Problem59 {
	public static BinarySearchTreeNode bst2DLL(BinarySearchTreeNode root) {
	    return bstToDLLHelper(root, null);
	}

	private static BinarySearchTreeNode bstToDLLHelper(BinarySearchTreeNode root, BinarySearchTreeNode prev) {
	    if (root == null) {
	        return prev;
	    }

	    // Convert left subtree
	    prev = bstToDLLHelper(root.left, prev);

	    // Process the current node
	    root.left = prev;
	    if (prev != null) {
	        prev.right = root;
	    }
	    prev = root;

	    // Convert right subtree
	    return bstToDLLHelper(root.right, prev);
	}
	private static BinarySearchTreeNode arrayToBST(int a [],int left,int right) {
		if(left>right)
			return null;
		int mid =  (left+right)/2;
		BinarySearchTreeNode root =  new BinarySearchTreeNode(a[mid]);
		root.left=arrayToBST(a, left, mid-1);
		root.right =  arrayToBST(a, mid+1, right);
		return root;
		
	}
	public static  void inOrderTraversal(BinarySearchTreeNode root) {
	    if (root == null) {
	        return;
	    }

	    inOrderTraversal(root.left);  // Visit the left subtree
	    System.out.print(root.data + " "); // Visit the current node
	    inOrderTraversal(root.right); // Visit the right subtree
	}

	public static void main(String[] args) {
	    // Create a sample Binary Search Tree
	    BinarySearchTreeNode root = new BinarySearchTreeNode(4);
	    root.left = new BinarySearchTreeNode(2);
	    root.right = new BinarySearchTreeNode(6);
	    root.left.left = new BinarySearchTreeNode(1);
	    root.left.right = new BinarySearchTreeNode(3);
	    root.right.left = new BinarySearchTreeNode(5);
	    root.right.right = new BinarySearchTreeNode(7);
	    int a[] = {1,2,3,4,5,6,7};
	    root =  arrayToBST(a, 0, a.length-1);
	    inOrderTraversal(root);
	}
	   

}
