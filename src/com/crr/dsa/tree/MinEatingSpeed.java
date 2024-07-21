package com.crr.dsa.tree;

public class MinEatingSpeed {

	public static int mySqrt(int x) {
		if (x < 2)
			return x;

		long num;
		int pivot, left = 2, right = x / 2;
		while (left <= right) {
			pivot = left + (right - left) / 2;
			num = (long) pivot * pivot;
			if (num > x)
				right = pivot - 1;
			else if (num < x)
				left = pivot + 1;
			else
				return pivot;
		}

		return right;
	}
public static void main(String[] args) {
	System.out.println(mySqrt(8));
}
	public int minEatingSpeed(int piles[], int h) {
		int speed = 1;
		while (true) {

			int hourSpend = 0;

			for (int pile : piles) {
				hourSpend += Math.ceil(pile / speed);
				if (hourSpend > h)
					break;
			}
			if (hourSpend <= h)
				return hourSpend;
			speed++;
		}
	}
}
