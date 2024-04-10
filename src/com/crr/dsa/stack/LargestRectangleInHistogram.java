package com.crr.dsa.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static int largestRectangleArea(int[] heights) {
		int length = heights.length;
		int[] leftArray = new int[length];
		int[] rightBoundaries = new int[length];
		// 3, 2, 5, 6, 1, 4, 4

		for (int i = 0; i < length; i++) {
			leftArray[i] = i;
			while (leftArray[i] > 0 && heights[leftArray[i] - 1] >= heights[i]) {
				leftArray[i] = leftArray[leftArray[i] - 1];
			}
		}
	//	printIntArray(leftArray);
		for (int i = length - 1; i >= 0; i--) {
			rightBoundaries[i] = i;
			while (rightBoundaries[i] < length - 1 && heights[rightBoundaries[i] + 1] >= heights[i]) {
				rightBoundaries[i] = rightBoundaries[rightBoundaries[i] + 1];
			}
		}
	//	printIntArray(rightBoundaries);

		int max = 0;
		for (int i = 0; i < length; i++) {
			int temp = heights[i] * (rightBoundaries[i] - leftArray[i] + 1);
			System.out.println(temp);
			max = Math.max(max, temp);
		}
		return max;
	}
	
	public static int largestRectangleAreaUisngStack(int [] inputArray)
	{
		Stack<Integer> s = new Stack<>();
		if(inputArray==null || inputArray.length==0)
		{
			return 0;
		}
		int max = 0;
		int i=0; //6, 2, 5, 4, 5, 1, 6
		while(i<inputArray.length)
		{
			if(s.empty() ||  inputArray[s.peek()]<=inputArray[i])
				s.push(i++);
			else {
				int top =  s.pop();
				max = Math.max(max, inputArray[top] * (s.empty()?i:i-s.peek()-1));
			}
		}
		while(!s.isEmpty())
		{
			int top =  s.pop();
			max=  Math.max(max, inputArray[top] * (s.empty()?i:i-s.peek()-1));
		}
		return max;
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
		int[] heights = { 6, 2, 5, 4, 5, 1, 6 };
		int maxRectangleArea = largestRectangleAreaUisngStack(heights);
		System.out.println("The largest rectangle area is: " + maxRectangleArea);
	}
}
