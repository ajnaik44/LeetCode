package com.crr.dsa.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
	 public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        for (int num: nums) {
	            heap.add(num);
	            if (heap.size() > k) {
	                heap.remove();
	            }
	        }
	        
	        return heap.peek();
	    }
	 public static void main(String[] args) {
	        int[] nums = {3,2,3,1,2,4,5,5,6}; // Example array
	        int k = 4; // Example value of k

	        // Create an instance of the class containing the findKthLargest method
	        KthLargestElementinanArray solution = new KthLargestElementinanArray();

	        // Call the findKthLargest method and print the result
	        int result = solution.findKthLargest(nums, k);
	        System.out.println("The " + k + "th largest element is: " + result);
	    }
}
