package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
	}
	  public static int lengthOfLongestSubstring(String s) {
	        int left = 0;
	        int maxLength = 0;
	        HashSet<Character> charSet = new HashSet<>();

	        for (int right = 0; right < s.length(); right++) {
	            while (charSet.contains(s.charAt(right))) {
	                charSet.remove(s.charAt(left));
	                left++;
	            }

	            charSet.add(s.charAt(right));
	            maxLength = Math.max(maxLength, right - left + 1);
	        }

	        return maxLength;       
	    }
}
