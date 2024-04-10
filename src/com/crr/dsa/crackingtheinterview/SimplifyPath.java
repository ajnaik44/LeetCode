package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
	    public static String simplifyPath(final String path) {
	        final StringBuilder sb = new StringBuilder();
	        final Stack<String> stack = new Stack<>();

	        for(int i = 0; i < path.length() + 1; ++i) {
	            if((i == path.length() || path.charAt(i) == '/') && sb.length() > 0) {
	                final String directory = sb.toString();

	                if(directory.equals("..") && !stack.isEmpty())
	                    stack.pop();
	                else if(!directory.equals("..") && !directory.equals("."))
	                    stack.push(directory.toString());

	                sb.setLength(0);
	            } else if(i < path.length() && path.charAt(i) != '/') {
	                sb.append(path.charAt(i));
	            }
	        }

	        String result = "";

	        while(!stack.isEmpty())
	            result = "/" + stack.pop() + result;

	        return result.length() == 0 ? "/" : result;
	    }
	    public static void main(String[] args) {
			System.out.println(simplifyPath("/../"));
			 int[] intervals = {2,3,5};
		      System.out.println(combinationSum(intervals, 8));
		}
	    
	    public static List<List<Integer>> combinationSum(int[] nums, int target) {
	        List<List<Integer>> list = new ArrayList<>();
	        Arrays.sort(nums);
	        backtrack(list, new ArrayList<>(), nums, target, 0);
	        return list;
	    }

	    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	        if(remain < 0) return;
	        else if(remain == 0) list.add(new ArrayList<>(tempList));
	        else{ 
	            for(int i = start; i < nums.length; i++){
	                tempList.add(nums[i]);
	                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	                tempList.remove(tempList.size() - 1);
	            }
	        }
	    }
}
