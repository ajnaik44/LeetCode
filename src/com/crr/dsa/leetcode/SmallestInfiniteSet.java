package com.crr.dsa.leetcode;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	int currentInteger = 1;

	public SmallestInfiniteSet() {
		System.out.println("called");
	}

	public int popSmallest() {
		System.out.println("Popping the smallest element:");
		if (pq.peek() == null) {
			int answer = currentInteger;
			currentInteger++;
			return answer;
		}
		System.out.println(pq);
		return pq.poll();
	}

	public void addBack(int num) {
		System.out.println("Adding some elements to the set:");
		System.out.println(num);
		System.out.println(currentInteger);
		System.out.println(currentInteger <= num);
		if (currentInteger <= num && pq.contains(num))
			return;
		pq.add(num);
		System.out.println(pq);
	}

	public static void main(String[] args) {
		SmallestInfiniteSet set = new SmallestInfiniteSet();

		// Example usage
		System.out.println("Adding some elements to the set:");
		set.addBack(3);
		set.addBack(3);
		set.addBack(3);
		set.addBack(1);
		set.addBack(5);

		System.out.println("Popping the smallest element:");
		int smallest = set.popSmallest();
		System.out.println("Smallest element: " + smallest);

		// Add more elements or perform additional operations as needed
	}
}
