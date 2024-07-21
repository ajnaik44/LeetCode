package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class SubsetXORSum {
	public void generateSubSet(int[] nums, int index, List<List<Integer>> answer, List<Integer> list) {

		if (index == nums.length) {
			answer.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[index]);
		generateSubSet(nums, index + 1, answer, list);
		list.remove(list.size() - 1);

		generateSubSet(nums, index + 1, answer, list);

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3 };
		SubsetXORSum subsetXORSum = new SubsetXORSum();
		List<List<Integer>> answer = new ArrayList<>();
		subsetXORSum.generateSubSet(nums, 0, answer, new ArrayList<Integer>());
		System.out.println(answer);
	}
}
