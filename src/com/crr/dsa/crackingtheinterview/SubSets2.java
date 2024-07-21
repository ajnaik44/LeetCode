package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets2 {
	public static void main(String[] args) {
		int[]nums= {1,1,2};
		System.out.println(new SubSets2().subsetsWithDupApproach2(nums));
		System.out.println(letterCasePermutationAjay("ab"));
	}
	public static List<String> letterCasePermutationAjay(String s) {

	     List<StringBuilder> list = new ArrayList<StringBuilder>();
	     list.add(new StringBuilder());

	     for(char c: s.toCharArray())
	     {
	        int size =  list.size();
	        if(Character.isLetter(c))
	        {
	            
	            
	            for(int i=0;i<size;i++)
	            {
	                list.add(new StringBuilder(list.get(i)));
	                list.get(i).append(Character.toLowerCase(c));
	                list.get(i+size).append(Character.toUpperCase(c));
	                
	            }
	        }else{
	            for(int i=0;i<size;i++)
	            {
	                list.get(i).append(c);
	            }
	           
	        }
	        
	       
	     }
	      List<String> result = new ArrayList<String>();
	         for(StringBuilder sb :  list)
	         {
	            result.add(sb.toString());
	         }
	  return result;
	    }
	 public static List<String> letterCasePermutation(String S) {
	        List<StringBuilder> ans = new ArrayList();
	        
	        ans.add(new StringBuilder());

	        for (char c: S.toCharArray()) {
	            int n = ans.size();
	            if (Character.isLetter(c)) {
	                
	            	for (int i = 0; i < n; ++i) {
	                    ans.add(new StringBuilder(ans.get(i)));
	                    ans.get(i).append(Character.toLowerCase(c));
	                    ans.get(n+i).append(Character.toUpperCase(c));
	                }
	            } else {
	                for (int i = 0; i < n; ++i)
	                    ans.get(i).append(c);
	            }
	        }

	        List<String> finalans = new ArrayList();
	        for (StringBuilder sb: ans)
	            finalans.add(sb.toString());
	        return finalans;
	    }
    public List<List<Integer>> subsetsWithDupApproach2(int[] nums) {
        Arrays.sort(nums);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		List<List<Integer>> subsets = new ArrayList();
        subsets.add(new ArrayList<Integer>());
        int startingIndex=0;
        int total =0;
        for(int i=0;i<nums.length;i++)
        {
        	 startingIndex = (i>=1 &&  nums[i-1]==nums[i] ? total : 0 );
        	  total = subsets.size();
        	 for(int j=startingIndex;j<total;j++)
        	 {
        		 List<Integer> list = new ArrayList<Integer>(subsets.get(j));
        		 list.add(nums[i]);
        		 subsets.add(list);
        	 }
        	
        }
        
        return subsets;
    }
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        return new ArrayList(subsetsWithDup(nums,0));
      
    }
    public Set<List<Integer>> subsetsWithDup(int[] nums,int index) {
        Set<List<Integer>>   result = new HashSet();
        if(nums.length==index)
        {
         
          result.add(new ArrayList());
          return result;  
        }
        else{
            Set<List<Integer>>  moreElements =  subsetsWithDup( nums, index+1);
          
            for(List list :  moreElements)
            {
                List newList = new ArrayList(list);
               newList.add(nums[index]);
               result.add(newList);
            }

            result.addAll(moreElements);
        }
        return result;
    }
}
