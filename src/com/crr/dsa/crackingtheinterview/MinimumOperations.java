package com.crr.dsa.crackingtheinterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperations {
	public static void main(String[] args) {
		int num[]=new int[] {1,5,0,3,5};
		MinimumOperations minimumOperations = new MinimumOperations();
		System.out.println(minimumOperations.minimumOperationsApproach1(num));
	}
	public int minimumOperationsApproach1(int[] nums) {
        HashSet<Integer> a=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            a.add(nums[i]);
        }
        return a.size();
    
    }
	public int minimumOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i:nums)
        {
            if(i!=0 &&  i < min )
            {
                min = Math.min(min, i);
            }
        }

        Queue<Integer> pq = new LinkedList<Integer>();
        pq.add(min);
        int result=0;
        while(!pq.isEmpty())
        {
            min =  pq.poll();
            int nextMin=Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=0)
                {
                    nums[i] =  nums[i] - min;
                    if(nums[i]!=0 )
                        nextMin =  Math.min(nextMin,nums[i]);
                }
            }
            result++;
            if(nextMin!=Integer.MAX_VALUE)
                pq.add(nextMin); 
        }
return result;
    }
}
