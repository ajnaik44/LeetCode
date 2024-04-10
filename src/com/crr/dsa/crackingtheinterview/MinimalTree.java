package com.crr.dsa.crackingtheinterview;

public class MinimalTree {
	public static TreeNode buildMinimalTree(int[] sortedArray) {
        return buildMinimalTreeHelper(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode buildMinimalTreeHelper(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedArray[mid]);

        root.left = buildMinimalTreeHelper(sortedArray, start, mid - 1);
        root.right = buildMinimalTreeHelper(sortedArray, mid + 1, end);

        return root;
    }
	public static void main(String[] args) {
		int[] sortedArray=new int[] {1,2,3,4,5,6,7};
		TreeNode node  = buildMinimalTree(sortedArray);
		TreeNode.inlineTraversal(node);
	}
}
