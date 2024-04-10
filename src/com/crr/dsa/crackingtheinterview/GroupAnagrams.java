package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class GroupAnagrams {
	static class AnagramComparator implements Comparator<String> {
	    public String sortChars(String s) {
	        char[] content = s.toCharArray();
	        Arrays.sort(content);
	        return new String(content);
	    }

	    public int compare(String s1, String s2) {
	        return sortChars(s1).compareTo(sortChars(s2));
	    }
	}
	public static void main(String[] args) {
		String[] words = {"cat", "dog", "tac", "god", "act"};

        // Sort the array of words based on their anagrams
		sort(words);
       
	}
	
	static void sort(String[] array) {
	    HashMap<String, ArrayList<String>> maplist = new HashMap<String, ArrayList<String>>();

	    /* Group words by anagram */
	    for (String s : array) {
	        String key = sortChars(s);
	        if (!maplist.containsKey(key)) {
	            maplist.put(key, new ArrayList<String>());
	        }
	        maplist.get(key).add(s);
	    }

	    /* Convert hash table to array */
	    int index = 0;
	    for (String key : maplist.keySet()) {
	        ArrayList<String> list = maplist.get(key);
	        for (String t : list) {
	            array[index] = t;
	            index++;
	        }
	    }
	}

	static String sortChars(String s) {
	    char[] content = s.toCharArray();
	    Arrays.sort(content);
	    return new String(content);
	}


}
