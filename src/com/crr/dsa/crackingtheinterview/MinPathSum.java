package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class MinPathSum {
	public static void main(String[] args) {
		int [][]grid =  new int[][] 
				{{1,3,1},
				{1,5,1},
				{4,2,1}};
		MinPathSum minPathSum = new MinPathSum();
		
		System.out.println(minPathSum.minPathSumAjay(grid));
	}
	public int minPathSumAjay(int[][] grid) {
	       int row =  grid.length;
	       int col =  grid[0].length;
	       int sumGrid [][]=new int[row][col];

	      for(int i=0; i<row; i++){
		     Arrays.fill(sumGrid[i],-1); 
		  }
	       for(int i=0;i<row;i++)
	       {
	        for(int j=0;j<col;j++)
	        {
	            int rowSum = Integer.MAX_VALUE;
	            int colSum =  Integer.MAX_VALUE;
	           if(i==j && i==0)
	            {
	                sumGrid[i][j] =  grid[i][j] ;
	                continue;
	            }
	            if(i>0)
	            {
	                rowSum = sumGrid[i-1][j] + grid[i][j]; 
	            }
	            if(j>0)
	            {
	                colSum =  sumGrid[i][j-1] +  grid[i][j];
	            }

	            sumGrid[i][j] =  Math.min(rowSum,colSum);

	        }
	       }  
	    return sumGrid[row-1][col-1];
	           
	    }
	 public int minPathSum(int[][] grid) {
	        
	        int m=grid.length;
	        int n=grid[0].length; 

	        int[][] dp=new int[m][n];
	        for(int i=0; i<m; i++){
	            Arrays.fill(dp[i],-1); 
	        }
	        
	         

	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                int one=Integer.MAX_VALUE; 
	                int two=Integer.MAX_VALUE;
	                if(i==j && i==0){
	                    dp[0][0]=grid[0][0];
	                    continue; 
	                }
	                if(i>0)
	                	one=dp[i-1][j]+grid[i][j];
	                if(j>0) 
	                	two=dp[i][j-1]+grid[i][j];

	                dp[i][j]=Math.min(one,two);
	            }
	        }

	        return dp[m-1][n-1];

	    }
}
