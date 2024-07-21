package com.crr.dsa.crackingtheinterview;

public class IntegerBreak {
	int max =  Integer.MIN_VALUE;
    public int integerBreak(int n) {
        maximumProduct( n, 0,1,1);
        return max;
    }
    public int dp(int num)
    {
     if(num<=3)
         return num-1;
     
     int ans=num;
     for (int i = 2; i < num; i++) {
             ans = Math.max(ans, i * dp(num - i));
         }
     return ans;
    }
    public void maximumProduct(int n, int sum,int index,int product)
    {
        if(sum==n)
        {
        	  System.out.println( "  sum  " +  sum +  " products " +product);
            max =  Math.max(max,product);
            return;
        }
      
        if(sum>n)
            return;
        
        for(int i=index;i<=n;i++)
        {
        	sum =sum+i;
        	if(sum>n)
        		break;
            maximumProduct(n, sum,i, product*i);
        }
    }
    public static void main(String[] args) {
		IntegerBreak  break1 = new IntegerBreak();
		System.out.println(break1.integerBreak(10));
	}
}
