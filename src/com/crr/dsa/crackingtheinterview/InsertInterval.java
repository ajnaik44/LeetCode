package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Add intervals that come before the newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals with the newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Add intervals that come after the newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] result = insert(intervals, newInterval);

        // Print the result
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
    
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]>  result = new ArrayList<int[]>();

        for(int i=0;i<intervals.length-1;)
        {
            if(intervals[i][1] <  intervals[i+1][0])
            {
            	int[] temp  = { Math.max( intervals[i][0],intervals[i+1][0] ) , Math.max( intervals[i][1],intervals[i+1][1] )} ;
            	result.add(temp );
                i++;
            }else{
                int[] temp =  {intervals[i][0],intervals[i+1][1]};
                int j=i+1;
                while(j<intervals.length)
                {
                    if(intervals[j][1] <  intervals[j+1][0])
                    {
                        temp[1] =  intervals[j+1][1];
                        j++;
                    }
                } 
                result.add(temp);
                i=j;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
