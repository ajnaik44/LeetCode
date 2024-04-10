package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> stackNewest = new Stack<Integer>();
	Stack<Integer> stackOldest = new Stack<Integer>();
	
	public void add(int data)
	{
		stackNewest.push(data);
		
	}
	public void TransferElements(Stack<Integer> newElement,Stack<Integer> oldElement)
	{
		while(!newElement.isEmpty())
		{
			oldElement.push(newElement.pop());
		}
	}
	
	public int pop()
	{
		if(this.stackOldest.isEmpty())
			TransferElements(this.stackNewest, this.stackOldest);
		return this.stackOldest.pop();
	}
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
	}

}
