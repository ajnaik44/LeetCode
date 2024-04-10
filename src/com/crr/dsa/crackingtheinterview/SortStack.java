package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class SortStack {

	public Stack sortStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			int current = stack.pop();
			while (!temp.isEmpty() && temp.peek() > current) {
				stack.add(temp.pop());
			}
			temp.add(current);

		}
		while(!temp.isEmpty())
		{
			stack.push(temp.pop());
		}
	return stack;

	}

	public static void main(String[] args) {
		SortStack sortStack = new SortStack();
		Stack<Integer> setOfStacks = new Stack<>();
		setOfStacks.push(4);
		setOfStacks.push(2);
		setOfStacks.push(6);
		setOfStacks.push(5);

		sortStack.sortStack(setOfStacks);
		System.out.println(setOfStacks);
	}

}
