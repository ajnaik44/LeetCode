package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ReverseWords {
	public static String reverseWords(String s) {
		s = s.trim();
		StringTokenizer st = new StringTokenizer(s, " ");
		List<String> res = new ArrayList<>();
		while (st.hasMoreTokens()) {

			String temp = st.nextElement().toString() + " ";
			res.add(temp);

		}
		StringBuilder result = new StringBuilder();
		System.out.println(res.size());
		for (int i = res.size() - 1; i >= 0; i--) {
			result.append(res.get(i).toString());
		}
		return result.toString().trim();
	}

	public static int[] productExceptSelf(int[] nums) {

		int ans[] = new int[nums.length];
		Integer answer = null;
		for (int k = 0; k < nums.length; k++) {
			for (int i = 0; i < nums.length; i++) {
				if (i == k)
					continue;
				else {
					if (answer == null)
						answer = nums[i];
					else
						answer = answer * nums[i];
				}

			}
			ans[k] = answer;

			System.out.println(answer);
			answer = null;
		}
		return ans;
	}

	public static int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n];

		int[] leftProducts = new int[n];
		int[] rightProducts = new int[n];

		// Calculate the product of all elements to the left of each element
		leftProducts[0] = 1;
		for (int i = 1; i < n; i++) {
			leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
		}

		// Calculate the product of all elements to the right of each element
		rightProducts[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
		}

		// Multiply the corresponding left and right products to get the answer
		for (int i = 0; i < n; i++) {
			answer[i] = leftProducts[i] * rightProducts[i];
		}

		return answer;
	}

	public static boolean increasingTriplet(int[] nums) {
		int first_num = Integer.MAX_VALUE;
		int second_num = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= first_num) {
				first_num = n;
			} else if (n <= second_num) {
				second_num = n;
			} else {
				return true;
			}
		}
		return false;
	}
	
	
	

		 

		   private Map<String, Integer> map;

		 

		   public  ReverseWords() {
				      map = new HashMap<>();

		      map.put("foo", 1);

		      map.put("bar", 3);

		   }

		 

		   public int getValue(String input, int numRetries) throws Exception {

		      try {

		         return map.get(input);

		      }

		      catch (Exception e) {

		         if (numRetries > 3) {

		            throw e;

		         }

		         return getValue(input, numRetries + 1);

		      }

		   }

		

	public static int compress(char[] chars) {
		int counter = 0;
		char temp = chars[0];
		StringBuilder res = new StringBuilder();
		for (int i = 1; i < chars.length; i++) {
			if (temp == chars[i]) {
				counter++;
			} else {

				res.append(temp + "" +(counter==0?"": (counter + 1)));
				counter = 0;
				
				temp = chars[i];
				
			}
		}
		res.append(temp + "" +(counter==0?"": (counter + 1)));
		counter = 0;
		System.out.println(res);
		
		for(int i=0;i<res.toString().length();i++)
		{
			chars[i]= res.charAt(i);
		}
		return res.length();
	}
	
	
	public static int compress_T1(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

	public static void main(String[] args) throws Exception {
		
		
		ReverseWords  reverseWords = new ReverseWords();
		reverseWords.getValue("baz", 0);
	
		
	/*	char ch[] = { 'a','a','b','b','b'};
		 System.out.println(reverseWords("a    example"));
		// System.out.println(productExceptSelf1(a));
		// System.out.println(increasingTriplet(a));
		System.out.println(compress_T1(ch));
		String str = "practice makes perfect";
		char[] charArray = str.toCharArray();
		reverseCharArray(charArray);
		
		
		int a[] = { 5,3,4,2 };
		
		int b[] = { 4,2,2,5 };
		minProductSum(a,b); */ 
	}
	public static void reverseCharArray(char[] charArray)
	{
		reverseCharArrayHelper(charArray , 0,charArray.length-1);
		int start = 0;
		int left=0;
		for(;left< charArray.length-1;left++)
		{
			if(charArray[left]==' ')
			{
				reverseCharArrayHelper(charArray , start,  left-1);
				start = left+1;
			}
		}
		reverseCharArrayHelper(charArray , start,  left);
		System.out.println(new String(charArray));
	}
	public static void reverseCharArrayHelper(char[] charArray , int start, int end)
	{
		for(int left=start,right=end;left<right;left++,right--)
		{
			char temp =  charArray[left];
			charArray[left] = charArray[right];
			charArray[right] =  temp;
		}
	}
	
	 public static int minProductSum(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int sum=0;
	        int j=nums2.length-1;
	        for(int i=0;i<nums1.length;i++){
	            sum+=nums1[i]*nums2[j];
	            j--;
	        }
	          return sum;   
	    }
	
}
