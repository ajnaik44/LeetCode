package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTotalDistance {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        // Collect coordinates of all friends (1s)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Sort the coordinates
        Collections.sort(rows);
        Collections.sort(cols);

        // Get the median
        int medianRow = rows.get(rows.size() / 2);
        int medianCol = cols.get(cols.size() / 2);

        // Calculate the total travel distance to the median point
        int totalDistance = 0;
        for (int row : rows) {
            totalDistance += Math.abs(row - medianRow);
        }
        for (int col : cols) {
            totalDistance += Math.abs(col - medianCol);
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        MinTotalDistance sol = new MinTotalDistance();
        int[][] grid = {
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };
        int result = sol.minTotalDistance(grid);
        System.out.println(result);  // Output: 6
    }
}

