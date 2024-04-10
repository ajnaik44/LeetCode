package com.crr.dsa.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
	public long maxScore(int[] nums1, int[] nums2, int k) {
        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Use a min-heap to maintain the top k elements.
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        
        // The score of the first k pairs.
        long answer = topKSum * pairs[k - 1][1];
        
        // Iterate over every nums2[i] as minimum from nums2.
        for (int i = k; i < n; ++i) {
            // Remove the smallest integer from the previous top k elements
            // then add nums1[i] to the top k elements.
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            
            // Update answer as the maximum score.
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        
        return answer;
    }
	public static void main(String[] args) {
	    int[] nums1 = {10,3,4,1,1};
	    int[] nums2 = {8,5,7,10,9};
	    int k = 2;
	    MaximumSubsequenceScore maximumSubsequenceScore = new MaximumSubsequenceScore();
	    long maxScore = maximumSubsequenceScore.maxScore(nums1, nums2, k);
	    
	    System.out.println("Maximum Score: " + maxScore);
	}

}
