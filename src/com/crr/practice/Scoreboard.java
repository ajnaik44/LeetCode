package com.crr.practice;

public class Scoreboard {
	private int numEntries = 0;
	private GameEntry[] board;

	public Scoreboard(int capacity) {
		super();
		board = new GameEntry[capacity];
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder  sb = new StringBuilder();
		for(int i=0;i<numEntries;i++)
		{
			sb.append(board[i].getName() + " :: "); 
			sb.append(board[i].getScore() + " :: "); 
			sb.append("\n"); 
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public void addEntry(GameEntry gameEntry) {
		int newScore = gameEntry.getScore();
		if (this.numEntries < this.board.length || newScore > board[numEntries - 1].getScore()) {
			numEntries++;
			int j = numEntries - 1;
			while (j > 0 && board[j - 1].getScore() < newScore) {
				board[j] = board[j - 1];
				j--;
			}
			board[j] = gameEntry;
		}
	}

	public GameEntry removeEntry(int i) {
		if(i<0||i>=numEntries) {
			throw new IndexOutOfBoundsException("Invalid index"+i);
		}
		GameEntry temp =  board[i];
		for(int j=i;j<numEntries-1;j++) {
			board[j]= board[j+1];
		
		}
		board[numEntries-1]=null;
		numEntries--;
		return temp;
	}
	public static void main(String[] args) {
		Scoreboard scoreboard = new Scoreboard(10);
		GameEntry entry = new GameEntry("Mike", 1105);
		GameEntry entry1 = new GameEntry("Rob", 750);
		GameEntry entry2 = new GameEntry("Paul", 720);
		GameEntry entry3 = new GameEntry("Anna", 660);
		GameEntry entry4 = new GameEntry("Rose", 590);
		GameEntry entry5 = new GameEntry("Jack", 510);
		scoreboard.addEntry(entry);
		scoreboard.addEntry(entry1);
		scoreboard.addEntry(entry2);
		scoreboard.addEntry(entry3);
		scoreboard.addEntry(entry4);
		scoreboard.addEntry(entry5);
		scoreboard.toString();
		GameEntry entry6 = new GameEntry("Jill", 740);
		scoreboard.addEntry(entry6);
		scoreboard.toString();
		scoreboard.removeEntry(2);
		scoreboard.toString();
		
		
	}
}
