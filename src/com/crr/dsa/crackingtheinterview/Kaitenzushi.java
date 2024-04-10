package com.crr.dsa.crackingtheinterview;

import java.util.LinkedHashSet;

public class Kaitenzushi {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 3, 2, 1 };

		System.out.println(getMaximumEatenDishCount(6, nums, 2));
	}

	public static int getMaximumEatenDishCount(int N, int[] D, int K) {

		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			if (!set.contains(D[i])) {
				result++;
				set.add(D[i]);

				if (set.size() > K) {
					// Remove the oldest dish if the set exceeds the limit
					int oldest = i - K;
					// Since LinkedHashSet maintains insertion order,
					// the first element in the set will be the oldest.
					int oldestDish = set.iterator().next();
					set.remove(oldestDish);
				}
			}
		}

		return result;

	}
}