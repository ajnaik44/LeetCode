package com.crr.dsa.stack;

import java.util.Stack;

public class StackReversal2 {

	public static  void reversalSTack(Stack<Integer> stack)
	{
		if(stack.empty())
		{
			return;
		}
		int temp =  stack.pop();
		reversalSTack(stack);
		insertAtBottom(stack,temp);
	}
	
	public static void insertAtBottom(Stack<Integer> stack,int data)
	{
		if(stack.empty())
		{
			stack.push(data);
			return ;
		}
		int temp =  stack.pop();
		insertAtBottom(stack,data);
		stack.push(temp);
		
	}
public static void main(String[] args) {
	Stack<Integer> stack = new Stack<>();
	stack.push(0);
	stack.push(1);
	stack.push(2);
	stack.push(3);
	reversalSTack(stack);
	System.out.println(stack);
}
}
