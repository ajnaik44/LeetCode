package com.crr.dsa.stack;

public class Palindrome {

	public static boolean isPalindrome(String inputStr) {
		char charray[] = inputStr.toCharArray();
		int i = 0, j = charray.length-1 ;
		while(charray[i] == charray[j]&& j>=i)
		{
			i++;
			j--;
		}
		System.out.println(i + "    "+j);
		if (i < j)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aba"));
	}
}
