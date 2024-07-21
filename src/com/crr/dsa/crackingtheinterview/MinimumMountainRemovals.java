package com.crr.dsa.crackingtheinterview;

public class MinimumMountainRemovals {
	public static void main(String[] args) {
		MinimumMountainRemovals minimumMountainRemovals = new MinimumMountainRemovals();
		int nums[] = {2,1,1,5,6,2,3,1};
		int res = minimumMountainRemovals.minimumMountainRemovals(nums);
		System.out.println(res);
	}
	public int minimumMountainRemovals(int[] nums) {
		int mid = nums.length / 2;
		int len1 = dfsright(nums, mid, mid + 1);
		int len2 = dfsleft(nums, mid, mid - 1);
		System.out.println(mid);
		System.out.println(len1);
		System.out.println(len2);
		return len1 + len2;

	}

	public int dfsleft(int[] nums, int mid, int next) {
		if (next < 0 || mid < 0)
			return 0;

		if (nums[mid] > nums[next]) {
			return dfsleft(nums, mid - 1, next - 1);
		} else if (nums[mid] < nums[next]) {
			return 1 + dfsleft(nums, next , next - 1);
		} else {
			return 1 + dfsleft(nums, mid, next - 1);
		}

	}

	public int dfsright(int[] nums, int mid, int next) {

		if (next >= nums.length || mid >= nums.length)
			return 0;
		if (nums[mid] > nums[next]) {
			return dfsright(nums, mid + 1, next + 1);
		} else if (nums[mid] < nums[next]) {
			return 1 + dfsright(nums, next , next + 1);
		} else {
			return 1 + dfsright(nums, mid, next + 1);
		}

	}
}
