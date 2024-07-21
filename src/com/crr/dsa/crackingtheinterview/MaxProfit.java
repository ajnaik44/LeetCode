package com.crr.dsa.crackingtheinterview;

public class MaxProfit {
	public static void main(String[] args) {
		int num[] = { 7, 1, 5, 3, 6, 4 };
		MaxProfit maxProfit = new MaxProfit();
		System.out.println(maxProfit.maxProfitApproach1(num));
	}

	public int maxProfit(int[] prices) {
		return calculate(prices, 0);
	}

	public int maxProfitApproach1(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}

	public int calculate(int prices[], int s) {
		if (s >= prices.length)
			return 0;
		int max = 0;
		for (int start = s; start < prices.length; start++) {
			int maxprofit = 0;
			for (int i = start + 1; i < prices.length; i++) {
				if (prices[start] < prices[i]) {
					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
					if (profit > maxprofit)
						maxprofit = profit;
				}
			}
			if (maxprofit > max)
				max = maxprofit;
		}
		return max;
	}

}
