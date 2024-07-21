package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;

public class ShortestBridge {
	public static void main(String[] args) {
		 // Test cases
        int[][] grid1 = {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,0,0,0,1},
            {1,1,1,1,1}
        };
        System.out.println("Shortest bridge in grid1: " + new ShortestBridge().shortestBridge(grid1));

	}
	public int shortestBridge(int[][] grid) {
        int firstX=0, firstY=0;
        ArrayList<int[]> firstIland =  new ArrayList<int[]>();
        for(int row=0;row<grid.length;row++)
        {
            for(int col =0;col<grid.length;col++)
            {
                if(grid[row][col]==1)
                {
                    firstX = row;
                    firstY = col;
                    break;
                }
            }
        }
        shortestPath( grid , firstX,firstY,2,  firstIland);
        int distance = 0;
         System.out.println("ddddddddddddddddd");
        while(!firstIland.isEmpty())
        {
            ArrayList<int[]> newList =  new ArrayList<int[]>();
            for(int [] pair : firstIland )
            {
                int row= pair[0];
                int col =  pair[1];
              
                int n = grid.length;
                int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
                for (int[] dir : direction) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && c >= 0 && c < n && r < n ) {
                        
                        if(grid[r][c]==1){
                             return distance;
                        }
                       else if (grid[r][c]==0)
                       {
                        newList.add(new int[]{r,c});
                         grid[r][c]=-1; 
                       }
                       
                    }
                }
            }
        System.out.println(newList);
           firstIland =  newList;
           distance++;
        
        }
        return distance;
    }

    public void shortestPath(int[][] grid, int row, int col, int value, ArrayList<int[]> list) {
        if (grid[row][col] == value)
            return;
        list.add(new int[] { row, col });
        grid[row][col] = value;
        int n = grid.length;
        int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : direction) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && c >= 0 && c < n && r < n && grid[r][c] == 1) {
                shortestPath(grid, r, c, value, list);
            }
        }

    }
}
