package com.crr.dsa.stack;

import java.util.Stack;

public class Recursivelyremovealladjacentduplicates {
	public static void main(String[] args) {
		int[] array = { 1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5 };
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(array[0]);
		Integer previousElement = null;
		for (int i = 1; i < array.length; i++) {
			if (previousElement != null && previousElement == array[i]) {

			} else if (!(array[i] == stack.peek())) {
				stack.push(array[i]);
			} else {
				previousElement = stack.peek();

				stack.pop();

			}
		}
		System.out.println(stack);
	}
}
