package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPurmutation {
	 public static List<List<Integer>> generatePermutations(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        generate(nums, 0, result);
	        return result;
	    }

	    private static void generate(int[] nums, int index, List<List<Integer>> result) {
	        if (index == nums.length) {
	            List<Integer> permutation = new ArrayList<>();
	            for (int num : nums) {
	                permutation.add(num);
	            }
	            result.add(permutation);
	            return;
	        }

	        for (int i = index; i < nums.length; i++) {
	            swap(nums, index, i);
	            generate(nums, index + 1, result);
	            swap(nums, index, i); // Backtrack to restore the original array
	        }
	    }

	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    
	    
	    
	    public static List<ArrayList<Integer> > 
	     generatePurmutationAjay( int index,int [] nums)
	    {
	        List<ArrayList<Integer>>  result =  null;
	        if(index==nums.length)
	        {
	            List<ArrayList<Integer>> emptyList = new ArrayList<ArrayList<Integer>>();
	            emptyList.add(new ArrayList<Integer>());
	            return emptyList;
	        }else{
	            result =generatePurmutationAjay(index+1,nums);

	             List<ArrayList<Integer>>  temp = new ArrayList<>();
	            
	             for(ArrayList<Integer> list :  result){
	            	 ArrayList<Integer> l1 = new ArrayList<>(list);
	            	 l1.add(nums[index]);
	            	 temp.add(l1);
	             }
	             result.addAll(temp);

	        }
	        return result;
	    }
	    public static void main(String[] args) {
	        int[] nums = {1, 2, 3};
	        List<ArrayList<Integer>> permutations = generatePurmutationAjay(0,nums);
	        System.out.println(permutations);
	       /* int index = -1;
	        for (int i = 0; i < permutations.size(); i++) {
	            List<Integer> currentPermutation = permutations.get(i);
	            if (Arrays.equals(nums, currentPermutation.stream().mapToInt(Integer::intValue).toArray())) {
	                index = i;
	                break;
	            }
	        }
	        System.out.println(index);
	        if(index >= permutations.size()-1)
	        	 nums = permutations.get(0).stream().mapToInt(Integer::intValue).toArray();
	        else 
	        	 nums = permutations.get(index+1).stream().mapToInt(Integer::intValue).toArray();
	        
	        
	        for(int i:nums)
	        {
	        	System.out.println(i);
	        }
	        
	        for (List<Integer> permutation : permutations) {
	            System.out.println(permutation);
	        }*/
	    }
}
