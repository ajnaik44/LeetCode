package com.crr.dsa.tree;

public class SortColors {
	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int nums[]= {2,0,2,1,1,0};
		sortColors.sortColors(nums);
	}
	public void sortColors(int[] nums) {
        int left=0;
        int right =  nums.length-1;
        int current=0;
        while(left<right)
        {
            while(nums[left]==0)
            { left++;
            }
            while(nums[right]!=0)
            {
                right--;
            }
            if(left<right) {
	            int temp =  nums[left];
	            nums[left] =  nums[right];
	            nums[right] = temp;
            }
            
        }
        right =  nums.length-1;
        while(left<right)
        {
            while(nums[left]==1)
            { left++;
            }
            while(nums[right]!=1)
            {
                right--;
            }
            if(left<right) {
	            int temp =  nums[left];
	            nums[left] =  nums[right];
	            nums[right] = temp;
            }
            
        }
    }
}
