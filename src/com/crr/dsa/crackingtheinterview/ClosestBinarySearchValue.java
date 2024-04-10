package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestBinarySearchValue {
	public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Define the target value
        double target = 4.714;

        // Create an instance of the class containing the methods
        ClosestBinarySearchValue main = new ClosestBinarySearchValue();

        // Call the closestValue method and print the result
        int closest = main.closestValue(root, target);
        System.out.println("Closest value to " + target + " in the tree: " + closest);
    }
	public void inorder(TreeNode root, List<Integer> nums) {
	    if (root == null) return;
	    inorder(root.left, nums);
	    nums.add(root.data);
	    inorder(root.right, nums);
	  }

	  public int closestValue(TreeNode root, double target) {
	    List<Integer> nums = new ArrayList();
	    inorder(root, nums);
	    
	    return Collections.min(nums, new Comparator<Integer>() {
	      @Override
	      public int compare(Integer o1, Integer o2) {
	    	  System.out.println(Math.abs(o1 - target)  + " "  +  Math.abs(o2 - target) );
	    	  System.out.println("  o1 " +  o1 + "  o2 " +  o2) ;
	        return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
	      }
	    });
	  }
}
