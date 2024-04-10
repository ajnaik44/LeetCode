package com.crr.dsa.crackingtheinterview;

import java.util.PriorityQueue;

public class FindMediean {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

	public void addMedian(int n) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(n);
			return;
		}
		if (minHeap.isEmpty()) {
			if (maxHeap.peek() < n) {
				minHeap.add(n);
			} else {
				minHeap.add(maxHeap.poll());
				maxHeap.add(n);
			}
		} else if (!minHeap.isEmpty() && !maxHeap.isEmpty() && (minHeap.size() - maxHeap.size()) > 1) {
			maxHeap.add(minHeap.poll());
			minHeap.add(n);
		} else if (!minHeap.isEmpty() && !maxHeap.isEmpty() && (maxHeap.size() - minHeap.size()) > 1) {
			minHeap.add(maxHeap.poll());
			maxHeap.add(n);
		} else if (n < maxHeap.peek()) {
			maxHeap.add(n);
		} else {
			minHeap.add(n);
		}
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println("ddddddddddddddddddd");
	}

	public double calculateMedian() {
		if (minHeap.size() == maxHeap.size())
			return ((double) (minHeap.peek() + maxHeap.peek() / 2));
		if (minHeap.size() - maxHeap.size() > 1)
			return minHeap.peek();
		else
			return maxHeap.peek();
	}

	public static void main(String[] args) {
		FindMediean medianCalculator = new FindMediean(); // Replace YourClassNameHere with the name of the class where
															// your addMedian method resides

		// Add some numbers to the median calculator
		medianCalculator.addMedian(5);
		medianCalculator.addMedian(10);
		medianCalculator.addMedian(2);
		medianCalculator.addMedian(7);
		medianCalculator.addMedian(1);
		medianCalculator.addMedian(3);
		medianCalculator.addMedian(4);
		// Calculate and print the median
		double median = medianCalculator.calculateMedian();
		System.out.println("Median: " + median);
	}

}
