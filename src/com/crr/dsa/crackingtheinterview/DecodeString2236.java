package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.Set;

public class DecodeString2236 {
public static void main(String[] args) {
	System.out.println(decodeString("2263"));
	HashSet<Integer> hashset = new HashSet<Integer>();
	
}
	public static int decodeString(String encryptedString)
	{
		int[] dp = new int[encryptedString.length()];
		int c[] = new int[encryptedString.length()];
		for(int i=0;i<encryptedString.length();i++)
		{
			c[i] =  Integer.parseInt(encryptedString.charAt(i)+"");
		}
		return decodeString(c, 0, dp);
	}
	
	public static int decodeString(int[] encryptedString,int index,int[] dp)
	{
		if(index>=encryptedString.length)
			return dp[index-1];
		if( Integer.parseInt(encryptedString[index]+"")  >=1  && Integer.valueOf( encryptedString[index]+"") <=26)
		{
			dp[index]++;
		}
		if( index-1>=0 &&  index-1 < encryptedString.length )
		{
			if(Integer.valueOf(encryptedString[index-1]+""+ encryptedString[index]) >=1  &&  
					Integer.valueOf( encryptedString[index-1] +""+ encryptedString[index]) <=26)
			{
				dp[index]++;
			}
		}
		if(index-1>=0)
		dp[index]+=dp[index-1];
		return decodeString(encryptedString,index+1,dp);
	}
}
