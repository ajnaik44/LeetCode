package com.crr.dsa.crackingtheinterview;

public class RecursiveMultiply {

	static int minProduct(int a,int b)
	{
		int bigger =a>b ?  a:b;
		int smaller =  a>b ? b:a;
		
		return minProductHelper(smaller, bigger);
	}
	static int minProductHelper(int smaller,int bigger)
	{
		if(smaller==0) {
			return 0;
		}
		else if(smaller==1)
			return bigger;
		int s =  smaller>>1;
		int side1 = minProduct(s, bigger);
		
		if(smaller %2==0)
			return side1+side1;
		else
			return side1+side1+bigger;
	}
	public static void main(String[] args) {
		System.out.println(minProduct(7,8));
	}
}
