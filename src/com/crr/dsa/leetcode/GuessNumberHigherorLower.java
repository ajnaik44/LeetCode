package com.crr.dsa.leetcode;

public class GuessNumberHigherorLower 
{
	 public int guessNumber(int n) {
	        int low = 1;
	        int high = n;
	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            int res = guessNumber(mid);
	            if (res == 0)
	                return mid;
	            else if (res < 0)
	                high = mid - 1;
	            else
	                low = mid + 1;
	        }
	        return -1;
	    }
}
