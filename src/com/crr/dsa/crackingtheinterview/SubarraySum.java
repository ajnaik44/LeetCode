package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	 public int subarraySum(int[] nums, int k) {
	        int answer=0;
	       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	      int sum=0;
	      for(int num: nums)
	      {
	    	  sum+=num;
	    	  answer+=map.getOrDefault(sum-k, 0);
	    	  map.put(sum, map.getOrDefault(sum,0)+1);
	      }
	        return answer;
	    }
	 public static void main(String[] args) {
		int nums[] ={-2,1,2,-2,5,-2,1};
		System.out.println(new SubarraySum().subarraySum(nums, 3));
		System.out.println(Math.ceil(3.714286));
	}
}
