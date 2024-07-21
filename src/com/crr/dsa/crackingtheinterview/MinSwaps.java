package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class MinSwaps {
	 public static String minSwapsToBalance(String s) {
	        char[] arr = s.toCharArray();
	        int imbalance = 0;
	        int maxImbalance = 0;
	        int left = 0;
	        int right = s.length() - 1;
	        
	        // Array to store the positions of imbalanced brackets
	        List<Integer> imbalancePositions = new ArrayList<>();

	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == '[') {
	                imbalance--;
	            } else {
	                imbalance++;
	            }
	            // Record the maximum imbalance observed
	            if (imbalance > maxImbalance) {
	                maxImbalance = imbalance;
	                imbalancePositions.add(i);
	            }
	        }

	        // Perform swaps to balance the string
	        int swapsNeeded = (maxImbalance + 1) / 2;

	        for (int i = 0; i < swapsNeeded; i++) {
	            // Find the positions to swap
	            while (arr[left] == '[') left++;
	            while (arr[right] == ']') right--;

	            // Swap positions to balance
	            char temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;

	            left++;
	            right--;
	        }

	        return new String(arr);
	    }
	 public static void main(String[] args) {
		MinSwaps minSwaps = new MinSwaps();
		System.out.println(minSwaps.minInsertions(")))))))"));
		TreeSet<String> set = new TreeSet<>();
		set.add("cvf");
		set.add("azs");
		for(String s :  set)
		{
			System.out.println(s);
		}
	}
	 public int minInsertions(String s) {
	        Stack<Character> stack=new Stack<>();
	        int count=0;
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if(c == '('){
	                stack.push(c);
	            }
	            else{
	                if(i+1<s.length()&& s.charAt(i+1)==')'){
	                    i++;
	                }
	                else {
	                    count++;
	                }
	                
	                if(!stack.isEmpty()){
	                    stack.pop();
	                }
	                else{
	                    count++;
	                }
	            }
	        }
	        count += 2*stack.size();
	        return count;
	    }
}
