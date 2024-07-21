package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinRemoveToMakeValid {
	public static void main(String[] args) {
		System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValidApproach1("))(("));
	}
	private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            } if (c == close) {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }  
        return sb;
    }

    public String minRemoveToMakeValidApproach1(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }
	    public String minRemoveToMakeValid(String s) {
	        Set<Integer> indexesToRemove = new HashSet<>();
	        Deque<Integer> stack = new ArrayDeque<>();
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } if (s.charAt(i) == ')') {
	                if (stack.isEmpty()) {
	                    indexesToRemove.add(i);
	                } else {
	                    stack.pop();
	                }
	            }
	        }
	        // Put any indexes remaining on stack into the set.
	        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < s.length(); i++) {
	            if (!indexesToRemove.contains(i)) {
	                sb.append(s.charAt(i));
	            }
	        }
	        return sb.toString();
	    }
}
