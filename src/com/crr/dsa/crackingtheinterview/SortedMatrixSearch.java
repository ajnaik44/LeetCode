package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class SortedMatrixSearch {
	static boolean findElement(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1; // Start from the top-right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Element found
            } else if (matrix[row][col] > target) {
                col--; // Move left in the same row
            } else {
                row++; // Move down to the next row
            }
        }

        return false; // Element not found
    }
	 // Method to print the matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
	  public static void main(String[] args) {
	        int[][] matrix = {
	            {15, 20, 40,85},
	            {20, 35, 80,95},
	            {30, 55, 95,105},
	            {40,80,100,120}
	        };

	        int target = 55;

	        System.out.println("Matrix:");
	        printMatrix(matrix);

	        if (findElement(matrix, target)) {
	            System.out.println("Element " + target + " found in the matrix.");
	        } else {
	            System.out.println("Element " + target + " not found in the matrix.");
	        }
	    }
}
