package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;

public class CombinationSum4 {

	private HashMap<Integer, Integer> memo;

	public int combinationSum4(int[] nums, int target) {
		// minor optimization
		// Arrays.sort(nums);
		memo = new HashMap<>();
		return combs(nums, target);
	}

	private int combs(int[] nums, int remain) {
		if (remain == 0)
			return 1;
		

		int result = 0;
		for (int num : nums) {
			if (remain - num >= 0)
				result += combs(nums, remain - num);
			// minor optimizaton, early stopping
			// else
			// break;
		}
	
		return result;
	}
	 public int combinationSum4Approach1(int[] nums, int target) {
	        // minor optimization
	        // Arrays.sort(nums);
	        int[] dp = new int[target + 1];
	        dp[0] = 1;

	        for (int combSum = 1; combSum < target + 1; ++combSum) {
	            for (int num : nums) {
	                if (combSum - num >= 0)
	                    dp[combSum] += dp[combSum - num];
	                // minor optimizaton, early stopping
	                // else
	                //     break;
	            }
	        }
	        return dp[target];
	    }
public static void main(String[] args) {
	int nums[]= {1,2,3};
	CombinationSum4 combinationSum4 = new CombinationSum4();
	System.out.println(combinationSum4.combinationSum4Approach1(nums, 4));
}
}
