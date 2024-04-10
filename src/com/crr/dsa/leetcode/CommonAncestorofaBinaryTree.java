package com.crr.dsa.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonAncestorofaBinaryTree {
	  private TreeNode ans;

	    public CommonAncestorofaBinaryTree() {
	        // Variable to store LCA node.
	        this.ans = null;
	    }

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	        // Stack for tree traversal
	        Deque<TreeNode> stack = new ArrayDeque<>();

	        // HashMap for parent pointers
	        Map<TreeNode, TreeNode> parent = new HashMap<>();

	        parent.put(root, null);
	        stack.push(root);

	        // Iterate until we find both the nodes p and q
	        while (!parent.containsKey(p) || !parent.containsKey(q)) {

	            TreeNode node = stack.pop();

	            // While traversing the tree, keep saving the parent pointers.
	            if (node.left != null) {
	                parent.put(node.left, node);
	                stack.push(node.left);
	            }
	            if (node.right != null) {
	                parent.put(node.right, node);
	                stack.push(node.right);
	            }
	        }

	        // Ancestors set() for node p.
	        Set<TreeNode> ancestors = new HashSet<>();

	        // Process all ancestors for node p using parent pointers.
	        while (p != null) {
	            ancestors.add(p);
	            p = parent.get(p);
	        }

	        // The first ancestor of q which appears in
	        // p's ancestor set() is their lowest common ancestor.
	        while (!ancestors.contains(q))
	            q = parent.get(q);
	        return q;
	    }

	 public static void main(String[] args) {
		
			TreeNode root = new TreeNode(3);
			root.left = new TreeNode(5);
			root.right = new TreeNode(1);
			
			root.left.left = new TreeNode(6);
			root.left.right = new TreeNode(2);
			
			root.left.right.left = new TreeNode(7);
			root.left.right.right = new TreeNode(4);
			
			root.right.left = new TreeNode(0);
			root.right.right = new TreeNode(8);
			

			CommonAncestorofaBinaryTree binaryTree = new CommonAncestorofaBinaryTree();
			System.out.println(binaryTree.lowestCommonAncestor(root,root.left.right.right,root.right));

		}
}
