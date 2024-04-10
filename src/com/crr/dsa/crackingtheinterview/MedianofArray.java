package com.crr.dsa.crackingtheinterview;

public class MedianofArray {
	public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    // Ensure nums1 is smaller or equal in size compared to nums2
	    if (nums1.length > nums2.length) {
	        return findMedianSortedArrays(nums2, nums1);
	    }

	    int x = nums1.length;
	    int y = nums2.length;

	    int low = 0;
	    int high = x;

	    while (low <= high) {
	        int partitionX = (low + high) / 2;
	        int partitionY = (x + y + 1) / 2 - partitionX;

	        // Finding elements on the left and right sides of the partitions
	        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
	        int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
	        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
	        int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

	        // Checking if we have found the correct partition
	        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
	            // If total number of elements is odd
	            if ((x + y) % 2 == 1) {
	                return (double) Math.max(maxLeftX, maxLeftY);
	            } else {
	                // If total number of elements is even
	                return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
	            }
	        } else if (maxLeftX > minRightY) {
	            // If we are too far on the right side, move left in partitionX
	            high = partitionX - 1;
	        } else {
	            // If we are too far on the left side, move right in partitionX
	            low = partitionX + 1;
	        }
	    }

	    // We should never reach here, but if we do, it indicates input arrays were not sorted.
	    throw new IllegalArgumentException();
	}
	public static void main(String[] args) {
		int[] num1 = {1, 3, 8, 9, 15,16};
		int[] num2= {7, 11, 18, 19, 21, 25};
		System.out.println(findMedianSortedArrays(num1,num2));
	}

}
