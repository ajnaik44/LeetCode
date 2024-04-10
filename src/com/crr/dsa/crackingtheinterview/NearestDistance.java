package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestDistance {
	public static void main(String[] args) {
		// Example matrix
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		NearestDistance solution = new NearestDistance();
		int[][] updatedMatrix = solution.updateMatrix(matrix);

		// Print the updated matrix
		System.out.println("Updated Matrix:");
		for (int[] row : updatedMatrix) {
			for (int cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		
		
		ArrayList<Set<Integer>> ds = new ArrayList();
		ds.add
	}

	class State {
		int row;
		int col;
		int steps;

		State(int row, int col, int steps) {
			this.row = row;
			this.col = col;
			this.steps = steps;
		}
	}

	int m;
	int n;
	int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int[][] updateMatrix(int[][] mat) {
		m = mat.length;
		n = mat[0].length;

		int[][] matrix = new int[m][n];
		boolean[][] seen = new boolean[m][n];
		Queue<State> queue = new LinkedList<>();

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				matrix[row][col] = mat[row][col];
				if (mat[row][col] == 0) {
					queue.add(new State(row, col, 0));
					seen[row][col] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			State state = queue.remove();
			int row = state.row, col = state.col, steps = state.steps;

			for (int[] direction : directions) {
				int nextRow = row + direction[0], nextCol = col + direction[1];
				if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
					seen[nextRow][nextCol] = true;
					queue.add(new State(nextRow, nextCol, steps + 1));
					matrix[nextRow][nextCol] = steps + 1;
				}
			}
		}

		return matrix;
	}

	public boolean valid(int row, int col) {
		return 0 <= row && row < m && 0 <= col && col < n;
	}

}
