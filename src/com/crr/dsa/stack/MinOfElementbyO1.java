package com.crr.dsa.stack;

import java.util.Stack;

public class MinOfElementbyO1 {
	Stack<Integer> normalStack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int data) {
		if (normalStack.empty()) {
			normalStack.push(data);
			minStack.push(data);
		} else if (minStack.peek() >= data) {
			minStack.push(data);
			normalStack.push(data);
		} else {
			normalStack.push(data);
		}
	}

	public void pop() throws Exception {
		if (normalStack.empty()) {
			throw new Exception("EMpty Stack");
		} else if (normalStack.peek() == minStack.peek()) {
			normalStack.pop();
			minStack.pop();
		} else {
			normalStack.pop();
		}
	}

	public int minimum() {
		return minStack.peek();
	}

	public static void main(String[] args) throws Exception {
		MinOfElementbyO1 elementbyO1 = new MinOfElementbyO1();
		elementbyO1.push(2);
		elementbyO1.push(6);
		elementbyO1.push(4);
		elementbyO1.push(1);
		elementbyO1.push(5);
		elementbyO1.push(1);
		System.out.println(elementbyO1.normalStack.size());
		System.out.println(elementbyO1.minStack.size());
		elementbyO1.pop();
		
	
		System.out.println(elementbyO1.normalStack.size());
		System.out.println(elementbyO1.minStack);
	}
}
