package com.crr.dsa.crackingtheinterview;

public class ValidPalindrome2 {
	public static void main(String[] args) {
		System.out.println(new ValidPalindrome2().validPalindrome("deeee"));
	}
	
	    private boolean checkPalindrome(String s, int i, int j) {
	        while (i < j) {
	            if (s.charAt(i) != s.charAt(j)) {
	                return false;
	            }
	            
	            i++;
	            j--;
	        }
	        
	        return true;
	    }
	    
	    public boolean validPalindrome(String s) {
	        int i = 0;
	        int j = s.length() - 1;
	        
	        while (i < j) {
	            // Found a mismatched pair - try both deletions
	            if (s.charAt(i) != s.charAt(j)) {
	                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
	            }
	            
	            i++;
	            j--;
	        }
	        
	        return true;
	    }
	
}
