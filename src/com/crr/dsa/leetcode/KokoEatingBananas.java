package com.crr.dsa.leetcode;

public class KokoEatingBananas {
	
	    public int minEatingSpeedIntuitiveApproach(int[] piles, int h) {
	        // Start at an eating speed of 1.
	        int speed = 1;

	        while (true) {
	            // hourSpent stands for the total hour Koko spends with 
	            // the given eating speed.
	            int hourSpent = 0;

	            // Iterate over the piles and calculate hourSpent.
	            // We increase the hourSpent by ceil(pile / speed)
	            for (int pile : piles) {
	                hourSpent += Math.ceil((double) pile / speed);
	                if (hourSpent > h) {
	                    break;
	                }
	            }

	            // Check if Koko can finish all the piles within h hours,
	            // If so, return speed. Otherwise, let speed increment by
	            // 1 and repeat the previous iteration.
	            if (hourSpent <= h) {
	                return speed;
	            } else {
	                speed += 1;
	            }            
	        }
	    }
	    public int minEatingSpeed(int[] piles, int h) {
	        // Initalize the left and right boundaries 
	        int left = 1, right = 1;
	        for (int pile : piles) {
	            right = Math.max(right, pile);
	        }

	        while (left < right) {
	            // Get the middle index between left and right boundary indexes.
	            // hourSpent stands for the total hour Koko spends.
	            int middle = (left + right) / 2;
	            int hourSpent = 0;

	            // Iterate over the piles and calculate hourSpent.
	            // We increase the hourSpent by ceil(pile / middle)
	            for (int pile : piles) {
	                hourSpent += Math.ceil((double) pile / middle);
	            }

	            // Check if middle is a workable speed, and cut the search space by half.
	            if (hourSpent <= h) {
	                right = middle;
	            } else {
	                left = middle + 1;
	            }
	        }

	        // Once the left and right boundaries coincide, we find the target value,
	        // that is, the minimum workable eating speed.
	        return right;
	    }
	public static void main(String[] args) {
		KokoEatingBananas bananas = new KokoEatingBananas();
		int [] piles = new int[] {3,6,7,11};
		int h = 8;
		System.out.println(bananas.minEatingSpeed(piles, h));
	}
}
