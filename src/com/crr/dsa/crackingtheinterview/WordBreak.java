package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	public static void main(String[] args) {
		ArrayList word= new ArrayList();
		word.add("car");
		word.add("ca");
		word.add("rs");
		String s ="cars";
		
		System.out.println(new WordBreak().wordBreak(s,s,word,-1,0,new StringBuilder())) ;
	}
	
	    private String s;
	    private List<String> wordDict;
	    private int[] memo;
	    
	    private boolean dp(int i) {
	        if (i < 0) return true;
	        
	        if (memo[i] != -1) {
	            return memo[i] == 1;
	        }
	        
	        for (String word: wordDict) {
	            // Handle out of bounds case
	            if (i - word.length() + 1 < 0) {
	                continue;
	            }
	            
	            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
	                memo[i] = 1;
	                return true;
	            }
	        }
	        
	        memo[i] = 0;
	        return false;
	    }
	    
	    public boolean wordBreak(String s, List<String> wordDict) {
	        this.s = s;
	        this.wordDict = wordDict;
	        this.memo = new int[s.length()];
	        Arrays.fill(this.memo, -1);
	        return dp(s.length() - 1);
	    }
	
	    public boolean wordBreak(String originalString , String s, List<String> wordDict,int lastIndex,int arrayIndex,StringBuilder result) {
	      
	        for(int i=arrayIndex;i< wordDict.size();i++)
	        {
	            if(s.contains(wordDict.get(i)))
	            {   int resultsize =  result.length();
	            	result.append(wordDict.get(i));
	            	if(originalString.equals(result.toString()))
	            		return true;
	                String[] splitString = s.trim().split(wordDict.get(i));
	                for(String word:splitString)
	                     {
	                    	 if(!word.isEmpty()) {
	                    		 int length =  result.length();
	                    		   if(wordBreak(originalString,word,wordDict,lastIndex,i+1,result)) {
	                    			   return true;
	                    		   }else {
	                    			   result.setLength(length);
	                    		   }
	                    	 }
	                    		
	                    	 
	                     }
	                result.setLength(resultsize);
	           }
	    
	        }
	        return result.equals(s);
	    }

	    
}
