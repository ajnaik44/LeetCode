package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListofDepths {

	public void createLevelLinkedList(ArrayList<LinkedList<TreeNode>> result, TreeNode node ,int level)
	{
		if(node!=null)
		{
			if(result.isEmpty() || level >= result.size())
			{
				LinkedList<TreeNode> levelList = new LinkedList<>();
				
				result.add(levelList);
			}
				 result.get(level).add(node);
				
			
			createLevelLinkedList(result, node.left, level+1);
			createLevelLinkedList(result, node.right, level+1);
		}
	}
	public void printResult(ArrayList<LinkedList<TreeNode>> result) {
        for (LinkedList<TreeNode> levelList : result) {
            for (TreeNode node : levelList) {
                System.out.print(node.data + " ");
            }
            System.out.println(); // Move to the next line after printing each level
        }
    }
	public static TreeNode createTestTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        root.left.left.left.left = new TreeNode(16);
        root.left.left.left.right = new TreeNode(17);
        root.left.left.right.left = new TreeNode(18);
        root.left.left.right.right = new TreeNode(19);
        root.left.right.left.left = new TreeNode(20);
        root.left.right.left.right = new TreeNode(21);
        root.left.right.right.left = new TreeNode(22);
        root.left.right.right.right = new TreeNode(23);
        root.right.left.left.left = new TreeNode(24);
        root.right.left.left.right = new TreeNode(25);
        root.right.left.right.left = new TreeNode(26);
        root.right.left.right.right = new TreeNode(27);
        root.right.right.left.left = new TreeNode(28);
        root.right.right.left.right = new TreeNode(29);
        root.right.right.right.left = new TreeNode(30);
        root.right.right.right.right = new TreeNode(31);
        return root;
    }
	public static void main(String[] args) {
		ListofDepths utils = new ListofDepths();
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        TreeNode root =  createTestTree();
        utils.createLevelLinkedList(result, root, 0);
        // Now 'result' contains the linked lists representing nodes at each level
        utils.printResult(result);
    }
}
