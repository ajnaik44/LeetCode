package com.crr.dsa.leetcode;

import java.util.Map;
import java.util.stream.Collectors;

public class Amazon2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("1233"));
	}
	public static long solve(String s) {
	    Map<Character, Integer> freq = s.chars().mapToObj(i -> (char) i)
	                                        .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
	    long ans = 1L * s.length() * (s.length() - 1) / 2 + 1;
	    for (Integer v : freq.values()) { 
	        ans -= 1L * v * (v - 1) / 2;
	    }
	    return ans;
	}


}
