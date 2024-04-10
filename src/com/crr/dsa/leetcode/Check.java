package com.crr.dsa.leetcode;

import java.util.ArrayList;

public class Check {

enum Piece { Empty, Red, Blue};
	public int row,column;
	private int rowIncrement,columnIncrement;
	public Check(int row, int column, int rowIncrement, int columnIncrement) {
		super();
		this.row = row;
		this.column = column;
		this.rowIncrement = rowIncrement;
		this.columnIncrement = columnIncrement;
	}
	public void increment()
	{
		row+=rowIncrement;
		column += columnIncrement;
	}
	
	public boolean inBounds(int size)
	{
		return row >=0&& column>=0 && row< size&& column<size;
	}
	Piece hasWon(Piece[][] board)
	{
		if(board.length!=board[0].length)
			return Piece.Empty;
		
		int size =  board.length;
		
		ArrayList<Check> instructions = new ArrayList<Check>();
		for(int i=0;i<board.length;i++)
		{
			instructions.add(new Check(0,i,1,0));
			instructions.add(new Check(i,0,0,1));
			
		}
		instructions.add(new Check(0,0,1,1));
		instructions.add(new Check(0,size-1,1,-1));
		
		for(Check instr:instructions)
		{
			Piece winner =  hasWon(board,instr);
			if(winner!=Piece.Empty)
				return winner;
		}
		return Piece.Empty;
		
		
	}
	Piece hasWon(Piece[][] board,Check check)
	{
		Piece first =  board[check.row][check.column];
		while(check.inBounds(board.length))
		{
			if(board[check.row][check.column]!=first)
			{
				return Piece.Empty;
			}
			check.increment();
		}
		return first;
	}
	
}
