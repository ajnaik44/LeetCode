package com.crr.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root==null)
            return answer;
        Stack<TreeNode> stack = new Stack<TreeNode>();
    
        TreeNode curr =  root;
        while(curr!=null ||!stack.isEmpty())
        {
            while(curr!=null){
                stack.push(curr);
                curr =  curr.left;
            }
            curr= stack.pop();
           answer.add(curr.val);
         
           curr =  curr.right;
             
        }
        return answer;
    }
	 public static void main(String[] args) {
	        // Creating a sample binary tree:
	        //       1
	        //        \
	        //         2
	        //        /
	        //       3
	        TreeNode root = new TreeNode(1);
	        root.right = new TreeNode(2);
	        root.right.left = new TreeNode(3);
	        
	        // Calling the inorderTraversal method
	        List<Integer> result = inorderTraversal(root);
	        
	        // Printing the result
	        System.out.println(result); // Output should be [1, 3, 2]
	    }
}
