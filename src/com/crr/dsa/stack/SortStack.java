package com.crr.dsa.stack;

import java.util.Stack;

public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> stk) {
	    Stack<Integer> rstk = new Stack<Integer>(); // Create an auxiliary stack to hold sorted elements
	    
	    while (!stk.isEmpty()) {
	        int tmp = stk.pop(); // Pop an element from the input stack
	        
	        while (!rstk.isEmpty() && rstk.peek() > tmp) {
	            stk.push(rstk.pop()); // Move elements from rstk back to stk to make space
	        }
	        
	        rstk.push(tmp); // Push the current element onto the rstk in sorted order
	    }
	    
	    return rstk; // Return the sorted stack
	}
	public static void main(String[] args) {
	    Stack<Integer> stk1 = new Stack<Integer>();
	    stk1.push(34);
	    stk1.push(3);
	    stk1.push(31);
	    stk1.push(98);
	    stk1.push(92);
	    stk1.push(23);

	    System.out.println("Original Stack: " + stk1);
	    Stack<Integer> sortedStack1 = sort(stk1);
	    System.out.println("Sorted Stack: " + sortedStack1);

	    Stack<Integer> stk2 = new Stack<Integer>();
	    stk2.push(5);
	    stk2.push(2);
	    stk2.push(10);
	    stk2.push(7);

	    System.out.println("Original Stack: " + stk2);
	    Stack<Integer> sortedStack2 = sort(stk2);
	    System.out.println("Sorted Stack: " + sortedStack2);
	}

}
