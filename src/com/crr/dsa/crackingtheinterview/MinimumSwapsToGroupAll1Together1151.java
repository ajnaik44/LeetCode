package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToGroupAll1Together1151 {
	public static String Left1 = "Left1";
	public static String Right1 = "Righ1";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,0,1,0,1,0,1,1,1,0};
		System.out.println(minSwapsSolution1(data));
	}
	public static int minSwaps(int[] data)
	{
		Map<String,Integer> map =  helper(data);
		int left1 =  map.get(Left1);
		int right1 =  map.get(Right1);
	
		System.out.println(left1);
		System.out.println(right1);
		int left = left1>right1 ? 1 : 0;
		int right = left1 >  right1   ? 0 : 1;
		int swapCOunt=0;
		
		if(left1+right1==1)
			return 0;
		if(data.length -  left1-right1==1)
			return 0;
		for(int ii:data)
		{
			System.out.print( ii + " ");
		}
		System.out.println();
		for(int i=0,j=data.length-1;i<j;)
		{
			if(data[i]==right)
			{
				if(data[j]==left)
				{
					data[i]=left;
					data[j]=right;
					for(int ii:data)
					{
						System.out.print( ii + " ");
					}
					System.out.println();
					swapCOunt++;
					
					i++;
					j--;
				}else {
					j--;
				}
			}else {
				i++;
			}
		}
	
		return swapCOunt;
		
	}
	
	public static Map<String,Integer>  helper(int [] data)
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();	
		
		int mid =  data.length/2;
		int ones = 0;
		for(int i=0; i<=mid;i++)
		{
			if(data[i]==1)
				ones++;
			
		}
		map.put(Left1, ones);
		
		
		 ones = 0;
		for(int i=mid+1; i<data.length;i++)
		{
			if(data[i]==1)
					ones++;
			
		}
		map.put(Right1, ones);
	
		return map;
		
		
	}
	public static int minSwapsSolution1(int[] data) {
		int windowssize = 0;
		for(int i:data)
		{
			windowssize+=i;
		}
		int currentOnes = 0;
		int maxOnes = 0;
		for(int i=0;i<data.length;i++)
		{
			currentOnes +=data[i];
			if(i>=windowssize)
			{
				currentOnes	-=data[i-windowssize]; 
			}
			maxOnes =  Math.max(maxOnes, currentOnes);
			
		}
		return windowssize- maxOnes;
	}
	


}
