package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {
	public static void main(String[] args) {
		int nums[] = { 3, 4, 16, 8 };
		LargestDivisibleSubset divisibleSubset = new LargestDivisibleSubset();
		System.out.println(divisibleSubset.largestDivisibleSubset(nums));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[i]);
			for (int j = 0; j < nums.length; j++) {
				if (i == j)
					continue;
				if (isMod(list, nums[j])) {
					list.add(nums[j]);
				}
			}
			if (list.size() > result.size())
				result = list;

		}
		return result;

	}

	public boolean isMod(List<Integer> list, int num) {
		for (int i : list) {
			if ( !(num % i == 0 ||  i%num==0)) {
				return false;
			}
		}
		return true;
	}
}
