package com.crr.dsa.crackingtheinterview;

import java.util.*;

public class PalindromicPermutations {

    public static void main(String[] args) {
        String s = "aabb";
        List<String> result = generatePalindromicPermutations(s);
        System.out.println(result); // Output: [abba, baab]
    }

    public static List<String> generatePalindromicPermutations(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        
        // Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Check the number of characters with odd frequency
        int oddCount = 0;
        Character oddChar = null;
        StringBuilder half = new StringBuilder();
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count % 2 != 0) {
                oddCount++;
                oddChar = c;
            }
            // Append half the count to form half of the palindrome
            for (int i = 0; i < count / 2; i++) {
                half.append(c);
            }
        }
        
        // If more than one character has an odd frequency, no palindromic permutation is possible
        if (oddCount > 1) return result;
        
        // Generate all unique permutations of the half string
        List<String> halfPermutations = new ArrayList<>();
        backtrack(half.toString().toCharArray(), new boolean[half.length()], new StringBuilder(), halfPermutations);
        
        // Construct the full palindromes from the half permutations
        for (String halfPerm : halfPermutations) {
            StringBuilder palindrome = new StringBuilder(halfPerm);
            if (oddChar != null) {
                palindrome.append(oddChar);
            }
            palindrome.append(new StringBuilder(halfPerm).reverse());
            result.add(palindrome.toString());
        }
        
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            backtrack(chars, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
