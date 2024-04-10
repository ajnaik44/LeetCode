package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class MaxFrequency {

	public static void main(String[] args) {
		int nums[]= {0,4,6,7,8,9};
		System.out.println(new MaxFrequency().maxFrequencyOptimize(nums, 6));
	}
	
	    public int maxFrequency(int[] nums, int k) {
	    	Arrays.sort(nums);
	    	int lastIndex = 0;
	        while(k>0)
	        {
	            int smallestIndex =  findSmallestDiff( nums, k);
	            if(smallestIndex!=-1 && Math.abs(nums[smallestIndex] -  nums[smallestIndex+1]) <=k )
        		{
	            	k = k - Math.abs( nums[smallestIndex] -  nums[smallestIndex+1] );
	            	nums[smallestIndex] = nums[smallestIndex]+Math.abs(nums[smallestIndex] -  nums[smallestIndex+1]);
	            	lastIndex =  smallestIndex;
	            	
	            }else {
	            	break;
	            }
	           
	        }
	        int counter=1;
	        for(int i=lastIndex;i< nums.length-1;i++)
	        {
	        	if(nums[i]==nums[i+1])
	        		counter++;
	        }
	      
	       return counter;
	    }


	    public int findSmallestDiff(int [] nums,int remainingK)
	    {
	        if(remainingK<0)
	            return -1;
	        int min = Integer.MAX_VALUE;
	        int index = -1;
	        for(int i=1;i<nums.length;i++)
	        {
	            if(Math.abs(nums[i]-nums[i-1])!=0 &&   Math.abs(nums[i]-nums[i-1]) <min )
	            {
	                index = i-1;
	                System.out.println(i);
	                min = Math.abs(nums[i]-nums[i-1]);
	            }else {
	            	continue;
	            }
	        }
	        return index;
	    }
	   
	        public int maxFrequencyOptimize(int[] nums, int k) {
	            Arrays.sort(nums);
	            int left = 0;
	            long total = 0;
	            
	            for (int right = 0; right < nums.length; right++) {
	                int target = nums[right];
	                total += target;
	                int size = right - left + 1;
	                if (size * target - total > k) {
	                	total -= nums[left];
	                    left++;
	                }
	            }
	            
	            return nums.length - left;
	        }
	    
	
}
