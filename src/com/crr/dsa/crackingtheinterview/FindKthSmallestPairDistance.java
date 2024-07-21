package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
	public static void main(String[] args) {
		int nums [] = {1,6,1};
	FindKthSmallestPairDistance  distance = new FindKthSmallestPairDistance();
	System.out.println(distance.smallestDistancePair(nums, 3));
		
	}
	 public int smallestDistancePair(int[] nums, int k) {
	  Arrays.sort(nums);
	  int left =  0;
	  int right =  nums[nums.length-1] -  nums[0];
	  while(left<right)
	  {
		  int mid =  left+ ( right -left )/2;
		  boolean enough =  enough(nums, mid, k);
		  if(enough)
		  {
			  right = mid;
		  }
		  else {
			  left = mid+1;
		  }
	  }
	  return left;
	  
	  
	  }
	public boolean enough(int[]nums , int distance,int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        int n =  nums.length;

        while (i < n || j < n) {
        	
            while (j < n && nums[j] - nums[i] <= distance) {  // move fast pointer
                j++;
            }
            count += j - i - 1;  // count pairs
            i++;  // move slow pointer
        }

        return count >= k;
    }
}
