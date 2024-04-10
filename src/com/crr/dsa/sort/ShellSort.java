package com.crr.dsa.sort;

public class ShellSort {

	
	public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        shellSort(arr);
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void shellSort(int[] arr) {
        int n=arr.length;
        for(int gap=n/2;gap>0;gap=gap/2)
        {
        	for(int i=gap;i<n;i++)
        	{
        		int temp = arr[i];
        		int j;
        		for(j=i;j>=gap &&  arr[j-gap]>temp;j =  j-gap)
        		{
        			arr[j] =  arr[j-gap];
        		}
        		
        		arr[j]=temp;
        	}
        }
        
    }
}
