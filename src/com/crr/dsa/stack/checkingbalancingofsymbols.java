package com.crr.dsa.stack;

import java.util.HashMap;
import java.util.Stack;

public class checkingbalancingofsymbols {
	Stack<Character> stack = new Stack<>();

	HashMap<Character, Character> mapping = new HashMap<>();

	public checkingbalancingofsymbols() {
		// TODO Auto-generated constructor stub
		mapping.put( '{','}');
		mapping.put( '[',']');
		mapping.put( '(',')');
	}

	public boolean checkbalSymoboles(String string) {
		char[] symbols = string.toCharArray();
		boolean results=true;
		for (char ch : symbols) {
			if (mapping.containsKey(ch)) {
				stack.push(ch);
			}
			if (!stack.isEmpty()&& stack.peek()!=null&&  mapping.containsValue(ch)) {
				char popelement = stack.pop();
				if( (ch=='}' && popelement=='{') ||(ch==')' && popelement=='(') || (ch==']' && popelement=='[')) {
					continue;
				}else {
					results= false;
					break;
				}

			}

		}
		if(results!=false)
			results = stack.isEmpty();
		return results;
	}
	
	

	public static void main(String[] args) {
		System.out.println(new checkingbalancingofsymbols().checkbalSymoboles("{(A+b)]"));
	}
}
