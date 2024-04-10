package com.crr.dsa.sort;

public class Problem1 {
public static void main(String[] args) {
	 int[] A = {4, 8, 3,1};
	 System.out.println(problem1(A));
}


public static boolean problem1(int a[] )
{
	for(int i=0;i<a.length-1;i++)
	{
		for(int j=i+1;j<a.length;j++)
		{
			if(a[i]==a[j])
				return true;
		}
	}
	return false;
}

}
