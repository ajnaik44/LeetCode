package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixSorting {
    public static void main(String[] args) {
        int[][] matrix = {
            {6, 2},
            {5, 0},
            {8, 3},
            {2, 1},
            {4, 7}
        };

        // Sort the matrix
        sortMatrix(matrix);

        System.out.println("Sorted Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void sortMatrix(int[][] matrix) {
        Arrays.sort(matrix, Comparator.comparingInt(row -> row[0]));
    }
}
