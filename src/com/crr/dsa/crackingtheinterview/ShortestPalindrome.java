package com.crr.dsa.crackingtheinterview;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		String sb = new StringBuilder(s).reverse().toString();
		StringBuilder result = new StringBuilder();
		int left = 0, right = 0;
		while (left < s.length() && right < sb.length()) {
			if (s.charAt(left) == sb.charAt(right)) {
				result.append(s.charAt(left));
				left++;

			} else if (s.charAt(left) != sb.charAt(right)) {
				result.append(sb.charAt(right));

			}
			right++;
		}

		if (left < s.length()) {
			result.append(s.substring(left));

		}
		return result.toString();
	}

	public static void main(String[] args) {
		ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
		System.out.println(shortestPalindrome.shortestPalindrome("adcba"));
	}
}
