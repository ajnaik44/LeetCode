package com.crr.dsa.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		mergeSort(arr);
		System.out.println("Sorted Array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void mergeSort(int[] arr) {
		int n = arr.length;
		if (n > 1) {
			int mid = n / 2;
			int left_arr[] = new int[mid];
			int right_arr[] = new int[n - mid];

			for (int i = 0; i < mid; i++) {
				left_arr[i] = arr[i];
			}
			for (int j = 0; j < n-mid; j++) {
				right_arr[j] = arr[mid+j];
			}

			mergeSort(left_arr);
			mergeSort(right_arr);

			int i = 0, j = 0, k = 0;

			for (; i < left_arr.length && j < right_arr.length;) {
				if (left_arr[i] < right_arr[j]) {
					arr[k] = left_arr[i];
					i++;
				} else {
					arr[k] = right_arr[j];
					j++;
				}
				k++;
			}
			while (i < left_arr.length) {
				arr[k] = left_arr[i];
				i++;
				k++;
			}
			while (j < right_arr.length) {
				arr[k] = right_arr[j];
				j++;
				k++;
			}
		}
	}
}
