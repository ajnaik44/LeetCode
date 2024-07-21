package com.crr.dsa.crackingtheinterview;

public class MinWindow {
	 public String minWindow(String s1, String s2) {
	        int left =0;
	        int right=0;
	        int s2Index = 0;
	        String ans="";
	        int minLen = Integer.MAX_VALUE;
	        while(right<s1.length())
	        {
	            if(s1.charAt(right)==s2.charAt(s2Index))
	            {
	             
	               s2Index++;
	            }
	            if(s2Index>=s2.length())
	            {
	            	 // Move the left pointer to shrink the window as much as possible
	                int tempIndex = s2Index - 1;
	                int tempLeft = right;

	                while (tempIndex >= 0) {
	                    if (s1.charAt(tempLeft) == s2.charAt(tempIndex)) {
	                        tempIndex--;
	                    }
	                    tempLeft--;
	                }

	                tempLeft++; // Move left back to the start of the valid window
	                if (right - tempLeft + 1 < minLen) {
	                    minLen = right - tempLeft + 1;
	                    ans = s1.substring(tempLeft, right + 1);
	                }

	                // Reset s2Index and move left to the right of the previous left
	                s2Index = 0;
	                right = tempLeft;
	            }
	            right++;
	        }
	        return ans;
	    }
	 public static void main(String[] args) {
		MinWindow minWindow = new MinWindow();
		System.out.println(minWindow.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "k"));
	}
}
