package com.crr.practice;

public class InsertionSort {
	public static void main(String[] args) {
		char[] ch = { 'b', 'c', 'd', 'a', 'e', 'h', 'g', 'f' };
		for (int i = 1; i < ch.length; i++) {
			char temp =  ch[i];
			int j=i;
			for (;j>0&& ch[j-1]>temp;)
			{
				ch[j]=  ch[j-1];
				j--;
			}
			ch[j]=temp;
		}
		System.out.println(ch);
	}
}
