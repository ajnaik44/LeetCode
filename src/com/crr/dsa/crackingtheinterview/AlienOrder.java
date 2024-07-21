package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienOrder {
	
	public static void main(String[] args) {
		AlienOrder  alienOrder = new AlienOrder();
		String[] words = {"wrt","wrf","er","ett","rftt"};
		System.out.println(alienOrder.alienOrderBFS(words));
	}
	public String alienOrderBFS(String[] words) {
	    
	    // Step 0: Create data structures and find all unique letters.
	    Map<Character, List<Character>> adjList = new HashMap<>();
	    Map<Character, Integer> counts = new HashMap<>();
	    for (String word : words) {
	        for (char c : word.toCharArray()) {
	            counts.put(c, 0);
	            adjList.put(c, new ArrayList<>());
	        }
	    }
	    
	    // Step 1: Find all edges.
	    for (int i = 0; i < words.length - 1; i++) {
	        String word1 = words[i];
	        String word2 = words[i + 1];
	        // Check that word2 is not a prefix of word1.
	        if (word1.length() > word2.length() && word1.startsWith(word2)) {
	            return "";
	        }
	        // Find the first non match and insert the corresponding relation.
	        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
	            if (word1.charAt(j) != word2.charAt(j)) {
	                adjList.get(word1.charAt(j)).add(word2.charAt(j));
	                counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
	                break;
	            }
	        }
	    }
	    
	    // Step 2: Breadth-first search.
	    StringBuilder sb = new StringBuilder();
	    Queue<Character> queue = new LinkedList<>();
	    for (Character c : counts.keySet()) {
	        if (counts.get(c).equals(0)) {
	            queue.add(c);
	        }
	    }
	    while (!queue.isEmpty()) {
	        Character c = queue.remove();
	        sb.append(c);
	        for (Character next : adjList.get(c)) {
	            counts.put(next, counts.get(next) - 1);
	            if (counts.get(next).equals(0)) {
	                queue.add(next);
	            }
	        }
	    }
	    
	    if (sb.length() < counts.size()) {
	        return "";
	    }
	    return sb.toString();
	}
	StringBuilder sb = new StringBuilder();
	public String alienOrder(String[] words) {

		Map<Character, List<Character>> adjList = new HashMap<>();
		Map<Character, Integer> counts = new HashMap<>();

		for (String word : words) {
			for (char c : word.toCharArray()) {
				counts.put(c, 0);
				adjList.put(c, new ArrayList<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return "";
			}
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					adjList.get(word1.charAt(j)).add(word2.charAt(j));
					counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
					break;
				}
			}
		}

		
		Map<Character,Boolean> seen = new HashMap<>();
		for (Character c : counts.keySet()) {
			boolean res =  dfs(c,adjList,seen);
			if(!res)return "";
		}
		return sb.toString();

	}
	public boolean dfs(char current,Map<Character, List<Character>> adjList , Map<Character, Boolean> seen)
	{
		if(seen.containsKey(current)) return seen.get(current);
		
		seen.put(current, false);
		
		for(char next :  adjList.get(current))
		{
			
			boolean res = dfs(next,adjList,seen);
			if(!res)
				return false;
		}
		seen.put(current, true);
		sb.append(current);
		return true;
	}

}
