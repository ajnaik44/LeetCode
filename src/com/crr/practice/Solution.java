package com.crr.practice;

import java.util.Arrays;



class Solution {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int c : coins) {
            for (int i = c; i < dp.length; i++) {
                if (dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
    
    public static void main(String[] args) {
        int[] a = { 1,2,5};
        System.out.println(coinChange(a, 11));
        int[] b = {2};
        System.out.println(coinChange(b, 3));
        int[] c = { 1};
        System.out.println(coinChange(c, 0));
    }
}
