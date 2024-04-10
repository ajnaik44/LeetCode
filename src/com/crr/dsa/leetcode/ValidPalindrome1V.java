package com.crr.dsa.leetcode;

public class ValidPalindrome1V {

	public static void main(String[] args) {
		System.out.println(makePalindrome("abcdef"));
	}

	public static boolean makePalindrome(String s) {
		char[] ch = s.toCharArray();
		int swap = 1;
		for (int i = 0, j = ch.length - 1; j >= i; i++, j--) {
			if (ch[i] == ch[j])
				continue;
			else if (ch[i] != ch[j] & swap < 3) {

				ch[i] = ch[j];
				swap++;

			} else {
				return false;
			}
		}
		return true;
	}

}
