package com.crr.dsa.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromEntranceinMaze {
	public int nearestExit(char[][] maze, int[] entrance) {

		int rows = maze.length, cols = maze[0].length;
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int startrow = entrance[0], startCol = entrance[1];
		maze[startrow][startCol] = '+';
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startrow, startCol, 0 });
		while(!queue.isEmpty())
		{
			int cur[] =  queue.poll();
			int currRow =  cur[0], currCol =  cur[1], currDistance = cur[2];
			
			for(int [] dir : dirs)
			{
				int nextrow= currRow+ dir[0], nextCol =  currCol+dir[1];
				
				if(0<=nextrow && nextrow<rows &&  0<=nextCol &&  nextCol< cols &&  maze[nextrow][nextCol]=='.')
				{
					if(nextrow==0 ||  nextCol==0|| nextrow ==  rows-1 || nextCol ==  cols-1)
						return currDistance+1;
					maze[nextrow][nextCol]='+';
					queue.offer(new int[] {nextrow,nextCol,currDistance+1});
				}
			}
		}
		return -1;
	}
	    public static void main(String[] args) {
	        char[][] maze = {
	            {'+', '+', '+', '+'},
	            {'.', '.', '.', '+'},
	            {'+', '+', '+', '.'}
	        };
	        
	        int[] entrance = {1,2};
	        
	        // Create an instance of the class containing the nearestExit method
	        NearestExitfromEntranceinMaze yourClassInstance = new NearestExitfromEntranceinMaze();
	        
	        // Call the nearestExit method and print the result
	        int result = yourClassInstance.nearestExit(maze, entrance);
	        System.out.println("The nearest exit distance is: " + result);
	    }

}
