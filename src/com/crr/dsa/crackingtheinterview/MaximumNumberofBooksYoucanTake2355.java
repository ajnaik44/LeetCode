package com.crr.dsa.crackingtheinterview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumNumberofBooksYoucanTake2355 {
	public static long maximumBooks(int[] books) {
	    long[] dp = new long[books.length];
	    Deque<Integer> stack = new ArrayDeque<>();

	    for (int i = 0; i < books.length; i++) {
	        int currentBookCount = books[i];
	        int currentIndex = i;
	        
	        while (!stack.isEmpty() && currentBookCount < books[stack.peek()] + currentIndex - stack.peek()) {
	            stack.pop();
	        }

	        int startingIndex = stack.isEmpty() ? Math.max(0, currentIndex - currentBookCount + 1) : stack.peek() + 1;
	        int j = startingIndex;
	        
	        long doubleCurrentBookCount = currentBookCount + currentBookCount; // Twice the current number of books
	        long currentIndexMinusJ = currentIndex - j; // Difference between current index and starting index
	        long maxBooksNumerator = doubleCurrentBookCount - currentIndexMinusJ; // Numerator for maxBooks calculation
	        long maxBooksDenominator = currentIndexMinusJ + 1; // Denominator for maxBooks calculation
	        long maxBooksNumeratorTimesDenominator = maxBooksNumerator * maxBooksDenominator; // Numerator times Denominator
	        long maxBooks = maxBooksNumeratorTimesDenominator / 2; // Max books that can be collected

	        long additionalBooks = stack.isEmpty() ? 0 : dp[j - 1];
	        dp[currentIndex] = maxBooks + additionalBooks;

	        stack.push(currentIndex);
	    }

	    long maxBookCount = Arrays.stream(dp).max().getAsLong();
	    return maxBookCount;
	}


	 public static void main(String[] args) {
		 int array[] ={8,5,2,7,9};
	
		System.out.println(maximumBooks(array));
	}
	 
}
