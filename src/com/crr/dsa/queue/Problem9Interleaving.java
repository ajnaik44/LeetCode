package com.crr.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem9Interleaving {
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
		Queue<Integer> temp = new LinkedList<>();
		int halfSize = queue.size() / 2;

		for (int i = 0; i < halfSize; i++) {
			temp.add(queue.poll());
		}

		while (!temp.isEmpty()) {
			queue.add(temp.poll());
			queue.add(queue.poll());
		}

		System.out.println(queue);
	}
}
