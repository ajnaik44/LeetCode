package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrampInterview {
	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        // Populate the map with array elements
        for (int i = 0; i < arr.length; i++) {
            pairMap.put(arr[i], i);
        }

        // Iterate through the array and find pairs with the given difference
        for (int i = 0; i < arr.length; i++) {
            int complement = k + arr[i]; // Calculate the complement
            if (pairMap.containsKey(complement) && pairMap.get(complement) != i) {
                int[] tempResult = {complement, arr[i]}; // Create a pair
                result.add(tempResult); // Add the pair to the result list
            }
        }

       

        return result.toArray(new int[0][]); // Return the resulting 2D array
    }

	public static void main(String[] args) {
		int arr[] = { 0, -1, -2, 2, 1 };
		int[][] res = findPairsWithGivenDifference(arr, 1);
		for (int a[] : res) {
			System.out.println(a[0] + " " + a[1]);
		}
		System.out.println(decrypt("crime"));
	}
	 public static String decrypt(String word) {
	        int secondStep = 1;
	        StringBuilder decryption = new StringBuilder();

	        for (int i = 0; i < word.length(); i++) {
	            int newLetterAscii = (int) word.charAt(i);
	            newLetterAscii -= secondStep;

	            while (newLetterAscii < (int) 'a') {
	                newLetterAscii += 26;
	            }

	            decryption.append((char) newLetterAscii);
	            secondStep += newLetterAscii;
	        }

	        return decryption.toString();
	    }
}
