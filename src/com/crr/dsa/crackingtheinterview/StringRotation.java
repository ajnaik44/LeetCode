package com.crr.dsa.crackingtheinterview;

public class StringRotation {
	public static boolean isRotation(String s1, String s2) {
	    // Check if the lengths of the two strings are the same and they are not empty
	    if (s1.length() != s2.length() || s1.isEmpty() || s2.isEmpty()) {
	        return false;
	    }

	    // Concatenate s1 with itself
	    String concatenated = s1 + s1;

	    // Check if s2 is a substring of concatenated string
	    return isSubstring(concatenated, s2);
	}

	public static boolean isSubstring(String s1, String s2) {
	    return s1.contains(s2);
	}

	public static void main(String[] args) {
		System.out.println(isRotation("abc", "bc"));
	}
}
