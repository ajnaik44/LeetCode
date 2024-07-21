package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestWordEditPath {
	static int shortestWordEditPath(String source, String target, String[] words) {
		
		if (source.length() != target.length())
			return -1;
		List<String> wordList = new ArrayList<String>();
		wordList.add(source);
		
		boolean isDest = false;
		for (String temp : words) {
			if (temp.equals(target)) {
				isDest = true;
			}

			wordList.add(temp);
		}
		if (!isDest)
			return -1;

		Map<String, Set<String>> graph = populateAdj(wordList);

		
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();

		queue.add(source);// bit
		visited.add(source);
		int result = 0;

		System.out.println(graph);
		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;

			for (int i = 0; i < size; i++) {
				String nextNode = queue.poll();
				if (graph.get(nextNode).contains(target)) {
					return result;
				}

				for (String wrd : graph.get(nextNode)) {
					if (!visited.contains(wrd)) {

						queue.add(wrd);
						visited.add(wrd);
					}

				}
			}

			// 2

		}

		return result;

	}

	public static void main(String[] args) {
		String[] words = { "but", "put", "big", "pot", "pog", "dog", "lot" };
		int res = shortestWordEditPath("bit", "dog", words);
		System.out.println(res);
	}

	public static Map<String, Set<String>> populateAdj(List<String> words) {
		Map<String, Set<String>> graph = new HashMap<>();

		for (int i = 0; i < words.size(); i++) {

			for (int j = i + 1; j < words.size(); j++) {

				if (difference(words.get(i), words.get(j))) {

					if (!graph.containsKey(words.get(i)))
						graph.put(words.get(i), new HashSet<String>());
					graph.get(words.get(i)).add(words.get(j));

					if (!graph.containsKey(words.get(j)))
						graph.put(words.get(j), new HashSet<String>());
					graph.get(words.get(j)).add(words.get(i));

					// graph.putIfAbsent(words.get(i), new HashSet<String>()).add(words.get(j));
					// graph.putIfAbsent(words.get(j), new HashSet<String>()).add(words.get(i));

				}

			}

		}
		return graph;

	}

	public static boolean difference(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int difference = 0;
		int i = 0;
		while (i < str1.length()) {
			if (str1.charAt(i) != str2.charAt(i)) {
				difference++;
			}
			i++;

		}

		return difference == 1;

	}

}
