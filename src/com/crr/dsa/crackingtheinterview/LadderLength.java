package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LadderLength {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.length() != endWord.length())
			return 0;
		Set<String> dict = new HashSet<String>(wordList);

		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.add(beginWord);
		visited.add(beginWord);

		int distance = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String word = queue.poll();

				if (word.equals(endWord))
					return distance;
				for (int i = 0; i < word.length(); i++) {
					char[] array = word.toCharArray();
					for (char j = 'a'; j <= 'z'; j++) {
						array[i] = j;
						String temp = new String(array);
						if (dict.contains(temp) &&  !visited.contains(temp)) {
							queue.add(temp);
							visited.add(temp);
						}
					}

				}

			}

		}
		return 0;

	}
	public static void main(String[] args) {
		
	}
}
