package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindRadius {
	public static void main(String[] args) {
		int[] houses = new int[] { 1,2,3};
		int heaters[] = new int[] { 1,4};
		FindRadius findRadius = new FindRadius();
		String word[][] = findRadius.wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
		
		for(String [] temp :  word)
				System.out.println(temp[0] + "  " +  temp[1]);
	}

	public int findRadius(int[] houses, int[] heaters) {
        int totalHouses = houses.length;
        int totalHeaters = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int j = 0;
        int[] left = new int[totalHouses];
        int[] right = new int[totalHouses];

        for (int i = 0; i < totalHouses; i++) {
            while (j + 1 < totalHeaters && houses[i] >= heaters[j + 1]) {
                j++;
            }
            left[i] = heaters[j] > houses[i] ? heaters[j] - houses[i] : houses[i] - heaters[j];
        }

        j = totalHeaters - 1;
        for (int i = totalHouses - 1; i >= 0; i--) {
            while (j - 1 >= 0 && houses[i] < heaters[j - 1]) {
                j--;
            }
            right[i] = heaters[j] > houses[i] ? heaters[j] - houses[i] : houses[i] - heaters[j];
        }

        int max = -1;
        int result = 0;
        for (int k = 0; k < totalHouses; k++) {
            result = Math.min(left[k], right[k]);
            max =  Math.max(result, max);
        }
        return max;
    }
	
	static String[][] wordCountEngine(String document) {
	    // your code goes here
		String[] words = document.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
	    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	    //StringBuilder result = new 
	    for(String word: words){
	      map.put(word, map.getOrDefault(word,0)+1);
	    }
	    LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
	    		collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1, LinkedHashMap::new));
	    
	    String[][] arrayString = sortedMap.entrySet().stream().map(e -> new String[]{e.getKey(), 
	    		String.valueOf(e.getValue())}).toArray(String[][]::new);
	    
	    return arrayString;


	    
	  }
	
}
