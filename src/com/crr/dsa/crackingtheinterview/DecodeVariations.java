package com.crr.dsa.crackingtheinterview;

public class DecodeVariations {
	static int decodeVariations(String S) {

		numberOfWays(S, 0);
		return numways;

	}

	static int numways = 0;

	public static void numberOfWays(String s, int index) {
		if (index >= s.length()) {
			numways++;
			return;
		}
		if (s.charAt(index) == '0') {
			numways = 0;
			return;
		}
		numberOfWays(s, index + 1);
		if (index + 1 < s.length()) {
			Integer number = Integer.valueOf(s.substring(index, index + 2));
			if (number >= 1 && number <= 26)
				numberOfWays(s, index + 2);

		}
	}

	public static void main(String[] args) {
		System.out.println(decodeVariations("8254779486"));
	}
}
