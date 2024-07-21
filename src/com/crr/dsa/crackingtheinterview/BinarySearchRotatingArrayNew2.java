package com.crr.dsa.crackingtheinterview;

public class BinarySearchRotatingArrayNew2 {
	public static void main(String[] args) {
		int nums[] = { 3,4,5,1,2 };
		System.out.println(new BinarySearchRotatingArrayNew2().findMin(nums));
	}
	public int findMin(int[] nums) 
    {
       int n = nums.length;
        int left = 0, right = n - 1;

        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > nums[start]) {
				
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (nums[mid] < nums[start]) {
				if (target <= nums[end] && target > nums[mid])
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				start += 1;
			}
		}
		return false;
	}

	

}
