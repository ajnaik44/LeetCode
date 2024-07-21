package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class NumDecodings {
	int nWays = 0;
	int dp[];
	Map<Integer, Character> map = new HashMap<Integer, Character>();

	public void decodeAproach2(String s) {

		dp[0] = 1;

		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i - 1) != '0')
				dp[i] = dp[i - 1];

			int twoDigit = Integer.valueOf(s.substring(i - 2, i));
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}

		}

	}

	public static void main(String[] args) {
		System.out.println(new NumDecodings().numDecodings("03"));
	}

	public int numDecodings(String s) {
		dp = new int[s.length() + 1];
		for (char a = 'A'; a <= 'Z'; a++) {
			map.put(a - 'A' + 1, a);
		}
		decodeAproach2(s);
		return dp[s.length()];
	}

	public void decode(int index, String s) {

		if (index == s.length()) {
			nWays++;
			return;
		}

		for (int i = index; i < s.length(); i++) {
			String substr = s.substring(index, i + 1);
			if (isValid(substr)) {
				decode(i + 1, s);
			} else {
				break;
			}
		}

	}

	private boolean isValid(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return false;

		int num = Integer.parseInt(s);
		return num >= 1 && num <= 26;
	}
}
