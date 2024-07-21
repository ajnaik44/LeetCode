package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq {
	
	
	
	
	public int lenLongestFibSubseq(int[] arr) {
		int n = arr.length;
		int result = 0;
		int[][] dp = new int[n][n];

		for (int i = 2; i < n; i++) {
			int l = 0, r = i - 1;

			while (l < r) {
				int sum = arr[l] + arr[r];
 				if (sum > arr[i]) {
					r--;
				} else if (sum < arr[i]) {
					l++;
				} else {
					dp[r][i] = dp[l][r] + 1;
					result = Math.max(result, dp[r][i]);
					l++;
					r--;
				}
			}
		}
		for( int row=0;row<dp.length;row++)
		{
			for(int col=0;col<dp[0].length;col++)
			{
				System.out.print(dp[row][col] + " ");	
			}
			System.out.println();
		}
		if (result != 0) {
			return result + 2;
		}

		return 0;
	}
public int lenLongestFibSubseqAjay(int[] arr) {
		
			
		int max = 0;
		Map<Integer,Integer>  map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], i);
		}
		for(int i=2;i<arr.length;i++)
		{
			int left= 0;
			int right =  left+1;
			int sum  = arr[left]+arr[right];
			int counter=0;;
			System.out.println(left +  " "+right);
			while(map.containsKey(sum) &&  map.get(sum)<=i)
			{
				counter++;
				left =  right;
				right =  map.get(sum);
				sum = arr[left]+arr[right];
			}
			max =  Math.max(max, counter);
		}
		if(max!=0)
			return max+2;
		return max;
		
		
	}
	public static void main(String[] args) {
		int nums[] = new int[]{1,2,3,4,5,7,8};
		LenLongestFibSubseq  fibSubseq = new LenLongestFibSubseq();
		System.out.println(fibSubseq.lenLongestFibSubseqGood(nums));
	}
	public int lenLongestFibSubseqGood(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            mp.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
       
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = arr[i] - arr[j];
                if (mp.containsKey(d)) {
                    int k = mp.get(d);
                    if (k < j) {
                        dp[j][i] = Math.max(dp[j][i], dp[k][j] + 1);
                        ans = Math.max(ans, dp[j][i]);
                    }
                }
            }
        }
        return ans+2;
    }
}
