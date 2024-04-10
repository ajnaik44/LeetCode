package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
	public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                // get the encoded string
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            // push the current character to stack
            else {
                stack.push(s.charAt(i));
            }
        }      
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
	public static void main(String[] args) {
		System.out.println(decodeString("3[a2[cc]]"));
		System.out.println(scoreOfParentheses("(()(()))"));
	}
	public static int scoreOfParentheses(String S) {
	    Stack<Integer> stack = new Stack();
	    stack.push(0); // The score of the current frame

	    for (char c: S.toCharArray()) {
	        if (c == '(')
	            stack.push(0);
	        else {
	            int a = stack.pop();
	            int b = stack.pop();
	            stack.push(b + Math.max(2 * a, 1));
	        }
	    }

	    return stack.pop();
	}
	public int scoreOfParenthesesOpt(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
}
