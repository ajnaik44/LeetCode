package com.crr.dsa.tree;

public class Problem41 {

	public static void main(String[] args) {
		TreeNode  node = new TreeNode(1);
		node.firstChild =  new TreeNode(2);
		node.firstChild.nextSibling =  new TreeNode(3);
		node.firstChild.nextSibling.nextSibling= new  TreeNode(4);
		node.firstChild.nextSibling.nextSibling.nextSibling = new TreeNode(5);
		node.firstChild.nextSibling.nextSibling.nextSibling.firstChild = new TreeNode(6);
		System.out.println(findSum(node));
	}
	public static int findSum(TreeNode node)
	{
		if(node==null)
			return 0;
		return node.data+ findSum(node.firstChild) + findSum(node.nextSibling);
	}
}
