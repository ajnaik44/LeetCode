package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoveZeros {
	public static void moveZeroesMYLogic(int[] nums) {
		int counter = 0;
		;
		for (int i = 0; i < nums.length;) {
			if (nums[i] == 0) {
				counter++;
				for (int k = i; k < nums.length - 1; k++) {
					int tmp = nums[k];
					nums[k] = nums[k + 1];
					nums[k + 1] = tmp;
				}
				if (counter > nums.length)
					return;

			} else {
				counter = 0;
				i++;
			}
		}

	}

	public static void moveZeroes(int[] nums) {
		int counter = 0;
		;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[counter] = nums[i];
				counter++;
			}
		}
		while (counter < nums.length) {
			nums[counter] = 0;
			counter++;
		}

	}

	public static boolean isSubsequence(String s, String t) {
		int sIndex = 0;
		int tIndex = 0;

		while (sIndex < s.length() && tIndex < t.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
			}
			tIndex++;
		}

		return sIndex == s.length();
	}

	public static Map<String, Integer> checkCountGreaterThenTwo(String t) {
		HashMap<String, Integer> map = new HashMap<>();
		for (Character c : t.toCharArray()) {
			if (map.containsKey(c.toString())) {
				map.put(c.toString(), map.get(c.toString()) + 1);
			} else {
				map.put(c.toString(), 1);
			}

		}
		return map;
	}

	public static int maxArea(int[] height) {
		int maxarea = 0;
		for (int left = 0; left < height.length; left++) {
			for (int right = left + 1; right < height.length; right++) {
				int width = right - left;
				int current = Math.min(height[left], height[right]);
				maxarea = Math.max(maxarea, current * width);
			}
		}
		return maxarea;
	}

	public static int maxAreaEff(int[] height) {
		int maxarea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int width = right - left;
			maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxarea;
	}

	public static int maxOperations(int[] nums, int k) {
		int maxOp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == 0)
					continue;
				if (nums[i] + nums[j] == k) {
					nums[i] = 0;
					nums[j] = 0;
					maxOp++;
					break;
				}

			}
		}
		return maxOp;
	}

	public static int maxOperationsEff(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // build the hashmap with count of occurence of every element in array
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - nums[i];
            if (map.getOrDefault(current, 0) > 0
                    && map.getOrDefault(complement, 0) > 0) {
                if ((current == complement) && map.get(current) < 2)
                    continue;
                map.put(current, map.get(current) - 1);
                map.put(complement, map.get(complement) - 1);
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int a[] = { 3, 1, 3, 4, 3, 2, 4};
		moveZeroes(a);
		/*
		 * for (int i : a) { System.out.print(i + " "); }
		 */
		System.out.println(isSubsequence("ab", "baab"));
		System.out.println(maxOperationsEff(a, 6));

	}
}
