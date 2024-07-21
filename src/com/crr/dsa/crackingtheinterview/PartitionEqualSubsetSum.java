package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class PartitionEqualSubsetSum 
{
	static Boolean  [][] array = null;
	public static void main(String[] args) {
	/*	int num[]= {1,5,11,5};
		array = new Boolean[num.length+1][12];
		System.out.println(dfs(num, 11, num.length-1));
		System.out.println("ddddddddd"); */
		int []nums = {1,1,1,1,1};
		int target = 3;
		System.out.println(new PartitionEqualSubsetSum().findTargetSumWaysApproach2(nums, 3));
		System.out.println("ddd");
	}
	public static boolean dfs(int num[],int target,int index)
	{
		if(index<0)
			return false;
		if(target<0)
			return false;
		if(array[index][target]!=null)
				return array[index][target];
		
		if(target==0)
			return true;
		array[index][target] =  dfs(num,target,index-1) ||  dfs(num,target-num[index],index-1);
		return array[index][target];
	}
	public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,nums.length-1,0);
        return totalExpression;
    }
    int totalExpression=0;
    public void dfs(int[]nums,int target,int index,int sum)
    {
    
        if(index<0)
            return;
   	 if(target==sum)
	        totalExpression++;
      
       
       dfs(nums,target , index-1, sum+nums[index]);
       dfs(nums,target, index-1, sum-nums[index]);
       
    }
 int total;
    
    public int findTargetSumWaysApproach2(int[] nums, int S) {
        total = Arrays.stream(nums).sum();
        
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int res =  calculate(nums, 0, 0, S, memo);
        return res;
    }
    
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[i][sum + total] != Integer.MIN_VALUE) {
                return memo[i][sum + total];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + total] = add + subtract;
            return memo[i][sum + total];
        }
    }
}
