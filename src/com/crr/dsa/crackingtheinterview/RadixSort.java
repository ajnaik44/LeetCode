package com.crr.dsa.crackingtheinterview;

public class RadixSort {
	private static final int NUM_DIGITS = 10;

	public void countingSort(int[] arr, int placeVal) {
	        // Sorts an array of integers where minimum value is 0 and maximum value is NUM_DIGITS
	     int counts [] =  new int [NUM_DIGITS];
	     
	     for(int i : arr)
	     {
	    	 int current =  i/placeVal;
	    	 counts[current%10]++;
	    	 
	     }
	     
	     int start = 0;
	     
	     for(int i=0;i<counts.length;i++)
	     {
	    	 int count =  counts[i];
	    	 counts[i] =  start;
	    	 start+=count;
	     }
	      
	     int sorted[] = new int[arr.length];
	     for(int i=0;i<arr.length;i++)
	     {
	    	 int current =  arr[i]/placeVal;
	    	 sorted[counts[current%10]] =  arr[i];
	    	 counts[current%10]++;
	     }
	      for(int i=0;i<arr.length;i++)
	      {
	    	  arr[i] =  sorted[i];
	      }
	      
	    }

	public void radixSort(int[] arr) {
		int maxElem = Integer.MIN_VALUE;
		for (int elem : arr) {
			if (elem > maxElem) {
				maxElem = elem;
			}
		}

		int placeVal = 1;
		while (maxElem / placeVal > 0) {
			countingSort(arr, placeVal);
			placeVal *= 10;
		}
		for(int i: arr)
		{
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		int arr[] = {831, 443, 256, 336, 736, 907};
		
		RadixSort  radixSort = new RadixSort();
		radixSort.radixSort(arr);
	}
}
