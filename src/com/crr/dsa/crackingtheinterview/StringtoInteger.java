package com.crr.dsa.crackingtheinterview;

public class StringtoInteger {
	public static void main(String[] args) {
		System.out.println(new StringtoInteger().myAtoi("-2147483647"));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}

	public int myAtoi(String s) {
		if (s == null || s.isEmpty())
			return 0;
		boolean isNegative = false;
		s = s.trim();
		long currentNumber = 0;
		int index = 0;
		if (index < s.length() && s.charAt(index) == '+') {
			index++;
		} else if (index < s.length() && s.charAt(index) == '-') {
			index++;
			isNegative = true;
		}
		while (index < s.length()) {
			char c = s.charAt(index);

			if (Character.isDigit(c)) {
				currentNumber = (currentNumber * 10) + (c - '0');

				if (!isNegative && currentNumber >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (isNegative && currentNumber > Integer.MAX_VALUE)
					return Integer.MIN_VALUE;
			} else
				break;
			index++;
		}

		return isNegative ? -(int) currentNumber : (int) currentNumber;
	}

	public int myAtoiEditorApproach1(String input) {
		int sign = 1;
		int result = 0;
		int index = 0;
		input = input.trim();
		int n = input.length();

		// Discard all spaces from the beginning of the input string.
		while (index < n && input.charAt(index) == ' ') {
			index++;
		}

		// sign = +1, if it's positive number, otherwise sign = -1.
		if (index < n && input.charAt(index) == '+') {
			sign = 1;
			index++;
		} else if (index < n && input.charAt(index) == '-') {
			sign = -1;
			index++;
		}

		// Traverse next digits of input and stop if it is not a digit
		while (index < n && Character.isDigit(input.charAt(index))) {
			int digit = input.charAt(index) - '0';

			// Check overflow and underflow conditions.
			if ((result > Integer.MAX_VALUE / 10)
					|| (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
				// If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			// Append current digit to the result.
			result = 10 * result + digit;
			index++;
		}

		// We have formed a valid number without any overflow/underflow.
		// Return it after multiplying it with its sign.
		return sign * result;
	}

}
