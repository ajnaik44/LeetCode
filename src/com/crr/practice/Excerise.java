package com.crr.practice;

import java.util.HashMap;
import java.util.*;

public class Excerise {
static	char[] c1 = "paper".toCharArray();
static	char[] c2 = "title".toCharArray();
static String results1="";
@SuppressWarnings("rawtypes")
static	Map resultsMap = new HashMap();
@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
public static void main(String[] args) {
	for(int i=0;i<c1.length;i++)
	{
		String key = String.valueOf(c1[i]);
		if(!resultsMap.containsKey(key))
		{
			resultsMap.put(String.valueOf(key),String.valueOf( c2[i]));
		}
		results1 += String.valueOf(resultsMap.get(key));
	}
	
	System.out.println(new String(c2).equals(results1));
	
}
}
