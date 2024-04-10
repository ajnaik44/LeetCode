package com.crr.dsa.tree;

public class Problem38 {

	public static BinaryTreeNode buildTreeFromPreOrder(char[] A,int i)
	{
		if(A==null)
			return null;
		if(A.length==i)
			return null;
		BinaryTreeNode node = new BinaryTreeNode();
		node.data =  A[i];
		node.left = null;
		node.right = null;
		if(A[i]=='L')
			return node;
		i = i+1;
		node.left = buildTreeFromPreOrder(A, i);
		i=i+1;
		node.right =  buildTreeFromPreOrder(A, i);
		return node;
				
					
	}
	public static void main(String[] args) {
		char []A ={'I','L','I','L','L'};
		BinaryTreeNode  node =  buildTreeFromPreOrder(A, 0);
		new BinaryTreeNode().preOrder(node);
	}
}
