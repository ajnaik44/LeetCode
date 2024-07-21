package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;

public class LengthOfLIS {
	
	 public int bs(ArrayList<Integer> list, int num)
    {
      int left=0;
      int right =list.size()-1;
      
      while(left<right)
      {
    	  int mid = left+(right-left)/2;
    	  if(list.get(mid)==num)
    		  return mid;
    	  if(num > list.get(mid))
    	  {
    		  left =  mid+1;
    	  }
    	  else {
    		  right =  mid-1;
    	  }
    	 
      }
      return left;
    }
	
	public int lengthOfLISApproach1(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = bs(sub,num);

				sub.set(j, num);
			}
		}

		return sub.size();
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int longest = 0;
		for (int c : dp) {
			longest = Math.max(longest, c);
		}

		return longest;
	}

	public static void main(String[] args) {
		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		LengthOfLIS lengthOfLIS = new LengthOfLIS();
		System.out.println(lengthOfLIS.lengthOfLISApproach1(nums));
	}
}
