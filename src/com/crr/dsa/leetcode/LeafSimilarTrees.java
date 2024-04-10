package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilarTrees {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 public static  boolean leafSimilar(TreeNode root1, TreeNode root2) {
	    List<Integer> node1 = new ArrayList<>();
	    List<Integer> node2 = new ArrayList<>();
	    populateLeafNode(root1, node1);
	    populateLeafNode(root2, node2);
	    System.out.println(node1);
	    System.out.println(node2);
	  return  node1.equals(node2);
		 
	    }
	public static void populateLeafNode(TreeNode root,List<Integer> queue)
	{
		if(root!=null)
		{
			if(root.left==null &&  root.right==null)
				queue.add(root.val);
			populateLeafNode(root.left, queue);
			populateLeafNode(root.right, queue);
				
		}
		
	}
	private static TreeNode createNodeFromArray(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = createNodeFromArray(array, 2 * index + 1);
        node.right = createNodeFromArray(array, 2 * index + 2);

        return node;
    }
	 public static  boolean leafSimilarUsingList(TreeNode root1, TreeNode root2) {
	        List<Integer> leaves1 = new ArrayList();
	        List<Integer> leaves2 = new ArrayList();
	       
	        dfs(root1, leaves1);
	        dfs(root2, leaves2);
	        System.out.println(leaves1);
	        System.out.println(leaves2);
	        return leaves1.equals(leaves2);
	    }

	    public static void dfs(TreeNode node, List<Integer> leafValues) {
	        if (node != null) {
	            if (node.left == null && node.right == null)
	                leafValues.add(node.val);
	            dfs(node.left, leafValues);
	            dfs(node.right, leafValues);
	        }
	    }
	public static void main(String[] args) {
		 Integer[] root1Array = {3,5,1,6,2,9,8,null,null,7,4};
	        Integer[] root2Array = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};

	        // Creating TreeNode instances for testing
	        TreeNode root1 = createNodeFromArray(root1Array, 0);
	        TreeNode root2 = createNodeFromArray(root2Array, 0);
	        System.out.println(leafSimilar(root1, root2));
	}

}
