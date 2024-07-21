package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class BracketMatch {
	public static void main(String[] args) {
		BracketMatch bracketMatch = new BracketMatch();
		System.out.println(bracketMatch.bracketMatch("())("));
		
	}

	public int bracketMatch(String s) {

		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();

			} else {
				stack.add(s.charAt(i));
			}
			i++;
		}
		return stack.size();
	}
}
