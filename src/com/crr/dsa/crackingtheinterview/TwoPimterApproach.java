package com.crr.dsa.crackingtheinterview;

public class TwoPimterApproach {

	public void allEqualsToK(int nums[],int k)
	{
		int left=0,right=nums.length-1;
		while(left<right)
		{
			if(nums[left]+nums[right]==k)
			{
				System.out.println(left +  " " +  right );
			}
			if(nums[left]+nums[right] >  k)
			{
				right--;
			}else {
				left++;
			}
		}
	}
	public static void main(String[] args) {
		int num[]= {1,2,3,4,6};
		new TwoPimterApproach().allEqualsToK(num, 6);
	}
}
