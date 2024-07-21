package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToSupplyWater {

	// Union-Find Class with Path Compression and Union by Rank
	class UnionFind {
		int[] root;
		int[] rank;

		public UnionFind(int size) {
			root = new int[size];
			rank = new int[size];
			for (int i = 0; i < size; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		public int find(int x) {
			if (x != root[x]) {
				root[x] = find(root[x]);
			}
			return root[x];
		}

		public boolean union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					root[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
					root[rootX] = rootY;
				} else {
					root[rootY] = rootX;
					rank[rootX] += 1;
				}
				return true;
			}
			return false;
		}
	}

	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		List<int[]> edges = new ArrayList<>();

		// Add edges for building wells directly in each house
		for (int i = 0; i < wells.length; i++) {
			edges.add(new int[] { 0, i + 1, wells[i] });
		}

		// Add edges for pipes between houses
		for (int[] pipe : pipes) {
			edges.add(pipe);
		}

		// Sort all edges by cost
		edges.sort(Comparator.comparingInt(edge -> edge[2]));

		UnionFind uf = new UnionFind(n + 1); // +1 to include the virtual node 0

		int totalCost = 0;
		for (int[] edge : edges) {
			int house1 = edge[0];
			int house2 = edge[1];
			int cost = edge[2];

			if (uf.union(house1, house2)) {
				totalCost += cost;
			}
		}

		return totalCost;
	}
	public static int findLength(String s) {
	    // curr is the current number of zeros in the window
	    int left = 0;
	    int curr = 0;
	    int ans = 0;

	    for (int right = 0; right < s.length(); right++) {
	        if (s.charAt(right)== '0') {
	            curr++;
	        }

	        while (curr > 1) {
	            if (s.charAt(left) == '0') {
	                curr--;
	            }

	            left++;
	        }

	        ans = Math.max(ans, right - left + 1);
	    }

	    return ans;
	}
	public static void main(String[] args) {
		MinCostToSupplyWater ws = new MinCostToSupplyWater();

		int n = 3;
		int[] wells = { 1, 2, 2 };
		int[][] pipes = { { 1, 2, 1 }, { 2, 3, 1 } };

	//	int result = ws.minCostToSupplyWater(n, wells, pipes);
		//System.out.println(result); // Output: 3
		System.out.println(findLength("1101100111"));
	}

}
