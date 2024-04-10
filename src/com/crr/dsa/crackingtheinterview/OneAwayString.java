package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class OneAwayString {

	public static boolean oneway(String str1, String str2) {
		Map<String, Integer> str1Map = new HashMap<>();
		for (char ch : str1.toCharArray()) {
			str1Map.put(String.valueOf(ch), str1Map.getOrDefault(String.valueOf(ch), 0) + 1);
		}

		for (char ch : str2.toCharArray()) {
			if (str1Map.containsKey(String.valueOf(ch)) && str1Map.get(String.valueOf(ch)) > 1) {
				str1Map.put(String.valueOf(ch), str1Map.get(String.valueOf(ch)) - 1);
			} else if (str1Map.containsKey(String.valueOf(ch)) && str1Map.get(String.valueOf(ch)) == 1) {
				str1Map.remove(String.valueOf(ch));
			}
		}
		System.out.println(str1Map);

		if (!str1Map.isEmpty() && (str1Map.size() > 1 || !str1Map.values().contains(1)))
			return false;
		return true;

	}
	static boolean oneEditAway(String first, String second) {
	    /* Length checks. */
	    if (Math.abs(first.length() - second.length()) > 1) {
	        return false;
	    }

	    /* Get shorter and longer string.*/
	    String sl = first.length() < second.length() ? first : second;
	    String s2 = first.length() < second.length() ? second : first;

	    int indexl = 0;
	    int index2 = 0;
	    boolean foundDifference = false;
	    while (index2 < s2.length() && indexl < sl.length()) {
	        if (sl.charAt(indexl) != s2.charAt(index2)) {
	            /* Ensure that this is the first difference found.*/
	            if (foundDifference) return false;
	            foundDifference = true;

	            if (sl.length() == s2.length()) { // On replace, move shorter pointer
	                indexl++;
	            }
	        } else {
	            indexl++; // If matching, move shorter pointer
	        }
	        index2++; // Always move pointer for longer string
	    }
	    return true;
	}


	public static void main(String[] args) {
		System.out.println(oneEditAway("pales", "pale"));
	}
}
