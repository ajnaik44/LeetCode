package com.crr.dsa.crackingtheinterview;

public class GameOfLife {
	
	public static void main(String[] args) {
		int [][]board = {{1,1},{1,0}};
		new GameOfLife().gameOfLife(board);
	}
	public void gameOfLife(int[][] board) {
        int[][]  result = new int[board.length][board[0].length];
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[0].length;col++)
            {
               gameOfLifeHelper( board,result, row, col);
            }
        }
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[0].length;col++)
            {
               System.out.print( result[row][col] + " ");
            }
            System.out.println();
        }
   board= result;
    }

   public void gameOfLifeHelper(int[][] board,int[][] result,int row,int col)
   {
    int direction[][]={ { 1,0 },{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    int numberofZero=0;
    int numOfones = 0;
    for(int [] dir :  direction)
    {
        int newRow=row+dir[0];
        int newCol =  col+dir[1];

        if(newRow>=0 && newRow< board.length && newCol>=0 && newCol<board[0].length)
        {
            if(board[newRow][newCol]==1)
            {
                numOfones++;

            }else{
               numberofZero++; 
            }
        }
      
    }
    System.out.println( " if1 row " +  row +  " col +  "+ col + " numOfones "+ numOfones + " numberofZero "+numberofZero);
     if(numOfones<2 && board[row][col]==1)
    {
        
    
        result[row][col]=0;
    }
    else if(numOfones>=2 && numOfones<=3 && board[row][col]==1)
    {
    
        result[row][col]=1;
    }
    else if(numOfones>3 && board[row][col]==1)
    {
    
        result[row][col]=1;
    }
    
     
     else if(numOfones==3 && board[row][col]==0)
    {
    
        result[row][col]=1;
    }
    
   }
}
