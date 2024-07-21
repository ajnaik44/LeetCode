package com.crr.dsa.crackingtheinterview;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reorganizestring {
	public static void main(String[] args) {
		Reorganizestring solution = new Reorganizestring();
		
		// Test case 1
		String s1 = "aab";
	//	System.out.println("Reorganized string for '" + s1 + "': " + solution.reorganizeStringAp1(s1)); // Output: "aba"

		// Test case 2
		String s2 = "aaab";
		 System.out.println("Reorganized string for '" + s2 + "': " +
		 solution.reorganizeStringAp1(s2)); // Output: ""

		// Test case 3
		String s3 = "aaabbc";
		System.out.println("Reorganized string for '" + s3 + "': " + solution.reorganizeString(s3)); // Output: "ababac"
	}

	public String reorganizeString(String s) {
		int[] charCounts = new int[26];
		for (char c : s.toCharArray()) {
			charCounts[c - 'a']++;
		}

		// Max heap ordered by character counts
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
		for (int i = 0; i < 26; i++) {
			if (charCounts[i] > 0) {
				pq.offer(new int[] { i + 'a', charCounts[i] });
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int[] first = pq.poll();
			if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
				sb.append((char) first[0]);
				if (--first[1] > 0) {
					pq.offer(first);
				}
			} else {
				if (pq.isEmpty()) {
					return "";
				}

				int[] second = pq.poll();
				sb.append((char) second[0]);
				if (--second[1] > 0) {
					pq.offer(second);
				}

				pq.offer(first);
			}
		}

		return sb.toString();
	}

	public String reorganizeStringAp1(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != entry.getKey()) {
				sb.append(entry.getKey());
				int count = entry.getValue();
				if (count - 1 > 0) {
					pq.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), count - 1));
				}
			} else {
				if (pq.isEmpty())
					return "";
				Map.Entry<Character, Integer> second = pq.poll();

				sb.append(second.getKey());

				int count = second.getValue();
				if (count - 1 > 0) {
					pq.offer(new AbstractMap.SimpleEntry<>(second.getKey(), count - 1));
				}

				pq.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
			}
		}
		return sb.toString();
	}

}
