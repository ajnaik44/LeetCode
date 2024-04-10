package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLeavesofBinaryTree {
	static class Pair<K, V> {
	    private final K key;
	    private final V value;

	    public Pair(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public K getKey() {
	        return key;
	    }

	    public V getValue() {
	        return value;
	    }
	}

	
	    private static List<Pair<Integer, Integer>> pairs;
	    
	    private static int getHeight(TreeNode root) {
	        
	        // return -1 for null nodes
	        if (root == null) return -1;
	        
	        // first calculate the height of the left and right children
	        int leftHeight = getHeight(root.left);
	        int rightHeight = getHeight(root.right);
	        
	        // based on the height of the left and right children, obtain the height of the current (parent) node
	        int currHeight = Math.max(leftHeight, rightHeight) + 1;

	        // collect the pair -> (height, val)
	        pairs.add(new Pair<Integer, Integer>(currHeight, root.data));

	        // return the height of the current node
	        return currHeight;
	    }
	    
	    public static List<List<Integer>> findLeaves(TreeNode root) {
	        pairs = new ArrayList<>();
	        
	        getHeight(root);
	        
	        // sort all the (height, val) pairs
	        Collections.sort(pairs, Comparator.comparing(p -> p.getKey()));
	        
	        int n = pairs.size(), height = 0, i = 0;

	        List<List<Integer>> solution = new ArrayList<>();
	        
	        while (i < n) {
	            List<Integer> nums = new ArrayList<>();
	            while (i < n &&pairs.get(i).getKey() == height) {
	                nums.add(pairs.get(i).getValue());
	                i++;
	            }
	            solution.add(nums);
	            height++;
	        }
	        return solution;
	    }
	    public static void main(String[] args) {
	        // Example usage
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        List<List<Integer>> solution = new ArrayList<>();
	      
	         findLeaves(root,solution,0);

	        for (List<Integer> list : solution) {
	            System.out.println(list);
	        }
	    }
	    
	    public static void  findLeaves(TreeNode root,List<List<Integer>> result ,int index  )
	    {
	    	if(root!=null) {
		    	if(index == result.size() ) {
		    		List<Integer> list = new ArrayList<Integer>(); 
		    		list.add(root.data);
		    		result.add(list);
		    	}
		    	else {
		    		result.get(index).add(root.data);
		    	}
		    	findLeaves(root.left,result,index+1);
		    	findLeaves(root.right,result, index+1);
	    	}
	    }
		
}
