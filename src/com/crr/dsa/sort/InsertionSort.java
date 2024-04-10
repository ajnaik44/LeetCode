package com.crr.dsa.sort;

public class InsertionSort {
	public static void main(String[] args) {
        int[] arr = {6 ,8, 1, 4, 5, 3, 7, 2};
        insertionSort(arr);
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
	public static void insertionSort(int[] A) {
	    int i, j, v;
	    for (i = 1; i < A.length; i++) { // Start from the second element (index 1)
	        v = A[i];
	        j = i;
	        while (j > 0 && A[j - 1] > v) {
	            A[j] = A[j - 1]; // Shift elements to the right
	            j--;
	        }
	        A[j] = v; // Place v in its correct position
	    }
	}

}
