package com.crr.dsa.leetcode;

public class HighestAltitude {

	 public static  int largestAltitude(int[] a) {
	        int max=0;
	        int gainAlti = 0 + a[0];
	       max =  Math.max(gainAlti, max);
	        for(int i=1;i<a.length;i++)
	        {
	        	gainAlti = gainAlti + a[i];
	        	max =  Math.max(gainAlti, max);
	        }
	        return max;
	    }
	 
	 public static int pivotIndex(int[] nums) {
	      int left=0,right=0;
	      int leftSum=0,rightSum=0;
		 for(int i=0;i<nums.length;i++)
		 {
			 left = i-1;
			 right  = i+1;
			 while(left>=0)
			 {
				 leftSum +=  nums[left];
				 left--;
			 }
			
			 while(right<nums.length)
			 {
				 rightSum +=  nums[right];
				 right++;
			 }
			 if(leftSum==rightSum)
				 return i;
			  left=0;right=0;
		       leftSum=0;rightSum=0;
		 }
		return -1;
		 
	    }
	 public static int pivotIndex_1(int[] nums) {
	        int sum = 0, leftsum = 0;
	        for (int x: nums) sum += x;
	        for (int i = 0; i < nums.length; ++i) {
	            if (leftsum == sum - leftsum - nums[i]) return i;
	            leftsum += nums[i];
	        }
	        return -1;
	    }
	 public static void main(String[] args) {
		int  gain[] = {1,2,3};
		System.out.println(pivotIndex_1(gain));
	}
}
