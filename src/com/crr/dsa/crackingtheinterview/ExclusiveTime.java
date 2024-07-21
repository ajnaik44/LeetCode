package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
		
		int i[] = new ExclusiveTime().exclusiveTime(2, list);
		for(int j:i)
			System.out.println(j);
	}
	    public int[] exclusiveTime(int n, List<String> logs) {
	        Stack<Log> stack = new Stack<>();
	        
	        int[] result = new int[n];
	        
	        for (String content : logs) {
	            Log log = new Log(content);
	            if (log.isStart) {
	                stack.push(log);
	            } else {
	                Log top = stack.pop();
	                result[top.id] += (log.time - top.time + 1);
	                if (!stack.isEmpty()) {
	                    result[stack.peek().id] -= (log.time - top.time + 1);
	                }
	            }
	        }
	        
	        return result;
	    }
	    
	    public static class Log {
	        public int id;
	        public boolean isStart;
	        public int time;
	        
	        public Log(String content) {
	            String[] strs = content.split(":");
	            id = Integer.parseInt(strs[0]);
	            isStart = strs[1].equals("start");
	            time = Integer.valueOf(strs[2]);
	        }
	    }
	
}
