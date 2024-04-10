package com.crr.dsa.crackingtheinterview;
import java.util.*;
public class ZigZagLevel {
	
	

	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    
	    TreeNode(int x) {
	        val = x;
	    }
	}
	 public static int minDepth(TreeNode root) {
	        if(root == null)
	            return 0;
	        if(root.left == null)
	            return 1 + minDepth(root.right);
	        if(root.right == null)
	            return 1 + minDepth(root.left);
	        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	    }
	    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(root == null)
	            return result;
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        boolean isLevelOdd = false;
	        while(!q.isEmpty()) {
	            int size = q.size();
	            List<Integer> level = new ArrayList<>();
	            while(size-- > 0) {
	                root = q.poll();
	                level.add(root.val);
	                if(root.left != null)
	                    q.add(root.left);
	                if(root.right != null)
	                    q.add(root.right);
	            }
	            if(isLevelOdd) 
	                Collections.reverse(level);
	            result.add(level);
	            isLevelOdd = !isLevelOdd;
	        }
	        
	        return result;
	    }

	
	    public static void main(String[] args) {
	        // Creating a sample binary tree
	        TreeNode root = new TreeNode(3);
	        root.left = new TreeNode(9);
	        root.right = new TreeNode(20);
	        root.right.left = new TreeNode(15);
	        root.right.right = new TreeNode(7);

	        // Creating an instance of the Solution class
	        

	        // Calling the zigzagLevelOrder method and printing the result
	        List<List<Integer>> result = zigzagLevelOrder(root);
	        System.out.println("Zigzag level order traversal:");
	        for (List<Integer> level : result) {
	            System.out.println(level);
	        }
	        System.out.println(minDepth(root));
	        System.out.println(rightSideViewOptimie(root));
	    }
	    public static List<Integer> leftSideView(TreeNode root) {
	        List<Integer> result = new ArrayList();
	        if(root == null)
	            return result;
	        
	        Queue<TreeNode> q = new LinkedList();
	        q.add(root);
	        while(q.size() > 0) {
	            int size = q.size();
	            result.add(q.peek().val);
	            while(size-- > 0) {
	                root = q.poll();
	                if(root.left != null)
	                    q.add(root.left);
	                if(root.right != null)
	                    q.add(root.right);
	            }
	        }
	        
	        return result;
	    }
	    public static List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList();
	        dfs(root, result, 0);
	        return result;
	    }
	    
	    private static void dfs(TreeNode node, List<Integer> result, int level) {
	        if(node == null)
	            return;
	        if(result.size() == level)
	            result.add(node.val);
	        dfs(node.left, result, level + 1);
			dfs(node.right, result, level + 1);
	    }
	    public static List<Integer> rightSideViewOptimie(TreeNode root) {
	        List<Integer> result = new ArrayList();
	        if(root == null)
	            return result;
	        
	        Queue<TreeNode> q = new LinkedList();
	        q.add(root);
	        while(q.size() > 0) {
	            int size = q.size();
	            result.add(q.peek().val);
	            while(size-- > 0) {
	                root = q.poll();
	                if(root.right != null)
	                    q.add(root.right);
	                if(root.left != null)
	                    q.add(root.left);
	            }
	        }
	        
	        return result;
	    }
}
