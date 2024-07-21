package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
	int min = Integer.MAX_VALUE;

	private static final int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
			{ 1, -1 }, { 1, 0 }, { 1, 1 } };

	public int shortestPathBinaryMatrixEditor(int[][] grid) {

		if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0)
			return -1;

		grid[0][0] = 1;

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] direction = queue.poll();
			int row = direction[0];
			int col = direction[1];

			int distance = grid[row][col];

			if (row == grid.length - 1 && col == grid.length - 1)
				return distance;

			for (int[] dir : getEdges(direction[0], direction[1], grid)) {
				grid[dir[0]][dir[1]] = distance + 1;
				queue.add(dir);
			}
		}
		return -1;

	}

	public List<int[]> getEdges(int row, int col, int[][] grid) {
		List<int[]> list = new ArrayList<int[]>();

		for (int dir[] : directions) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] == 0) {
				list.add(new int[] { r, c });
			}

		}
		return list;
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] != 0)
			return -1;
		shortedtPath(grid, 0, 0, 0);
		return this.min + 1;
	}

	public void shortedtPath(int[][] grid, int row, int col, int result) {
		if (row == grid.length - 1 && col == grid.length - 1 && grid[row][col] == 0) {

			min = Math.min(result, min);
			System.out.println(min);
			return;
		}
		if (grid[row][col] != 0)
			return;

		for (int[] direction : directions) {
			int r = row + direction[0];
			int c = col + direction[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] == 0) {
				grid[row][col] = 1;
				result++;
				shortedtPath(grid, r, c, result);
				grid[row][col] = 0;
				result--;
			}

		}

	}
	 public int shortestPathBinaryMatrixApproach2(int[][] grid) {
	        
	      if(grid[0][0] !=0 ||  grid[grid.length-1] [ grid.length-1]!=0)
	    	  return -1;
	     
	   
	     
	     List<int[]> current =new ArrayList<int[]>();
        List<int[]> nextList =new ArrayList<int[]>();
	     current.add(new int[] {0,0});
	     boolean [][] visited =  new boolean[grid.length][grid[0].length];
        visited[0][0] =true;
        int distance=0;
	     while(!current.isEmpty())
	     {
	    	for( int[] direction :  current){
	    	 int row = direction[0];
	    	 int col =  direction[1];
	    	 if(row==grid.length-1 &&  col==grid.length-1)
			    	return distance;
	    	 
	    	 for(int [] dir :  getEdges(row, col, grid)) {
               if(visited[dir[0]][dir[1]])
                   continue;
                visited[dir[0]][dir[1]] =true;
	    		 nextList.add(new int[]{dir[0],dir[1]});

	    		
               }
           current =   nextList;
           nextList = new ArrayList<int[]>();
           distance++;  
           }
	     }
	     return -1;
	     
	    }
	public static void main(String[] args) {
		int num[][] = { { 0, 0, 0 }, { 1,1,0 }, { 1, 1, 0 } };
		System.out.println(new ShortestPathinBinaryMatrix().shortestPathBinaryMatrixApproach2(num));
	}
}
