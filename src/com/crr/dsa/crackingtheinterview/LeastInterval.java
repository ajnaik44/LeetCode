package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastInterval {
	public static void main(String[] args) {
		LeastInterval solution = new LeastInterval();
		StringBuilder sb = new StringBuilder();
		
        // Example 1
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B','C','C','D'};
        int n1 = 3;
        System.out.println("Least interval for Example 1: " + solution.leastIntervalAp2(tasks1, n1)); // Output: 8

        // Example 2
        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n2 = 0;
       // System.out.println("Least interval for Example 2: " + solution.leastInterval(tasks2, n2)); // Output: 6
    }
	    public int leastInterval(char[] tasks, int n) {
	        // Build frequency map
	        int[] freq = new int[26];
	        for (char ch : tasks) {
	            freq[ch - 'A']++;
	        }
	        
	        // Max heap to store frequencies
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        for (int i = 0; i < 26; i++) {
	            if (freq[i] > 0) {
	                pq.offer(freq[i]);
	            }
	        }

	        int time = 0;
	        // Process tasks until the heap is empty
	        while (!pq.isEmpty()) {
	            int cycle = n + 1;
	            List<Integer> store = new ArrayList<>();
	            int taskCount = 0;
	            // Execute tasks in each cycle
	            while (cycle-- > 0 && !pq.isEmpty()) {
	                int currentFreq = pq.poll();
	                if (currentFreq > 1) {
	                    store.add(currentFreq - 1);
	                }
	                taskCount++;
	            }
	            // Restore updated frequencies to the heap
	            store.forEach(pq::offer);
	            // Add time for the completed cycle
	            time += (pq.isEmpty() ? taskCount : n + 1);
	        }
	        return time;
	    }
	    
	    
	    public int leastIntervalAjay(char[] tasks, int n) {
	        Map<Character, Integer> map = new HashMap<>();

	        for (char c : tasks) {
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        }

	        PriorityQueue<Map.Entry<Character, Integer>> pq =
	                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
	      

	        pq.addAll(map.entrySet());

	        int totalTasks = 0;
	        while (!pq.isEmpty()) {
	            int k = n + 1;
	            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
	            int taskCompleted = 0;
	            while (k > 0 && !pq.isEmpty()) {
	                Map.Entry<Character, Integer> task = pq.poll();
	                taskCompleted++;
	                if (task.getValue() > 1) {
	                    task.setValue(task.getValue() - 1);
	                    temp.add(task);
	                }
	                k--;
	            }
	            if (!temp.isEmpty()) {
	                pq.addAll(temp);
	            }
	            totalTasks += pq.isEmpty() ? taskCompleted : n + 1;
	        }
	        return totalTasks;
	    }
	    
	    public int leastIntervalAp2(char[] tasks, int n) {
	        // Create a frequency array to keep track of the count of each task
	        int[] freq = new int[26];
	        for (char task : tasks) {
	            freq[task - 'A']++;
	        }

	        // Sort the frequency array in non-decreasing order
	        Arrays.sort(freq);
	        // Calculate the maximum frequency of any task
	        int maxFreq = freq[25] - 1;
	        // Calculate the number of idle slots that will be required
	        int idleSlots = maxFreq * n;

	        // Iterate over the frequency array from the second highest frequency to the lowest frequency
	        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
	            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
	            idleSlots -= Math.min(maxFreq, freq[i]);
	        }

	        // If there are any idle slots left, add them to the total number of tasks
	        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
	    }
	
}
