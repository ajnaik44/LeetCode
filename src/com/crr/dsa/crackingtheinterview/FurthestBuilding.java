package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuilding {
public static void main(String[] args) {
	int[] heights = {2, 7, 9, 3, 1, 2, 5, 9, 4, 6};
	System.out.println(furthestBuildingApproach2(heights, 8, 2));
}

    
    public static int furthestBuildingApproach2(int[] heights, int bricks, int ladders) {
        // Do a binary search on the heights array to find the final reachable building.
        int lo = 0;
        int hi = heights.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (isReachable(mid, heights, bricks, ladders)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return hi; // Note that return lo would be equivalent.
    }
    
    private static boolean isReachable(int buildingIndex, int[] heights, int bricks, int ladders) {
        // Make a list of all the climbs we need to do to reach buildingIndex.
        List<Integer> climbs = new ArrayList<>();
        for (int i = 0; i < buildingIndex; i++) {
            int h1 = heights[i];
            int h2 = heights[i + 1];
            if (h2 <= h1) {
                continue;
            }
            climbs.add(h2 - h1);
        }
        Collections.sort(climbs);
        
        // And now determine whether or not all of these climbs can be covered with the
        // given bricks and ladders.
        for (int climb : climbs) {
            // If there are bricks left, use those.
            if (climb <= bricks) {
                bricks -= climb;
            // Otherwise, you'll have to use a ladder.
            } else if (ladders >= 1) {
                ladders -= 1;
            // And if there are no ladders either, we can't reach buildingIndex.
            } else {
                return false;
            }
        }
        return true;
    }

	    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
	        // Create a priority queue with a comparator that makes it behave as a min-heap.
	        Queue<Integer> ladderAllocations = new PriorityQueue<>((a, b) -> a - b);
	        for (int i = 0; i < heights.length - 1; i++) {
	            int climb = heights[i + 1] - heights[i];
	            // If this is actually a "jump down", skip it.
	            if (climb <= 0) {
	                continue;
	            }
	            // Otherwise, allocate a ladder for this climb.
	            ladderAllocations.add(climb);
	            // If we haven't gone over the number of ladders, nothing else to do.
	            if (ladderAllocations.size() <= ladders) {
	                continue;
	            }
	            // Otherwise, we will need to take a climb out of ladder_allocations
	            bricks -= ladderAllocations.remove();
	            // If this caused bricks to go negative, we can't get to i + 1
	            if (bricks < 0) {
	                return i;
	            }
	        }
	        // If we got to here, this means we had enough materials to cover every climb.
	        return heights.length - 1;
	    }
	
}
