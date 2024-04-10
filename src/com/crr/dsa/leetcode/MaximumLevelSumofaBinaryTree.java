package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
	 public int maxLevelSumUsingBFS(TreeNode root) 
	 {
		 int maxLevel =0;
		 int max = Integer.MIN_VALUE;
		 if(root==null)
			 return maxLevel;
		 Queue<TreeNode>  queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 int level = 0;
		 while(!queue.isEmpty())
		 {
			 int size = queue.size();
			 int sum = 0;
			 level++;
			 for(int i=0;i<size;i++)
			 {
				 TreeNode tmp =  queue.poll();
				 sum+=tmp.val;
				 if(tmp.left!=null)
					 queue.add(tmp.left);
				 if(tmp.right!=null)
					 queue.add(tmp.right);
			 }
			 if(sum>max)
				 maxLevel = level;
			max =  Math.max(max, sum);	
			
		 }
		 return maxLevel;
	        
	 }
	 public void dfs(TreeNode node, int level, List<Integer> sumOfNodesAtLevel) {
	       if(node==null)
	    	   return ;
	       if(sumOfNodesAtLevel.size()==level)
	       {
	    	   sumOfNodesAtLevel.add(node.val);
	       }else {
	    	   sumOfNodesAtLevel.set(level, sumOfNodesAtLevel.get(level)+node.val);
	       }
	       dfs(node.left, level+1, sumOfNodesAtLevel);
	       dfs(node.right, level+1, sumOfNodesAtLevel);
	       
	    }

	    public int maxLevelSum(TreeNode root) {
	        List<Integer> sumOfNodesAtLevel = new ArrayList<>();
	        dfs(root, 0, sumOfNodesAtLevel);

	        int maxSum = Integer.MIN_VALUE;
	        int ans = 0;

	        for (int i = 0; i < sumOfNodesAtLevel.size(); i++) {
	            if (maxSum < sumOfNodesAtLevel.get(i)) {
	                maxSum = sumOfNodesAtLevel.get(i);
	                ans = i + 1;
	            }
	        }

	        return ans;
	    }
	 public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
			root.left = new TreeNode(7);
			root.right = new TreeNode(0);

			root.left.left = new TreeNode(7);

			root.right.right = new TreeNode(-8);
			
			Integer[] root1Array = { -100,-200,-300,-20,-5,-10,null};

			 TreeNode root1 = TreeNode.createTreeFromArray(root1Array);

			MaximumLevelSumofaBinaryTree  maximumLevelSumofaBinaryTree =  new MaximumLevelSumofaBinaryTree();
			System.out.println(maximumLevelSumofaBinaryTree.maxLevelSum(root1));
	}
}
