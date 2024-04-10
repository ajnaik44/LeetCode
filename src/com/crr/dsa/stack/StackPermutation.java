package com.crr.dsa.stack;

import java.util.Stack;

public class StackPermutation {
	public static boolean checkPurmutation(String s) {
		Stack<Integer> stack = new Stack<>();
		int[] seq = { 1, 2, 3, 4, 5, 6 };
		String output = "";
		String finalString = "";
		char charray[] = s.toCharArray();
		int index = 0;
		for (int i = 0; i < charray.length && index<charray.length;) {
			int temp = Integer.parseInt(String.valueOf(charray[i]));
			if (!stack.isEmpty() && stack.peek() == temp) {
				output += "X";
				finalString += stack.pop();
				i++;
			}
			else if (stack.isEmpty() || stack.peek() != temp) {
				output += "S";
				stack.push(seq[index]);
				index++;
			}
			else {
				output += "S";
				stack.push(seq[index]);
				index++;
			}

		}
		while (!stack.isEmpty()) {
			output += "X";
			finalString += stack.pop();
		}
		System.out.println(finalString);
		System.out.println(output);
		return finalString.equals(s);
	}

	public static void main(String[] args) {
		System.out.println(checkPurmutation("325641"));
	}
}