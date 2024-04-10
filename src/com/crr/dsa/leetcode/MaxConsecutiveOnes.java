package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnes {
	public static int longestOnes(int[] nums, int k) {
		//1,1,1,0,0,0,1,1,1,1,0 k=2
		int left = 0, right;
		for (right = 0; right < nums.length; right++) {
			// If we included a zero in the window we reduce the value of k.
			// Since k is the maximum zeros allowed in a window.
			if (nums[right] == 0) {
				k--;
			}
			// A negative k denotes we have consumed all allowed flips and window has
			// more than allowed zeros, thus increment left pointer by 1 to keep the window
			// size same.
			if (k < 0) {
				// If the left element to be thrown out is zero we increase k.
				k += 1 - nums[left];
				left++;
			}
		}
		return right - left;
	}

	public static int longestSubarray(int[] nums) {
		// Number of zero's in the window.
		int zeroCount = 0;
		int longestWindow = 0;
		// Left end of the window.
		int start = 0;

		for (int i = 0; i < nums.length; i++) {
			zeroCount += (nums[i] == 0 ? 1 : 0);

			// Shrink the window until the zero counts come under the limit.
			while (zeroCount > 1) {
				zeroCount -= (nums[start] == 0 ? 1 : 0);
				start++;
			}

			longestWindow = Math.max(longestWindow, i - start);
		}

		return longestWindow;
	}

	public static void main(String[] args) {
		int a[] = { 1,1,1,0,0,0,1,1,1,1,0 };
		System.out.println(longestOnes(a,2));

	}

}
