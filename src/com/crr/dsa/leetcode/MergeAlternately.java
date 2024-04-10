package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeAlternately {
	public static String mergeAlternately(String word1, String word2) {
		String result = "";

		if (word1 != null && word2 != null) {
			int i = 0;
			for (i = 0; i < word1.length() && i < word2.length(); i++) {
				result = result + String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(i));

			}
			if (i < word1.length())
				result = result + word1.substring(i);
			if (i < word2.length())
				result = result + word2.substring(i);
		}
		return result;
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (str1 != null && str2 != null) {
			if (str1.contains(str2)) {
				while (!str1.equalsIgnoreCase(str2)) {
					int index = str1.indexOf(str2);

					str1 = str1.substring(index + str2.length());

					if (str1.equalsIgnoreCase(str2)) {
						return str1;
					}
					if (!(str1.contains(str2))) {
						return str1;
					}
				}
			}
		}
		return "";
	}
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =  candies[0];
        List<Boolean>  res = new ArrayList<>();
       for(int i=1;i<candies.length;i++)
       {
    	   max =  Math.max(max, candies[i]);
    	   
       }
       for(int i=0;i<candies.length;i++)
       {
    	   if(candies[i]+extraCandies >= max)
    	   {
    		   res.add(true);
    	   }else {
    		   res.add(false);
    	   }
    	   
       }
       
       return res;
    }
	public static boolean checkVowels(String vowels,char input)
	 {
		 if(vowels.contains(String.valueOf(input)))
		 {
			 return true;
		 }
		 return false;
	 }
	 public static boolean canPlaceFlowers(int[] flowerbed, int n) {
	        int count = 0;
	        for (int i = 0; i < flowerbed.length; i++) {
	            // Check if the current plot is empty.
	            if (flowerbed[i] == 0) {
	                // Check if the left and right plots are empty.
	                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
	                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
	                
	                // If both plots are empty, we can plant a flower here.
	                if (emptyLeftPlot && emptyRightPlot) {
	                    flowerbed[i] = 1;
	                    count++;
	                }
	            }
	        }
	        return count >= n;
	    }
	 public static String reverseVowels(String s) {
		    char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		    char[] inputs = s.toCharArray();

		    int i = 0, j = s.length() - 1;
		    while (i < j) {
		        while (i < j && !isVowel(inputs[i], vowels)) {
		            i++;
		        }
		        while (i < j && !isVowel(inputs[j], vowels)) {
		            j--;
		        }
		        if (i < j) {
		            char temp = inputs[i];
		            inputs[i] = inputs[j];
		            inputs[j] = temp;
		            i++;
		            j--;
		        }
		    }

		    return new String(inputs);
		}

		public static boolean isVowel(char input, char[] vowels) {
		    for (char vowel : vowels) {
		        if (input == vowel) {
		            return true;
		        }
		    }
		    return false;
		}

	
		 public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
		        
		        int len = flowerbed.length;
		        int total_allowed = 0, total_current=0;
		        boolean odd_positioned = false;
		        
		        
		        for(int i=0; i<len; i++){
		            if(flowerbed[i]==1)
		            {
		                total_current++;

		                if(i/2==0)
		                	odd_positioned = true;
		                	
		            }
		        }
		        
		        
		        if(len/2==0){
		            total_allowed = len/2;
		            
		        }
		        else{
		            
		            if(odd_positioned)
		                      total_allowed = (len+1)/2;
		            else 
		                total_allowed = (len-1)/2;
		        }
		        
		        System.out.println("total_allowed " + total_allowed);
		         
		        
		        
		        if(total_current+n<=total_allowed)
		            return true;
		        else
		            return false;
		    }
	public static void main(String[] args) {
		int a[] = {0,0,1,0,0};
//		[0,0,1,0,0]
//				2
		
		System.out.println(canPlaceFlowers1(a, 2));
		
		
	}
}
