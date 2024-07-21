package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice {
	
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
		final List<String> answer = new ArrayList<>();
		for (final String word : words) {
			final int length = word.length();
			final boolean[] dp = new boolean[length + 1];
			dp[0] = true;
			for (int i = 1; i <= length; ++i) {
				for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
					dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
				}
			}
			if (dp[length]) {
				answer.add(word);
			}
		}
		return answer;
	}

	private static boolean dfs(final String word, int length, final boolean[] visited, final Set<String> dictionary) {
		if (length == word.length()) {
			return true;
		}
		if (visited[length]) {
			return false;
		}
		visited[length] = true;
		for (int i = word.length() - (length == 0 ? 1 : 0); i > length; --i) {
			if (dictionary.contains(word.substring(length, i)) && dfs(word, i, visited, dictionary)) {
				return true;
			}

		}
		return false;
	}

	public static List<String> findAllConcatenatedWordsInADictApproach1(String[] words) {
		final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
		final List<String> answer = new ArrayList<>();
		for (final String word : words) {
			final int length = word.length();
			final boolean[] visited = new boolean[length];
			if (dfs(word, 0, visited, dictionary)) {
				answer.add(word);
			}
		}
		return answer;
	}

	public int findSubstringInWraproundString(String s) {
		int dp[] = new int[s.length()];
		dp[s.length() - 1] = 1;
		int maxArray[] = new int[26];
		System.out.println(s.charAt(s.length() - 1) - 'a');
		maxArray[s.charAt(s.length() - 1) - 'a' + 26 % 26] = 1;
		for (int i = s.length() - 2; i >= 0; i--) {

			if (s.charAt(i) == s.charAt(i + 1) - 1 || s.charAt(i) == 'z' && s.charAt(i + 1) == 'a') {
				dp[i] = 1 + dp[i + 1];
			} else {
				dp[i] = 1;
			}
			int key = s.charAt(i) - 'a';
			System.out.println(key + "  " + s.charAt(i));
			maxArray[key] = Math.max(maxArray[key], dp[i]);
		}
		int res = 0;
		for (int i = 0; i < 26; i++) {
			res = res + maxArray[i];
		}
		return res;
	}

}
