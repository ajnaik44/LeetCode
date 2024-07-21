package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class MinCameraCover {
	public static void main(String[] args) {
		MinCameraCover cameraCover = new MinCameraCover();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		
		System.out.println(cameraCover.minCameraCover(root));
	}

	int ans = 0;
	Set<TreeNode> covered;

	public int minCameraCover(TreeNode root) {
		covered = new HashSet<TreeNode>();
		covered.add(null);
		dfs(root, null);
		return ans;

	}

	public void dfs(TreeNode child, TreeNode parent) {

		if (child != null) {

			dfs(child.left, child);
			dfs(child.right, child);
			if ((parent == null && !covered.contains(child)) || !covered.contains(child.left)
					|| !covered.contains(child.right)) {
				ans++;
				covered.add(child);
				covered.add(child.left);
				covered.add(child.right);
				covered.add(parent);

			}

		}
	}
}
