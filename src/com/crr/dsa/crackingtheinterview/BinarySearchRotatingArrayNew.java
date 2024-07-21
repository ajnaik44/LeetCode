package com.crr.dsa.crackingtheinterview;

public class BinarySearchRotatingArrayNew {
	public static void main(String[] args) {
		int[] nums= {1};
		BinarySearchRotatingArrayNew arrayNew = new BinarySearchRotatingArrayNew();
	//	arrayNew.rotateBinaryArray(nums);
		System.out.println(arrayNew.search(nums, 0));
	}
	public int search(int nums[],int target)
	{
		int left=0;
		int right =  nums.length-1;
		
		while(left<=right)
		{
			int mid =  left+(right-left)/2;
			if(nums[mid]==target)
				return mid;
			if(nums[mid]>nums[left])
			{
				if(target>=nums[left] &&  target<=nums[mid])
				{
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			else {
				if(mid+1 <=nums.length-1 &&  target>=nums[mid+1] &&  target<=nums[right])
				{
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
		}
		return -1;
	}
	public void rotateBinaryArray(int nums[])
	{
		int n =nums.length;
		
		while(! (nums[0]<nums[n-1]))
		{
			int temp =  nums[n-1];
			
			for(int i=n-1;i>=1;i--)
			{
				nums[i] =  nums[i-1];
			}
			nums[0]= temp;
		}
		
	}
	public int binarySearch(int nums[],int target)
	{
		int left=0;
		int right=nums.length-1;
		while(left<=right)
		{
			int mid=  left+(right-left)/2;
			if(nums[mid]==target)
				return mid;
			if(target>nums[mid])
				left =  mid+1;
			else
				right =  mid-1;
			
		}
	return -1;
	}
}
