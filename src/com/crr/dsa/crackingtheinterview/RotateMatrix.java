package com.crr.dsa.crackingtheinterview;

public class RotateMatrix {

	public static void main(String[] args) {
	    // Example usage
	    int[][] matrix = {
	        {1, 2, 3},
	        {4, 5, 6},
	        {7, 8, 9}
	    };

	    System.out.println("Original Matrix:");
	    printMatrix(matrix);

	    // Rotate the matrix
	    rotate(matrix);

	    System.out.println("Rotated Matrix:");
	    printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
	    for (int[] row : matrix) {
	        for (int num : row) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }
	}

static	boolean rotate(int[][] matrix) {
	    if(matrix!=null && matrix.length==0&&  matrix.length!=matrix[0].length)
	    	return false;
	    
	    for(int layer=0;layer< matrix.length/2;layer++ )
	    {
	    	int first =  layer;
	    	int last = matrix.length-1-first;
	    	
	    	for(int i=first;i<last;i++)
	    	{
	    		int offset =  i-first;
	    		int top =  matrix[first][i];
	    		
	    		
	    		// left to top
	    		matrix[first][i] =  matrix[last-offset][first];
	    		
	    		// bootom to left
	    		matrix[last-offset][first] =  matrix[last][last-offset];
	    		
	    		// right to bottom 	    		
	    		matrix[last][last-offset] =  matrix[i][last];
	    		
	    		//top to right
	    		matrix[i][last] = top;
	    		
	    		
	    		
	    		
	    	}
	    	
	    }
	    return true;
	    
	}

}
