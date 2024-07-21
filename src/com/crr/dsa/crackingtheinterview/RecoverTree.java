package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class RecoverTree {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */

	public void swap(TreeNode a, TreeNode b) {
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}
private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    private int totalWays(int i, int k) {
        if (i == 1) return k;
        if (i == 2) return k * k;
        
        // Check if we have already calculated totalWays(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        // Use the recurrence relation to calculate totalWays(i)
        int i1 = totalWays(i - 1, k);
        int i2 = totalWays(i - 2, k) ;
        memo.put(i, (k - 1) * (  i1+ i2) );
        return memo.get(i);
    }
    
    public int numWays(int n, int k) {
        return totalWays(n, k);
    }
	public void recoverTreeApproach1(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque();
		TreeNode x = null, y = null, pred = null;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.removeLast();
			if (pred != null && root.val < pred.val) {
				y = root;
				if (x == null)
					x = pred;
				else
					break;
			}
			pred = root;
			root = root.right;
		}

		swap(x, y);
	}

	public static void main(String[] args) {
		RecoverTree recoverTree = new RecoverTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		//recoverTree.recoverTreeApproach1(root);
	System.out.println(	recoverTree.numWays(7, 2));
	}

	public void recoverTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		Integer x = null, y = null;
		boolean swapped_first_occurrence = false;

		for (int i = 0; i < list.size() - 1; ++i) {
			if (list.get(i) > list.get(i + 1)) {
				y = list.get(i + 1);
				if (!swapped_first_occurrence) {
					// The first swap occurrence
					x = list.get(i);
					swapped_first_occurrence = true;
				} else {
					// The second swap occurrence
					break;
				}
			}
		}

		recover(root, 2, x, y);
	}

	public void recover(TreeNode r, int count, int x, int y) {
		if (r != null) {
			if (r.val == x || r.val == y) {
				r.val = (r.val == x) ? y : x;
				if (--count == 0)
					return;
			}
			recover(r.left, count, x, y);
			recover(r.right, count, x, y);
		}
	}

	public void inOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
