package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class ZeroMatrix {
	public static void setZeroMatrix(int[][] matrix) {
		Map<Integer, Integer> row = new HashMap<>();
		Map<Integer, Integer> col = new HashMap<>();

		for (int i = 0; i < matrix.length; i++) {
			if (row.containsKey(i))
				continue;
			for (int j = 0; j < matrix[0].length; j++) {
				if (col.containsKey(j))
					continue;
				if (matrix[i][j] == 0) {

					for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
						matrix[i][colIndex] = 0;
					}

					for (int rowIndex = 0; rowIndex < matrix[0].length; rowIndex++) {
						matrix[rowIndex][j] = 0;
					}

					row.put(i, 1);
					col.put(j, 1);
					break;
				}

			}
		}
		System.out.println(row);
	}

	public static void main(String[] args) {
		// Example usage
		int[][] matrix = { { 0, 4, 9, 3 }, { 5, 3, 1, 2 }, { 7, 4, 3, 0 }, { 9, 8, 5, 1 } };

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		// Rotate the matrix
		setZeroMatrix(matrix);

		System.out.println("Rotated Matrix:");
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
