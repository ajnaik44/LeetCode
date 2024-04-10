package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;

public class MissingElementinSortedArray {

	
public static void main(String[] args) {
	int nums[]= {4,7,9,10};
	System.out.println(new MissingElementinSortedArray().missingElementBS(nums, 5));
}
	    public int missingElement(int[] nums, int k) {
	        int start=0,end=nums.length-1;
	        while(start < end)
	        {

	            int mid =  start+(end-start)/2;
	            if(nums[mid] -nums[start]  + (mid-start) >= k   )
	            {
	                System.out.println("IF");
	                mid =  end;
	                ArrayList<Integer> list =  new ArrayList<Integer>();
	                int addition = 1;
	               
	                int startelement =  nums[start];
	                start++;
	                int i=0;
	                while(i<k)
	                {
	                	if(startelement+addition !=  nums[start])
	                	{
	                		i++;
	                		list.add(startelement+addition);
	                	}else {
	                		start++;
	                		addition++;
	                	}
	                }
	                return list.get(k-1);
	            }
	            else {
	                start =  mid;

	                ArrayList<Integer> list =  new ArrayList<Integer>();
	                int addition = 1;
	               
	                int startelement =  nums[start];
	                start++;
	                int i=0;
	                while(i<k)
	                {
	                	if(start!=end  && startelement+addition !=  nums[start])
	                	{
	                		i++;
	                		list.add(startelement+addition);
	                		addition++;
	                	}
	                	else if(start==end )
	                	{
	                		i++;
	                		list.add(startelement+addition);
	                		addition++;
	                		
	                	}
	                	else {
	                		start++;
	                		addition++;
	                	}
	                }
	                return list.get(k-1);
	                
	            }
	   

	        }
	         return 0;
	    }
	    
	    
	        public int missingElementOptimize(int[] nums, int k) {
	            int n = nums.length;
	            
	            for (int i = 1; i < n; ++i) {
	                int missedInGap = nums[i] - nums[i - 1] - 1;
	                if (missedInGap >= k) {
	                    return nums[i - 1] + k;
	                }
	                k -= missedInGap;
	            }
	            
	            return nums[n - 1] + k;
	        }

	            public int missingElementBS(int[] nums, int k) {
	                int n = nums.length;
	                int left = 0, right = n - 1;
	                
	                while (left < right) {
	                    int mid = right - (right - left) / 2;
	                    if (nums[mid] - nums[0] - mid < k) {
	                        left = mid;
	                    } else{
	                        right = mid - 1;
	                    }
	                }
	                
	                return nums[0] + k + left;
	            }
	        
}
