package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Bogglefindpossiblewordsboard_MySolution {

	static class Index {
		int row;
		int col;

		public Index(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GU" };
	static final int n = dictionary.length;
	static final int M = 2, N = 2;

	static HashMap<String, HashMap<Character, Integer>> dictoryMap = new HashMap<String, HashMap<Character, Integer>>();

	static HashMap<Character, HashMap<Integer, ArrayList<Index>>> boggleMap = new HashMap<Character, HashMap<Integer, ArrayList<Index>>>();

	// Driver program to test above function
	public static void main(String args[]) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

		System.out.println("Following words of dictionary are present");
		initializeDictionaryMap();
		initializeBoggleyMap(boggle);
		for (String word : dictionary) {
			HashMap<Integer, ArrayList<Index>> characDetails = boggleMap.get(word.charAt(0));
			if (characDetails != null) {
				for (Map.Entry<Integer, ArrayList<Index>> temp : characDetails.entrySet()) {
					ArrayList<Index> list = temp.getValue();
					for (Index index : list) {
						if (checkWordIsValid(boggle, word, index))
							System.out.println(word);
					}
				}
			}

		}
		// findWords(boggle);
	}

	public static void initializeDictionaryMap() {
		for (String word : dictionary) {
			HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
			for (char ch : word.toCharArray()) {
				wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
			}
			dictoryMap.put(word, wordMap);
		}
	}

	public static void initializeBoggleyMap(char boggle[][]) {
		for (int row = 0; row < boggle.length; row++) {
			for (int col = 0; col < boggle[0].length; col++) {
				Index index = new Index(row, col);

				if (boggleMap.get(boggle[row][col]) == null) {
					HashMap<Integer, ArrayList<Index>> boggleIndexClass = new HashMap<Integer, ArrayList<Index>>();
					ArrayList<Index> indexArray = new ArrayList<>();
					indexArray.add(index);
					boggleIndexClass.put(1, indexArray);

					boggleMap.put(boggle[row][col], boggleIndexClass);
				} else {
					HashMap<Integer, ArrayList<Index>> boggleIndexClass = boggleMap.get(boggle[row][col]);
					Integer value = null;
					ArrayList<Index> indexArray = null;

					for (Map.Entry<Integer, ArrayList<Index>> temp : boggleIndexClass.entrySet()) {
						value = temp.getKey();
						indexArray = temp.getValue();
						break; // Exit loop after processing the first entry
					}
					indexArray.add(index);
					boggleIndexClass.clear();
					boggleIndexClass.put(value + 1, indexArray);
					boggleMap.put(boggle[row][col], boggleIndexClass);
				}
			}
		}
	}

	public static boolean isValidWord(String word) {

		HashMap<Character, Integer> wordMap = dictoryMap.get(word);
		for (Entry<Character, Integer> wordCount : wordMap.entrySet()) {
			Character key = wordCount.getKey();
			Integer value = wordCount.getValue();
			if (boggleMap.get(key) == null)
				return false;
			HashMap<Integer, ArrayList<Index>> boggleIndexClass = boggleMap.get(key);
			for (Map.Entry<Integer, ArrayList<Index>> temp : boggleIndexClass.entrySet()) {
				if (temp.getKey() != value)
					return false;
			}
		}
		return true;
	}

	public static Index checkCurrentCharacter(char[][] booble, Index startingPoint, Character ch) {
		int[][] iterator = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

		for (int[] cell : iterator) {
			int row = cell[0] + startingPoint.row;
			int col = cell[1] + startingPoint.col;
			if (row >= 0 && col >= 0 && row < booble.length && col < booble[0].length)
				if (booble[row][col] == ch) {
					return new Index(row, col);
				}
		}
		return null;
	}

	public static boolean checkWordIsValid(char[][] booble, String word, Index startIndex) {
		for (int i = 1; i < word.length(); i++) {
			startIndex = checkCurrentCharacter(booble, startIndex, word.charAt(i));
			if (startIndex == null)
				return false;

		}
		return true;
	}
}
