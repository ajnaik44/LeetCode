package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DifferenceofTwoArrays {
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> ans1 = new HashSet<>();
		Set<Integer> ans2 = new HashSet<>();
		
		for (int i = 0, j = nums1.length - 1; i < nums1.length && j >= 0; i++, j--) {
			boolean flag = true;
			boolean flag1 = true;

			for (int k = 0; k < nums2.length; k++) {
				if (nums1[i] == nums2[k]) {
					flag = false;
					ans2.add(nums2[k]);
				}
				if (nums1[j] == nums2[k]) {
					flag1 = false;
					ans2.add(nums2[k]);
				}

			}

			if (i == j) {
				if (flag && flag1) {
					ans1.add(nums1[i]);
				}
				break;
			}
			if (flag) {
				ans1.add(nums1[i]);
			}
			if (flag1) {
				ans1.add(nums1[j]);
			}
		}
		Set<Integer> ans3 = new HashSet<>();
		for (int b : nums2) {
			boolean flag = true;
			for (Integer a : ans2) {
				if (a == b) {
					flag = false;
				}
			}
			if (flag) {
				ans3.add(b);
			}
		}

		res.add(new ArrayList<>(ans1));
		res.add(new ArrayList<>(ans3));
		// Printing the elements
		
		return res;

	}

	public static List<List<Integer>> findDifference_1(int[] nums1, int[] nums2) {
		Set<Integer> setnum1 = new HashSet<>();
		Set<Integer> setnum2 = new HashSet<>();
		Set<Integer> common = new HashSet<>();
		for (int i : nums1) {
			setnum1.add(i);
		}
		for (int j : nums2) {

			setnum2.add(j);

		}
		for (int i : setnum2) {
			if (setnum1.contains(i)) {
				common.add(i);
			}
		}
		for (int i : common) {
			setnum1.remove(i);
			setnum2.remove(i);
		}

		return Arrays.asList(new ArrayList<>(setnum1), new ArrayList<>(setnum2));
	}
public static boolean uniqueOccurrences(int[] arr) {
        
	Map<Integer,Integer> map = new HashMap<>();
	
	for(int i:arr)
	{
		if(map.containsKey(i))
		{
			map.put(i, map.get(i)+1);
			
		}else {
			map.put(i, 1);
		}
	}
		Set set = new HashSet<>();
		for(int i:map.values())
		{
			if(set.contains(i))
			{
				return false;
			}
			set.add(i);
		}
	return true;
    }

	public static boolean closeStrings(String word1, String word2) {
	    Map<Character,Integer>  map1 = new HashMap<>();
	    Map<Character,Integer>  map2 = new HashMap<>();
	    for(char c:word1.toCharArray())
	    {
	    	map1.put(c, map1.getOrDefault(c, 0)+1);
	    }
	    
	    for(char c:word2.toCharArray())
	    {
	    	map2.put(c, map2.getOrDefault(c, 0)+1);
	    }
	    System.out.println(map1);
	    System.out.println(map2);
	    List<Integer> word1FrequencyList = new ArrayList<>(map1.values());
        List<Integer> word2FrequencyList = new ArrayList<>(map2.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
	    return map1.keySet().size() ==map2.keySet().size()  &&  map1.values().size() ==map2.values().size() &&  map1.keySet().containsAll(map2.keySet()) &&   word1FrequencyList.equals(word2FrequencyList);
	    
	}
	public static void main(String[] args) {
		int[] nums1 = { 1,2,2,1,1,3};
		int[] nums2 = { 1, 2,3,4,5,6,7,8 };
		/*
		 * List<List<Integer>> res = findDifference(nums1, nums2); for (List<Integer>
		 * innerList : res) { for (Integer value : innerList) { System.out.print(value +
		 * " "); } System.out.println(); // Move to the next line after printing each
		 * inner list }
		 */
		System.out.println(uniqueOccurrences(nums1));
		System.out.println(closeStrings( "aaabbbbccddeeeeefffff","aaaaabbcccdddeeeeffff"));
	}
}
