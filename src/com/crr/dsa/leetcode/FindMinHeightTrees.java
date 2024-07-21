package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindMinHeightTrees {
	public static void main(String[] args) {
		FindMinHeightTrees findMinHeightTrees = new FindMinHeightTrees();
		int edges[][] = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } };
		System.out.println(findMinHeightTrees.findMinHeightTrees(6, edges));
	}

	 public List<Integer> findMinHeightTrees(int n, int[][] edges) {

			int[] indegree = new int[n];

			Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
			ArrayList<Integer> answer = new ArrayList<Integer>();
			if (n == 1) {
				answer.add(0);
				return answer;
			}
			for (int edge[] : edges) {
				indegree[edge[0]]++;
				indegree[edge[1]]++;

				graph.computeIfAbsent(edge[0], a -> new ArrayList<Integer>()).add(edge[1]);
				graph.computeIfAbsent(edge[1], a -> new ArrayList<Integer>()).add(edge[0]);

			}

			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));

			for (int i = n - 1; i >= 0 ; i--) {
				if(indegree[i]<=1)
					continue;
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(i);
				int result = backtracking(graph, set, i, indegree);
				pq.add(new int[] { i, result });

			}
			if(pq.isEmpty())
			{
				for(int i=0;i<n;i++)
					answer.add(i);
				return answer;
			}
			
			Map<Integer, Integer> tempAnswer = new HashMap<Integer, Integer>();
			int previosResult[] = pq.poll();
			answer.add(previosResult[0]);
			int previous = previosResult[1];
			tempAnswer.put(previosResult[0], previous);
			while (!pq.isEmpty()) {
				int[] temp = pq.poll();
				if (answer.isEmpty() || previous == temp[1]) {
					answer.add(temp[0]);
				}
			}
			return answer;

		}

		public int backtracking(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int[] indegree) {
			if (!graph.containsKey(node))
				return 0;

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(node);

			int answer = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				boolean flag = false;
				for (int i = 0; i < size; i++) {

					int currentnode = queue.poll();
					visited.add(currentnode);
					if (visited.size() == indegree.length)
						break;

					
					for (int neighbors : graph.get(currentnode)) {
						if (!visited.contains(neighbors)) {
							queue.add(neighbors);
							flag = true;
						}

					}
				}
				if (flag) {
					answer++;
				}

			}
			return answer;
		}


}
