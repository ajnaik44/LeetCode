package com.crr.dsa.stack;



import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static String decodeMessage(String key, String message) {
        StringBuilder ans = new StringBuilder();
        char cipher[] = key.toCharArray();

        HashMap<Character, Character> map = new HashMap<>();
        for (char ch = 'a', i = 0; ch <= 'z'; ch++, i++) {
            map.put(ch, cipher[i]);
        }

        for (char i : message.toCharArray()) {
            char lowerCaseChar = Character.toLowerCase(i);
            if (map.containsKey(lowerCaseChar)) {
                char decodedChar = map.get(lowerCaseChar);
                ans.append(Character.isUpperCase(i) ? Character.toUpperCase(decodedChar) : decodedChar);
            } else {
                ans.append(i);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
		
    	int n = 5; // Number of working hours in a day
        int[][] issues = {
            {1, 3, 4, 1, 3},
            {3, 5, 1, 9, 7},
            {1, 1, 1, 2, 0},
            {4, 3, 1, 7, 9},
            {32, 1, 4, 6,8}
        };

        int totalDistortion = 0;
        for (int hour = 1; hour < n; hour++) {
            int prevHourTotal = 0;
            for (int i = 0; i < 5; i++) {
                prevHourTotal += issues[hour - 1][i];
            }

            int currHourTotal = 0;
            for (int i = 0; i < 5; i++) {
                currHourTotal += issues[hour][i];
            }
            if (currHourTotal - prevHourTotal >= 0) {
            totalDistortion += Math.abs(currHourTotal - prevHourTotal);
            }
        }

        System.out.println(totalDistortion); // Correct output is 60


    }
}
