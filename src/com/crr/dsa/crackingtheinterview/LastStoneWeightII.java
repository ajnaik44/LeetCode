package com.crr.dsa.crackingtheinterview;

public class LastStoneWeightII {
	public static void main(String[] args) {
	
		int num[]= {31,26,33,21,40};
		System.out.println(lastStoneWeightII(num));
	}

	public static int lastStoneWeightII(int[] stones) {
		int n = stones.length;
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}

		boolean[] dp = new boolean[sum / 2 + 1];
		dp[0] = true;

		for (int i = 0; i < n; i++) {
			int stone = stones[i];
			for (int j = sum / 2; j >= stone; j--) {
				if (dp[j - stone]) {
					dp[j] = true;
				}
			}
		}

		int i = sum / 2;
		while (i >= 0 && !dp[i]) {
			i--;
		}

		return sum - 2 * i;
	}

}
