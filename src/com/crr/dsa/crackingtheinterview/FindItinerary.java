package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindItinerary {
	 public List<String> findItinerary(List<List<String>> tickets) {
	        Map<String, PriorityQueue<String>> graph = new HashMap<>();

	        // Build the graph
	        for (List<String> ticket : tickets) {
	            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
	            graph.get(ticket.get(0)).add(ticket.get(1));
	        }

	        LinkedList<String> answer = new LinkedList<>();
	        dfs(graph, "JFK", answer);
	        return answer;
	    }

	    public void dfs(Map<String, PriorityQueue<String>> graph, String source, LinkedList<String> answer) {
	        PriorityQueue<String> nextAirports = graph.get(source);
	        while (nextAirports != null && !nextAirports.isEmpty()) {
	            dfs(graph, nextAirports.poll(), answer);
	        }
	        answer.addFirst(source);  // Use addFirst to add the source at the beginning
	    }

	    public static void main(String[] args) {
	    	FindItinerary sol = new FindItinerary();
	    	List<List<String>> tickets = new ArrayList<>();
	        
	        tickets.add(Arrays.asList("JFK", "SFO"));
	        tickets.add(Arrays.asList("JFK", "ATL"));
	        tickets.add(Arrays.asList("SFO", "ATL"));
	        tickets.add(Arrays.asList("ATL", "JFK"));
	        tickets.add(Arrays.asList("ATL", "SFO"));

	        System.out.println(sol.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc")); // Expected Output: [JFK, MUC, LHR, SFO, SJC]
	    }
	    public int strongPasswordChecker(String password) {
	        boolean lowercase = false;
	        boolean uppercase = false;
	        boolean digit = false;
	        int answer = 0;
	        int length = password.length();
	        int consecutive = 0;

	        // Count the types of characters present and find consecutive characters
	        for (int i = 0; i < length; ) {
	            char c = password.charAt(i);
	            if (Character.isLowerCase(c)) {
	                lowercase = true;
	            }
	            if (Character.isUpperCase(c)) {
	                uppercase = true;
	            }
	            if (Character.isDigit(c)) {
	                digit = true;
	            }

	           // int j = i;
	            int counter=0;
	            while (i < length && password.charAt(i) == c) {
	                i++;
	                counter++;
	            }
	           // i =  i==length ? i :  i-1; 
	            consecutive += Math.max(0, counter / 3);
	        }

	        // Check for character type constraints
	        if (!lowercase) {
	            answer++;
	        }
	        if (!uppercase) {
	            answer++;
	        }
	        if (!digit) {
	            answer++;
	        }

	        // Check for length constraints and adjust the answer accordingly
	        if (length < 6) {
	            return Math.max(6 - length, answer);
	        } else if (length <= 20) {
	            return Math.max(consecutive, answer);
	        } else {
	            // Handle passwords longer than 20 characters
	            int extraChars = length - 20;
	            answer += extraChars;
	            // Reduce the number of replacements needed by reducing the number of consecutive characters
	            return answer + Math.max(0, consecutive - extraChars);
	        }
	    }
}
