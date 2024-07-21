package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class MmaximalRectangle {

	public int leetcode84(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxarea = 0;
		for (int i = 0; i < heights.length; ++i) {
			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
				int h1 =heights[stack.pop()];
				int h2= i - stack.peek() - 1;
				maxarea = Math.max(maxarea,h1  * (h2));
			}
			stack.push(i);
		}
		while (stack.peek() != -1) {
			int h1 =heights[stack.pop()];
			int h2 = heights.length - stack.peek() - 1;
			maxarea = Math.max(maxarea, h1 * (h2));
		}
		return maxarea;
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int maxarea = 0;
		int[] dp = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// update the state of this row's histogram using the last row's histogram
				// by keeping track of the number of consecutive ones

				dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
			}
			// update maxarea with the maximum area from this row's histogram
			maxarea = Math.max(maxarea, leetcode84(dp));
		}
		return maxarea;
	}
	public static void main(String[] args) {
	    char[][] matrix = {
	        {'1', '0', '1', '0', '0'},
	        {'1', '0', '1', '1', '1'},
	        {'1', '1', '1', '1', '1'},
	        {'1', '0', '0', '1', '0'}
	    };
	    
	    MmaximalRectangle solution = new MmaximalRectangle();
	    int maxRectangleArea = solution.maximalRectangle(matrix);
	    System.out.println("Maximum rectangle area: " + maxRectangleArea);
	}


}
