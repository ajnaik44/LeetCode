package com.crr.dsa.stack;

import java.util.Stack;

public class Findingspan {
    public static int[] findingSpan(int[] inputArray) {
        int[] spans = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            int span = 1;
            int j = i - 1;
            while (j >= 0 && inputArray[j] <= inputArray[j + 1]) {
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }
    public static int[] findingSpanUsingStack(int[] inputArray) {
        int[] spans = new int[inputArray.length];
        Stack<Integer> stack = new Stack();
        int p=1;
        for(int i=0;i<inputArray.length;i++)
        {
        	while(!stack.isEmpty() &&  inputArray[i] >  inputArray[stack.peek()])
        	{
        		stack.pop();
        	}
        	if(stack.isEmpty())
        	{
        		p=-1;
        		        		
        	}else {
        		p =  stack.peek();
        	}
        	spans[i]=i-p;
        	stack.push(i);
        }
        return spans;
    }

    public static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Print a new line at the end
    }

    public static void main(String[] args) {
        int[] inputArray = { 6,3,4,5,2 };
        int[] spans = findingSpanUsingStack(inputArray);
        printIntArray(spans);
    }
}
