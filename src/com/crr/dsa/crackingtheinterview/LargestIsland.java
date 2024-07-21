package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LargestIsland {
	int sum = 0;
	boolean zeroPresent = false;
	int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) {
		LargestIsland island = new LargestIsland();
		int grid[][] = new int[][] {{1,0},{1,0}};
		System.out.println(island.largestIsland(grid));
	}
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	 
	
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        Queue<Pair> queue = new LinkedList<Pair>();
	        Map<Integer,List<Integer>>  map = new HashMap();
	        int min=0;
	        queue.add(new Pair(root,0));

	        while(!queue.isEmpty())
	        {
	            int size =  queue.size();
	            Map<Integer,List<Integer>> tempMap= new HashMap<>();
	            while(size-->0)
	            {
	                Pair<TreeNode,Integer> pair =  queue.poll();
	                min = Math.min(min,pair.getValue());
	                TreeNode temp =  pair.getKey();
	                if(temp.left!=null)
	                    queue.add(new Pair(temp.left,pair.getValue()-1));
	                if(temp.right!=null)
	                    queue.add(new Pair(temp.right,pair.getValue()+1));

	                if(tempMap.get(pair.getValue())==null)
	                    tempMap.put(pair.getValue(),new ArrayList());
	                tempMap.get(pair.getValue()).add(temp.val);
	            }
	           for (Map.Entry<Integer, List<Integer>> m1 : tempMap.entrySet()) {
	            {
	                if(!map.containsKey(m1.getKey()))
	                    map.put(m1.getKey(),new ArrayList());
	                List<Integer> values =  m1.getValue();
	                if(values.size()>1)
	                     Collections.sort(values);
	                map.get(m1.getKey()).addAll(values);
	            }

	            
	       
	           
	        }
	        List<List<Integer>> answer= new ArrayList<>();
	        while(map.get(min)!=null)
	        {
	           
	            answer.add(map.get(min));
	            min++;
	        }
	        return answer;

	    }
	
	public int largestIsland(int[][] grid) {
		int n = grid.length;
		int counter = 2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (grid[row][col] == 1) {
					grid[row][col] = counter;
					int res = findAllIsland(grid, row, col, counter);
					System.out.println(res);
					map.put(counter, res + 1);
					counter++;

				}
			}
		}
		return 0;
	}

	public int findAllIsland(int[][] grid, int row, int col, int value) {

		int n = grid.length;

		int total = 0;
		for (int[] direction : directions) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
			if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
				grid[newRow][newCol] = value;
				total++;
				total += findAllIsland(grid, newRow, newCol, value);

			}
		}
		return total;

	}
}
