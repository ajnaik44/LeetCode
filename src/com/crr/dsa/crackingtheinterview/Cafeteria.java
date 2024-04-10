package com.crr.dsa.crackingtheinterview;

public class Cafeteria {
	public static void main(String[] args) {
        // Example usage of getMaxAdditionalDinersCount method
        int N = 10; // Total number of dining spots
        int K = 1; // Number of consecutive spots needed for a diner
        int M = 2; // Number of reserved spots
        int[] S = {2,6}; // Reserved spots

        Cafeteria main = new Cafeteria();
        long additionalDinersCount = main.getMaxAdditionalDinersCount(N, K, M, S);
        System.out.println("Maximum additional diners that can be accommodated: " + additionalDinersCount);
    }
	public long getMaxAdditionalDinersCount(int N, int K, int M, int[] S) {

		long[] table = new long[(int) N];

		for (int i : S) {
			table[i] = 2;

			for (int j = 1; j <= K; j++) {
				if (i - j >= 0 &&  table[i-j]!=2) {
					table[i - j] = -1;
				}
				if (i + j < N &&  table[i+j]!=2) {
					table[i + j] = -1;
				}
			}

		}
		for(long kk:table)
		{
			System.out.print(kk + "  ");
		}
		System.out.println();
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (table[i] == 0) {
				boolean flag = true;
				for (int j = 1; j <= K; j++) {
					if (i + j < N &&( table[i + j] == 2)) {
							flag = false;
					}
				}
				if (flag) {
					result++;
					i = i +K;
				}
			}

		}

		return result;
	}
}
