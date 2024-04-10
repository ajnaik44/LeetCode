package com.crr.dsa.crackingtheinterview;

public class FindDuplicates {
	public static void main(String[] args) {
		int [] nums= {1,3,4,2,2};
		int [] arr1 = {4,5,8};
		int[] arr2 = {10,9,1,8};
		int d = 2;
		System.out.println(findTheDistanceValue(arr1,arr2,d));
	}
	public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for (int i =0;i<arr1.length;i++){
            for (int j =0;j<arr2.length;j++){
                if (Math.abs(arr1[i]-arr2[j])<=d){
                   ans++;
                   break;
                }
            }
        }
        return (arr1.length-ans);
    }
	 public static int findDuplicate(int[] nums) {
	        
	        // Find the intersection point of the two runners.
	        int tortoise = nums[0];
	        int hare = nums[0];
	        
	        do {
	            tortoise = nums[tortoise];
	            hare = nums[nums[hare]];
	        } while (tortoise != hare);

	        // Find the "entrance" to the cycle.
	        tortoise = nums[0];
	        
	        while (tortoise != hare) {
	            tortoise = nums[tortoise];
	            hare = nums[hare];
	        }

	        return hare;
	    }
	
}
