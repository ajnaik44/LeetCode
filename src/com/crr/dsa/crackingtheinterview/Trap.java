package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class Trap {

	public int trap(int[] height) {
		int ans = 0;
		int size = height.length;
		int current = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (current < size) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {

				int top = stack.pop();
				if (stack.isEmpty())
					break;
				int distance = current - stack.peek() - 1;

				int boundHeight = Math.min(height[current], height[stack.peek()]) - height[top];
				ans += distance * boundHeight;

			}
			stack.push(current);
			current++;
		}
		return ans;
	}
	// Java

	public int trapOptimize1(int[] height) {
		int left = 0, right = height.length - 1;
		int ans = 0;
		int left_max = 0, right_max = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				left_max = Math.max(left_max, height[left]);
				ans += left_max - height[left];
				++left;
			} else {
				right_max = Math.max(right_max, height[right]);
				ans += right_max - height[right];
				--right;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { 4, 2, 0, 3, 2, 5 };
		Trap trap = new Trap();
		trap.trapOptimize1(nums);
	}
}
