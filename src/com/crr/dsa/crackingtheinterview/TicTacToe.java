package com.crr.dsa.crackingtheinterview;

public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        System.out.println(game.move(0, 0, 1)); // Player 1 moves at (0, 0)
        System.out.println(game.move(0, 1, 2)); // Player 2 moves at (0, 1)
        System.out.println(game.move(1, 1, 1)); // Player 1 moves at (1, 1)
        System.out.println(game.move(1, 0, 2)); // Player 2 moves at (1, 0)
        System.out.println(game.move(2, 2, 1)); // Player 1 moves at (2, 2), Player 1 wins
    }
}

