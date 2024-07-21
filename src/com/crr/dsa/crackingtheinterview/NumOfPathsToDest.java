package com.crr.dsa.crackingtheinterview;

public class NumOfPathsToDest {
	static int numOfPathsToDest(int n) {
	    // your code goes here/
	    /*
	      -1  0 0 
	      -1  0 0 
	      0  0 0 
	     
	      
	    */
	    
	    
	    int[][] grid = new int[n][n];
	    backtracking(grid,0 ,0);
	    return noOfWays;
	    
	  }
	  
	  public static int noOfWays=0;
	  static int directions [][] = new int[][]{ { 0,1}, { 1,0}};
	  
	  public static  void backtracking(int [][] grid,int row ,int col)
	  {
	    
	    if(col>row) return;
	    
	    
	    if(row==grid.length-1 &&  col== grid[0].length-1){
	      noOfWays++;
	      return;
	    }
	    grid[row][col]= -1;
	    
	     for(int dir[] : directions )
	     {

	       int r =  dir[0]+ row;
	       int c =  dir[1]+col;
	       if(r>=0 &&  c>=0 &&  r<grid.length && 
	          c< grid[0].length  && grid[r][c]!=-1)
	       {
	         backtracking(grid,r,c);
	       }


	     }
	     grid[row][col]= 0;
	    
	    
	  }
	  
	  
	  

	  public static void main(String[] args) {
		 System.out.println(numOfPathsToDest(2)); 
	  }

}
