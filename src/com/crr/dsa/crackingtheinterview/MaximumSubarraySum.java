package com.crr.dsa.crackingtheinterview;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MaximumSubarraySum {
	public static void main(String[] args) {
		int [] nums= {1,1,1,7,8,9};
		System.out.println(new MaximumSubarraySum().maximumSubarraySum(nums, 3));
		System.out.println(new MaximumSubarraySum().lengthOfLongestSubstringKDistinctAproach2("eceba", 2));
	}
	  public long maximumSubarraySum(int[] nums, int k) {
	        Set<Integer> set = new HashSet<Integer>();
	        long max = 0;
	        long sum = 0;
	        
	        int right=0;

	        for(int left=0;left<nums.length;left++)
	        {
	            while(right<nums.length &&  !set.contains(nums[right]) && set.size()<k)
	            {
	                set.add(nums[right]);
	                sum+=nums[right];
	                right++;
	            }
	            if(set.size()==k)
	            {
	                max =  Math.max(sum,max);
	            }
	            set.remove(nums[left]);
	            sum-=nums[left];
	        }
	       
 	    return max;
	    }
	  public int lengthOfLongestSubstringKDistinctAproach2(String s, int k) 
	    {
	        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
	        int right = 0;
	        int max = 1;
	        int left=0;
	       while(right< s.length())
	       {
	        Character  character =  s.charAt(right);
	        if(map.containsKey(character))
	        {
	            map.remove(character);
	        }
	        map.put(character,right++);

	        if(map.size()==k+1)
	        {
	           Map.Entry<Character,Integer> leftmost =  map.entrySet().iterator().next();
	           left = leftmost.getValue()+1;
	        }
	        max =  Math.max(max,right-left);
	       }
	       return max;
	    }
	  public int lengthOfLongestSubstringKDistinct(String s, int k) 
	    {
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        int right = 0;
	        int max = 1;
	        int left=0;
	       while(right< s.length())
	       {
	        map.put(s.charAt(right),right++);
	        if(map.size()==k+1)
	        {
	        	System.out.println(map.values());
	            int lowestIndex =  Collections.min(map.values());
	            map.remove(s.charAt(lowestIndex));
	            left =  lowestIndex+1;
	        }
	        max =  Math.max(max,right-left);
	       }
	       return max;
	    }
}
