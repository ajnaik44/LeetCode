package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;

public class PathswithSum {
	static int countPathsWithSum(RandomNode.TreeNode root, int targetSum) {
	    return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	static int countPathsWithSum(RandomNode.TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
	    if (node == null) return 0; // Base case

	    /* Count paths with sum ending at the current node. */
	    runningSum += node.data;
	    int sum = runningSum - targetSum;
	    int totalPaths = pathCount.getOrDefault(sum, 0);

	    /* If runningSum equals targetSum, then one additional path starts at root.
	     * Add in this path.*/
	    if (runningSum == targetSum) {
	        totalPaths++;
	    }

	    /* Increment pathCount, recurse, then decrement pathCount. */
	    incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
	    totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
	    totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
	    incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount
	    System.out.println("Node "  + node.data + " "+   totalPaths +" "+ runningSum);
	    return totalPaths;
	}

	static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
	    int newCount = hashTable.getOrDefault(key, 0) + delta;
	    if (newCount == 0) { // Remove when zero to reduce space usage
	        hashTable.remove(key);
	    } else {
	        hashTable.put(key, newCount);
	    }
	}
	public static void main(String[] args) {
        // Create a sample binary search tree
        RandomNode.TreeNode root = new RandomNode.TreeNode(10);
        root.insertInOrder(5);
        root.insertInOrder(-3);
        root.insertInOrder(3);
        root.insertInOrder(2);
        root.insertInOrder(11);
        root.insertInOrder(3);
        root.insertInOrder(-2);
        root.insertInOrder(1);

        // Count paths with sum 8
        
        int targetSum = 8;
        int pathsCount = countPathsWithSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + pathsCount);
    }
	static void printTree(RandomNode.TreeNode node, int depth) {
        if (node == null) return;

        // Print the node's value with appropriate indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);

        // Recursively print the left and right subtrees
        printTree(node.left, depth + 1);
        printTree(node.right, depth + 1);
    }
}
