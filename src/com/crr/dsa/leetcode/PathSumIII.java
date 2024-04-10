package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathSumIII {

	public int pathSum(TreeNode root, int targetSum) {
		int numOfPaths = 0;
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			list.add(root.val);
			numOfPaths += (root.val == targetSum) ? 1 : 0;
			numOfPaths += pathSumHelper(root.left, list, targetSum);
			list.clear();
			list.add(root.val);
			numOfPaths += pathSumHelper(root.right, list, targetSum);
		}
		return numOfPaths;
	}

	public int pathSumHelper(TreeNode root, List<Integer> list, int targetSum) {
		int count = 0;
		int sum = 0;
		if (root != null) {
			int size = list.size();
			sum += root.val;
			if (sum == targetSum)
				count++;
			for (int i = size - 1; i >= 0; i--) {
				sum += list.get(i);
				if (sum == targetSum)
					count++;

			}

			list.add(root.val);
			count += pathSumHelper(root.left, list, targetSum);
			if (root.left != null)
				list.remove(list.size() - 1);
			count += pathSumHelper(root.right, list, targetSum);
			if (root.right != null)
				list.remove(list.size() - 1);

		}
		return count;
	}

	public static void main(String[] args) {
		PathSumIII pathSumIII = new PathSumIII();
		Integer[] root1Array = { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 };

		TreeNode root1 = TreeNode.createTreeFromArray(root1Array);
		System.out.println(pathSumIII.pathSumSolution(root1, 8));
	}

	int count = 0;
	int k;
	HashMap<Long, Integer> h = new HashMap();

	public void preorder(TreeNode node, long currSum) {
		if (node == null)
			return;

		// The current prefix sum
		currSum += node.val;

		// Here is the sum we're looking for
		if (currSum == k)
			count++;

		// The number of times the curr_sum − k has occurred already,
		// determines the number of times a path with sum k
		// has occurred up to the current node
		count += h.getOrDefault(currSum - k, 0);

		// Add the current sum into the hashmap
		// to use it during the child node's processing
		h.put(currSum, h.getOrDefault(currSum, 0) + 1);

		// Process the left subtree
		preorder(node.left, currSum);

		// Process the right subtree
		preorder(node.right, currSum);

		// Remove the current sum from the hashmap
		// in order not to use it during
		// the parallel subtree processing
		h.put(currSum, h.get(currSum) - 1);
	}

	public int pathSumSolution(TreeNode root, int sum) {
		k = sum;
		preorder(root, 0L);
		return count;
	}
}
