package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrder {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(new VerticalOrder().verticalOrder(root));
	}
	  @SuppressWarnings("unchecked")
	public List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> output = new ArrayList();
	    if (root == null) {
	      return output;
	    }

	    Map<Integer, ArrayList> columnTable = new HashMap();
	    
	    Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
	    
	    int column = 0;
	    
	    queue.offer(new Pair(root, column));

	    while (!queue.isEmpty()) {
	      Pair<TreeNode, Integer> p = queue.poll();
	      root = p.first;
	      column = p.second;

	      if (root != null) {
	        if (!columnTable.containsKey(column)) {
	          columnTable.put(column, new ArrayList<Integer>());
	        }
	        columnTable.get(column).add(root.data);

	        queue.offer(new Pair(root.left, column - 1));
	        queue.offer(new Pair(root.right, column + 1));
	      }
	    }

	    List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
	    Collections.sort(sortedKeys);
	    for(int k : sortedKeys) {
	      output.add(columnTable.get(k));
	    }

	    return output;
	  }
	
}
