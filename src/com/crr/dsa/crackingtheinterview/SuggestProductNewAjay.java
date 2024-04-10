package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuggestProductNewAjay {

	List<List<String>> result = new ArrayList();

	class SuggestProductTrie {
		Map<Character, SuggestProductTrie> child = new HashMap<Character, SuggestProductTrie>();
		String word;

		public SuggestProductTrie() {
			// TODO Auto-generated constructor stub
		}
	}

	public List<List<String>> searchWords(String arr[], String searchWord) {
		SuggestProductTrie root = new SuggestProductTrie();

		for (String word : arr) {
			SuggestProductTrie current = root;
			for (char c : word.toCharArray()) {
				if (current.child.containsKey(c)) {
					current = current.child.get(c);
				} else {
					SuggestProductTrie newNode = new SuggestProductTrie();
					current.child.put(c, newNode);
					current = current.child.get(c);
				}
			}
			current.word = word;
		}

		String prefix = "";
		for (char c : searchWord.toCharArray()) {
			prefix += c;

			search(prefix, root);
		}

		return this.result;
	}

	private void search(String prefix, SuggestProductTrie root) {
		SuggestProductTrie current = root;
		for (char c : prefix.toCharArray()) {
			if (!current.child.containsKey(c)) {
				return;
			}
			current = current.child.get(c);

		}
		List<String> list = new ArrayList<String>();
		backtracking(current, list);
		result.add(list);
	}

	private void backtracking(SuggestProductTrie current, List<String> list) {
		if (list.size() == 3) {

			System.out.println("result size");
			return;
		}
		if (current.word != null) {
			System.out.println(current.word);
			list.add(current.word);
		}

		for (char c = 'a'; c <= 'z'; c++) {
			if (current.child.get(c) != null) {
				backtracking(current.child.get(c), list);

			}
		}

	}

	public static void main(String[] args) {
		String arr[] = { "a", "mouse", "moneypot", "monitor", "mousepad" };
		// System.out.println(new SuggestedProductsAjay().getSuggestsWord(arr, "mou"));
		SuggestProductNewAjay searchWords = new SuggestProductNewAjay();
		System.out.println(searchWords.searchWords(arr, "mou"));
	}
}
