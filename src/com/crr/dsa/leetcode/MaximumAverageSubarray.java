package com.crr.dsa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumAverageSubarray {

	public  static double findMaxAverage(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		sum[i] = sum[i - 1] + nums[i];
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
		return res;
	}
	
	public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        // Build the window of size k, count the number of vowels it contains.
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int answer = count;
        
        // Slide the window to the right, focus on the added character and the
        // removed character and update "count". Record the largest "count".
        for (int i = k; i < s.length(); i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
            count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }
        
        return answer;
    }

	 public static boolean isVovels(char c)
	 {
		 char [] ovelsArray = {'a','e','i','o','u'};
		 for(char oval:ovelsArray)
		 {
			if(oval==c)
				return true;
		 }
		 return false;
	 }
	 
	public static void main(String[] args) {
		int[] a = {1,12,-5,-6,50,3};
		System.out.println(maxVowels("abciiidef",3));
	}
}
