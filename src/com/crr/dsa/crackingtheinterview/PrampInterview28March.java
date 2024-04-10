package com.crr.dsa.crackingtheinterview;

import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class PrampInterview28March {

	 public static void main(String[] args) {
	        // Create a TreeMap with a custom comparator to sort in descending order
	        TreeMap<Integer, String> descendingMap = new TreeMap<>(Collections.reverseOrder());

	        // Add elements to the TreeMap
	        descendingMap.put(3, "Three");
	        descendingMap.put(1, "One");
	        descendingMap.put(2, "Two");

	        // Iterate over the entries in descending order
	        for (Map.Entry<Integer, String> entry : descendingMap.entrySet()) {
	           // System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	        System.out.println(isMatchOptimize("aab", "c*a*b"));
	    }
	 public static boolean isMatchOptimize(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--) {
	            for (int j = pattern.length() - 1; j >= 0; j--) {
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));

	                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
	                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i + 1][j + 1];
	                }
	            }
	        }
	        for (int i = 0; i < dp.length; i++) {
	            for (int j = 0; j < dp[0].length; j++) {
	                System.out.print(dp[i][j] ? "1" : "0");
	                if (j != dp[0].length - 1) {
	                    System.out.print(", ");
	                }
	            }
	            System.out.println();
	        }
	        return dp[0][0];
	    }
	 static boolean isMatch(String text, String pattern) 
	  {
	    
	    //https://github.com/neetcode-gh/leetcode/blob/main/java/0010-regular-expression-matching.java
	    
	    // your code goes here
	    // if it contains . * 
	      // if it contains * //  get the string before the * charcater  and match if it macthes return rue
	      //  if it contains . get the string befor and after dot  + 1  if it matches with the count with pattern return true
	    // if string equals to patterns return 
	    
	    Stack<Character> textqueue =  new Stack<Character>();
	    Stack<Character> patternqueue =  new Stack<Character>();
	    
	    for( char c : text.toCharArray() )
	    {
	      textqueue.push(c);
	    }
	    
	     for( char c : pattern.toCharArray() )
	    {
	      patternqueue.push(c);
	    }
	    
	    Character previousCharacter=null; 
	    while(!patternqueue.isEmpty())
	    {
	      if(patternqueue.peek()=='*'  )
	      {
	        previousCharacter =  '*';
	        patternqueue.pop();
	      
	      }
	     else  if(previousCharacter!=null && previousCharacter=='*' &&  ((textqueue.peek()==  patternqueue.peek() ) || patternqueue.peek()=='.'  ))
	      {
	    	 if(patternqueue.peek()=='.' )
	    	 {
	    		 
	    		 int index=  pattern.indexOf('.');
	    		 while(index < patternqueue.size()) {
	    			 textqueue.remove(index);
		          
		          previousCharacter =  null;
	    		 }
	    		 patternqueue.remove(index); 
	    	 }
	    	 else { textqueue.pop();
	        patternqueue.pop();
	        previousCharacter =  null;
	    	 }
	       
	      }
	     else  if(previousCharacter!=null && previousCharacter=='*' &&  textqueue.peek()!=  patternqueue.peek()  )
	      {
	    	 patternqueue.pop();
	       
	       
	      }
	      else if(!textqueue.isEmpty() &&  patternqueue.peek()=='.')
	      {
	    	  int index=  pattern.indexOf('.');
	          textqueue.remove(index);
	          patternqueue.remove(index);
	      }
	      else  if(patternqueue.peek()!= textqueue.peek() ){
	        return false;
	      }
	      else{
	         textqueue.pop();
	         
	          patternqueue.pop();
	      }
	    
	      
	    }
	    if(!textqueue.isEmpty())
	    	return false;
	    return true;
	    
	  }
	
		    

		   

}
