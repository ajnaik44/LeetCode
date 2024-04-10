package com.crr.dsa.crackingtheinterview;

public class SortedMerge {

	public static void mergeArray(int[] a, int[] b) {
		int[] bigger = a.length > b.length ? a : b;
		int[] smaller = a.length > b.length ? b : a;
		int indexBigger = 0;
		int indexSmaller = 0;
		while ( bigger[indexBigger]!=0 &&  indexSmaller < smaller.length && indexBigger < bigger.length) {
			if (bigger[indexBigger] > smaller[indexSmaller]) {
				int elemet = bigger[indexBigger];
				bigger[indexBigger] = smaller[indexSmaller];
				shiftIndex(bigger, indexBigger + 1, bigger.length - indexBigger - indexSmaller, elemet);

				indexSmaller++;
				indexBigger++;
			} else {
				indexBigger++;
			}
		}
		if(indexSmaller<  smaller.length)
		{
			bigger[indexBigger] = smaller[indexSmaller];
			indexBigger++;
			indexSmaller++;
		}

	}

	public static void shiftIndex(int[] bigger, int index, int noOfShift, int nextElement) {
		for (int i = index; i < noOfShift; i++) {
			int temp = bigger[i];
			bigger[i] = nextElement;
			nextElement = temp;
		}

	}
	static void merge(int[] a, int[] b, int lastA, int lastB) {
		
		int mergedIndex =  a.length-1;
		
		while(lastB >= 0 )
		{
			if(a[lastA] >  a[lastB])
			{
				a[mergedIndex] =  a[lastA];
				mergedIndex --;
				lastA--;
			}
			else {
				a[mergedIndex] =  b[lastB];
				mergedIndex--;
				lastB--;
			}
		}
		
	}
	public static void main(String[] args) {
		int a[] = new int[] { 1, 3, 4, 5, 0, 0 };
		int b[] = new int[] { 2, 6 };
		merge(a, b,3,1);
		System.out.println(a);
		for (Integer result : a) {

			System.out.print(result + " ");

		}
		System.out.println();
	}
}
