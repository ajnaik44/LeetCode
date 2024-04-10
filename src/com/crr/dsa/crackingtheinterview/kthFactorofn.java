package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class kthFactorofn {
	

	public static int minPartitionSubstrings(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int start = 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= start) {
                result++;
                start = i;
            }
            lastSeen.put(ch, i);
        }
        
        return result + 1; // Add 1 to account for the last partition
    }
	public static void main(String[] args) {
		System.out.println(new kthFactorofn().minPartitionSubstrings("abacaba"));
	}
}
