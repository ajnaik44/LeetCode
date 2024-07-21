package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
public static void main(String[] args) {
	int nums[][]= {{0,30},{5,10},{15,20}};
	System.out.println(new MinMeetingRooms().minMeetingRooms(nums));
	
	int [] g = new int[] {1,2,3};
	int [] s = new int[] {1};
	System.out.println(findContentChildren(g, s));
	System.out.println(3%7);
	
}
public static int  findContentChildren(int[] g, int[]s ) {
	  Arrays.sort(g);
      Arrays.sort(s);
      int contentChildren = 0;
      int cookieIndex = 0;
      while (cookieIndex < s.length && contentChildren < g.length) {
          if (s[cookieIndex] >= g[contentChildren]) {
              contentChildren++;
          }
          cookieIndex++;
      }
      return contentChildren;

  }
public int minMeetingRoomsApproach2(int[][] intervals) {
    int n = intervals.length;
    int[] begins = new int[n];
    int[] ends = new int[n];
    for(int i = 0 ; i < n; i++) {
        begins[i] = intervals[i][0];
        ends[i] = intervals[i][1];
    }
    Arrays.sort(begins);
    Arrays.sort(ends);
    //index of sorted begins and end array
    int i = 0, j = 0;
    int res = 0, cur = 0;
    while(i < n) {
        if(begins[i] < ends[j]) {
            //start of a meeting, move the next meeting's start point.
            cur++;
            i++;
        } else {
            //end of a meeting, release a meeting room.
            //begins[i] >= ends[j], [1,2][2,3] only need one meeting room.
            cur--;
            j++;
        }
        res = Math.max(res, cur);
    }
    return res;
}


	    public int minMeetingRooms(int[][] intervals) {
	        
	    // Check for the base case. If there are no intervals, return 0
	    if (intervals.length == 0) {
	      return 0;
	    }

	    // Min heap
	    PriorityQueue<Integer> allocator =
	        new PriorityQueue<Integer>(
	            intervals.length,
	            new Comparator<Integer>() {
	              public int compare(Integer a, Integer b) {
	                return a - b;
	              }
	            });

	    // Sort the intervals by start time
	    Arrays.sort(
	        intervals,
	        new Comparator<int[]>() {
	          public int compare(final int[] a, final int[] b) {
	            return a[0] - b[0];
	          }
	        });

	    // Add the first meeting
	    allocator.add(intervals[0][1]);

	    // Iterate over remaining intervals
	    for (int i = 1; i < intervals.length; i++) {

	      // If the room due to free up the earliest is free, assign that room to this meeting.
	      if (intervals[i][0] >= allocator.peek()) {
	        allocator.poll();
	      }

	      // If a new room is to be assigned, then also we add to the heap,
	      // If an old room is allocated, then also we have to add to the heap with updated end time.
	      allocator.add(intervals[i][1]);
	    }

	    // The size of the heap tells us the minimum rooms required for all the meetings.
	    return allocator.size();
	  }
	
}
