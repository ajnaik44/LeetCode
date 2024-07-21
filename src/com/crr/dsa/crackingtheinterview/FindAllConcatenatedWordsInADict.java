package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllConcatenatedWordsInADict {

    class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> children;

        TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    private void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
    }

    private int solve(TrieNode rt, int i, String s) {
        if (i == s.length()) {
            return 0;
        }

        TrieNode temp = rt; // Save the current node to traverse the trie

        // Iterating over the word to check if the word can be formed
        for (int j = i; j < s.length(); j++) {
            char idx = s.charAt(j);
            if (!temp.children.containsKey(idx)) {
                return -1;
            }
            temp = temp.children.get(idx);
            if (temp.isWord) {
                // Recursively checking for the remaining string.
                int next = solve(rt, j + 1, s);
                // If the string can be formed with the word.
                if (next != -1) {
                    return next + 1;
                }
            }
        }

        // If no words can be formed
        return -1;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.root = new TrieNode();
        // Creating Trie with words
        for (String word : words) {
            insert(word);
        }

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            int count = solve(root, 0, word);
            if (count > 1) {
                // Adding the word to the list, only if it is
                // made up from concatenation of more than 1 word.
                ans.add(word);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String words[] = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        FindAllConcatenatedWordsInADict aDict = new FindAllConcatenatedWordsInADict();
        System.out.println(aDict.findAllConcatenatedWordsInADict(words));
    }
}
