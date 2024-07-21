package com.crr.dsa.crackingtheinterview;

public class WildMatching {

	Boolean[][] memo = null;

	public static void main(String[] args) {
		WildMatching matching = new WildMatching();
		System.out.println(matching.isMatch("aab","c*a*b"));
	}
	public boolean isMatch(String s, String p) {
		memo = new Boolean[s.length()][p.length()];
		return finding(s, p, s.length() - 1, p.length() - 1);
	}

	boolean finding(String s, String p, int n, int m) {
		// return true if n and m are negative
		if (n < 0 && m < 0)
			return true;

		// return false if m is negative
		if (m < 0)
			return false;

		// return n if n is negative
		if (n < 0) {
			// while m is positive
			while (m >= 0) {
				if (p.charAt(m) != '*')
					return false;
				m--;
			}
			return true;
		}
		if (memo[n][m] != null)
			return memo[n][m];

		if (p.charAt(m) == '*') {
			return memo[n][m] = (finding(s, p, n - 1, m) || finding(s, p, n, m - 1));

		} else {
			if (p.charAt(m) != s.charAt(n) && p.charAt(m) != '?') {
				memo[n][m] = false;
				return false;
			} else {
				return memo[n][m] = (finding(s, p, n - 1, m - 1));

			}
		}

	}

}
