package com.crr.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TribonacciNumber {
	private Map<Integer, Integer> dp = new HashMap<>() ;
	public TribonacciNumber() {
		// TODO Auto-generated constructor stub
		
			dp.	put(0, 0);
			dp.	put(1, 1);
			dp.	put(2, 1);
		
	}

	private int dfs(int i) {
		if (dp.containsKey(i)) {
			return dp.get(i);
		}

		int answer = dfs(i - 1) + dfs(i - 2) + dfs(i - 3);
		dp.put(i, answer);
		return answer;
	}

	public int tribonacci(int n) {
		return dfs(n);
	}
	public static void main(String[] args) {
		TribonacciNumber tr = new TribonacciNumber();
		System.out.println(tr.tribonacci(25));
	}
}
