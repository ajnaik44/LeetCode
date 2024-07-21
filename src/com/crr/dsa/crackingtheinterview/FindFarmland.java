package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class FindFarmland {
	public static void main(String[] args) {
		FindFarmland farmland = new FindFarmland();
		int [][]land = {{1,0,0},{0,1,1},{0,1,1}};
		System.out.println(farmland.findFarmland(land));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public int[][] findFarmland(int[][] land) {
		List<int[]> answer = new ArrayList<int[]>();

		for (int row = 0; row < land.length; row++) {
			for (int col = 0; col < land[0].length; col++) {
				if (land[row][col] == 1) {

					int result[] = new int[4];
					result[0] = row;
					result[1] = col;
					dfs(land, row, col, result);
					answer.add(result);
				}
			}
		}
		return answer.toArray(new int[answer.size()][]);
	}

	public void dfs(int[][] land, int row, int col, int[] result) {
		if (land[row][col] != 1)
			return;

		land[row][col] = 2;
		result[2] = row;
		result[3] = col;
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int[] dir : directions) {
			int r = dir[0] + row;
			int c = dir[1] + col;

			if (r >= 0 && r < land.length && c >= 0 && c < land[0].length && land[r][c] == 1) {
				dfs(land, r, c, result);
			}
		}

	}
}
