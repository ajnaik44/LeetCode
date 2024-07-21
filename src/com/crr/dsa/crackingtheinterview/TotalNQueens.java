package com.crr.dsa.crackingtheinterview;

public class TotalNQueens {
public static void main(String[] args) {
	TotalNQueens nQueens = new TotalNQueens();
	System.out.println(nQueens.totalNQueens(2));
}
	int answer = 0;

	public int totalNQueens(int n) {
		int[][] board = new int[n][n];
		backTracking(0, board);
		return answer;
	}

	public void backTracking(int row, int[][] board) {
		if (row >= board.length) {
			answer++;
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			if(row<board.length) {
			if (canPlace(row, col, board)) {
				board[row][col] = 1;
				backTracking(row + 1, board);
				board[row][col] = 0;
			}
			}
		}
	}

	public boolean canPlace(int row, int col, int[][] board) {
		if(row>board.length ||  col >  board[0].length)
			return true;
		int c = 0;
		while (row <  board.length &&  c < board[0].length) {
			
			if (c == col) {
				c++;
				continue;
				}
			if (board[row][c] == 1)
				return false;
			c++;
		}

		int r = 0;
		c=col;
		while (r < board.length && c < board[0].length) {
			
			if (r == row) {r++;
				continue;
			}
			if (board[r][col] == 1)
				return false;
			r++;

		}
		// right diagonal
		r = row + 1;
		c = col + 1;
		while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			if (board[r][c] == 1)
				return false;
			r++;
			c++;

		}

		// top diagonal
		r = row - 1;
		c = col - 1;
		while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			if (board[r][c] == 1)
				return false;
			r--;
			c--;

		}
		// bottom left diagonal
		r = row + 1;
		c = col - 1;
		while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			if (board[r][c] == 1)
				return false;
			r++;
			c--;

		}
		// right top diagonal
		r = row - 1;
		c = col + 1;
		while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			if (board[r][c] == 1)
				return false;
			r--;
			c++;

		}
		return true;
	}

}
