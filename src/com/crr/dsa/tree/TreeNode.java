package com.crr.dsa.tree;

public class TreeNode {

	public int data;
	public TreeNode firstChild;
	public TreeNode nextSibling;
	public int getData() {
		return data;
	}
	public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getFirstChild() {
		return firstChild;
	}
	public void setFirstChild(TreeNode firstChild) {
		this.firstChild = firstChild;
	}
	public TreeNode getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(TreeNode nextSibling) {
		this.nextSibling = nextSibling;
	}
	
	
}
