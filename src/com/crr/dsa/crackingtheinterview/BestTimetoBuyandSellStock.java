package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStock {

	
	public static int maxSell(int[] array)
	{
		int min =  Integer.MAX_VALUE;
		Map<Integer,Integer>  map = new HashMap<>();
		for(int i=0;i< array.length;i++)
		{
			min =  Math.min(min, array[i]);
			map.put(array[i], i);
		}
		System.out.println(min);
		System.out.println(map);
		int max = Integer.MIN_VALUE;
		for( int i = map.get(min)+1;i<array.length;i++)
		{
			max =  Math.max(max, array[i]);
					
		}
		if(max==Integer.MIN_VALUE)
			return 0;
		return Math.abs(max-min);
		
	}
	
	public static int maxSellBF(int[] array)
	{
		int profit = 0 ;
		for(int i=0;i< array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]<  array[j])
				{
					
					profit =  Math.max(profit, array[j]-array[i]);
				}
			}
		}
		return Math.abs(profit);
		
	}

	public static void main(String[] args) {
		int []array = new int[] {2,4,1};
		System.out.println(maxSellBF(array));
	}
}
