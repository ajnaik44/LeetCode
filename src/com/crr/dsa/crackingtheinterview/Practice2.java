package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Practice2 {

	public static boolean isValid(String a, String b, int i, int j) {
		if (i >= a.length() && j >= b.length())
			return true;
		if (j >= b.length())
			return false;
		boolean match = i < a.length() && (a.charAt(i) == b.charAt(j) || b.charAt(j) == '-');
		if (j + 1 < b.length() && b.charAt(j + 1) == '*') {
			return isValid(a, b, i, j + 2) || (match && isValid(a, b, i + 1, j));
		}
		if (match) {
			return isValid(a, b, i + 1, j + 1);
		}
		return false;
	}

	int[][] memo = null;
	String source, target = null;

	public int memo(int i, int j) {
		if (i == source.length() || j == target.length())
			return target.length() - 1;
		if(memo[i][j]!=0)
			return memo[i][j];
		if (source.charAt(i) == target.charAt(j)) {
			memo[i][j] = memo(i + 1, j + 1);

		} else
			memo[i][j] = 1 + Math.min(memo(i + 1, j), memo(i, j + 1));
		return memo[i][j];

	}
	public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
           
        }
    }
	 public static int distinctSubseqII(String S) {
	        int MOD = 1_000_000_007;
	        int N = S.length();
	        int[] dp = new int[N+1];
	        dp[0] = 1;

	        int[] last = new int[26];
	        Arrays.fill(last, -1);

	        for (int i = 0; i < N; ++i) {
	            int x = S.charAt(i) - 'a';
	            dp[i+1] = dp[i] * 2 % MOD;
	            if (last[x] >= 0)
	                dp[i+1] -= dp[last[x]];
	            dp[i+1] %= MOD;
	            last[x] = i;
	        }

	        dp[N]--;
	        if (dp[N] < 0) dp[N] += MOD;
	        return dp[N];
	    }
	public static void main(String[] args) {
		int res=0;
		 int MOD = 1_000_000_007;
		String s =  "aba";
		for(int i=0;i<s.length();i++ )
			allSubstrings(s,i,i+1);
		for(Map.Entry<String, Integer> map : combination.entrySet() )
		{
			res+=map.getValue();
		}
		 System.out.println(distinctSubseqII("aaa"));
		System.out.println(res);
	}
	public static String getStringFromLinkedList(LinkedList<Character> list) {
	    StringBuilder sb = new StringBuilder();
	    for (char ch : list) {
	      sb.append(ch);
	    }
	    return sb.toString();
	  }
	static TreeMap<String,Integer> combination = new TreeMap<String,Integer>();
	public static void  allSubstrings(String inputString,int i,int j) {
	    
		if(i>=inputString.length())
			return ;
		LinkedList<Character> list = new LinkedList<Character>();
		
		list.add(inputString.charAt(i));
		while(j< inputString.length())
		{
			list.add(inputString.charAt(j));
			String str = getStringFromLinkedList(list);
			if(combination.get(str)==null)
			{
				combination.put(str, isPalindrome(str));
			}
			j++;
		}
		LinkedList<Character> itr =  new LinkedList<Character>(list);
		int size= 1;
		while(  size<itr.size())
		{	
			list.remove(list.size() - list.size()+1);
			String str = getStringFromLinkedList(list);
			if(combination.get(str)==null)
			{
				combination.put(str, isPalindrome(str));
			}
			
			size++;
		}
		
		
	  }

	 public static int isPalindrome(String s)
	   {
	        int i=0;
	        int j=s.length()-1;
	        if(s.isEmpty())
	            return 0;
	        
	        while(i<j)
	        {
	            if(s.charAt(i)!=s.charAt(j))
	                return 0;
	            i++;
	            j--;
	        }
	        return 1;


	   }

	public int minimumDeleteSum(String s1, String s2) {
	       return minimumDeleteSum( s1,  s2,0,0);  
	    }
	    public int minimumDeleteSum(String s1, String s2,int i,int j) 
	    {
	     if(i> s1.length() &&  j> s2.length())
	        return 0;
	    if(i<s1.length() &&  j>=s2.length())
	    {
	    	int sum =0;
	    	while(i<s1.length())
	    	{
	    		sum+= s1.charAt(i);
	    		i++;
	    	}
	    	
	    	return sum;
	    }else {
	    	if(i>=s1.length() &&  j<s2.length())
		    {
		    	int sum =0;
		    	while(j<s2.length())
		    	{
		    		sum+= s2.charAt(j);
		    		j++;
		    	}
		    	return sum;
		    }
	    }
	    
	    
	    if(i< s1.length()  &&  j< s2.length() &&  s1.charAt(i)==s2.charAt(j))
	    {
	     return  minimumDeleteSum( s1,  s2, i+1, j+1);
	    }
	    else 
	    {
	    	int sum1=0;
	    	int sum2=0;
	    	if (i < s1.length())
	         sum1= (int)s1.charAt(i)+ minimumDeleteSum( s1,  s2, i+1, j);  
	        if(j< s2.length()) 
	         sum2= 
	        (int)s1.charAt(j)+ minimumDeleteSum( s1,  s2, i, j+1);
	        System.out.println( " sum " +  sum1 + " sum2 " +  sum2); 
	      
	        return Math.min(sum1,Math.min(sum2,sum1+sum2));

	    }
	    
	    }
}
