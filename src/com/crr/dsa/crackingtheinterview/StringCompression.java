package com.crr.dsa.crackingtheinterview;

public class StringCompression {

	public static String stringCompress(String str) {
		if (str == null || str.length() < 1)
			return str;

		StringBuilder res = new StringBuilder();
		int counter = 1;
		char ch = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				counter++;
			else {
				res.append(ch + "" + counter);
				ch = str.charAt(i);
				counter = 1;
			}
		}
		if (ch == str.charAt(str.length() - 1)) {
			res.append(ch + "" + (counter));
		} else {
			res.append(ch + "" + counter);
			res.append(str.length() - 1 + "" + 1);
		}

		return res.length() > str.length() ? str : res.toString();
	}

	public static void main(String[] args) {
		System.out.println(stringCompress("aaaabbb"));
	}
}
