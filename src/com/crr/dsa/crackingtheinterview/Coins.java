package com.crr.dsa.crackingtheinterview;

public class Coins {
	int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) 
        	return 1; // last denom
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }
    
    int makeChange(int n) {
        int[] denoms = {2,5,1};
        return makeChange(n, denoms, 0);
    }

    public static void main(String[] args) {
    	Coins coinChange = new Coins();
        System.out.println("Number of ways to make change for  cents: " + coinChange.makeChange(7));
    }
}
