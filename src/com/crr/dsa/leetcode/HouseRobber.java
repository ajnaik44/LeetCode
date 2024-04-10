package com.crr.dsa.leetcode;

import java.util.Arrays;

public class HouseRobber {
	  public int robAjay(int[] nums) {
		  if(nums==null ||  nums.length<=0)
			  return 0;
		  int res[] =  new int[nums.length+2];
		   res[2] =nums[0];  
		  for(int i=3;i<res.length;i++)
		  {
			  int leftone =  res[i-2]+  nums[i-2];
			  int lefttwo = res[i-3]+ nums[i-3];
			  res[i] = Math.max(leftone, lefttwo);
		  }
		  return res[res.length-1];
		  
		  
	    }
	  
	  
	  private int[] memo;
	    
	    public int robRecursion(int[] nums) {
	        
	        this.memo = new int[100];
	        
	        // Fill with sentinel value representing not-calculated recursions.
	        Arrays.fill(this.memo, -1);
	        
	        return this.robFrom(0, nums);
	    }
	    
	    private int robFrom(int i, int[] nums) {
	        
	        // No more houses left to examine.
	        if (i >= nums.length) {
	            return 0;
	        }
	        
	        // Return cached value.
	        if (this.memo[i] > -1) {
	            return this.memo[i];
	        }
	        
	        // Recursive relation evaluation to get the optimal answer.
	        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
	        
	        // Cache for future use.
	        this.memo[i] = ans;
	        return ans;
	    }
	    public int rob(int[] nums) {
	        
	        int N = nums.length;
	        
	        // Special handling for empty array case.
	        if (N == 0) {
	            return 0;
	        }
	        
	        int[] maxRobbedAmount = new int[nums.length + 1];
	        
	        // Base case initializations.
	        maxRobbedAmount[N] = 0;
	        maxRobbedAmount[N - 1] = nums[N - 1];
	        
	        // DP table calculations.
	        for (int i = N - 2; i >= 0; --i) {
	            
	            // Same as the recursive solution.
	            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
	        }
	        
	        return maxRobbedAmount[0];
	    }
	  public static void main(String[] args) {
		HouseRobber houseRobber = new HouseRobber();
		int []nums= new int[] {2,7,9,3,1};
		System.out.println(houseRobber.rob(nums));
	}
}
