package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindBuilding {
	public static void main(String[] args) {
		int arr[]= {4,2,3,1,1};
		System.out.println(findBuildings(arr));
	}
	    public static int[] findBuildings(int[] heights) {
	        int n = heights.length;
	        List<Integer> list = new ArrayList<>();
	        
	        // Monotonically decreasing stack.
	        Stack<Integer> stack = new Stack<>();  
	        for (int current = n - 1; current >= 0; --current) {
	            // If the building to the right is smaller, we can pop it.
	            while (!stack.isEmpty() && heights[stack.peek()] < heights[current]) {
	                stack.pop();
	            }
	            
	            // If the stack is empty, it means there is no building to the right 
	            // that can block the view of the current building.
	            if (stack.isEmpty()) { 
	                list.add(current);
	            }
	            
	            // Push the current building in the stack.
	            stack.push(current);
	        }
	 
	        // Push elements from list to answer array in reverse order.
	        int[] answer = new int[list.size()];
	        for (int i = 0; i < list.size(); ++i) {
	            answer[i] = list.get(list.size() - 1 - i);
	        }
	        
	        return answer;
	    }
	
}
