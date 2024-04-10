package com.crr.dsa.leetcode;

import java.util.Arrays;

public class FindMinimumTimetoFinishAllJObs {
	public static int minimumTime(int[] jobs, int[] workers) {

		Arrays.sort(jobs);
		Arrays.sort(workers);
		int max = 0;

		for (int i = 0; i < jobs.length; i++) {
			max = Math.max(--jobs[i] / workers[i] + 1, max);
		}

		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jobs[] = { 3,9,15,18};
		int[] workers = { 1,3,5,6 };
		System.out.println(minimumTime(jobs, workers));
	}

}
