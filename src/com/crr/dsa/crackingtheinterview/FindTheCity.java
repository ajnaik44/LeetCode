package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import javafx.util.Pair;

public class FindTheCity {

	public static void main(String[] args) {
		FindTheCity findTheCity = new FindTheCity();
		int[][] array = { { 0, 1, 10 }, { 0, 2, 1 }, { 2, 3, 1 }, { 1, 3, 1 }, { 1, 4, 1 }, { 4, 5, 10 } };

		System.out.println(findTheCity.findTheCity(6, array, 20));

	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {

		Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Pair(edge[1], edge[2]));
			graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Pair(edge[0], edge[2]));
		}

		int min = Integer.MAX_VALUE;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int result = bsf(graph, i, n, distanceThreshold);
			System.out.println(i + " " + result);
			if (result <= min) {
				min = result;
				answer = i;
			}
		}
		return answer;
	}

	public int bsf(Map<Integer, List<Pair<Integer, Integer>>> graph, int source, int n, int distanceThreshold) {
		  PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>( (a,b) -> (a.getValue() -  b.getValue() ) );
		queue.add(new Pair(source, 0));
		boolean visited[] = new boolean[n];
		int distance = 0;
		Set<Integer> consider = new HashSet<Integer>();
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Pair<Integer, Integer> pair = queue.poll();

				if (visited[pair.getKey()])
					continue;

				visited[pair.getKey()] = true;

				if (!graph.containsKey(pair.getKey()))
					continue;

				List<Pair<Integer, Integer>> list = graph.get(pair.getKey());

				for (int i = 0; i < list.size(); i++) {
					if (!visited[list.get(i).getKey()]
							&& pair.getValue() + list.get(i).getValue() <= distanceThreshold) {
						if (!consider.contains(list.get(i).getKey()))
							distance++;
						consider.add(list.get(i).getKey());
						queue.add(new Pair(list.get(i).getKey(), pair.getValue() + list.get(i).getValue()));
					}
				}
			}
		}
		return consider.size();

	}

}
