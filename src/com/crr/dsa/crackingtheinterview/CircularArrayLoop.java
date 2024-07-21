package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class CircularArrayLoop {

	public boolean circularArrayLoop(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			float direction = Math.signum(nums[i]);
			int slow = i;
			int fast = i;

			do {
				slow = getNextIndex(nums, direction, slow);
				fast = getNextIndex(nums, direction, fast);

				if (fast != -1)
					fast = getNextIndex(nums, direction, fast);

			} while (slow != -1 && fast != -1 && slow != fast);

			if (slow != -1 && slow == fast)
				return true;
		}
		return false;
	}

	private int getNextIndex(int[] nums, float direction, int i) {
		float currentDirection = Math.signum(nums[i]);

		if (currentDirection * direction < 0)
			return -1;

		int n = nums.length;
		int nextIndex = (i + nums[i]) % n;

		if (nextIndex < 0)
			nextIndex += n;

		return nextIndex == i ? -1 : nextIndex;
	}

	public static void main(String[] args) {
		CircularArrayLoop solution = new CircularArrayLoop();
		int[] nums = { 2, -1, 1, 2, 2 };
		boolean result = solution.circularArrayLoop(nums);
		System.out.println("Does the array contain a circular loop   ?  " + result);
	}

}
