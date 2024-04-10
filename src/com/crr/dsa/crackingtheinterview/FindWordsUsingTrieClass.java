package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNodeAjay {
	Map<Character,TrieNodeAjay> child = new HashMap<Character,TrieNodeAjay>();
	String words;
		public TrieNodeAjay() {
		// TODO Auto-generated constructor stub
	}
}

public class FindWordsUsingTrieClass {
	List<String> results = new ArrayList<String>();
	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, 
							{ 'e', 't', 'a', 'e' },
							{ 'i', 'h', 'k', 'r' },
							{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
	
	System.out.println(new FindWordsUsingTrieClass().storeWord(board,words));
	}

	public List<String> storeWord(char[][] board, String[] words) {
		TrieNodeAjay root = new TrieNodeAjay();
		for(String word: words)
		{
			TrieNodeAjay curr =root;
			for(char c: word.toCharArray())
			{
				if(curr.child.containsKey(c))
				{
					curr =  curr.child.get(c);
				}else {
					
					TrieNodeAjay newNode = new TrieNodeAjay();
					curr.child.put(c,newNode);
					curr = curr.child.get(c);
				}
				
			}
			curr.words =  word;
		}
		for(int row=0;row<board.length;row++)
		{
			for(int col=0;col<board[0].length;col++)
			{
				if(root.child.containsKey(board[row][col]))
				{
					backtracking(board,root,row,col);
				}
			}
		}
		return results;
	}

	private void backtracking(char[][] board, TrieNodeAjay root, int row, int col) {
		char letter = board[row][col];
		TrieNodeAjay current =  root.child.get(letter);
		
		if(current.words!=null)
		{
			results.add(current.words);
			return;
		}
		
		board[row][col]='#';
		
		
		int rows[]= {1,0,-1,0};
		int cols[] = {0,1,0,-1};
		
		for(int newrow=0;newrow<rows.length;newrow++)
		{
			int r =  rows[newrow]+row;
			int c =  cols[newrow]+col;
			if(r>=0&&r<board.length &&  c>=0 &&  c< board[0].length && current.child.containsKey(board[r][c]))
			{
				backtracking(board, current,r, c );
			}
		}
		board[row][col]=letter;
		
		
	}

}
