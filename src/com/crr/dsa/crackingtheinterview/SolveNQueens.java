package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

	public static void main(String[] args) {
		SolveNQueens nQueens = new SolveNQueens();
		System.out.println(nQueens.solveNQueens(4));
	}

	List<List<String>> answer;

	public List<List<String>> solveNQueens(int n) {
		answer = new ArrayList<>();
		char board[][] = new char[n][n];
		backtracking(board, 0, new ArrayList<String>(), new StringBuilder());
		return answer;
	}

	public void backtracking(char[][] board, int row, List<String> result, StringBuilder sb) {
		if (result.size() == board.length && row >= board.length) {
			answer.add(new ArrayList<>(result));
			return;

		}

		for (int col = 0; col < board[0].length;) {
			if (row < board.length) {
				boolean res = canPlace(board, row, col);

				if (res) {
					int length = sb.length();
					sb.append('Q');
					board[row][col] = 'Q';
					int temp = col + 1;
					while (temp < board[0].length) {
						sb.append('.');
						temp++;
					}

					result.add(sb.toString());
					backtracking(board, row + 1, result, new StringBuilder());
					result.remove(result.size() - 1);
					sb.setLength(length);
					board[row][col] = '.';

				}
				sb.append('.');

				col++;
			}
		}

	}

	public boolean canPlace(char[][] board, int row, int col) {
		// horizontal

		for (int c = 0; c < board[0].length; c++) {
			if (board[row][c] == 'Q')
				return false;
		}

		// vertically

		for (int r = 0; r < board.length; r++) {
			if (board[r][col] == 'Q')
				return false;
		}

		// diagonally
		for (int r = row + 1, c = col + 1; r < board.length && c < board[0].length; r++, c++) {
			if (board[r][c] == 'Q')
				return false;
		}
		for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c] == 'Q')
				return false;
		}

		// anti diagonally
		for (int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--) {
			if (board[r][c] == 'Q')
				return false;
		}

		for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c] == 'Q')
				return false;
		}

		return true;
	}

}
