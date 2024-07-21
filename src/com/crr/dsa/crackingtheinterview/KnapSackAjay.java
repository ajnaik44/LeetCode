package com.crr.dsa.crackingtheinterview;

public class KnapSackAjay {
	int dp[][]=null;
	public static void main(String[] args) {
		
		int weight[] = { 2, 3, 4 };
		int value[] = { 1, 2, 5 };
		int capacity = 7;
		KnapSackAjay  ajay = new KnapSackAjay();
		ajay.dp = new int[weight.length+1][capacity+1];
		System.out.println(ajay.dfsnew(5,value, value.length));
	}
	public int dfsnew(int amount, int[] coins, int n) {
	    int[][] memo = new int[coins.length + 1][amount + 1];

	    // Base case: when amount is 0, there's 1 way to make change (by not selecting any coin)
	    for (int i = 0; i <= coins.length; i++) {
	        memo[i][0] = 1;
	    }

	    for (int i = 1; i <= coins.length; i++) {
	        for (int j = 1; j <= amount; j++) {
	            if (j - coins[i - 1] >= 0) {
	                memo[i][j] = memo[i][j - coins[i - 1]] + memo[i-1][j];
	            } else {
	                memo[i][j] = memo[i - 1][j];
	            }
	        }
	    }
	    return memo[n][amount];
	}
	public int dfsIterative(int weight[],int value[],int w,int n)
	{
		
		int t[][]= new int[n+1][w+1];
		
		for(int i=1;i<n+1;i++)
		{
			
			for(int j=1;j<w+1;j++)
			{
				if(weight[i-1]<=j)
				{
					t[i][j] =  Math.max(value[i-1]+  
							t [i-1]
							[j-weight[i-1] ] , 
							t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];	
				}
			}
			
		}
		return t[n][w];
		
		
	}
	public int dfs(int weight[],int value[],int w,int n)
	{
		if(n==0 || w==0 )
			return 0;
		if(this.dp[n][w]!=0)
			return this.dp[n][w];	
		int res=0;
		if(weight[n-1] <=  w)
			res = Math.max(value[n-1]+    dfs (weight, value,w-weight[n-1],n-1 ),
					dfs (weight, value,w,n-1 ));
		else
		res=	 dfs(weight,value,w,n-1);
		this.dp[n][w] = res;
		return res;
		
	}

}
