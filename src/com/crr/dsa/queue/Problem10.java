package com.crr.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem10 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		queue.add(19);
		queue.add(20);
		Stack<Integer> stack = new Stack<>();
		int k = 4;
		int size = queue.size();
		for (int i = 0; i < k; i++) {
			stack.push(queue.poll());

		}
		for (int i = 0; i < k; i++) {
			queue.add(stack.pop());

		}
		System.out.println(queue);
		for (int i = 0; i < size - k; i++) {
			queue.add(queue.poll());
		}
		System.out.println(queue);
	}
}
