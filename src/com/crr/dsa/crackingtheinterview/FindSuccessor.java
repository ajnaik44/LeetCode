package com.crr.dsa.crackingtheinterview;

public class FindSuccessor {
	    static class TreeNode {
	        int data;
	        TreeNode left;
	        TreeNode right;
	        TreeNode parent; // Parent reference is needed for inorder successor

	        TreeNode(int data) {
	            this.data = data;
	        }
	    }
	 static   TreeNode commonAncestor(TreeNode p, TreeNode q) {
	        int delta = depth(p) - depth(q); // get difference in depths
	        TreeNode first = delta > 0 ? q : p; // get shallower node
	        TreeNode second = delta > 0 ? p : q; // get deeper node
	        second = goUpBy(second, Math.abs(delta)); // move deeper node up

	        /* Find where paths intersect. */
	        while (first != second && first != null && second != null) {
	            first = first.parent;
	            second = second.parent;
	        }
	        return (first == null || second == null) ? null : first;
	    }

	 static	    TreeNode goUpBy(TreeNode node, int delta) {
	        while (delta > 0 && node != null) {
	            node = node.parent;
	            delta--;
	        }
	        return node;
	    }

	 static    int depth(TreeNode node) {
	        int depth = 0;
	        while (node != null) {
	            node = node.parent;
	            depth++;
	        }
	        return depth;
	    }

	    public static void main(String[] args) {
	        // Constructing a binary search tree
	        TreeNode root = new TreeNode(10);
	        root.left = new TreeNode(5);
	        root.left.parent = root;
	        root.right = new TreeNode(15);
	        root.right.parent = root;
	        root.left.left = new TreeNode(3);
	        root.left.left.parent = root.left;
	        root.left.right = new TreeNode(8);
	        root.left.right.parent = root.left;
	        root.right.left = new TreeNode(12);
	        root.right.left.parent = root.right;
	        root.right.right = new TreeNode(20);
	        root.right.right.parent = root.right;

	        // Example usage: finding inorder successor of a node
	        TreeNode node = root.left.left; // Example node
	       System.out.println( commonAncestor(root.right.right,root.right.left).data);
	       
	    }

	    static TreeNode inorderSucc(TreeNode n) {
	        if (n == null) return null;

	        // Found right children -> return leftmost node of right subtree
	        if (n.right != null) {
	            return leftMostChild(n.right);
	        } else {
	            TreeNode q = n;
	            TreeNode x = q.parent;
	            // Go up until we're on left instead of right
	            while (x != null && x.left != q) {
	                q = x;
	                x = x.parent;
	            }
	            return x;
	        }
	    }

	    static TreeNode leftMostChild(TreeNode n) {
	        if (n == null) {
	            return null;
	        }
	        while (n.left != null) {
	            n = n.left;
	        }
	        return n;
	    }

}
