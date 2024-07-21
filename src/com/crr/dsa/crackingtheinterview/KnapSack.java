package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class KnapSack {
	int max = 0;

	public static void main(String[] args) {
		int weight[] = { 2, 3, 4 };
		int value[] = { 1, 2, 5 };
		int capacity = 7;
		KnapSack k = new KnapSack();

		int wv[][] = new int[weight.length][2];
		for (int i = 0; i < weight.length; i++) {
			wv[i][0] = weight[i];
			wv[i][1] = value[i];
		}

		Arrays.sort(wv, (a, b) -> (a[0] - b[0]));

		System.out.println(k.knapSackApparoch1(capacity, weight, value, 3));

	}

	// int weight []= {2,3,4,5};
	// int value[]= {1,2,5,6};
	public int knapSack(int W, int wt[], int val[], int n) {
		int[][] dp = new int[n + 1][W + 1];

		// Build dp table bottom-up
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else if (wt[i - 1] <= w) {
					int t1 = val[i - 1];
					int t2 = dp[i - 1][w - wt[i - 1]];
					int t3 = dp[i - 1][w];
					dp[i][w] = Math.max(t1 + t2, t3);
				} else
					dp[i][w] = dp[i - 1][w];
			}
		}
		return dp[n][W];
	}

	public void knapSack1(int wv[][], int capacity, int index, int total) {
		if (index >= wv.length)
			return;
		if (capacity < 0)
			return;
		max = Math.max(total, max);
		for (int i = index; i < wv.length; i++) {
			if (capacity - wv[i][0] < 0)
				break;
			knapSack1(wv, capacity - wv[i][0], i + 1, wv[i][1] + total);
		}

	}

	public void knapSack(int weight[], int value[], int capacity, int index, int total) {
		if (index >= weight.length)
			return;
		if (capacity < 0)
			return;
		max = Math.max(total, max);
		for (int i = index; i < value.length; i++) {
			if (capacity - weight[i] >= 0)
				knapSack(weight, value, capacity - weight[i], i + 1, total + value[i]);
		}

	}

	public int knapSackApparoch1(int W, int wt[], int val[], int n) {
		// Create a memoization array to store the results of subproblems
		int[][] memo = new int[n + 1][W + 1];
		// Initialize memoization array with -1 indicating no result has been computed
		// yet
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				memo[i][j] = -1;
			}
		}
		// Call the recursive function with memoization
		return knapSackMemo(W, wt, val, n, memo);
	}

	private int knapSackMemo(int W, int wt[], int val[], int n, int[][] memo) {
		// If the result is already computed, return it
		if (memo[n][W] != -1)
			return memo[n][W];
		// Base case: If either the capacity is 0 or the number of items is 0
		if (n == 0 || W == 0)
			return 0;

		// If the weight of the nth item is more than the knapsack capacity, it cannot
		// be included
		if (wt[n - 1] > W) {
			 memo[n][W] = knapSackMemo(W, wt, val, n - 1, memo);
			 return memo[n][W];
		}

		// Return the maximum of two cases:
		// 1. nth item included
		// 2. nth item not included
		else {
			int val1 =val[n - 1];
			int val2= knapSackMemo(W - wt[n - 1], wt, val, n - 1, memo);
			int val3= knapSackMemo(W, wt, val, n - 1, memo);
			int res = Math.max(val1 + val2,val3					);
			 memo[n][W] =  res;
		}
		return memo[n][W];
	}

}
