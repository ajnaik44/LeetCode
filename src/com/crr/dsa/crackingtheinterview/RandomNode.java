package com.crr.dsa.crackingtheinterview;

import java.util.Random;

public class RandomNode {
	static class TreeNode {
	    public int data;
	    public TreeNode left;
	    public TreeNode right;
	    private int size = 0;

	    public TreeNode(int d) {
	        data = d;
	        size = 1;
	    }

	    public TreeNode getRandomNode() {
	        int leftSize = left == null ? 0 : left.size();
	        Random random = new Random();
	        int index = random.nextInt(size);
	        if (index < leftSize) {
	            return left.getRandomNode();
	        } else if (index == leftSize) {
	            return this;
	        } else {
	            return right.getRandomNode();
	        }
	    }

	    public void insertInOrder(int d) {
	        if (d <= data) {
	            if (left == null) {
	                left = new TreeNode(d);
	            } else {
	                left.insertInOrder(d);
	            }
	        } else {
	            if (right == null) {
	                right = new TreeNode(d);
	            } else {
	                right.insertInOrder(d);
	            }
	        }
	        size++;
	    }

	    public int size() {
	        return size;
	    }

	    public int data() {
	        return data;
	    }

	    public TreeNode find(int d) {
	        if (d == data) {
	            return this;
	        } else if (d <= data) {
	            return left != null ? left.find(d) : null;
	        } else if (d > data) {
	            return right != null ? right.find(d) : null;
	        }
	        return null;
	    }
	}
	 public static void main(String[] args) {
	        // Create a sample binary search tree
	        TreeNode root = new TreeNode(5);
	        root.insertInOrder(3);
	        root.insertInOrder(7);
	        root.insertInOrder(2);
	        root.insertInOrder(4);
	        root.insertInOrder(6);
	        root.insertInOrder(8);

	        // Print the size of the tree
	        System.out.println("Size of the tree: " + root.size());

	        // Find a node with data 4
	        TreeNode node = root.find(4);
	        if (node != null) {
	            System.out.println("Node found: " + node.data());
	        } else {
	            System.out.println("Node not found");
	        }

	        // Get a random node from the tree
	        TreeNode randomNode = root.getRandomNode();
	        System.out.println("Random node data: " + randomNode.data());
	    }
}
