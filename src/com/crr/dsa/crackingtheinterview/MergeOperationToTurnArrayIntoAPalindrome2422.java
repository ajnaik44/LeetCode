package com.crr.dsa.crackingtheinterview;

public class MergeOperationToTurnArrayIntoAPalindrome2422 {
public static void main(String[] args) {
	int[] data = {3371976,23421,3300450};
	System.out.println(minSwapsSolution1(data));
}
	public static int minSwapsSolution1(int[] nums) {
		int operation= 0 ;
		int left=0;int right= nums.length-1;
		while(right>=left)
		{
			System.out.println(" left " +  left  + "   right" + right);
			for(int i:nums)
			{
				System.out.print(i + " ");
			}
			System.out.println();
			if(nums[left]==nums[right])
			{
				left++;
				right--;
			}
			else if(nums[left]>  nums[right])
			{
				
					nums[right-1] =  nums[right]+nums[right-1];
					nums[right]=0;
					right=right-1;
					
					operation++;
				
			}
			else if(nums[right]> nums[left])
			{
				
					nums[left+1] =  nums[left]+nums[left+1];
					nums[left]=0;
					left=  left+1;
			
					operation++;
				
			}
		}
		for(int i:nums)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		return operation;
	}
}
