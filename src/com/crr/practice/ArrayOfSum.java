package com.crr.practice;


import java.util.*;


public class ArrayOfSum {
	
	
	static int[] inputArray; 

	
	/**
	 * given an array and a sum, return a set of sub-arrays whose consecutive sum is the input sum
	 * @param inputArray
	 * @param sum
	 * @return
	 */
	public static List<int[]> getArrayOfSum( int[] i, int sum ){
		
		inputArray = i;
		
		return getArrayOfSumRecursive(0,sum);
		
	}
	
	
	/**
	 * 
	 * @param start
	 * @param sum
	 * @return
	 */
	public static List<int[]> getArrayOfSumRecursive(int start, int sum ){

		List<int[]> a2 = new ArrayList<int[]>();
		
		if( (start+2) >= inputArray.length) {
			return a2;
		}
		
		int first = inputArray[start];
		int second = inputArray[start+1];
		int third = inputArray[start+2];
		
		if(first+second+third == sum) {
			int[] subArray = {first, second, third};
			a2.add(subArray);
		}
		
		a2.addAll( getArrayOfSumRecursive( start+1, sum));

		return a2;
	}
	
	
	/**
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {0,4,1,2,2,-6,3,8,0};
		
		List<int[]> ans = getArrayOfSum(arr, 5);

		for(int[] a :ans) {
			System.out.println("[" + a[0] + " " + a[1] + " " + a[2] + "]");
		}
	}

}
