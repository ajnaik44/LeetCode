package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice3 {
	static String getShortestUniqueSubstring(char[] arr, String str) {

		Set<Character> set = new HashSet<Character>();

		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();

		for (char c : arr)
			set.add(c);
		if (set.isEmpty())
			return "";
		int left = 0;
		int right = left;
		int n = str.length();

		String result = "";
		while (right < n) {
			char c = str.charAt(right);
			if (set.contains(c)) {
				temp.put(c, temp.getOrDefault(c, 0) + 1);

			}

			if (temp.size() == set.size() || right == n - 1) {
				while (left < n && temp.size() == set.size() && set.equals(temp.keySet())) {

					System.out.println(temp);
					String res1 = str.substring(left, right + 1);
					if (result.isEmpty() || result.length() > right - left + 1) {
						result = res1;
					}

					char c1 = str.charAt(left);
					if (!temp.containsKey(c1)) {
						left++;
						continue;
					}
					temp.put(c1, temp.get(c1) - 1);
					if (temp.get(c1) == 0) {
						temp.remove(c1);
					}
					left++;
				}
				while (left < n) {
					if (!set.contains(str.charAt(left)))
						left++;
					break;
				}

			}

			right++;

		}

		return result;
	}

	public static int decode(int index, String s) {
		if (index == s.length()) {
			return 1;
		}
		if (s.charAt(index) == '0')
			return 0;

		if (index == s.length() - 1) {
			return 1;
		}
		int ans = decode(index + 1, s);
		if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			ans += decode(index + 2, s);
		}

		return ans;

	}
	 public static int numDecodings(String s) {
	        // DP array to store the subproblem results
	        int[] dp = new int[s.length() + 1];
	        dp[0] = 1;

	        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
	        // '0' doesn't have a single digit decode.
	        dp[1] = s.charAt(0) == '0' ? 0 : 1;

	        for (int i = 2; i < dp.length; i++) {
	            // Check if successful single digit decode is possible.
	            if (s.charAt(i - 1) != '0') {
	                dp[i] = dp[i - 1];
	            }

	            // Check if successful two digit decode is possible.
	            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
	            if (twoDigit >= 10 && twoDigit <= 26) {
	                dp[i] += dp[i - 2];
	            }
	        }

	        return dp[s.length()];
	    }
	public static void main(String[] args) {
		// System.out.println( getShortestUniqueSubstring( new char[] {'A','B','C'},
		// "ADOBECODEBANCDDD"));

		System.out.println(numDecodings( "1205"));
	}
}
