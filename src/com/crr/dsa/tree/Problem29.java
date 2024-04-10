package com.crr.dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class Problem29 {
	
	static BinaryTreeNode fromPreandInoder() {
		int preorder[] = { 10, 20, 40, 50, 30, 60 };
		int inorder[] = { 40, 20, 50, 10, 60, 30 };
		return buildTree(preorder, inorder);
	}

	static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {

		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		BinaryTreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
		return root;
	}

	public static BinaryTreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
			int inEnd, Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd)
			return null;
		BinaryTreeNode current = new BinaryTreeNode(preorder[preStart]);
		int index = inMap.get(current.data);
		int leftnums = index - inStart;
		current.left = buildTree(preorder, preStart + 1, preStart + leftnums, inorder, inStart, index - 1, inMap);
		current.right = buildTree(preorder, preStart + leftnums + 1, preEnd, inorder, index + 1, inEnd, inMap);
		return current;
	}

	static BinaryTreeNode buildTreethroughPostorder(int[] inorder, int[] postOrder) {

		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		BinaryTreeNode root = buildTreethroughPostorder(inorder, 0, inorder.length - 1, postOrder, 0,
				postOrder.length - 1, inMap);
		return root;
	}

	static BinaryTreeNode buildTreethroughPostorder(int[] inorder, int preStart, int preEnd, int[] postorder,
			int postStart, int postEnd, Map<Integer, Integer> inMap) {
		if (preStart > preEnd || postStart > postEnd)
			return null;
		BinaryTreeNode current = new BinaryTreeNode(postorder[postEnd]);
		int index = inMap.get(current.data);
		int lefts = preEnd - index;
		current.right = buildTreethroughPostorder(inorder, lefts + 1, preEnd, postorder, postStart + lefts, postEnd - 1,
				inMap);
		current.left = buildTreethroughPostorder(inorder, preStart, preEnd - lefts - 1, postorder, postStart,
				postStart + lefts - 1, inMap);
		return current;

	}

	public BinaryTreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, post);
    }
	
	    int postIndex = 0;
	     int preIndex = 0;

    private BinaryTreeNode construct(int[] pre, int[] post) 
    {
    	BinaryTreeNode root = new BinaryTreeNode(pre[preIndex++]);

        if (root.data != post[postIndex]) {
            root.left = construct(pre, post);
        }

        if (root.data != post[postIndex]) {
            root.right = construct(pre, post);
        }

        postIndex++;

        return root;
    }
 // Helper function to print inorder traversal
    public static void printInorder(BinaryTreeNode node) {
        if (node == null)
            return;
        
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

   


	public static void main(String args[]) {
		int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};

        Problem29 builder = new Problem29();
        BinaryTreeNode root = builder.constructFromPrePost(pre, post);

        // Print the inorder traversal of the constructed tree to verify
        System.out.println("Inorder Traversal:");
        System.out.println(builder.postIndex);
        printInorder(root);

	}

}
