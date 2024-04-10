package com.crr.dsa.crackingtheinterview;

import java.util.Random;
import java.util.TreeMap;

public class GettingADifferent {
	    public static int getDifferentNumber(int[] arr) {
	        int n = arr.length;
	        int temp;

	        // Put each number in its corresponding index, kicking out
	        // the original number, until the target index is out of range.
	        for (int i = 0; i < n; i++) {
	            temp = arr[i];
	            while (temp < n && arr[temp] != temp) {
	                int swapTemp = arr[temp];
	                arr[temp] = temp;
	                temp = swapTemp;
	            }
	        }

	        // Find the first index that doesn't match its value
	        for (int i = 0; i < n; i++) {
	            if (arr[i] != i) {
	                return i;  // i isn’t in arr, hence we can return it
	            }
	        }

	        // We got here since every number from 0 to n-1 is in arr.
	        // By definition then, n isn’t in arr. Otherwise, the size of arr
	        // would have been n+1 and not n.
	        return n;
	    }

	    public static void main(String[] args) {
	        int[] arr = {4, 0, 2, 1, 3};
	        System.out.println(getDifferentNumber(arr)); // Output: 5
	        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>((a,b) -> b-a);
	new StringBuilder().setLength(0);
	    }

}
