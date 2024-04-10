package com.crr.dsa.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class JumpGameV111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {3,2,4,4,1};
		
		
		int[] costs = {3,7,6,4,2};
		System.out.println(minCost(nums, costs));
	}
	 public static long minCost(int[] nums, int[] costs) {
	        Deque<Integer> one = new ArrayDeque<>();
	        Deque<Integer> two = new ArrayDeque<>();
	        long[] dp = new long[nums.length];
	        Arrays.fill(dp, Long.MAX_VALUE);
	        dp[0] = 0;

	        for (int i = 0; i < nums.length; i++){
	            while(!one.isEmpty() && nums[i] >= nums[one.peek()]){
	                dp[i] = Math.min(dp[i], dp[one.pop()] + costs[i]); // condition 1.
	            }
	            while(!two.isEmpty() && nums[i] < nums[two.peek()]){
	                dp[i] = Math.min(dp[i], dp[two.pop()] + costs[i]); // condition 2.
	            }
	            one.push(i);
	            two.push(i);
	        }

	        return dp[nums.length-1];
	    }
}
