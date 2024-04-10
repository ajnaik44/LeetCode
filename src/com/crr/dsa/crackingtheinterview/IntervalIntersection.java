package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
	public static void main(String[] args) {
		int nums1[][] = {{0,2},{5,10},{13,23},{24,25}};
		int nums2[][] ={{1,5},{8,12},{15,24},{25,26}};
		int [][] answer =  new IntervalIntersection().intervalIntersection(nums1, nums2);
		
		for (int i = 0; i < answer.length; i++) {
		    for (int j = 0; j < answer[i].length; j++) {
		        System.out.print(answer[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}
	  public int[][] intervalIntersection(int[][] A, int[][] B) {
		    List<int[]> ans = new ArrayList();
		    int i = 0, j = 0;

		    while (i < A.length && j < B.length) {
		      // Let's check if A[i] intersects B[j].
		      // lo - the startpoint of the intersection
		      // hi - the endpoint of the intersection
		      int lo = Math.max(A[i][0], B[j][0]);
		      int hi = Math.min(A[i][1], B[j][1]);
		      if (lo <= hi)
		        ans.add(new int[]{lo, hi});

		      // Remove the interval with the smallest endpoint
		      if (A[i][1] < B[j][1])
		        i++;
		      else
		        j++;
		    }

		    return ans.toArray(new int[ans.size()][]);
		  }
		
}
