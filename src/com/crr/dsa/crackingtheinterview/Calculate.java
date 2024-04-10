package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class Calculate {
	public static void main(String[] args) {
		System.out.println(new Calculate().calculate("-2+ 13*2+9"));
	}

	public int calculate(String s) {
		int n =  s.length();
		Stack<Integer> stack = new Stack<Integer>();
		int currentNumber=0;
		char operation='+';
		for(int i=0;i< n ;i++)
		{
			  char currentChar = s.charAt(i);
			if(!Character.isWhitespace(currentChar))
			{
				
				if(Character.isDigit(currentChar))
				{
					currentNumber = (currentNumber*10)+ (currentChar-'0'); 
				}
				if(!Character.isDigit(currentChar) &&  !Character.isWhitespace(currentChar) ||  i==n-1)
				{
					System.out.println("ss");
					if(operation=='+')
					{
						stack.push(currentNumber);
					}
					else if(operation=='-')
					{
						stack.push(-currentNumber);
					}
					else if(operation=='*')
					{
						stack.push(stack.pop()*currentNumber);
					}
					else if(operation=='/')
					{
						stack.push(stack.pop()/currentNumber);
					}
					currentNumber =  0;
					operation =  currentChar;
				}
				
			}
			
		}
		int result = 0;
		while(!stack.isEmpty())
		{
			result+=stack.pop();
		}
		return result;
	}

}
