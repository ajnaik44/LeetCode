package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class COntinouSumArray {
	public static void main(String[] args) {
		COntinouSumArray  array = new COntinouSumArray();
		int nums[] = {23,2,4,6,7};
		System.out.println(array.checkSubarraySum(nums, 6));
	}
	 public boolean checkSubarraySum(int[] nums, int k) {
		    if (nums == null || nums.length < 2) return false;

		    // Map to store the first occurrence of a remainder
		    Map<Integer, Integer> remainderMap = new HashMap<>();
		    remainderMap.put(0, -1); // To handle cases where the subarray starts from index 0

		    int runningSum = 0;

		    for (int i = 0; i < nums.length; i++) {
		        runningSum += nums[i];
		        int remainder = runningSum % k;

		        // Adjust for negative remainders if k is negative
		        if (remainder < 0) remainder += k;

		        if (remainderMap.containsKey(remainder)) {
		            if (i - remainderMap.get(remainder) > 1) {
		                return true;
		            }
		        } else {
		            remainderMap.put(remainder, i);
		        }
		    }

		    return false;
		}
}
