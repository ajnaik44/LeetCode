package com.crr.dsa.sort;

import java.util.HashSet;
import java.util.Set;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {7,6,16,5,9,2,1,15,10};
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
		Set<Character> set = new HashSet<Character>();
	    set.add('e');
	    set.add('E');
	    	}
	public static void quickSort(int[] A,int left,int right)
	{
		
		if(right>left)
		{
			int pivot =  partition(A,left,right);
			quickSort(A, left, pivot-1);
			quickSort(A, pivot+1, right);
		}
		
	}
	public static void swap(int[] A,int left,int right)
	{
		int tmp = A[left];
		A[left]=A[right];
		A[right]=tmp;
	}
	
	public static  int partition(int A[],int low,int high) {
		int pivot=A[low];
		int left =  low;
		int right= high;
		
		while(left<right)
		{
			while(A[left]<=pivot)
				left++;
			while(A[right]> pivot)
				right--;
			if(left<right)
				swap(A, left, right);
		}
		A[low]=A[right];
		A[right] =  pivot;
		return right;
	}
	
}
