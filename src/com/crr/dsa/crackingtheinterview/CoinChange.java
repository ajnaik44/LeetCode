package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class CoinChange {

	static int[][] memo = null;
	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2,3 };
		int sum=5;
		 memo = new int[coins.length + 1][sum + 1];
		for (int i = 0; i <= coins.length; i++) {
	        for (int j = 0; j <= sum; j++) {
	            memo[i][j] = -1;
	        }
	    }
		 Arrays.sort(coins);
		System.out.println(backtracking(coins,5,coins.length-1));
		
		
		
		
	}
	public static int backtracking(int coins[],int amount,int index )
	{
	    if(amount==0)
	        return 0;
	    if(index<0)
	        return 0;
	    if(coins[index]> amount)
	    {
	        return backtracking(coins,amount,index-1);
	    }
	    return 1+backtracking(coins,amount - coins[index],index);
	    
	}
	public static int minimumNumberOfCoinsHelper(int coins[], int sum, int n) {
	    // Base cases
	    if (sum == 0) {
	        return 0; // If sum is 0, no coins are needed
	    }
	    if (n <= 0 || sum < 0) {
	        return Integer.MAX_VALUE; // Return a large value for invalid cases
	    }
	    
	    // If the result is already memoized, return it
	    if (memo[n][sum] != -1) {
	        return memo[n][sum];
	    }
	    
	    // If the current coin value is greater than the sum, skip it
	    if (coins[n - 1] > sum) {
	        return memo[n][sum] = minimumNumberOfCoinsHelper(coins, sum, n - 1);
	    }
	    
	    // Recursively find the minimum number of coins by either including or excluding the current coin
	    int include = 1 + minimumNumberOfCoinsHelper(coins, sum - coins[n - 1], n);
	    int exclude = minimumNumberOfCoinsHelper(coins, sum, n - 1);
	    
	    // Memoize the result and return
	    return memo[n][sum] = Math.min(include, exclude);
	}
	
}
