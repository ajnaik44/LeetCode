package com.crr.dsa.stack;

public class DynamicSizeArrayStack {
	int capacity = 0;
	int[] array;
	int index = -1;

	public DynamicSizeArrayStack(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	public void push(int data)
	{
		if(isFull())
		{
			expand();
			this.array[++index] =  data;
		}else {
			array[++index] =  data;
		}
		System.out.println("Size" +  this.capacity);
	}
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack underflow error");
		}else {
			int data =  array[index];
			array[index] = -1;
			index--;
			return data;
		}
	}
	public boolean isEmpty()
	{
		return index<=-1;
	}
	public void expand()
	{
		int increasecapapcity=  this.capacity*2;
		int newarray[]= new int[increasecapapcity];
		System.arraycopy(this.array,0, newarray,0,this.capacity);
		this.array =  newarray;
		this.capacity=increasecapapcity;
	}
	public boolean isFull()
	{
		return index+1>=capacity;
	}
	public static void main(String[] args) throws Exception {
		DynamicSizeArrayStack arrayStack = new DynamicSizeArrayStack(1);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(5);
		arrayStack.pop();
		arrayStack.pop();
		arrayStack.pop();
		arrayStack.pop();
		System.out.println(1<<15);
		
	}
}
