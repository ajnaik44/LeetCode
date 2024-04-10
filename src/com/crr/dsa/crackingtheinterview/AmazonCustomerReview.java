package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AmazonCustomerReview {

	public static int findReviewScore(String review, List<String> prohibitedWords) {
		review = review.toLowerCase();
		CopyOnWriteArrayList<String> words = new CopyOnWriteArrayList<String>();
		splitWords(review, prohibitedWords, words);

		int max = 0;
		System.out.println(words);
		for (String entry : words) {
			max = Math.max(max, findMax(review, entry, prohibitedWords));

		}

		return max;
	}

	public static int findMax(String review, String SplitString, List<String> prohibited) {
		int left = review.indexOf(SplitString) - 1;
		int right = left + 1 + SplitString.length();
		int countMinus = 0;
		boolean flag = false;
		while (left > 0 && right < review.length()) {
			flag = true;
			SplitString = review.charAt(left) + SplitString;
			if (!checkIfStringIsValid(prohibited, SplitString)) {
				countMinus--;
				break;
			}
			SplitString += review.charAt(right);
			if (!checkIfStringIsValid(prohibited, SplitString)) {
				countMinus--;
				break;
			}
			left--;
			right++;
		}
		while (left > 0 && !flag) {
			SplitString = review.charAt(left) + SplitString;
			if (!checkIfStringIsValid(prohibited, SplitString)) {
				countMinus--;
				break;
			}

			left--;
		}
		while (right < review.length() && !flag) {

			SplitString += review.charAt(right);
			if (!checkIfStringIsValid(prohibited, SplitString)) {
				countMinus--;
				break;
			}

			right++;
		}
		System.out.println(SplitString.toString());
		return SplitString.length() + countMinus;
	}

	public static boolean checkIfStringIsValid(List<String> prohibitedsWords, String review) {
		for (String s : prohibitedsWords) {
			if (review.toLowerCase().contains(s.toLowerCase()))
				return false;
		}
		return true;
	}

	public static void splitWords(String word, List<String> prohibitedWord, CopyOnWriteArrayList<String> words) {

		for (String prhiWords : prohibitedWord) {
			String[] temp = word.toLowerCase().split(prhiWords.toLowerCase());
			addWords(temp, words);
			break;
		}
		for (String prhiWords : prohibitedWord) {
			for (String wrd : words) {
				String[] temp = wrd.toLowerCase().split(prhiWords.toLowerCase());
				if (temp.length > 1) {
					words.remove(wrd);
					addWords(temp, words);
				}
			}
		}

	}

	public static void addWords(String[] temp, CopyOnWriteArrayList<String> words) {

		if (!words.contains(temp[0])) {
			words.add(temp[0]);

		}
		if (temp.length > 1) {
			if (!words.contains(temp[1]))
				words.add(temp[1]);
		}
	}

	public static void main(String[] args) {
		List<String> probitedWords = new ArrayList<String>();
		probitedWords.add("yo");
		probitedWords.add("eli");
		probitedWords.add("eryoka");
		System.out.println(findLongestSubstringWithoutForbidden("FastDeliveryOkayProduct", probitedWords));
		
	
		
	}
	 public static int findLongestSubstringWithoutForbidden(String s, List<String> forbiddenWords) {
		 int max = 0;
			HashSet<String> set = new HashSet<String>(forbiddenWords);
			for (int i = 0, j = 0, k; i < s.length(); max = Math.max(max, j - i++)) {
				for (; j < s.length();j++) {
					for (k = Math.max(i, j - 9); k <= j && !set.contains(s.substring(k, j -k+ 1)); k++) {
					}
					if (k <= j) {
						break;
					}
				}
			}
			return max;

	       
	    }

}
