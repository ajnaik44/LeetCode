package com.crr.dsa.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reversingaqueue {

	public static Queue<Integer>  reverseQueue(Queue<Integer> queue)
	{
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty())
		{
			stack.push(queue.poll());
		}
		while(!stack.isEmpty())
		{
			queue.add(stack.pop());
		}
		
		return queue;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(1);
		System.out.println(reverseQueue(queue));
	}
}
