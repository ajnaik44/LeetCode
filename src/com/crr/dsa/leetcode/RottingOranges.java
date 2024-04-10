package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
	class Pair {
		int row = 0;
		int col = 0;

		public Pair(int row, int col) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
		}
	}

	public int orangesRotting(int[][] grid) {

		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int freshOrange=0;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					Pair pair = new Pair(i, j);
					list.add(pair);

				}
				else if(grid[i][j]==1)
					freshOrange++;
			}
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		int result = 0;
		for (Pair pairTemp : list) {
			queue.add(pairTemp);
		}
			while (!queue.isEmpty()) {
				int size = queue.size();
				boolean modify =false;
				for (int i = 0; i < size; i++) {

					Pair pair = queue.poll();
					for (int[] dir : dirs) {
						int newrow = pair.row + dir[0], colnew = pair.col + dir[1];

						if (0 <= newrow && 0 <= colnew && newrow < grid.length && colnew < grid[0].length
								&& grid[newrow][colnew] != 2 && grid[newrow][colnew] != 0) {
							Pair temp = new Pair(newrow, colnew);
							queue.add(temp);
							grid[newrow][colnew] = 2;
							modify=true;
							freshOrange--;

						}
					}
					

				}
				if(modify)
					result++;
			}
		
		if(freshOrange!=0)
			return -1;
		return (result==-1 || result==0) ? 0 :result;

	}

	public static void main(String[] args) {
		int[][] grid = { { 2,1,1},{1,1,1},{0,1,2} };
		RottingOranges rottingOranges = new RottingOranges();
		System.out.println(rottingOranges.orangesRotting(grid));

	}

	static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
