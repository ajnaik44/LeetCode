package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int [] sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i -1];
        }
        
        Set<Integer> set = new HashSet();
        
        for(int i = 2; i <= n; i++){
            set.add(sum[i - 2] % k);
            int temp =sum[i] % k;
            if(set.contains(temp)) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		int nums[]= {23,2,6,4,7};
		System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, 6));
	}
}
