package com.crr.dsa.crackingtheinterview;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LongestValidParenthsesi {
	
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push('(');
	            } else if (!stack.empty() && stack.peek() == '(') {
	                stack.pop();
	            } else {
	                return false;
	            }
	        }
	        return stack.empty();
	    }
	    public int longestValidParentheses(String s) {
	        int maxlen = 0;
	        for (int i = 0; i < s.length(); i++) {
	            for (int j = i + 2; j <= s.length(); j+=2) {
	                if (isValid(s.substring(i, j))) {
	                    maxlen = Math.max(maxlen, j - i);
	                }
	            }
	        }
	        return maxlen;
	    }
	    public int longestValidParenthesesOp1(String s) {
	        int maxans = 0;
	        Stack<Integer> stack = new Stack<>();
	        stack.push(-1);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {
	                stack.pop();
	                if (stack.empty()) {
	                    stack.push(i);
	                } else {
	                    maxans = Math.max(maxans, i - stack.peek());
	                }
	            }
	        }
	        return maxans;
	    }
	    public static void main(String[] args) {
			System.out.println(new LongestValidParenthsesi().lengthOfLongestSubstringTwoDistinctOptimize1("eceba"));
			System.out.println(isHappy(7));
	
		}
	    
	    
	    	  public int lengthOfLongestSubstringTwoDistinctOptimize1(String s) {
	    	  
	    		int n = s.length();
	    	    if (n < 3) return n;

	    	    // sliding window left and right pointers
	    	    int left = 0;
	    	    int right = 0;
	    	    // hashmap character -> its rightmost position
	    	    // in the sliding window
	    	    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

	    	    int max_len = 2;

	    	    while (right < n) {
	    	      // when the slidewindow contains less than 3 characters
	    	      hashmap.put(s.charAt(right), right++);

	    	      // slidewindow contains 3 characters
	    	      if (hashmap.size() == 3) {
	    	        // delete the leftmost character
	    	        int del_idx = Collections.min(hashmap.values());
	    	        hashmap.remove(s.charAt(del_idx));
	    	        // move left pointer of the slidewindow
	    	        left = del_idx + 1;
	    	      }

	    	      max_len = Math.max(max_len, right - left);
	    	    }
	    	    return max_len;
	    	  }
	    	
	    
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        int max = 0;
	      for (int i = 0; i < s.length(); i++) {
	    	  
	        for (int j = i + 1; j <= s.length(); j++) {
	        	// Corrected the loop condition
	            if (has2Char(s.substring(i, j))) { // Corrected the method name
	                max = Math.max(max, j - i);
	            }
	        }
	    }
	    return max;
	   
	    }
	    public boolean has2Char(String s)
	    {
	        HashSet set = new HashSet<Character>();
	        for(char c: s.toCharArray())
	        {
	            set.add(c);
	        }
	        return set.size()<=2;
	    }
	    
	    
	    static Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
	    public static boolean isHappy(int n) 
	    {
	      
	        String number =  n+"".trim();
	        int result = 0;
	      if(  memo.containsKey(n))
	    	  return memo.get(n)==1;
	        for(int i=0;i<number.length();i++)
	        {
	            if(memo.get(Integer.parseInt(String.valueOf(number.charAt(i))))==null)
	            {
	            	System.out.println(Integer.parseInt(String.valueOf(number.charAt(i))));
	            	System.out.println(Math.pow(Integer.parseInt(String.valueOf(number.charAt(i))),2));
	                memo.put(Integer.parseInt(String.valueOf(number.charAt(i))),(int) Math.pow(Integer.parseInt(String.valueOf(number.charAt(i))),2));
	            }
	                result+= memo.get(Integer.parseInt(String.valueOf(number.charAt(i))));
	        }
	        memo.put(n, result);
	    if(result==1)
	        return true;
	    else 
	        return  isHappy(Integer.valueOf( result) );
	    }
}
