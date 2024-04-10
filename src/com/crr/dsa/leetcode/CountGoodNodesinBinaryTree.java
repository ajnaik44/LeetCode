package com.crr.dsa.leetcode;

public class CountGoodNodesinBinaryTree {

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
	static int  counter=0;
	public static  int goodNodes(TreeNode root) {

		int numberOfGoodNodes = 0;

		if (root == null)
			return numberOfGoodNodes;
		counter++;

		numberOfGoodNodes+=goodNodesHelper(root,
				root.val);
		return counter;

	}
private static int numGoodNodes = 0;
    
    public static  int goodNodesSol1(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    
    private static void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        
        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }
	public static int goodNodesHelper(TreeNode root,int max ) {

		
		if (root == null)
			return counter;

		if (root.left != null) {
			if( root.left.val >= max)
				counter++;
			
				goodNodesHelper(root.left, Math.max(max, root.left.val));
		}
		if (root.right != null) {
			if( root.right.val >= max)
				counter++;
			goodNodesHelper(root.right, Math.max(max, root.right.val));
		}
		return counter;


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
	public static void main(String[] args) {
		 Integer[] root1Array = {3,3,null,4,2};

	        TreeNode root1 = createNodeFromArray(root1Array, 0);
	        System.out.println(goodNodesSol1(root1));
	}
}
