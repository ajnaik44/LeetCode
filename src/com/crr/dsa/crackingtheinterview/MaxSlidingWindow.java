package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) 
    {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int ri = 0;
        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements as they are not useful
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to deque
            deque.offer(i);

            // Add maximum of current window to result
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
           TreeMap tr= new TreeMap<>();
           tr.descendingMap();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Max values in sliding windows of size " + k + ":");
        System.out.println(wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!"));
    }
    
    
    public static String[][] wordCountEngine(String document) {
        Map<String, Integer> wordMap = new HashMap<>();
        String[] words = document.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        int largestCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                int count = wordMap.getOrDefault(word, 0) + 1;
                wordMap.put(word, count);
                largestCount = Math.max(largestCount, count);
            }
        }
    
        List<String>[] counterList = new ArrayList[largestCount + 1];
        for (int i = 0; i <= largestCount; i++) {
            counterList[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            counterList[entry.getValue()].add(entry.getKey());
        }

        List<String[]> resultList = new ArrayList<>();
        for (int i = largestCount; i >= 0; i--) {
            for (String word : counterList[i]) {
                resultList.add(new String[]{word, Integer.toString(i)});
            }
        }
        

        return resultList.toArray(new String[0][]);
    }
}
