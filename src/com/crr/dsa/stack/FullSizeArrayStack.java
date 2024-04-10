package com.crr.dsa.stack;

public class FullSizeArrayStack {
	int[] array = null;
	int size;
	int index = -1;

	public FullSizeArrayStack(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		array = new int[size];
	}

	public void push(int data) throws StackOverflowError {
		if (!isFull()) {
			array[++index] = data;
			
		} else {
			throw new StackOverflowError();
		}
	}
	public int size()
	{
		return index+1;
	}
	public boolean isEmpty()
	{
		return index<0;
	}
	public boolean isFull()
	{
		return index>=size;
	}

	public int pop() {
		
		if (!isEmpty()) {
			int data = array[index];
			array[index] = -1;
			index--;
			
			return data;
		} else {
			throw new StackOverflowError();
		}
	}
	public static void main(String[] args) {
		FullSizeArrayStack arrayStack = new FullSizeArrayStack(4);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		arrayStack.push(4);
		System.out.println(2<<1);
	}
}
