package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class CheckInclusion {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		new CheckInclusion().permutate(0, set, "abcd".toCharArray());
		System.out.println(set);
	}
	public boolean checkInclusion(String s1, String s2) 
    {
       return true;
    }
	public void  permutate(int index,Set<String> set,char[] s)
	{
		if(index==s.length) {
			set.add(new String(s));
		return;
		}
		
		for(int i=index;i<s.length;i++)
		{
			swap( index, i,s );
			permutate(index+1, set, s);
			swap( index, i,s );
		}
		
	}
	private void swap(int i, int j, char[] s) {
		char c = s[i];
		s[i]=s[j];
		s[j]=c;
	}
	
    
	
}
