package com.crr.dsa.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		
		boolean flag=true;
		for(int i=0;i<a.length-1 && flag;i++)
		{
			flag=false;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp =  a[i];
					a[i]=a[j];
					a[j] = temp;
					flag=true;
				}
			}
			
		}
		for(int i=0;i<a.length;i++)
		{
		System.out.print(a[i]+ " , ");
		}
	}
	
	
	
}
