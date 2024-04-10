package com.crr.dsa.stack;

import java.util.Stack;

public class successivepairinstack {
	public static boolean successivepair(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<>();
		Integer value = null;
		Integer value1 = null;
		int counter = 1;
		while (!stack.isEmpty()) {
			temp.push(stack.pop());

		}
		System.out.println(temp);
		while (!temp.isEmpty()) {
		
			if (counter == 1) {
				value = temp.pop();
				counter = 2;
			} else{
				value1 = temp.pop();
				counter = 1;
			}
			if (value != null && value1 != null) {
				if (Math.addExact(value, 1) == value1 || Math.subtractExact(value, 1) == value1) {
					System.out.println(value + "  " + value1);
					value1=null;
					value=null;
				}
				else {
					return false;
				}
			}

		}

		// System.out.println(temp.peek());
		return true;
	}

	public static void main(String[] args) {
System.out.println(Math.subtractExact(-2, 1));
		Stack<Integer> stack = new Stack();
		stack.add(4);
		stack.add(5);
		stack.add(-2);
		stack.add(-3);
		stack.add(11);
		stack.add(10);
		stack.add(5);
		stack.add(6);
		stack.add(20);

		
		System.out.println(successivepair(stack));
	}
}
