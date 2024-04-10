package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class NextGreaterElement {

	    public int[] nextGreaterElements(int[] nums) {
	        int[] res = new int[nums.length];
	        Stack<Integer> stack = new Stack<>();
	        for (int i = 2 * nums.length - 1; i >= 0; --i) {
	            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
	                stack.pop();
	            }
	            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
	            stack.push(i % nums.length);
	        }
	        return res;
	    }
public static void main(String[] args) {
	int[] nums =  {3,8,4,1,2};
	nums =  new NextGreaterElement().nextGreaterElements(nums);
	for(int i:nums)
	{
		System.out.print(i + " ");
	}
}
}
