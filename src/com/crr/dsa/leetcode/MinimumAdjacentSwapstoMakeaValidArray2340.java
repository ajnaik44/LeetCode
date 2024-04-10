package com.crr.dsa.leetcode;

public class MinimumAdjacentSwapstoMakeaValidArray2340 {
	 public static int minimumSwaps(int[] nums) {
	        int maxi = nums.length - 1, mini = 0;
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[maxi] < nums[nums.length - 1 - i]) {
	                maxi = nums.length - 1 - i;
	            }
	            if (nums[mini] > nums[i]) {
	                mini = i;
	            }
	        }
	        return (nums.length - 1 - maxi) + mini - (mini > maxi ? 1 : 0);
	    }

	public static void main(String[] args) {
		int a[] = { 3, 4, 5, 5, 3, 1 };
		System.out.println(minimumSwaps(a));
	}
}
