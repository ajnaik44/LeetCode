package com.crr.dsa.crackingtheinterview;

public class QuickSortNew 
{
	public static void main(String[] args) {
		int[] arr = {7,6,10,5,9,2,1,15,10};
		quickSort(arr, 0, arr.length-1);
		for(int i: arr)
		{
			System.out.print(i + "  ");
		}
	}
	public static void quickSort(int [] arr,int start,int end)
	{
		
		if(start<end )
		{
			int pivotindex = quickSortHelper(arr,start,end);
			System.out.println(pivotindex + "   "+  end);
			
			quickSort(arr,start,pivotindex-1);
			quickSort(arr, pivotindex+1, end);
			
		}
	}
	
	
	public static int quickSortHelper(int [] arr, int start,int end)
	{
		
		int pivot =  arr[start];
		int left =  start;
		int right =  end;
		while(left<=right)
		{
			while(left<=right && arr[left] <= pivot)
			{
				left++;
			}
			while(left<=right && arr[right]> pivot)
			{
				right--;
			}
			if(left<right)
			swap(arr,left,right);
			
		}
		swap(arr,start,right);
		return right;
	}

	private static void swap(int[] arr, int pivot, int left) {
		int temp =  arr[pivot];
		arr[pivot] =  arr[left];
		arr[left]= temp;
		
	}
	

}
