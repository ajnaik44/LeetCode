package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JobScheduling {
	public static void main(String[] args) {
		JobScheduling jobScheduling = new JobScheduling();
		int[] startTime = { 1, 2, 3, 4, 6 };
		int[] endTime = { 3, 5, 10, 6, 9 };
		int[] profit = { 20, 20, 100, 70, 60 };
		int pairs[][] = {{1,2},{2,3},{3,4}};
		System.out.println(jobScheduling.findLongestChain(pairs));

	}
	 public int findLongestChain(int[][] pairs) {
	        // Sort pairs by their second element
	        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
	        
	        int currentEnd = Integer.MIN_VALUE;
	        int chainLength = 0;
	        
	        // Iterate through the pairs
	        for (int[] pair : pairs) {
	            // If the current pair can be added to the chain
	            if (currentEnd < pair[0]) {
	                currentEnd = pair[1];  // Update the end of the chain
	                chainLength++;         // Increment the chain length
	            }
	        }
	        
	        return chainLength;
	    }

	Integer[] cache;

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int[][] jobs = new int[startTime.length][3];

		for (int i = 0; i < startTime.length; i++) {
			jobs[i][0] = startTime[i];
			jobs[i][1] = endTime[i];
			jobs[i][2] = profit[i];
		}
		cache = new Integer[startTime.length];
		Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
		return maxProfit(jobs, 0);
	}

	class The_Comparator implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
			return list1.get(0) - list2.get(0);
		}
	}

	private int findMaxProfit(List<List<Integer>> jobs) {
		int n = jobs.size(), maxProfit = 0;

		// min heap having {endTime, profit}
		/*
		 * 
		 * int[] startTime = { 1, 2, 3, 3 }; int[] endTime = { 3, 4, 5, 6 }; int[]
		 * profit = { 50, 10, 40, 70 };
		 */

		PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new The_Comparator());

		for (int i = 0; i < n; i++) {
			int start = jobs.get(i).get(0), end = jobs.get(i).get(1), profit = jobs.get(i).get(2);

			// keep popping while the heap is not empty and
			// jobs are not conflicting
			// update the value of maxProfit
			while (pq.isEmpty() == false && start >= pq.peek().get(0)) {
				maxProfit = Math.max(maxProfit, pq.peek().get(1));
				pq.remove();
			}

			ArrayList<Integer> combinedJob = new ArrayList<>();
			combinedJob.add(end);
			combinedJob.add(profit + maxProfit);

			// push the job with combined profit
			// if no non-conflicting job is present maxProfit will be 0
			pq.add(combinedJob);
		}

		// update the value of maxProfit by comparing with
		// profit of jobs that exits in the heap
		while (pq.isEmpty() == false) {
			maxProfit = Math.max(maxProfit, pq.peek().get(1));
			pq.remove();
		}

		return maxProfit;
	}

	public int jobSchedulingPQ(int[] startTime, int[] endTime, int[] profit) {
		List<List<Integer>> jobs = new ArrayList<>();

		// storing job's details into one list
		// this will help in sorting the jobs while maintaining the other parameters
		int length = profit.length;
		for (int i = 0; i < length; i++) {
			ArrayList<Integer> currJob = new ArrayList<>();
			currJob.add(startTime[i]);
			currJob.add(endTime[i]);
			currJob.add(profit[i]);

			jobs.add(currJob);
		}

		jobs.sort(Comparator.comparingInt(a -> a.get(0)));
		return findMaxProfit(jobs);
	}

	public int nextIndex(int[][] jobs, int endTime) {
		int left = 0;
		int right = jobs.length - 1;
		int result = jobs.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (jobs[mid][0] >= endTime) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	public int maxProfit(int[][] jobs, int position) {
		if (position == -1 || position >= jobs.length)
			return 0;

		if (cache[position] != null)
			return cache[position];

		int nextIndex = nextIndex(jobs, jobs[position][1]);

		int considerItem = jobs[position][2] + maxProfit(jobs, nextIndex);
		int notConsiderItem = maxProfit(jobs, position + 1);
		cache[position] = Math.max(considerItem, notConsiderItem);
		return Math.max(considerItem, notConsiderItem);
	}

}
