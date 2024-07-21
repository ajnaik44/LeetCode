package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;

import com.crr.dsa.stack.checkingbalancingofsymbols;

public class CombinationSum {

	ArrayList<ArrayList<Integer>>  answer = new ArrayList();
	
	public void dfs(int nums[],int index,int total, ArrayList<Integer> list)
	{
		if(total==0)
		{
			answer.add(new ArrayList(list));
			return ;
		}
		if(index>=nums.length ||  total<0)
			return;
		
		for(int i=0;i<nums.length;i++)
		{
			list.add(nums[i]);
			dfs(nums,i,total-nums[i],list);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3};
		CombinationSum d = new CombinationSum();
		d.dfs(nums, 0, 4, new ArrayList<Integer>());
		System.out.println(d.answer.size());
	}
}
