package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferentBinaryString {
	int n;
 static   Set<String> numsSet = new HashSet();
    public String findDifferentBinaryStringApproach1(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }
                
                return ans;
            }
        }
        
        return "";
    }
    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }
            
            return "";
        }
        
        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }
        
        return generate(curr + "1");
    }
    
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }
        
        return generate("");
    }
    public static void main(String[] args) {
		String arr[] = {"000","011","001"};
		List<String> list = new ArrayList();
		
	        for (String s : arr) {
	            list.add(s);
	        }
	        List<Integer> result = new ArrayList<Integer>();
	        result.toArray();
		System.out.println(new FindDifferentBinaryString().findDifferentBinaryString1(list ));
	}
    public static String findDifferentBinaryString1(List<String> nums) {
        Set<String> strSet = new HashSet<>(nums);
        int k = nums.size();
        StringBuilder result = new StringBuilder();

        dfs(nums, result, strSet, k);

        return result.toString();
    }
    private static void dfs(List<String> nums, StringBuilder result, Set<String> strSet, int k) {
       
    }
    
    public String findDifferentBinaryStringApproach4(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
    public String findDifferentBinaryStringAproach3(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }
    public String findDifferentBinaryStringAproach2(String[] nums) {
    	Set<String> set = new HashSet<String>();
    	 for (String s : nums) {
    		 set.add(s);
         }
    	 String nextString = "";
    	 for(String s : nums)
    	 {
    		  nextString =  getNewString(s);
    		  if(!set.contains(nextString))
    		return nextString;
    	 }
    	 return  "";
         
    }
    public String getNewString(String nums) {
        int n=nums.length();
        char[] str=new char[n];
        
        for(int i=0;i<n;i++)
        {
            if(nums.charAt(i)=='1')
            {
                str[i]='0';
            }
            else
            {
                str[i]='1';
            }
        }
        return new String(str);
      }
    
    
    public String backTracking(StringBuilder sb, int n, Set<String> numsSet, char lastCharacter) {
        if (sb.length() == n) {
        	System.out.println(sb.toString());
            if (!numsSet.contains(sb.toString()))
                return sb.toString();
            else
                return "";
        }

        for (int i = 0; i < n; i++) {
            char newChar = (lastCharacter == '0') ? '1' : '0';
            sb.append(newChar);
            String res = backTracking(sb, n, numsSet, newChar);
            if (!res.equals(""))
                return res;
            sb.setLength(sb.length() - 1);
        }
        return "";
    }

    
    
    
}
