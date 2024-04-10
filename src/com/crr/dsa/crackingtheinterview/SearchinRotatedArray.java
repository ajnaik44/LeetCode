package com.crr.dsa.crackingtheinterview;

public class SearchinRotatedArray {

	public static int findElementInSortedArray(int[] array,int searchElement)
	{
		return findElementInSortedArray(array, searchElement, 0, array.length-1);
	}
	public static int	findElementInSortedArray(int[] array,int searchElement, int start,int end)
	{
		if(start>end)
			return -1;
		int mid =  (start+end)/2;
		System.out.println(array[mid]);
		if(array[mid]==searchElement)
			return mid;
		if(array[mid]>  array[start])
		{
			if(searchElement>=array[start] &&  searchElement <=  array[mid])
			return	findElementInSortedArray(array, searchElement,start,mid-1);
			else
			return	findElementInSortedArray(array, searchElement, mid+1, end);
				
		}
		else if(array[mid] <  array[end])
		{
			if(searchElement>= array[mid] &&  searchElement<=array[end])
				return findElementInSortedArray(array, searchElement,mid+1,end);
			else
				return findElementInSortedArray(array, searchElement,start,mid-1);
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(findElementInSortedArray(a, 16));
	}
}
