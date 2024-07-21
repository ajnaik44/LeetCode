package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class Summation {
	public static void main(String[] args) {
		System.out.println(summation(new int[] { 1, 6, 8, 5, 9, 4, 7, 2 })); // [1,14,18,9]
	}

	private static List<Integer> summation(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		int increment = 1;
		int index = 0;
		while (index < arr.length) {
			int sum = 0;

			for (int j = index; j < arr.length && j < index + increment; j++) {
				sum += arr[j];
			}
			index += increment;
			list.add(sum);
			increment++;

		}
		return list;

	}
}
