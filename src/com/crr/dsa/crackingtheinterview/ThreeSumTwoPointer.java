package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSumTwoPointer {
	    public List<List<Integer>> threeSumApproach1(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<>();
	        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
	            if (i == 0 || nums[i - 1] != nums[i]) {
	                twoSum(nums, i, res);
	            }
	        return res;
	    }
	    void twoSum(int[] nums, int i, List<List<Integer>> res) {
	        Set<Integer> seen = new HashSet<Integer>();
	        for (int j = i + 1; j < nums.length; ++j) {
	            int complement = -nums[i] - nums[j];
	            if (seen.contains(complement)) {
	                res.add(Arrays.asList(nums[i], nums[j], complement));
	                while (j + 1 < nums.length && nums[j] == nums[j + 1])
	                    ++j;
	            }
	            seen.add(nums[j]);
	        }
	    }
	    public List<List<Integer>> threeSum(int[] nums) {
	       Set<List<Integer>> res = new HashSet();
	       Set<Integer> dups = new HashSet<Integer>();
	       Map<Integer,Integer> seen = new HashMap();
	       for( int i=0;i< nums.length;i++)
	       {
	        if(dups.add(nums[i])){
	            for(int j=i+1;j< nums.length;++j)
	            {
	                int complement = -nums[i]-nums[j];
	                if(seen.containsKey(complement)&&  seen.get(complement)==i )
	                {
	                    List<Integer> tri = Arrays.asList(nums[i],nums[j],complement);
	                    Collections.sort(tri);
	                    res.add(tri);
	                }
	                seen.put(nums[j],i);
	            }
	        }
	       }
	        return new ArrayList(res);

	    }
	    public static void main(String[] args) {
			int []nums= {-1,0,1,2,-1,-4};
			System.out.println(new ThreeSumTwoPointer().threeSumApproach1(nums));
		}
	 

	
}
