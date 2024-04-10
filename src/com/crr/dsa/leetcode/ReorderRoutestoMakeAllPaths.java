package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutestoMakeAllPaths {
	int count=0;
	public void dfs(int node,int parent,Map<Integer,List<List<Integer>>> adj)
	{
		 if (!adj.containsKey(node)) {
	            return;
	        }
	        for (List<Integer> nei : adj.get(node)) {
	            int neighbor = nei.get(0);
	            int sign = nei.get(1);
	            if (neighbor != parent) {
	                count += sign;
	                dfs(neighbor, node, adj);
	            }
	        }
	}
	 public int minReorder(int n, int[][] connections) {
		 Map<Integer,List<List<Integer>>> adj = new HashMap<>();
		 for (int i = 0; i < connections.length; i++) {
		        int[] connection = connections[i];

		        if (!adj.containsKey(connection[0])) {
		            adj.put(connection[0], new ArrayList<>());
		        }
		        adj.get(connection[0]).add(Arrays.asList(connection[1], 1));

		        if (!adj.containsKey(connection[1])) {
		            adj.put(connection[1], new ArrayList<>());
		        }
		        adj.get(connection[1]).add(Arrays.asList(connection[0], 0));
		    }
		 dfs(0, -1, adj);
         return count;
	 }
	public static void main(String[] args) {
		int n[][]= {{0,1},{1,3},{2,3},{4,0},{4,5}};
		ReorderRoutestoMakeAllPaths  reorderRoutestoMakeAllPaths =  new ReorderRoutestoMakeAllPaths();
		System.out.println(reorderRoutestoMakeAllPaths.minReorder(6, n));
	}
}
