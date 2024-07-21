package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleBST {
	
	public List<TreeNode> allPossibleBST(int start, int end) {

		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		} else {

			for (int i = start; i <= end; i++) {
				List<TreeNode> alleftNode = allPossibleBST(start, i - 1);
				List<TreeNode> allrightNode = allPossibleBST(i + 1, end);

				for (TreeNode leftNode : alleftNode) {
					for (TreeNode rightNode : allrightNode) {
						TreeNode rootNode = new TreeNode(i, leftNode, rightNode);
						result.add(rootNode);
					}
				}
			}
		}
		return result;

	}

	public List<TreeNode> generateTrees(int n) {
		Map<PairNew<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
		return allPossibleBST(1, n);
	}

	public static void main(String[] args) {
		AllPossibleBST allPossibleBST = new AllPossibleBST();
		allPossibleBST.generateTrees(3);
	}
}
