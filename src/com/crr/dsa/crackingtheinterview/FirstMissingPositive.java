package com.crr.dsa.crackingtheinterview;

public class FirstMissingPositive {
	 public int firstMissingPositive(int[] nums) {
	       int n=nums.length;
	       int i=0;
	       while(i<n)
	       {
	        int correctId =  nums[i]-1;
	        if(nums[i]>0 &&  nums[i]<n && nums[i]!=nums[correctId])
	        {
	             swap(nums, i, correctId);
	        }else{
	            i++;
	        }
	       }
	       for(i=0;i<n;i++)
	       {
	        if(nums[i]!=i+1)
	            return i+1;
	       }
	       return n+1; 
	    
	    }
	    // Swaps two elements in nums
	    private void swap(int[] nums, int index1, int index2) {
	        int temp = nums[index1];
	        nums[index1] = nums[index2];
	        nums[index2] = temp;
	    }
	    public static void main(String[] args) {
			int nums[]= {7,8,9,11,12};
			System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
		}
}
