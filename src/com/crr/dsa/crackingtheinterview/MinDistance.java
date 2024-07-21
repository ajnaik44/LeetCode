package com.crr.dsa.crackingtheinterview;

public class MinDistance {
public static void main(String[] args) {
	MinDistance  minDistance = new MinDistance();
	minDistance.minDistance("horse", "ros");
}
	    Integer memo [][]=null;
	    public int minDistance(String word1, String word2) {
	        memo = new Integer[word1.length()][word2.length()];
	        return dfs(word1,word2,0,0);
	    }
	    public int dfs(String word1,String word2,int i,int j)
	    {
	        // base condition
	        if (i >= word1.length()) return word2.length() - j; 
	        if (j >= word2.length()) return word1.length() - i;


	        if(memo[i][j]!=null)
	            return memo[i][j];
	        if(word1.charAt(i)== word2.charAt(j))
	        {
	            return dfs(word1,word2,i+1,j+1);
	        }
	        else{
	            //add condition
	         int add =   dfs(word1,word2,i,j+1);    
	           // replace
	         int replace =   dfs(word1,word2,i+1,j+1);
	           // remove
	         int remove =   dfs(word1,word2,i+1,j); 
	            return memo [i][j]= Math.min(add,Math.min(replace,remove))+1;
	        }


	    }
	
}
