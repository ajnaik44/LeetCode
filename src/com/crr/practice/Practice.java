package com.crr.practice;

import java.util.ArrayList;
//A Java program for mven an integer erging overlapping intervals
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Practice {

	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	
	     
	    // Function that takes a set of intervals, merges
	    // overlapping intervals and prints the result
	    public static void mergeIntervals(Interval arr[])
	    {
	        // Sort Intervals in increasing order of
	        // start time
	        Arrays.sort(arr,new Comparator<Interval>(){
	            public int compare(Interval i1,Interval i2)
	            {
	                return i1.start - i2.start;
	            }
	        });
	   
	        int index = 0; // Stores index of last element
	        // in output array (modified arr[])
	   
	        // Traverse all input Intervals
	        for (int i=1; i<arr.length; i++)
	        {
	            // If this is not first Interval and overlaps
	            // with the previous one
	            if (arr[index].end >=  arr[i].start)
	            {
	                   // Merge previous and current Intervals
	                arr[index].end = Math.max(arr[index].end, arr[i].end);
	            }
	            else {
	                index++;
	                arr[index] = arr[i];
	            }   
	        }
	         
	        // Now arr[0..index-1] stores the merged Intervals
	        System.out.print("The Merged Intervals are: ");
	        for (int i = 0; i <= index; i++)
	        {
	            System.out.print("[" + arr[i].start + ","
	                                        + arr[i].end + "]");
	        }
	    }

	

	public static void main(String args[]) {
		Interval arr[]=new Interval[2];
		arr[0]=new Interval(1,3);
		arr[1]=new Interval(6,9);
		
		mergeIntervals(arr);
	}
}

class Interval
{
	int start,end;
	Interval(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
}


