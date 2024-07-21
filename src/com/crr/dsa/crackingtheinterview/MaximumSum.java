package com.crr.dsa.crackingtheinterview;

public class MaximumSum {

	public static void main(String[] args) {
		int nums[] = {-1,-1,-1};
		MaximumSum maximumSum = new MaximumSum();
		System.out.println(maximumSum.maxSubArray(nums));
	}
	public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curr = nums[0];
        
        for(int i = 1;i<nums.length;i++){
            curr  = Math.max(curr+nums[i],nums[i]);
            ans = Math.max(ans,curr);
        }
        return ans;
    }
	public int maximumSum(int[] arr) {
	        int n = arr.length;
	        int[] forward = new int[n];
	        int currentSum = arr[0];
	        forward[0] = currentSum;
	        int maxSum = currentSum;

	        for (int i = 1; i < n; i++) {
	            currentSum = Math.max(arr[i], currentSum + arr[i]);
	            forward[i] = currentSum;
	            maxSum = Math.max(maxSum, currentSum);
	        }
	        int[] backward = new int[n];
	        currentSum = arr[n - 1];
	        backward[n - 1] = currentSum;

	        for (int i = n - 2; i >= 0; i--) {
	            currentSum = Math.max(arr[i], currentSum + arr[i]);
	            backward[i] = currentSum;
	        }

	        for (int i = 1; i < n - 1; i++) {
	            maxSum = Math.max(maxSum, forward[i - 1] + backward[i + 1]);
	        }

	        return maxSum;
	    }
	
}
