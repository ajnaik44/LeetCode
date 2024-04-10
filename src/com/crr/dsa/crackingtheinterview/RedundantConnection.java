package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
	Set<Integer> seen = new HashSet();
	int MAX_EDGE_VAL = 1000;

	public int[] findRedundantConnection(int[][] edges) {
		ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
		for (int i = 0; i <= MAX_EDGE_VAL; i++) {
			graph[i] = new ArrayList();
		}

		for (int[] edge : edges) {
			seen.clear();
			if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) {
				return edge;
			}
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		throw new AssertionError();
	}

	public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
		if (!seen.contains(source)) {
			seen.add(source);
			if (source == target)
				return true;
			for (int nei : graph[source]) {
				if (dfs(graph, nei, target))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = { { 1, 2 }, { 2, 3 }, {  3,4 },{1,4},{1,5} };
		System.out.println(new RedundantConnection().findRedundantConnectionDSU(nums));
	}

	public int[] findRedundantConnectionDSU(int[][] edges) {
		DSU dsu = new DSU(MAX_EDGE_VAL + 1);
		for (int[] edge : edges) {
			if (!dsu.union(edge[0], edge[1]))
				return edge;
		}
		throw new AssertionError();
	}
}

class DSU {
	int[] parent;
	int[] rank;

	public DSU(int size) {
		parent = new int[size];
		for (int i = 0; i < size; i++)
			parent[i] = i;
		rank = new int[size];
	}

	public int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}

	public boolean union(int x, int y) {
		int xr = find(x), yr = find(y);
		if (xr == yr) {
			return false;
		} else if (rank[xr] < rank[yr]) {
			parent[xr] = yr;
		} else if (rank[xr] > rank[yr]) {
			parent[yr] = xr;
		} else {
			parent[yr] = xr;
			rank[xr]++;
		}
		return true;
	}
}
