package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		Map<Character,Character>  mapping = new HashMap<>();
		mapping.put('}', '{');
		mapping.put(']', '[');
		mapping.put(')', '(');
		for (char ch : s.toCharArray()) {
	        if (mapping.containsValue(ch)) {
	            stack.push(ch);
	        } else if (stack.isEmpty() || stack.pop() != mapping.get(ch)) {
	            return false;
	        }
	    }
	    return stack.isEmpty();

	}

	

	public static void main(String[] args) {
		System.out.println(isValid("([{"
				+ "])"));
	}
}
