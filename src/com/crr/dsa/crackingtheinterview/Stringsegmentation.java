package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class Stringsegmentation {
	public static boolean canSegmentString(String s, Set<String> dictionary) {
		for(String word:dictionary)
		{
			String []splitString = 	s.split(word);
			int expectedCount =  splitString.length;
			int actualResult = 0;
			for(String splitWord:splitString)
			{
				if(!splitWord.isEmpty() && !splitWord.equals(s))
					actualResult+= isInDict(splitWord, dictionary);
			}
			if(expectedCount==actualResult)
				return  true;
		}
	    return false;
	  }
	public static int  isInDict(String s, Set<String> dictionary) {
		for(String word:dictionary)
		{
			System.out.println(s);
			if(s.equals(word))
				return 1;
		}
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set stArray = new HashSet();
		stArray.add("apple");
		stArray.add("pear");
		stArray.add("pier");
		stArray.add("pie");
		System.out.println(canSegmentString("appl", stArray));
		
	}

}
