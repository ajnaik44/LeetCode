package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	
	
	public int[] topKFrequentOptimize(int[] nums, int k) {
        if(nums.length==k)
            return nums;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }

       List<Integer>[] buckets = new ArrayList[nums.length+1];
       for(int i=0;i<=nums.length;i++)
    	   buckets[i]= new ArrayList();
      
       for(Map.Entry<Integer, Integer> counts: map.entrySet() )
       {
    	   buckets[counts.getValue()].add(counts.getKey());
       }
       
       int top[]=  new int[k];
       int i=0;
       int length =  nums.length;
       while(i<k)
       {
    	   while(buckets[length].isEmpty())
    	   {
    		   length--;
    	   }
    	   top[i] =  buckets[length].get(0);
    	   i++;
    	   length--;
    	   
       }
       return top;
       

    }
	 public int[] topKFrequent(int[] nums, int k) {
	        if(nums.length==k)
	            return nums;
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

	        for(int i:nums)
	        {
	            map.put(i,map.getOrDefault(i,0)+1);
	        }

	       
	       PriorityQueue<Integer> pq = new PriorityQueue<Integer>(   (n1, n2) -> map.get(n1) - map.get(n2));

	        for (int n: map.keySet()) {
	          pq.add(n);
	          if (pq.size() > k) pq.poll();    
	        }


	     int[] top = new int[k];
	        for(int i = k - 1; i >= 0; --i) {
	            top[i] = pq.poll();
	        }
	        return top;

	    }
	 public static void main(String[] args) {
		TopKFrequent topKFrequent = new TopKFrequent();
		int nums[]= {1,1,1,2,2,3};
		System.out.println(topKFrequent.topKFrequentOptimize(nums, 1));
	}
}
