package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,1);
        int longestSequence=0;
      
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int currentResult=0;
            int num =nums[i];
            Queue<Integer>  queue = new LinkedList<Integer>();
            queue.add(num);
            while(!queue.isEmpty() &&  !set.contains(queue.peek()) &&  map.get(num)!=null)
            {
               num = queue.poll(); 
               if(map.get(num)!=null){
                  currentResult+=map.get(num);
                  set.add(num);
                  if(map.get(num-1)!=null &&  !set.contains(num-1))
                    queue.add(num-1);
                 if(map.get(num+1)!=null && !set.contains(num+1))
                    queue.add(num+1);
                }
                
               
            }
            longestSequence =  Math.max(longestSequence,currentResult);
        }
        return longestSequence;
    }
	public static void main(String[] args) {
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		int num[] = {100,4,200,1,3,2};
		System.out.println(longestConsecutive.longestConsecutive(num));
	}
}
