package com.crr.dsa.leetcode;

import java.util.Arrays;

public class RestoreMatrix {
	public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int p, q, answer[][], i = 0, j = 0;
        p = rowSum.length;
        q = colSum.length;
        answer = new int[p][q];
        while(i<p && j<q) {
            answer[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= answer[i][j];
            colSum[j] -= answer[i][j];
            if(rowSum[i] == 0)
                i++;
            if(colSum[j] == 0)
                j++;
        }
	
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row[] = {5,7,10};
		int col[] = {8,6,8};
		int res[][] = restoreMatrix(row, col);
		// Printing each element of the array
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            
            System.out.println();  // Move to the next line after printing each row
        }
        
        int maximimSum []= {1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(maxSumAfterPartitioning(maximimSum, 4));
        
	}
	
	
	    private static int maxSum(int[] arr, int k, int[] dp, int start) {
	        int N = arr.length;

	        if (start >= N) {
	            return 0;
	        }

	        // Return the already calculated answer.
	        if (dp[start] != -1) {
	            return dp[start];
	        }

	        int currMax = 0, ans = 0;
	        int end = Math.min(N, start + k);
	        for (int i = start; i < end; i++) {
	            currMax = Math.max(currMax, arr[i]);
	            // Store the maximum of all options for the current subarray.
	            int sum =currMax * (i - start + 1);
	            ans = Math.max(ans,sum  + maxSum(arr, k, dp, i + 1));
	        }

	        // Store the answer to be reused.
	        return dp[start] = ans;
	    }

	    public static int maxSumAfterPartitioning(int[] arr, int k) {
	        int[] dp = new int[arr.length];
	        Arrays.fill(dp, -1);

	        return maxSum(arr, k, dp, 0);
	    }
	
	   
	        public static int maxSumAfterPartitioningBottomUpApproach(int[] arr, int k) {
	            int N = arr.length;

	            int[] dp = new int[N + 1];
	            Arrays.fill(dp, 0);
	            
	            for (int start = N - 1; start >= 0; start--) {
	                int currMax = 0;
	                int end = Math.min(N, start + k);

	                for (int i = start; i < end; i++) {
	                    currMax = Math.max(currMax, arr[i]);
	                    // Store the maximum of all options for the current subarray.
	                    dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
	                }
	            }
	            return dp[0];
	        }
	   
	
	
}
