package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Undirectedtreeconsisting {

	int minPath = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Undirectedtreeconsisting undirectedtreeconsisting = new Undirectedtreeconsisting();
		int[][] edges = {
	            {0, 1},
	            {0, 2},
	            {1, 4},
	            {1, 5},
	            {2, 3},
	            {2, 6}
	        };
		 List<Boolean> apple = Arrays.asList(false, false, true, false, true, true, false);
	System.out.println(undirectedtreeconsisting.minTime(7, edges, apple));
	}

	 public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();

	        // Build the graph
	        for (int[] edge : edges) {
	            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
	            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
	        }

	        // Start DFS from the root (node 0) with a visited set to avoid cycles
	        Set<Integer> visited = new HashSet<>();
	        return dfs(graph, 0, visited, hasApple);
	    }

	    private int dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, List<Boolean> hasApple) {
	        visited.add(node);
	        if(graph.get(node)==null ||   graph.get(node).isEmpty()) return 0;
	        int totalCost = 0;

	        // Traverse all adjacent nodes
	        for (int neighbor : graph.get(node)) {
	            if (!visited.contains(neighbor)) {
	                int cost = dfs(graph, neighbor, visited, hasApple);
	                // If the subtree rooted at this neighbor has an apple, include its cost
	                if (cost > 0 || hasApple.get(neighbor)) {
	                    totalCost += cost + 2; // Include the cost to travel to and back from the neighbor
	                }
	            }
	        }
	        return totalCost;
	    }

}
