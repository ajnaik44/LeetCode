package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class MaxProfitAssignment {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int [][] diffProfit =  new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++)
        {
           diffProfit[i][0] =  difficulty[i];
           diffProfit[i][1] =  profit[i];
        }

        Arrays.sort(worker);
        Arrays.sort(diffProfit,(a,b) -> (a[0]-b[0]));

        int i=0,j=0,sum=0;
        while(i<worker.length && j<diffProfit.length)
        {
           while(j< diffProfit.length && worker[i] > diffProfit[j][0]  )
           {
            j++;
           }
           if(j>=0 &&    diffProfit[j][0] <=worker[i]  )
			{
				 sum+=diffProfit[j][1];
				 i++;
			}
			else  if(j-1>=0 &&  diffProfit[j-1][0]  <=worker[i])
           {
            sum+=diffProfit[j-1][1];
            i++;
            j--;
           }
         
          
           
          
        }
        return sum;

    }
	public static void main(String[] args) {
        MaxProfitAssignment solution = new MaxProfitAssignment();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker));  // Output should be 100
    }
}
