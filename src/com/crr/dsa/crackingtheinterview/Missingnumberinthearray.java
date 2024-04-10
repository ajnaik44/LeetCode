package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class Missingnumberinthearray {

	public static int missingNumber(int[] numbers)
	{
		Arrays.sort(numbers);// o(n logn)
		int firstelement = numbers[0];
		for(int i=1;i<numbers.length;i++)
		{
			if(numbers[i]-firstelement>1)
				return numbers[i]-1;
			firstelement =  numbers[i];
		}
		return -1;
		
		
		
	}
	public static int missingNumberOptimize(int[] numbers,int n)
	{
		Arrays.sort(numbers);// o(n logn)
		int firstelement = numbers[0];
		for(int i=1;i<numbers.length;i++)
		{
			if(numbers[i]-firstelement>1)
				return numbers[i]-1;
			firstelement =  numbers[i];
		}
		return -1;
		
		
		
	}
	public static void main(String[] args) {
		int [] number = { 3,7,1,2,8,4,5};
		System.out.println(missingNumber(number));
	}
}
