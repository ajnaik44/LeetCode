package com.crr.dsa.crackingtheinterview;

public class MagicIndex {

	public static int  findMagicIndex(int[] array)
	{
		for(int i=0;i<array.length;i++)
		   {
			   if(array[i]==i)
				   return i;
		   }
		return -1;
	}
	public static int  findmagicIndex(int[] array) {
		return findmagicIndexWhenDuplicated(array,0,array.length);
	}
	public static int  findmagicIndexWhenSorted(int[] array,int start, int end) {
		int mid =  (start+end)/2;
		if(mid==array[mid])
			return mid;
		else if(mid> array[mid])
			return findmagicIndexWhenSorted(array,mid+1,end);
		else
			return findmagicIndexWhenSorted(array,start,mid-1);
	}
	public static int  findmagicIndexWhenDuplicated(int[] array,int start, int end) {
		if(start> end)
			return -1;
		int midIndex =  (start+end)/2;
		int midValue =  array[midIndex];
		if(midIndex==midValue)
			return midIndex;
		
		// search left 
		int leftIndex =  Math.min(midIndex-1, midValue);
		int left = findmagicIndexWhenDuplicated(array, start, leftIndex);
		if(left>=0)
			return left;
		
		int rightIndex =  Math.max(midIndex+1, midValue);
		int right =  findmagicIndexWhenDuplicated(array, rightIndex, end);
		
		return right;
		
	}
	public static void main(String[] args) {
		
		   int[] array = {-10,-5,2,2,2,3,4,7,9,12,13};
		   System.out.println(findmagicIndex(array));
		   
	}
}
