package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildOrder {

	public static List<String> findBuildOrder(String[] projects, String[][] dependencies) {
		// Create a graph to represent dependencies
		HashMap<String, List<String>> graph = new HashMap<>();
		HashMap<String, Integer> indegree = new HashMap<>();

		// Initialize the graph and indegree map
		for (String project : projects) {
			graph.put(project, new ArrayList<>());
			indegree.put(project, 0);
		}

		// Populate the graph and calculate indegrees
		for (String[] dependency : dependencies) {
			String dependent = dependency[0];
			String dependee = dependency[1];
			graph.get(dependent).add(dependee);
			indegree.put(dependee, indegree.get(dependee) + 1);
		}

		// Perform topological sort to find the build order
		List<String> buildOrder = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();

		// Add projects with 0 indegree to the queue
		for (String project : projects) {
			if (indegree.get(project) == 0) {
				queue.add(project);
			}
		}

		// Perform topological sort
		while (!queue.isEmpty()) {
			String project = queue.poll();
			buildOrder.add(project);
			for (String dependent : graph.get(project)) {
				indegree.put(dependent, indegree.get(dependent) - 1);
				if (indegree.get(dependent) == 0) {
					queue.add(dependent);
				}
			}
		}

		// Check if all projects are included in the build order
		if (buildOrder.size() != projects.length) {
			// Error: Dependency cycle detected
			return null;
		}

		return buildOrder;
	}

	public static void main(String[] args) {
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" }, { "d", "c" } };

		List<String> buildOrder = findBuildOrder(projects, dependencies);

		if (buildOrder == null) {
			System.out.println("Error: Dependency cycle detected, no valid build order exists.");
		} else {
			System.out.println("Valid build order: " + buildOrder);
		}
	}

}
