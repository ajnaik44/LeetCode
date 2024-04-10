package com.crr.dsa.crackingtheinterview;

import java.util.BitSet;

public class BitSetExample {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 8 };
		checkDuplicates(array);
	}

	static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}

}
