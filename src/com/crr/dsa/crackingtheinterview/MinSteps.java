package com.crr.dsa.crackingtheinterview;

public class MinSteps {
	public static void main(String[] args) {
		MinSteps minSteps = new MinSteps();
		System.out.println(minSteps.minSteps("leetcode", "practice"));
	}
	public int minSteps(String s, String t) {
		int sArray[] = new int[26];
		int tArray[] = new int[26];

		for (char c : s.toCharArray()) {
			sArray[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			tArray[c - 'a']++;
		}

		int answer = 0;
		for (int i = 0; i < 26 ; i++) {
			int count = sArray[i];
			while (tArray[i] > 0 && count > 0) {
				tArray[i]--;
				count--;
			}

		}

		for (int i = 0; i < 26; i++) {
			answer += tArray[i];
		}
		return answer;
	}
}
