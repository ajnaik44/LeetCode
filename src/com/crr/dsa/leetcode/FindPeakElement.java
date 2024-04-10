package com.crr.dsa.leetcode;

import java.util.Arrays;

public class FindPeakElement {
	public int findPeakElementAjay(int[] nums) {
		int array[][] = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			array[i][0] = nums[i];
			array[i][1] = i;
		}
		Arrays.sort(array, (a, b) -> a[0] - b[0]);
		return array[nums.length - 1][1];

	}

	public int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	public int search(int[] nums, int l, int r) {
		if (l == r)
			return l;
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
			return search(nums, l, mid);
		return search(nums, mid + 1, r);
	}

	public static void main(String[] args) {
		FindPeakElement findPeakElement = new FindPeakElement();
		int array[] = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeakElement.findPeakElement(array));
	}

}
