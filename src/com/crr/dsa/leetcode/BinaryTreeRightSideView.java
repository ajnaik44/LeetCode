package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightSide = new ArrayList<>();
		List<TreeNode> currentLevel = new ArrayList<>();

		if (root != null)
			currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			rightSide.add(currentLevel.get(currentLevel.size() - 1).val);

			List<TreeNode> nextLevel = new ArrayList<>();

			for (TreeNode var : currentLevel) {
				if (var.left != null)
					nextLevel.add(var.left);
				if (var.right != null)
					nextLevel.add(var.right);
			}
			currentLevel = nextLevel;
		}
		return rightSide;

	}
	public void containerLetter(String target,String[] stickers)
    {
        TreeMap<String,Integer> count =  new TreeMap<String,Integer>(Collections.reverseOrder());
        
        for(String s:stickers)
        {
            int i=0;
            int counter=0;
            while(i<target.length())
            {
                if(s.contains(target.charAt(i)+""))
                {
                    counter++;
                }
                i++;
            }
            if(counter>0)
                count.put(s,counter);
        }
        System.out.println(count);
    }

	public void preOrder(TreeNode root, int level, List<Integer> rightSide) {
		if (root == null)
			return;
		if (level == rightSide.size())
			rightSide.add(root.val);

		preOrder(root.right, level + 1, rightSide);
		preOrder(root.left, level + 1, rightSide);
	}

	public List<Integer> rightSideViewOptimize(TreeNode root) {
		List<Integer> rightSide = new ArrayList<>();
		preOrder(root, 0, rightSide);
		return rightSide;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(5);

		root.right.right = new TreeNode(4);

		BinaryTreeRightSideView binaryTree = new BinaryTreeRightSideView();
		System.out.println(binaryTree.rightSideViewOptimize(root));

	}
}
