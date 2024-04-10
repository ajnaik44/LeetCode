package com.crr.dsa.stack;

import java.util.Stack;

public class InfixToPostfix {
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(char ch :  infix.toCharArray())
        {
        	if(Character.isLetterOrDigit(ch))
        	{
        		postfix.append(ch);
        	}
        	else if(ch=='(')
        	{
        		stack.push(ch);
        	}
        	else if(ch==')')
        	{
        		while(!stack.empty()  && (stack.peek()!='('))
        		{
        			postfix.append(stack.pop());
        		}
        		stack.pop();
        	}else {
        		while(!stack.empty()  &&  getPrecedence(ch)<= getPrecedence(stack.peek()))
        		{
        			postfix.append(stack.pop());
        		}
        		stack.push(ch);
        	}
        }
        

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                // Unbalanced parentheses
                return "Invalid Expression";
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "A*B-(C+D)+E";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
