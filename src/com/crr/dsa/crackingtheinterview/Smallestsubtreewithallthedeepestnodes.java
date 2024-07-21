package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}
public class Smallestsubtreewithallthedeepestnodes {
	public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) 
        	return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) 
        	return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
	public static void main(String[] args) {
        // Example usage:
		Smallestsubtreewithallthedeepestnodes solution = new Smallestsubtreewithallthedeepestnodes();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Result result = solution.dfs(root);
        System.out.println("Subtree with deepest nodes has root value: " + result.node.val);
    }
	Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth =  new HashMap<TreeNode,Integer>();
        depth.put(null,-1);
        dfs(root,null);
        max_depth = -1;
        for(int i: depth.values())
           max_depth =  Math.max(max_depth,i);
        return answer(root); 
    }

    public void dfs(TreeNode node,TreeNode parent)
    {
        if(node!=null)
        {
            depth.put(node,depth.get(parent)+1);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
    public TreeNode answer(TreeNode node)
    {
        if(node==null ||  depth.get(node)==max_depth)
            return node;
            TreeNode L =  answer(node.left);
             TreeNode R =  answer(node.right);
             if(L!=null&& R!=null) 
            	 return node;
             if(L!=null) return L;
             if(R!=null) return R;
             return null;
    }
}
