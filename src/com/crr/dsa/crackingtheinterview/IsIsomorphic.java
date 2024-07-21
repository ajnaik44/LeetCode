package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
	public boolean wordPattern(String pattern, String s) {
        Map<String,Character> sMap = new HashMap<>();
        Map<Character,String> pMap = new HashMap<>();

        int i=0;
        for(String temp: s.split(" ")){
            if(temp.isEmpty())
            continue;
            char c =  pattern.charAt(i);
             i++;
            if(sMap.get(temp)==null && pMap.get(c)==null)
            {
                sMap.put(temp,c);
                pMap.put(c,temp);
                continue;
            }
            if( pMap.get(c)==null || sMap.get(temp)==null   || (sMap.get(temp)!=c || !pMap.get(c).equals(temp))){
                return false;
            }
           
        }
        return true;
    }
	public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Character> sMap =new HashMap<>();
        Map<Character,Character> tMap =new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char c1 =  s.charAt(i);
            char c2 = t.charAt(i);
            if(!sMap.containsKey(c1) && !tMap.containsKey(c2))
            {
                sMap.put(s.charAt(i),t.charAt(i));
                tMap.put(t.charAt(i),s.charAt(i));
            }
            else if(( sMap.get(c1)==null || tMap.get(c2)==null )
            ||  (sMap.get(c1)  !=c2 &&  tMap.get(c2)!=c1  ))
                return false;
        }
        return true;

    }
	public static void main(String[] args) {
		IsIsomorphic isIsomorphic = new IsIsomorphic();
		System.out.println(isIsomorphic.wordPattern("abba", "dog cat cat fish"));
	}
}
