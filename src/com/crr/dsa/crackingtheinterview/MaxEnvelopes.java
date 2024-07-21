package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
	public static void main(String[] args) {
		int nums[][] = new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
		MaxEnvelopes envelopes = new MaxEnvelopes();
		int nums1[]  =  new int[] {3,2,1};
		envelopes.lengthOfLIS(nums1);
		System.out.println(envelopes.maxEnvelopesApproach1(nums));
	}
	

	    public int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        int len = 0;
	        for (int num : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, num);
	            if (i < 0) {
	                i = -(i + 1);
	            }
	            dp[i] = num;
	            if (i == len) {
	                len++;
	            }
	        }
	        return len;
	    }

	    public int maxEnvelopesApproach1(int[][] envelopes) {
	        // sort on increasing in first dimension and decreasing in second
	        Arrays.sort(envelopes, new Comparator<int[]>() {
	            public int compare(int[] arr1, int[] arr2) {
	                if (arr1[0] == arr2[0]) {
	                    return arr2[1] - arr1[1];
	                } else {
	                    return arr1[0] - arr2[0];
	                }
	           }
	        });
	        // extract the second dimension and run LIS
	        int[] secondDim = new int[envelopes.length];
	        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
	        return lengthOfLIS(secondDim);
	    }
	

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
		for (int i = 0; i < envelopes.length; i++) {
			for (int j = 0; j < envelopes[i].length; j++) {
				System.out.print(envelopes[i][j] + " ");
			}
			System.out.println(); // Move to the next line after each row
		}
		int max = 0;
		for (int i = envelopes.length - 1; i >= 0; i--) {
			int ans = dfs(envelopes, i - 1, i);

			max = Math.max(max, ans + 1);

		}
		return max;
	}

	public int dfs(int[][] envelopes, int current, int prev) {
		if (current < 0)
			return 0;
		int max = 0;
		if (current >= 0 && envelopes[prev][0] > envelopes[current][0] && envelopes[prev][1] > envelopes[current][1]) {

			int res1 = 1 + dfs(envelopes, current - 1, current);
			max = Math.max(res1, max);

		}
		else if (current >= 0 && envelopes[prev][0] >= envelopes[current][0]
				|| envelopes[prev][1] >= envelopes[current][1]) {
			int res2 = dfs(envelopes, current - 1, current + 1);
			max = Math.max(res2, max);
		} else {
			int res3 = dfs(envelopes, current - 1, prev);
			max = Math.max(res3, max);
		}
		return max;
	}

}
