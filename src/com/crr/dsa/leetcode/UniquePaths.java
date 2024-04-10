package com.crr.dsa.leetcode;

import java.util.Arrays;

public class UniquePaths {
	public int uniquePathsRecursion(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n - 1);
	}

	public int uniquePaths(int m, int n) {
		int[][] d = new int[m][n];

		for (int[] arr : d) {
			Arrays.fill(arr, 1);
		}
		for (int col = 1; col < m; ++col) {
			for (int row = 1; row < n; ++row) {
				d[col][row] = d[col - 1][row] + d[col][row - 1];
			}
		}
		return d[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths paths = new UniquePaths();
		System.out.println(paths.uniquePathsRecursion(3, 7));
	}
}
