package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CanPartition {

	public int numberOfSubSet(int num[],int index,int sum)
	{
		if(sum==0)
			return 1;
		if(sum<0)
			return 0;
		if(index>=num.length)
			return 0;
		return numberOfSubSet(num, index+1, sum-num[index])+ numberOfSubSet(num, index+1, sum);
		
		
	}
	public boolean canPartitionMemo(int[] nums) {
		int totalSum = 0;
		// find sum of all array elements
		for (int num : nums) {
			totalSum += num;
		}
		// if totalSum is odd, it cannot be partitioned into equal sum subset
		if (totalSum % 2 != 0)
			return false;
		int subSetSum = totalSum / 2;
		int n = nums.length;
		Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
		return dfs(nums, n - 1, subSetSum, memo);
	}

	public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
		// Base Cases
		if (subSetSum == 0)
			return true;
		if (n == 0 || subSetSum < 0)
			return false;
		// check if subSetSum for given n is already computed and stored in memo
		if (memo[n][subSetSum] != null)
			return memo[n][subSetSum];
		System.out.println(subSetSum - nums[n - 1]);
		boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) || dfs(nums, n - 1, subSetSum, memo);
		// store the result in memo
		memo[n][subSetSum] = result;
		return result;
	}

	public boolean canPartitionApproach1(int[] nums) {
		int totalSum = 0;

		for (int i : nums)
			totalSum += i;
		if (totalSum % 2 != 0)
			return false;
		int target = totalSum / 2;
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);

		int right = nums.length - 1;
		while (right >= 0) {
			Set<Integer> nextSet = new HashSet<Integer>(set);
			for (int i : set) {
				nextSet.add(i + nums[right]);
			}
			set = nextSet;
			right--;

		}

		return set.contains(target);

	}

	public boolean canPartition(int[] nums) {
		Arrays.sort(nums);

		int totalSum = 0;

		for (int i : nums)
			totalSum += i;

		Stack<Integer> stack = new Stack<Integer>();
		int partitumSum = totalSum / 2;

		int firstHalfSum = 0;
		int secondHalf = 0;

		int right = nums.length - 1;
		while (right >= 0 && firstHalfSum != partitumSum) {
			if (firstHalfSum < partitumSum) {
				firstHalfSum += nums[right];
				stack.add(right);
			} else {
				while (!stack.isEmpty() && firstHalfSum > partitumSum) {
					firstHalfSum -= nums[stack.pop()];
				}
				firstHalfSum += nums[right];
				stack.add(right);
			}
			right--;
		}
		right = nums.length - 1;
		while (right >= 0) {
			if (!stack.contains(right)) {
				secondHalf += nums[right];
			}
			right--;
		}
		System.out.println(" secondHalf  " + secondHalf + " firstHalfSum " + firstHalfSum);
		return secondHalf == firstHalfSum;

	}
	public boolean canPartitionApproach2(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        
        
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
            }
        }
        return dp[n][subSetSum];
    }
	public static void main(String[] args) {
		int nums[] = { 1,1,1,1 };
		System.out.println(new CanPartition().canPartitionMemo(nums));
	}
}
