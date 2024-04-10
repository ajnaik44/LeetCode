package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TripleStep {
	static Map<Integer,Integer> totalStep =  new HashMap<>();
	public static void main(String[] args) {
		
		totalStep.put(1, 1);
		totalStep.put(-1, 0);
		totalStep.put(-2, 0);
		System.out.println(countWays(20));
		System.out.println(countWaysArray(20));
	}
	
	static int countWays(int n) {
		if (n < 0) {
			return 0;
		}else if(n==0)
			return 1;
		else if(totalStep.get(n)!=null)
			return totalStep.get(n);
		else {
			totalStep.put(n,    countWays(n - 1)+  countWays(n - 2) +countWays(n - 3)) ;
			return Math.abs(totalStep.get(n));
		}
	}
	static int countWaysArray(int n) {
	    int[] memo = new int[n + 1];
	    Arrays.fill(memo, -1);
	    return countWaysArray(n, memo);
	}

	static int countWaysArray(int n, int[] memo) {
	    if (n < 0) {
	        return 0;
	    } else if (n == 0) {
	        return 1;
	    } else if (memo[n] > -1) {
	        return memo[n];
	    } else {
	        memo[n] = countWaysArray(n - 1, memo) + countWaysArray(n - 2, memo) + countWaysArray(n - 3, memo);
	        return memo[n];
	    }
	}


}
