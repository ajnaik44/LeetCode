package com.crr.dsa.crackingtheinterview;

public class CanJump {
	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
		return dfs(nums, 0);
	}

	public boolean dfs(int[] nums, int index) {

		if (index >= nums.length - 1)
			return true;

		int current = nums[index];
		while (current >= 1) {
			boolean res = dfs(nums, index + current);
			if (res)
				return true;
			current--;
		}
		return false;
	}

	public int jump(int[] nums) {
		// The starting range of the first jump is [0, 0]
		int answer = 0, n = nums.length;
		int curEnd = 0, curFar = 0;

		for (int i = 0; i < n - 1; ++i) {
			// Update the farthest reachable index of this jump.
			curFar = Math.max(curFar, i + nums[i]);

			// If we finish the starting range of this jump,
			// Move on to the starting range of the next jump.
			if (i == curEnd) {
				answer++;
				curEnd = curFar;
			}
		}

		return answer;
	}

	int ans = 0;

	public int jump2(int[] nums) {
		int i = 0;
		while (i < nums.length - 1) {
			i = helper(i, nums[i], nums);

		}
		return ans;
	}

	public int helper(int a, int b, int[] nums) {
		ans++;
		if (a + b >= nums.length - 1) {
			return nums.length;
		}
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = a; i <= a + b; i++) {
			if (nums[i] + i >= max) {
				temp = i;
				max = nums[i] + i;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println(canJump.jump2(nums));
	}
}
