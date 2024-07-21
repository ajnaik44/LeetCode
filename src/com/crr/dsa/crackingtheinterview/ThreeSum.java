package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		int sSkip = 0;
		int tSkip = 0;

		while (i >= 0 && j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					sSkip++;
					i--;
				} else if (sSkip > 0) {
					sSkip--;
					i--;
				} else {
					break;
				}
			}
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					tSkip++;
					j--;
				} else if (tSkip > 0) {
					tSkip--;
					j--;
				} else {
					break;
				}
			}
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
				return false;
			}
			if ((i >= 0) != (j >= 0)) {
				return false;
			}
			i--;
			j--;
		}

		return true;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> triplets = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < n - 2; i++) {
			// Skip duplicate triplets
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1, right = n - 1;

			while (left < right) {
				int total = nums[i] + nums[left] + nums[right];

				if (total == 0) {
					triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// Skip duplicate elements
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (total < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return triplets;
	}

	public static void main(String[] args) {
		ThreeSum solution = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = solution.threeSumApproach1(nums);
		// System.out.println(result); // Output: [[-1, -1, 2], [-1, 0, 1]]
		// StringBuilder sb = new StringBuilder();
		// sb.deleteCharAt(sb.length()-1);

		System.out.println(Math.abs(1 - -4));
		System.out.println(Math.abs(1 - -3));
		int[][] matrix = { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
		largestLocal(matrix);
		// shuffle(nums,3);
		System.out.println(new ThreeSum().backspaceCompare("ab#c", "ad#c"));
	}

	public static int removeDuplicates(int[] nums) {
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] shuffled = new int[nums.length];
		for (int i = 0; i < n; i++) {
			shuffled[2 * i] = nums[i];
			shuffled[2 * i + 1] = nums[i + n];
		}
		return shuffled;
	}

	public static int[][] largestLocal(int[][] grid) {
		int maxLocal[][] = new int[grid.length - 2][grid[0].length - 2];

		for (int row = 0; row < grid.length - 2; row++) {
			for (int col = 0; col < grid[0].length - 2; col++) {
				int max = Integer.MIN_VALUE;

				// Traverse the 3x3 submatrix
				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						max = Math.max(max, grid[i][j]);
					}
				}

				maxLocal[row][col] = max;
			}
		}

		return maxLocal;
	}

	public List<List<Integer>> threeSumApproach1(int[] nums) {

		Set<List<Integer>> res = new HashSet();

		Set<Integer> dups = new HashSet<Integer>();

		Map<Integer, Integer> seen = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) == i) {
						List<Integer> tri = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(tri);
						res.add(tri);
					}
					seen.put(nums[j], i);
				}
			}
		}
		return new ArrayList(res);

	}

}
