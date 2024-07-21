package com.crr.dsa.crackingtheinterview;

import java.math.BigInteger;

public class Amazon1 {
	BigInteger MOD = BigInteger.TEN.pow(9).add(BigInteger.valueOf(7)); 
	public static void main(String[] args) {
		System.out.println(new Amazon1().calculatexy("101!1",2, 3));
	}
	public int calculate(String str,char x,char y)
	{
		int zero=0;
		int left=0;
		int right=left=0;
		while(right<str.length())
		{
			while(right< str.length() && str.charAt(right)!=x)
			{
				right++;
			}
			left =  right;
			right=right+1;
			while(right< str.length())
			{
				if(str.charAt(right)==y)
					zero++;
				right++;
			}
			right=left+1;
		}
		return zero;
	}
	
	public int calculatexy(String s,int x,int y)
	{
		String s1 =  s.replace("!", "0");
		int x1 =  calculate(s1, '0', '1');
		int y1 =  calculate(s1, '1', '0');
		int sum1 = (x1*x + y*y1 ) ;
		
		String s2 =  s.replace("!", "1");
		int x2 =  calculate(s2, '0', '1');
		int y2 =  calculate(s2, '1', '0');
		int sum2 = x2*x + y*y2;
		
		return Math.min(sum1, sum2);
		
	}

}
