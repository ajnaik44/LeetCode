package com.crr.practice;

public class TicTacClass {
	int[][] board = new int[3][3];
	static int X = -1;
	static int O = 1;
	private int currentPlayer =0; 
	public TicTacClass() {
		// TODO Auto-generated constructor stub
		currentPlayer=X;
	}
	public void putMark(int i, int j) throws Exception {
		if (i < 0 || i >= this.board[0].length || j < 0 || i >= this.board.length) {
			throw new Exception("Invalid Pointer");
		}
		this.board[i][j] = currentPlayer;
		currentPlayer=currentPlayer==X?O:currentPlayer==O?X:O;
	}

	public boolean isWinner(int player) {
		if (board[0][0] + board[0][1] + board[0][2] == player || board[1][0] + board[1][1] + board[1][2] == player
				|| board[2][0] + board[2][1] + board[2][2] == player
				|| board[0][0] + board[1][0] + board[2][0] == player
				|| board[0][1] + board[1][1] + board[2][1] == player
				|| board[0][2] + board[1][2] + board[2][2] == player
				|| board[0][0] + board[1][1] + board[2][2] == player
				|| board[2][0] + board[1][1] + board[0][2] == player) {
			return true;
		}
		return false;

	}
	public int winner()
	{
		if(isWinner(3))
			return O;
		else if(isWinner(-3))
			return X;
		else return 0;
		
	}

	public static void main(String[] args) throws Exception {
		TicTacClass game = new TicTacClass();
		game.putMark(1,1); game.putMark(0,2);
		 game.putMark(2,2); game.putMark(0,0);
		 game.putMark(0,1); game.putMark(2,1);
		 game.putMark(1,2); game.putMark(1,0);
		 game.putMark(2,0);
		 System.out.println(game);
		 int winningPlayer = game.winner();
		 String[ ] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
		 System.out.println(outcome[1 + winningPlayer]);

		for (int i = 0; i < game.board[0].length; i++) {
			for (int j = 0; j < game.board[0].length; j++) {
				System.out.print(game.board[i][j]);
			}
			System.out.print("\n");
		}
	}

}
