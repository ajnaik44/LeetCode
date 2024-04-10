package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;

public class EightQueens {
	static int GRID_SIZE = 4;

    // Method to place queens recursively
    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            // Found valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; // Place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    // Method to check if placing queen at (row, column) is valid
    boolean checkValid(Integer[] columns, int row, int column) {
        for (int row2 = 0; row2 < row; row2++) {
        	
            int column2 = columns[row2];
            // Check if (row, column) invalidates (row2, column2) as a queen spot
            
            if (column == column2 || Math.abs(column - column2) == row - row2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] columns = new Integer[GRID_SIZE];
        eightQueens.placeQueens(0, columns, results);
        System.out.println(results.size());
        for (Integer[] result : results) {
            for (int col : result) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
