package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
	// Custom class Trie with function to get 3 words starting with given prefix
	class Trie {

	    // Node definition of a trie
	    class Node {
	        boolean isWord = false;
	        List<Node> children = Arrays.asList(new Node[26]);
	    };
	    Node Root, curr;
	    List<String> resultBuffer;

	    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
	    void dfsWithPrefix(Node curr, String word) {
	        if (resultBuffer.size() == 3)
	            return;
	        if (curr.isWord)
	            resultBuffer.add(word);

	        // Run DFS on all possible paths.
	        for (char c = 'a'; c <= 'z'; c++)
	            if (curr.children.get(c - 'a') != null) {
	            	System.out.println( curr.children.get(c - 'a')+"  "+c);
	                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
	            }
	    }
	    Trie() {
	        Root = new Node();
	    }

	    // Inserts the string in trie.
	    void insert(String s) {

	        // Points curr to the root of trie.
	        curr = Root;
	        for (char c : s.toCharArray()) {
	            if (curr.children.get(c - 'a') == null)
	                curr.children.set(c - 'a', new Node());
	            curr = curr.children.get(c - 'a');
	        }

	        // Mark this node as a completed word.
	        curr.isWord = true;
	    }
	    List<String> getWordsStartingWith(String prefix) {
	        curr = Root;
	        System.out.println(prefix);
	        resultBuffer = new ArrayList<String>();
	        // Move curr to the end of prefix in its trie representation.
	        for (char c : prefix.toCharArray()) {
	            if (curr.children.get(c - 'a') == null)
	                return resultBuffer;
	            curr = curr.children.get(c - 'a');
	        }
	        dfsWithPrefix(curr, prefix);
	        return resultBuffer;
	    }
	};
	
	    List<List<String>> suggestedProductsTrie(String[] products,
	                                         String searchWord) {
	        Trie trie = new Trie();
	        List<List<String>> result = new ArrayList<>();
	        // Add all words to trie.
	        for (String w : products)
	            trie.insert(w);
	        String prefix = new String();
	        for (char c : searchWord.toCharArray()) {
	            prefix += c;
	            result.add(trie.getWordsStartingWith(prefix));
	        }
	        return result;
	    }
	
	public static void main(String[] args) {
		String arr[] = { "a", "mouse", "moneypot", "monitor", "mousepad" };
		System.out.println(new SuggestedProducts().suggestedProductsTrie(arr, "a"));
		
		
		String str1 = "app";
        String str2 = "apc";

        // Compare str1 with str2
        int result = str1.compareTo(str2);

        // Output the result
        if (result < 0) {
            System.out.println("str1 is less than str2");
        } else if (result == 0) {
            System.out.println("str1 is equal to str2");
        } else {
            System.out.println("str1 is greater than str2");
        }
	}

	// Equivalent code for lower_bound in Java
	public int lower_bound(String[] products, int start, String word) {
		int i = start, j = products.length, mid;
		while (i < j) {
			mid = (i + j) / 2;
			if (products[mid].compareTo(word) >= 0)
				j = mid;
			else
				i = mid + 1;
		}
		return i;
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);

		List<List<String>> result = new ArrayList<>();

		int start = 0, bsStart = 0, n = products.length;

		String prefix = new String();

		for (char c : searchWord.toCharArray()) {
			prefix += c;

			// Get the starting index of word starting with `prefix`.
			start = lower_bound(products, bsStart, prefix);

			// Add empty vector to result.
			result.add(new ArrayList<>());

			// Add the words with the same prefix to the result.
			// Loop runs until `i` reaches the end of input or 3 times or till the
			// prefix is same for `products[i]` Whichever comes first.
			for (int i = start; i < Math.min(start + 3, n); i++) {
				if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
					break;
				result.get(result.size() - 1).add(products[i]);
			}

			// Reduce the size of elements to binary search on since we know
			bsStart = Math.abs(start);
		}
		return result;
	}
}
