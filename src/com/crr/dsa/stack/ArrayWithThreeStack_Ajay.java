package com.crr.dsa.stack;

public class ArrayWithThreeStack_Ajay {
	int [] array;
	int capacity;
	int left_index;
	int left_index_current;
	int mid_index;
	int mid_index_current;
	int right_index;
	int right_index_current;
	int capacity_used;
	public ArrayWithThreeStack_Ajay(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity =  capacity;
		this.array = new int[capacity];
		this.left_index =  -1;
		
		this.right_index=capacity;
		this.mid_index =(0+right_index)/2;
		this.mid_index-=1;
		this.capacity_used=0;
		this.left_index_current = left_index;
		this.right_index_current =right_index;
		this.mid_index_current = mid_index;
	}
	public void push(int stack_id,int data) throws Exception
	{
		if(capacity_used==capacity)
		{
			throw new Exception("Array is full");
		}
		if(stack_id==1)
		{
			System.out.println(mid_index_current);
			if(left_index_current>=mid_index_current)
			{
				throw new Exception("Stack 1 is full");
			}
			array[++left_index_current] =  data;
			capacity_used++;
		}
		else if(stack_id==2)
		{
			if(mid_index_current>=right_index_current && mid_index_current>=left_index_current)
			{
				throw new Exception("Stack 2 is full");
			}
			if(right_index_current-mid_index_current>1)
			{
				array[++mid_index_current]=data;
			}
			else if(mid_index - left_index_current>0)
			{
				//shift to the left
				int temp = left_index_current+2;
				if(mid_index -  temp>=0)
				{
					temp+=1;
				}
				mid_index =  temp;
				for(int i=temp;i<=mid_index_current -mid_index;i++)
				{
					array[temp] = array[temp+1];
				}
				mid_index_current=temp;
				array[++mid_index_current]=data;
				
			}
		}else if(stack_id==3)
		{
			if(mid_index_current>=right_index_current-1)
				throw new Exception("Stack 3 is full");
			array[--right_index_current]= data;	
		}
	}
	public static void main(String[] args) throws Exception {
		ArrayWithThreeStack_Ajay arrayWithTwoStack = new ArrayWithThreeStack_Ajay(6);
		arrayWithTwoStack.push(1,1);
		arrayWithTwoStack.push(1,2);
		arrayWithTwoStack.push(2,3);
		arrayWithTwoStack.push(2,4);
		arrayWithTwoStack.push(2,5);
		arrayWithTwoStack.push(3,6);
		for(int i:arrayWithTwoStack.array)
		{
			System.out.print( i + " ");
		}
	}
}
