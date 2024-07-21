package com.crr.dsa.crackingtheinterview;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 0, 9 };
		int target = 10;
		int index = findPeakElement(nums);
		System.out.println(index);
	}

	public static int findPeakElement(int[] nums) {
		int left = 0;
		int right =  nums.length-1;
		while(left<right)
		{
			
			int mid =  left + (right-left)/2;
			if(mid-1>=0 &&  (nums[mid]< nums[mid+1]))
			{
				left=mid+1;
			}else {
				right = mid;
			}
		}
		return left;
		
	}

	public static int searchInsert(int nums[], int search) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == search)
				return mid;
			if (search < nums[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
