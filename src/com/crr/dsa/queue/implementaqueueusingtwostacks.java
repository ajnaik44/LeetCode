package com.crr.dsa.queue;

import java.util.Stack;

public class implementaqueueusingtwostacks {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	public void enQueue(int ddta)
	{
		s1.push(ddta);
		
	}
	public int deQueue()
	{
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
			return s2.pop();
		}
		return s2.pop();
		
	}
	public static void main(String[] args) {
		implementaqueueusingtwostacks s1 = new implementaqueueusingtwostacks();
		s1.enQueue(0);
		s1.enQueue(1);
		System.out.println("ss");
		System.out.println(s1.deQueue());
		System.out.println("ss");
		s1.enQueue(2);
		System.out.println(s1.deQueue());
		System.out.println(s1.s1);
	}
	
}
