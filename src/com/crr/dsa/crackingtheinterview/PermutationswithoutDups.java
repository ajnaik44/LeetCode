package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;

public class PermutationswithoutDups {
	ArrayList<String> getPerms(String str) {
        if (str == null) return null;
        
        ArrayList<String> permutations = new ArrayList<String>();
        
        if (str.length() == 0) {//base case
            permutations.add("");
            return permutations;
        }
        
        char first = str.charAt(0); // get the first char
        String remainder = str.substring(1); // remove the first char
        
        ArrayList<String> words = getPerms(remainder);
        
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        
        return permutations;
    }
    
    /* Insert char c at index i in word. */
  static  String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
    
    
    public static ArrayList<String>  getPermutation(String s)
    {
    	ArrayList<String> res =  new ArrayList<String>();
    	res.add(s.charAt(0)+"");
    	for(int i=1;i<s.length();i++) {
    		res =  getPermutation(res,s.charAt(i));
    	}
    	return res;
    	
    }
    public static ArrayList<String>  getPermutation(ArrayList<String> list , char c)
    {
    	ArrayList<String>	temp = new ArrayList<>();
    	for( String word:list) {
	    	for(int i=0;i<=word.length();i++)
	    	{
	    		String s =  insertCharAt(word, c, i);
	    		temp.add(s);
	    	}
    	}
    	
    	
    	return temp;
    	
    }
    ArrayList<String> getPermsOp1(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();
        
        /* Base case. */
        if (len == 0) {
            result.add(""); // Be sure to return empty string!
            return result;
        }
        
        for (int i = 0; i < len; i++) {
            /* Remove char i and find permutations of remaining chars.*/
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPermsOp1(before + after);
            
            /* Prepend char i to each permutation.*/
            for (String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
    	PermutationswithoutDups perm = new PermutationswithoutDups();
        ArrayList<String> result = perm.getPermsOp1("abc");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("c".substring(1,1));
    }
}
