package com.crr.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuePushontoStackmaintainOrder {

	public static  void pushontoStack(Queue<Integer> queue,Stack<Integer> stack ,int data)
	{
		if(!queue.isEmpty())
		{
			int temp =  queue.poll();
			pushontoStack(queue, stack, temp);
		
		}
		if(data!=-1 && queue.isEmpty())
		{
			stack.push(data);
		}
	}
	 public static void transferQueueToStack(Queue<Integer> Q, Stack<Integer> S) {
	        while (!Q.isEmpty()) {
	            int element = Q.poll();
	            S.push(element);
	        }
	    }
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<>();
		queue.add(1);
		queue.add(2);
		//pushontoStack(queue, stack, -1);
		 transferQueueToStack(queue, stack);
		System.out.println(stack.peek());
	}
	
}
