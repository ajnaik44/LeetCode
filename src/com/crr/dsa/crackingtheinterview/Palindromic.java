package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class Palindromic {
	public static void main(String[] args) {
		Palindromic palindromic = new Palindromic();
		System.out.println(palindromic.countSubstrings("aaa"));
		System.out.println().25*8);
	}
	  public int countSubstrings(String s) {
	       return  palindromic(s,0);
	    }
	  Set<Integer>  set = new HashSet<Integer>();
	    public int palindromic(String s, int index)
	    {
	        if(index>s.length()) return 0;
	        int answer=0;
	        if(set.contains(index)) return 0;
	        set.add(index);
	        for(int i=index;i<s.length();i++)
	        {
	            if(isPalindrome(s,index,i))
	            {
	                answer++;
	            }
	           
	           answer+=palindromic(s,i+1); 
	            
	        }
	        return answer;
	    }
	    public boolean isPalindrome(String s,int left,int right)
	    {
	        while(left<right)
	        {
	            if(s.charAt(left)!=s.charAt(right)) return false;
	            left++;
	            right--;
	        }
	        return true;
	    }
}
