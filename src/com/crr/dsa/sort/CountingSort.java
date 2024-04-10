package com.crr.dsa.sort;

public class CountingSort {
    public static void main(String[] args) {
        int[] A = {4, 8, 3,1};
        System.out.println(A.length);
        int k = 9; // The range of values (0 to k-1)
        int n = A.length;
        int[] B = new int[n];

        countingSort(A, B, k);

        System.out.println("Sorted Array:");
        for (int num : B) {
            System.out.print(num + " ");
        }
    }

    public static void countingSort(int[] A, int[] B, int k) {
        int i, j, n = A.length;
        int[] c = new int[k];

        for (i = 0; i < k; i++)
            c[i] = 0;

        for (j = 0; j < n; j++) {
            c[A[j]] = c[A[j]] + 1;
        }

        for (i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (j = n - 1; j >= 0; j--) {
            B[c[A[j]] - 1] = A[j];
            c[A[j]] = c[A[j]] - 1;
        }
    }
}
