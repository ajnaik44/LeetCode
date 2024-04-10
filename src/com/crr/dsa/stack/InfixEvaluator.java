package com.crr.dsa.stack;

import java.util.Stack;

public class InfixEvaluator {
	
	public static int evaluateInfixExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (char ch : expression.toCharArray()) {
			if (Character.isDigit(ch)) {
				operandStack.push(Character.getNumericValue(ch));
			} else if (ch == '(') {
				operatorStack.push(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					char operator = operatorStack.pop();
					int operand2 = operandStack.pop();
					int operand1 = operandStack.pop();
					int result = performOperation(operator, operand1, operand2);
					operandStack.push(result);
				}
				operatorStack.pop(); // Discard '('
			} else if (isOperator(ch)) {
				while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
					char operator = operatorStack.pop();
					int operand2 = operandStack.pop();
					int operand1 = operandStack.pop();
					int result = performOperation(operator, operand1, operand2);
					operandStack.push(result);
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.isEmpty()) {
			char operator = operatorStack.pop();
			int operand2 = operandStack.pop();
			int operand1 = operandStack.pop();
			int result = performOperation(operator, operand1, operand2);
			operandStack.push(result);
		}

		return operandStack.pop();
	}

	public static int performOperation(char operator, int operand1, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

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

	public static void main(String[] args) {
		String infixExpression = "3 + 4 * ( 2 - 1 )";
		int result = evaluateInfixExpression(infixExpression);
		System.out.println("Infix Expression: " + infixExpression);
		System.out.println("Result: " + result);
	}

}
