package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		 int sLength =  s.length();
		 int pLength = p.length();
		 List<Integer> answer = new ArrayList<Integer>();
		 if(s.isEmpty() ||  sLength< pLength)
			 	return answer;
		 int pArray[] =  new int[26];
		 int sArray[] =  new int[26];
		 
		 for(char c: p.toCharArray())
		 {
			 pArray[(int)c-'a']++;
		 }
		 
		 for(int i=0;i< sLength;i++)
		 {
			 sArray[(int)s.charAt(i)-'a']++;
			 if(i>=pLength)
			 {
				 sArray[(int)s.charAt(i-pLength)-'a']--;
			 }
			 if(Arrays.equals(pArray, sArray))
			 {
				 answer.add(i-pLength+1);
			 }
		 }
		 return answer;
		 
	 }
	public static void main(String[] args) {
		System.out.println(new FIndAnagrams().findAnagrams("cbaebabacd","abc"));
	}

}
