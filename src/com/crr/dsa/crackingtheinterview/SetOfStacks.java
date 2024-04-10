package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class SetOfStacks 
{
	int threshold=2;
	Stack<Stack<Integer>> parentStack = new Stack<Stack<Integer>>();
	
	public void push(int data)
	{
		if(parentStack.isEmpty() || parentStack.peek().size()>=this.threshold)
		{
			Stack<Integer> temp =  new Stack<>();
			parentStack.push(temp);
		}
		parentStack.peek().push(data);
	}
	public void pop()
	{
		if(parentStack.isEmpty())
			return;
		 parentStack.peek().pop() ;
		if(   parentStack.peek().isEmpty())
		{
			parentStack.pop();
		}
		
	}
	public void popAt(int index)
	{
		if(parentStack.isEmpty() ||  parentStack.size()> index)
			return ;
		if(parentStack.get(index).isEmpty())
			return ;
		parentStack.get(index).pop();
		
		
	}
	
	public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);

        // Pop elements
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop(); // Stack is empty now

        setOfStacks.pop(); // Trying to pop when stack is empty
        setOfStacks.popAt(2);
    }
	

}
