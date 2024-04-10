package com.crr.dsa.leetcode;

public class DeleteNodeinaBST {
	public TreeNode deleteNodebyAjay(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val == key) {
			if(root.left==null && root.right==null)
				root=null;
			if(root.right!=null)
			{
				TreeNode tmp1 = root.right;
				tmp1.left =  root.left;
				root = tmp1;
			}
			return root;
		}
		TreeNode tmp = null;
		if (root.val > root.val) {
			tmp = deleteNodebyAjay(root.right, key);
		} else {
			tmp = deleteNodebyAjay(root.left, key);
		}
		if (tmp != null &&  tmp.val==key) {
			if (root.left.val == tmp.val) {
				TreeNode tmp1 = root.left.right;
				if (tmp1 != null)
					tmp1.left = root.left != null ? root.left.left : null;
				root.left = tmp1;
			}
			if (root.right.val == tmp.val) {
				TreeNode tmp1 = root.right.right;
				if (tmp1 != null)
					tmp1.left = root.right.left;
				root.right = tmp1;

			}
			
		}
		return root;
	}
	
	// one step right and then always left
	public int successor(TreeNode root)
	{
		root =  root.right;
		while(root.left!=null)
			root =  root.left;
		return root.val;
	}
	
	// one step left and then always right
		public int predecessor(TreeNode root)
		{
			root =  root.left;
			while(root.right!=null)
				root =  root.right;
			return root.val;
		}
		
		public TreeNode deleteNode(TreeNode root, int key)
		{
			if(root==null)
				return root;
			if(key>root.val)
				root.right =  deleteNode(root.right, key);
			else if(key <  root.val)
				root.left =  deleteNode(root.left, key);
			else {
				if(root.left == null && root.right==null)
					root =null;
				
				else if(root.right!=null)
				{
					root.val =  successor(root);
					root.right =  deleteNode(root.right, root.val);
				}
				else if(root.left!=null)
				{
					root.val =  predecessor(root);
					root.left =  deleteNode(root.left, root.val);
				}
			}
			return root;
				
		}
		

	public static void main(String[] args) {
		Integer[] root1Array = {5,3,6,2,4,null,7 };

		TreeNode root1 = TreeNode.createTreeFromArray(root1Array);

		DeleteNodeinaBST SearchinaBinarySearchTree = new DeleteNodeinaBST();
		System.out.println(SearchinaBinarySearchTree.deleteNode(root1, 3));
	}
}
