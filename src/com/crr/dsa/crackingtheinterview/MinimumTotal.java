package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotal {
	 public static void main(String[] args) {
		 MinimumTotal solver = new MinimumTotal();

	        List<List<Integer>> triangle = new ArrayList<>();
	        triangle.add(Arrays.asList(2));
	        triangle.add(Arrays.asList(3, 4));
	        triangle.add(Arrays.asList(6, 5, 7));
	        triangle.add(Arrays.asList(4, 1, 8, 3));

	        int minimumTotal = solver.minimumTotal(triangle);
	        System.out.println("The minimum path sum is: " + minimumTotal);
	    }
	public int minimumTotal(List<List<Integer>> triangle) {
        for(int row=1;row<triangle.size();row++)
        {
        	for(int col=0;col<=row;col++)
        	{
        		int aboveValue=  Integer.MAX_VALUE;
        		if(col>0)
        		{
        			aboveValue =  triangle.get(row-1).get(col-1);
        		}
        		if(col<row)
        		{
        			aboveValue =  Math.min(aboveValue, triangle.get(row-1).get(col));
        		}
        		int path =  aboveValue +  triangle.get(row).get(col);
        		triangle.get(row).set(col, path);
        	}
        	
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
