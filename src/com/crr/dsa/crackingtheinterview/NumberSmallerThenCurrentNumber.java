package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class NumberSmallerThenCurrentNumber {
	 public int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] count = new int[101];
	        int n = nums.length;
	        
	        for (int i = 0; i < n; i++) {
	            count[nums[i]]++;
	        }
	        
	        for (int i = 1; i <= 100; i++) {
	            count[i] += count[i - 1];
	        }
	        
	        int[] result = new int[n];
	        
	        for (int i = 0; i < n; i++) {
	            if (nums[i] == 0) {
	                result[i] = 0;
	            } else {
	                result[i] = count[nums[i] - 1];
	            }
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
        // Example usage
        int[] nums = {8, 1, 2, 2, 3};
        NumberSmallerThenCurrentNumber main = new NumberSmallerThenCurrentNumber();
        int[] result = main.smallerNumbersThanCurrent(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Array of smaller numbers than current: " + Arrays.toString(result));
    }

}
