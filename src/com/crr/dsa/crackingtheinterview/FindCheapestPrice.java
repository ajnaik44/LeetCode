package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindCheapestPrice {
	public static void main(String[] args) {
		FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
		int[][] flight = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		System.out.println(findCheapestPrice.findCheapestPriceAjay(4, flight, 0, 3, 1));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		Map<Integer, Map<Integer, Integer>> flightDetails = new HashMap<Integer, Map<Integer, Integer>>();

		for (int i = 0; i < n; i++) {
			flightDetails.put(i, new HashMap<Integer, Integer>());
		}

		for (int[] fDetails : flights) {
			flightDetails.get(fDetails[0]).put(fDetails[1], fDetails[2]);
		}

		return findCheapestPrice(flightDetails, src, dst, k + 1, new HashSet<Integer>());

	}

	public int findCheapestPriceAjay(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<int[]>> adj = new HashMap<>();
		for (int[] i : flights)
			adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { src, 0 });
		int stops = 0;

		while (stops <= k && !q.isEmpty()) {
			int sz = q.size();
			// Iterate on current level.
			while (sz-- > 0) {
				int[] temp = q.poll();
				int node = temp[0];
				int distance = temp[1];

				if (!adj.containsKey(node))
					continue;
				// Loop over neighbors of popped node.
				for (int[] e : adj.get(node)) {
					int neighbour = e[0];
					int price = e[1];
					if (price + distance >= dist[neighbour])
						continue;
					dist[neighbour] = price + distance;
					q.offer(new int[] { neighbour, dist[neighbour] });
				}
			}
			stops++;
		}
		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}

	public static int findCheapestPrice(Map<Integer, Map<Integer, Integer>> flightDetails, int src, int dst, int k,
			Set<Integer> set) {
// Memoization cache to store computed results
		Map<String, Integer> memo = new HashMap<>();
		return helper(flightDetails, src, dst, k, set, memo);
	}

	private static int helper(Map<Integer, Map<Integer, Integer>> flightDetails, int src, int dst, int k,
			Set<Integer> set, Map<String, Integer> memo) {
// Base cases
		if (k < 0)
			return Integer.MAX_VALUE;
		if (set.contains(src) || src == dst)
			return 0;

// Check memoization cache
		String key = src + "-" + k;
		if (memo.containsKey(key))
			return memo.get(key);

		int cheapestFlight = Integer.MAX_VALUE;
		if (flightDetails.containsKey(src)) {
			for (Map.Entry<Integer, Integer> flight : flightDetails.get(src).entrySet()) {
				int sum = flight.getValue();
				int result = helper(flightDetails, flight.getKey(), dst, k - 1, set, memo);
				set.add(flight.getKey());
				if (result == Integer.MAX_VALUE)
					continue;
				sum += result;
				cheapestFlight = Math.min(cheapestFlight, sum);
				set.remove(flight.getKey()); // Backtrack
			}
		}

// Update memoization cache
		memo.put(key, cheapestFlight);

		return cheapestFlight;
	}
}
