package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	 public List<Integer> spiralOrder(int[][] matrix) {
	        int order = 1;
	        int rows =  matrix.length;
	        int cols = matrix[0].length;
	        boolean [][] visited = new boolean[rows][cols];
	        List<Integer> answer = new ArrayList(rows*cols);
	       
	        for(int row=0,col=cols-1; row<rows-1;row++,col--)
	        {
	           move(row,0,col,matrix,answer,visited);
	        }
	        return answer;
	    }
	    public void move(int row,int col,int colBoundary,
	    int[][] matrix,
	    List<Integer> answer, 
	    boolean[][] visited)
	    {
	    
	        while(  col<=colBoundary)
	        {
	            if(!visited[row][col]){
	            visited[row][col]= true;
	            answer.add(matrix[row][col]);
	            }
	            col++;
	        }
	           
	       
	        col=colBoundary;
	       
	        while(row<matrix.length )
	        {
	            if(!visited[row][col]){
	                visited[row][col]= true;
	                answer.add(matrix[row][col]);
	            }
	            row++;
	        }
	           
	        
	        row--;
	    
	         
	            while(col>=0 )
	            {
	                if(!visited[row][col]){
	                    visited[row][col]= true;
	                    answer.add(matrix[row][col]);
	                }
	                col--;
	            }
	        
	        col++;
	      
	         
	        while(row>=0 )
	        {
	            if(!visited[row][col]){
	                visited[row][col]= true;
	                answer.add(matrix[row][col]);
	            }
	            row--;
	        }
	            
	        
	    }
	    public static void main(String[] args) {
			SpiralOrder order = new SpiralOrder();
			int[][] matrix = {
		            {1,2,3}, {4,5,6},{7,8,9}
		        };
			System.out.println(order.spiralOrder(matrix));

		}
	    
	    
	    
}
