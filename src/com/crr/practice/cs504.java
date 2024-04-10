package com.crr.practice;

public class cs504 {
	public static void main(String[] args) {
		permutation("abcdefg");
	}

	static	void  permutation(String str) {
		permutation(str, "");
	}

	static void  permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}

}
