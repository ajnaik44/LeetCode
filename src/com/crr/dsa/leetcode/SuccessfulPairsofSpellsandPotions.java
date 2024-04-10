package com.crr.dsa.leetcode;

import java.util.Arrays;

public class SuccessfulPairsofSpellsandPotions 
{
	 public int[] successfulPairsAjay(int[] spells, int[] potions, long success) 
	 {
		int[] res = new int[spells.length];
		
		Arrays.sort(potions);
		for(int i=0;i<spells.length;i++)
		{
			int counter=0;
			for(int j=potions.length-1;j>=0;j--)
			{
				if(spells[i]*potions[j]<success)
					break;
				counter++;
				
			}
			res[i]=counter;
		}
	    return res;    
	  }
	 // Our implementation of lower bound method using binary search.
	    private int lowerBound(int[] arr, int key) {
	        int lo = 0;
	        int hi = arr.length;
	        while (lo < hi) {
	            int mid = lo + (hi - lo) / 2;
	            if (arr[mid] < key) {
	                lo = mid + 1;
	            } else {
	                hi = mid;
	            }
	        }
	        return lo;
	    }
	    
	    public int[] successfulPairsAppraoch1(int[] spells, int[] potions, long success) {
	        // Sort the potions array in increasing order.
	        Arrays.sort(potions);
	        int[] answer = new int[spells.length];

	        int m = potions.length;
	        int maxPotion = potions[m - 1];

	        for (int i = 0; i < spells.length; i++) {
	            int spell = spells[i];
	            // Minimum value of potion whose product with current spell  
	            // will be at least success or more.
	            long minPotion = (long) Math.ceil((1.0 * success) / spell);
	            // Check if we don't have any potion which can be used.
	            if (minPotion > maxPotion) {
	                answer[i] = 0;
	                continue;
	            }
	            // We can use the found potion, and all potion in its right 
	            // (as the right potions are greater than the found potion).
	            int index = lowerBound(potions, (int) minPotion);
	            answer[i] = m - index;
	        }

	        return answer;
	    }
	    public int[] successfulPairs(int[] spells, int[] potions, long success) {
	        int n = spells.length;
	        int m = potions.length;
	        
	        // Create an array of pairs containing spell and its original index
	        int[][] sortedSpells = new int[n][2];
	        for (int i = 0; i < n; i++) {
	            sortedSpells[i][0] = spells[i];
	            sortedSpells[i][1] = i;
	        }
	        
	        // Sort the 'spells with index' and 'potions' array in increasing order
	        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0], b[0]));
	        Arrays.sort(potions);
	        
	        // For each 'spell' find the respective 'minPotion' index
	        int[] answer = new int[n];
	        int potionIndex = m - 1;

	        for (int[] sortedSpell : sortedSpells) {
	            int spell = sortedSpell[0];
	            int index = sortedSpell[1];
	            
	            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
	                potionIndex -= 1;
	            }
	            answer[index] = m - (potionIndex + 1);
	        }
	        
	        return answer;
	    }
	 public static void main(String[] args) {
		int[] spells =new int[] { 3,1,2};
		int[] potions = new int[] {8,5,8};
		int success = 16;
		SuccessfulPairsofSpellsandPotions pairsofSpellsandPotions = new SuccessfulPairsofSpellsandPotions();
		System.out.println(pairsofSpellsandPotions.successfulPairs(spells, potions, success)[0]);
		System.out.println(pairsofSpellsandPotions.successfulPairs(spells, potions, success)[1]);
		System.out.println(pairsofSpellsandPotions.successfulPairs(spells, potions, success)[2]);
	}

}
