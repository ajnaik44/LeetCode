package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class AmazonCustomerReviewAnotherSolution {
	public static void main(String[] args) {
		List<String> probitedWords = new ArrayList<String>();
		probitedWords.add("crap");
		probitedWords.add("odpro");
		System.out.println(findReviewScore("GoodProductButScrapAfterWash", probitedWords));
	}

	public static void splitWords(String word, List<String> prohibitedWord, CopyOnWriteArraySet<String> words) {
		
		for (String prhiWords : prohibitedWord) {
				String[] temp = word.toLowerCase().split(prhiWords.toLowerCase());
				for( String splitString:  temp)
				{
					formWords(word, splitString, prhiWords, words);
				}
				break;
			}
		for (String prhiWords : prohibitedWord) {
			for( String fromString:  words) {
				String[] temp = fromString.toLowerCase().split(prhiWords.toLowerCase());
				for( String splitString:  temp)
				{
					if(!words.contains(splitString))
						formWords(word, splitString, prhiWords, words);
				
				}
			}
		
			
		}
		

	}
	public static boolean checkIfStringIsValid(String prohibitedsWords, String review) {
			if (review.toLowerCase().contains(prohibitedsWords.toLowerCase()))
				return false;
		
		return true;
	}

	public static void formWords(String actualWord, String SplitString,String prohibitedWord, CopyOnWriteArraySet<String> words )
	{
		int left = actualWord.indexOf(SplitString) - 1;
		int right = left + 1 + SplitString.length();
		boolean flag = false;
		while (left > 0 && right < actualWord.length()) {
			flag =true;
			SplitString = actualWord.charAt(left) + SplitString;
			if (!checkIfStringIsValid(prohibitedWord, SplitString)) {
				SplitString =  SplitString.substring(1);
				words.add(SplitString);
				return;
			}
			SplitString += actualWord.charAt(right);
			if (!checkIfStringIsValid(prohibitedWord, SplitString)) {
				SplitString =  SplitString.substring(0,SplitString.length()-1);
				words.add(SplitString);
				return;
			}
			left--;
			right++;
		}
		while (left > 0 && !flag) {
			SplitString = actualWord.charAt(left) + SplitString;
			if (!checkIfStringIsValid(prohibitedWord, SplitString)) {
				SplitString =  SplitString.substring(1);
				words.add(SplitString);
				return;
			}

			left--;
		}
		while (right < actualWord.length() && !flag) {

			SplitString += actualWord.charAt(right);
			if (!checkIfStringIsValid(prohibitedWord, SplitString)) {
				SplitString =  SplitString.substring(0,SplitString.length()-1);
				words.add(SplitString);
				return;
			}
			right++;
			
		}
	}
	public static int findMax(String review, String SplitString, List<String> prohibited) {
		CopyOnWriteArraySet<String> formWords = new CopyOnWriteArraySet<>();
		splitWords(SplitString, prohibited, formWords);
		int max = 0;
		for(String fromWord: formWords)
		{
			max = Math.max(max, fromWord.length());
		}
		return max;
	}
	public static void addWords(String[] temp, CopyOnWriteArrayList<String> words) {
		for (String t1 : temp) {
			if (!words.contains(t1)) {
				words.add(t1);

			}

		}
	}

	public static int findReviewScore(String review, List<String> prohibitedWords) {
		review = review.toLowerCase();
		CopyOnWriteArraySet<String> words = new CopyOnWriteArraySet<String>();
		splitWords(review, prohibitedWords, words);

		int max = 0;
		System.out.println(words);
		for(String prohibitedWord : prohibitedWords) {
			for (String entry : words) {
			String newWord []= entry.split(prohibitedWord);
			for(String t1 : newWord)
			{
				words.add(t1);
			}
			
				
				
	
			}
		}

		return max;
	}
}
