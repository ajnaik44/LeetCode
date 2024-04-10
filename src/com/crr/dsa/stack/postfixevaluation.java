package com.crr.dsa.stack;

import java.util.Stack;

public class postfixevaluation {
	public static int numerical_Operation(char operation, int var2, int var1) throws Exception {
		switch (operation) {
		case '+':
			return var2 + var1;
		case '-':
			return var2 - var1;
		case '*':
			return var2 * var1;
		case '/':
			return var2 / var1;
		default:
			throw new Exception("Operator not found");
		}
	}

	public static int postfix_evaluation(String postfix) throws Exception
	{
		Stack<Integer>  stack = new Stack<>();
	
		for(char ch :  postfix.toCharArray())
		{
		
			if(Character.isDigit(ch))
			{
				stack.push(Integer.parseInt(String.valueOf(ch)));
				System.out.println(stack);
			}
			else if(ch =='+' ||  ch=='-' ||  ch=='*' || ch=='/')
			{
				if(stack.empty())
				{
					break;
				}
				int vari1 =  stack.pop();
				
				int var2 = stack.pop();
				
				int result =  numerical_Operation(ch, var2, vari1);
				
				stack.push(result);
			}
		}
		return stack.pop();
		
	}

	public static void main(String[] args) throws Exception {
		System.out.println(postfix_evaluation("123*+5-"));
	}
}
