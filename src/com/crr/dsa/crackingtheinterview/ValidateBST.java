package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

	public static boolean isValidBST(TreeNode node) throws Exception
	{
		List<Integer> result = new ArrayList<>();
		copyTreeNodetoArray(node, result);
		System.out.println(result);
		for(int i=0;i<result.size()-1;i++)
		{
			if(result.get(i)<  result.get(i+1))
				continue;
			return false;				
			
		}
		return true;
	}
	public static void copyTreeNodetoArray(TreeNode node,List<Integer> result) throws Exception
	{
		if(node!=null)
		{
			copyTreeNodetoArray(node.left, result);
			result.add(node.data);
			copyTreeNodetoArray(node.right, result);
		}
	}
	static Integer last_printed = null;
	static boolean checkBST(TreeNode n) {
	    if (n == null) return true;

	    // Check left subtree
	    if (!checkBST(n.left)) return false;

	    // Check current node
	    if (last_printed != null && n.data <= last_printed) {
	        return false;
	    }
	    last_printed = n.data;

	    // Check right subtree
	    if (!checkBST(n.right)) return false;

	    return true; // All good!
	}
	static boolean checkBSTOptimize(TreeNode n) {
	return checkBSTHelper(n, null, null);
	}
	static boolean checkBSTHelper(TreeNode n,Integer min,Integer max) {
		if(n==null)
			return true;
		if((min!=null && n.data<=min) ||  (max!=null &&  n.data>max))
			return false;
		if(!checkBSTHelper(n.left,min,n.data) || !checkBSTHelper(n.right,n.data,max))
			return false;
		return true;
	}
	public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(2);
        root.left =  new TreeNode(1);
        root.right = new TreeNode(0);
        // Calculate the height of the binary tree
     
       
        // Print the height
        try {
			System.out.println(checkBSTOptimize(root) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
