package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinimumWindowSubString().numRescueBoats(new int[]{3,2,2,1},3));
	}

	    public String minWindow(String s, String t) {

	        if (s.length() == 0 || t.length() == 0) {
	            return "";
	        }

	        // Dictionary which keeps a count of all the unique characters in t.
	        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
	        for (int i = 0; i < t.length(); i++) {
	            int count = dictT.getOrDefault(t.charAt(i), 0);
	            dictT.put(t.charAt(i), count + 1);
	        }

	        // Number of unique characters in t, which need to be present in the desired window.
	        int required = dictT.size();

	        // Left and Right pointer
	        int l = 0, r = 0;

	        // formed is used to keep track of how many unique characters in t
	        // are present in the current window in its desired frequency.
	        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
	        // Thus formed would be = 3 when all these conditions are met.
	        int formed = 0;

	        // Dictionary which keeps a count of all the unique characters in the current window.
	        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

	        // ans list of the form (window length, left, right)
	        int[] ans = { -1, 0, 0 };

	        while (r < s.length()) {
	            // Add one character from the right to the window
	            char c = s.charAt(r);
	            int count = windowCounts.getOrDefault(c, 0);
	            windowCounts.put(c, count + 1);

	            // If the frequency of the current character added equals to the
	            // desired count in t then increment the formed count by 1.
	            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
	                formed++;
	            }

	            // Try and contract the window till the point where it ceases to be 'desirable'.
	            while (l <= r && formed == required) {
	                c = s.charAt(l);
	                // Save the smallest window until now.
	                if (ans[0] == -1 || r - l + 1 < ans[0]) {
	                    ans[0] = r - l + 1;
	                    ans[1] = l;
	                    ans[2] = r;
	                }

	                // The character at the position pointed by the
	                // `Left` pointer is no longer a part of the window.
	                windowCounts.put(c, windowCounts.get(c) - 1);
	                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
	                    formed--;
	                }

	                // Move the left pointer ahead, this would help to look for a new window.
	                l++;
	            }

	            // Keep expanding the window once we are done contracting.
	            r++;
	        }

	        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	    }
	    public String minWindowAjay(String s, String t) {
	        Map<Character,Integer> map=  new HashMap<Character,Integer>();
	        for(char c:t.toCharArray()){
	            map.put(c,map.getOrDefault(c,0)+1);
	        }
	        
	        String result = null;
	        Map<Character,Integer> temp =  new HashMap(map);
	        int left =0;
	        int right=0;
	        boolean startFlag = false;
	        while (right <  s.length() )
	        {
	            
	            if(temp.containsKey(s.charAt(right)))
	            {
	                temp.put(s.charAt(right) , temp.get(s.charAt(right))-1);
	                if(temp.get(s.charAt(right))==0)
	                    temp.remove(s.charAt(right));
	                    startFlag = true;
	            }
	          
	            if(temp.isEmpty())
	            {
	            	
	                String currentResult = s.substring(left,right+1);
	                
	                System.out.println(currentResult);
	                if(result ==null || currentResult.length() < result.length())
	                    result = currentResult;
	               
	                temp =  new HashMap(map);
	                right=left;
	                startFlag =false;   
	            }
	            if(!startFlag)
	                left++;
	            right++;
	        }
	        
	        return result==null? "":result;    
	    }

		
	    public String minWindowChatGPT(String s, String t) {
	        int[] tFreq = new int[128]; // Using an array to store the frequency of characters in string t
	        
	        // Calculate the frequency of characters in string t
	        for (char c : t.toCharArray()) {
	            tFreq[c]++;
	        }
	        
	        int[] windowFreq = new int[128]; // Using an array to store the frequency of characters in the current window
	        int left = 0, right = 0;
	        int minLen = Integer.MAX_VALUE;
	        int minStart = 0;
	        int required = t.length(); // Number of characters required to match
	        
	        while (right < s.length()) {
	            char c = s.charAt(right);
	            if (tFreq[c] > 0) { // If the character is in string t
	                windowFreq[c]++;
	                if (windowFreq[c] <= tFreq[c]) { // If the frequency of character in the window is less than or equal to required frequency
	                    required--;
	                }
	            }
	            
	            while (required == 0) { // If all characters in t are found in the window
	                if (right - left + 1 < minLen) { // Update minimum length and start index of minimum window
	                    minLen = right - left + 1;
	                    minStart = left;
	                }
	                char leftChar = s.charAt(left);
	                if (tFreq[leftChar] > 0) { // If the character at left pointer is in string t
	                    windowFreq[leftChar]--;
	                    if (windowFreq[leftChar] < tFreq[leftChar]) { // If the frequency of character becomes less than required
	                        required++;
	                    }
	                }
	                left++; // Move left pointer to the right
	            }
	            
	            right++; // Move right pointer to the right
	        }
	        
	        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen); // Return minimum window substring
	    }
	    public int numRescueBoats(int[] people, int limit) {
	        Arrays.sort(people);
	        int numOfBoats = 0;
	        int currentTotal = 0;
	        int i=0;
	        while(i< people.length)
	        {
	            
	            if(currentTotal+people[i]<=limit)
	            {
	               
	                currentTotal+=people[i];
	                 i++;
	            }
	          
	            else
	            {
	                numOfBoats++;
	                currentTotal=people[i];
	                i++;
	               
	            }    
	        }
	        return numOfBoats+1;
	    }
}
