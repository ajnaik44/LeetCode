package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorofaBinaryTreeIV {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	static	TreeNode lca = null;
    public static  TreeNode lowestCommonAncestorSolution2(TreeNode root, TreeNode[] nodes) {
        Set<Integer> targetNodes = new HashSet<>();
        for(TreeNode node : nodes) {
            targetNodes.add(node.val);
        }
        helper(root, targetNodes);
        return lca;
    }
    
    static  int helper(TreeNode root, Set<Integer> nodes) {
        if(root == null) return 0;
        int leftCount = helper(root.left, nodes);
        int rightCount = helper(root.right, nodes);
        int foundCount = leftCount + rightCount;
        if(nodes.contains(root.val)) {
            foundCount++;
        }
        if(foundCount == nodes.size() && lca == null) {
            lca = root;
        }
        
        return foundCount;
    }
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		if(nodes.length ==1)
			return nodes[0];
		HashMap<Integer, Integer> searchItem = new HashMap<Integer, Integer>();
		for (TreeNode node : nodes) {
			searchItem.put(node.val, node.val);
		}

		Stack<TreeNode> stackNodes = new Stack<TreeNode>();
		
		inlIneInterator(root, searchItem, stackNodes);
		
		return stackNodes.pop();

	}

	public static void inlIneInterator(TreeNode node, Map<Integer, Integer> searchItem, Stack<TreeNode> stackNodes) {
		if(searchItem.isEmpty())
			return;
		if (node != null && !searchItem.isEmpty()) {
			
			if(node.left!=null &&  searchItem.containsKey(node.left.val))
			{
				stackNodes.add(node);
				searchItem.remove(node.left.val);
				inlIneInterator(node.left, searchItem, stackNodes);
				
			}	else {
				inlIneInterator(node.left, searchItem, stackNodes);	
			}
			if(node.right!=null &&  searchItem.containsKey(node.right.val))
			{
			
				stackNodes.add(node);
				searchItem.remove(node.right.val);
				inlIneInterator(node.right, searchItem, stackNodes);
			}else {
				inlIneInterator(node.right, searchItem, stackNodes);	
			}
			
		}
	}
	public static void main(String[] args) {
		TreeNode  root = new TreeNode(3);
		root.left = new TreeNode(5);
				
		root.right = new TreeNode(1);
		
		root.left.left =  new TreeNode(6);
		root.left.right = new TreeNode(2);
		
		root.left.right.left = new TreeNode(7);
		root.left.right.right =  new TreeNode(4);
		
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		TreeNode [] array = new TreeNode[2];
		
		array[0] =new TreeNode(4);
		array[1] =new TreeNode(7);
		
		
		
	
		System.out.println(lowestCommonAncestor(root,array).val);
				
	}

}
