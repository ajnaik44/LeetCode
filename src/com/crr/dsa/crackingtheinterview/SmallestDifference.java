package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class SmallestDifference {

	public static int smallestDifference(int[] a, int b[]) {
		Arrays.sort(a);
		Arrays.sort(b);
		int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        
        while (i < a.length && j < b.length) {
            minDiff = Math.min(minDiff,  Math.abs(a[i] - b[j]));
            
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
		return minDiff;
	}
	public static void main(String[] args) {
		 int[] a = {10, 5, 15, 7};
	        int[] b = {8, 12, 3};
		System.out.println(smallestDifference(a,b));
		System.out.println(getMaxNaive(4,3));
	}
	static int flip(int bit) {
	    return 1 ^ bit;
	}

	static int sign(int a) {
	    System.out.println("Binary representation of a: " + String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
	    int result = a >> 31;
	    System.out.println("Binary representation of a: " + String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0'));
	    System.out.println("Binary representation  0x1: " + String.format("%32s", Integer.toBinaryString(0x1)).replace(' ', '0'));
	    return flip((a >> 31) & 0x1);
	}


	static int getMaxNaive(int a, int b) {
	    int k = sign(a - b);
	    int q = flip(k);
	    return a * k + b * q;
	}

	
}

