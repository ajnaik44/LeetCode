package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MincostTickets {
	public static void main(String[] args) {
		int days[] = {1,4,6,7,8,20};
		int[] costs= {2,7,15};
	System.out.println(new MincostTickets().mincostTicketsdfs(days, costs));
	}
	HashSet<Integer> isTravelNeeded = new HashSet<>();

	private int solve(int[] dp, int[] days, int[] costs, int currDay) {
		// If we have iterated over travel days, return 0.
		if (currDay > days[days.length - 1]) {
			return 0;
		}

		// If we don't need to travel on this day, move on to next day.
		if (!isTravelNeeded.contains(currDay)) {
			return solve(dp, days, costs, currDay + 1);
		}

		// If already calculated, return from here with the stored answer.
		if (dp[currDay] != -1) {
			return dp[currDay];
		}

		int oneDay = costs[0] + solve(dp, days, costs, currDay + 1);
		int sevenDay = costs[1] + solve(dp, days, costs, currDay + 7);
		int thirtyDay = costs[2] + solve(dp, days, costs, currDay + 30);

		// Store the cost with the minimum of the three options.
		return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
	}
	
	public int mincostTicketsdfs(int[] days, int[] costs) {
		 // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
	}

	public int mincostTickets(int[] days, int[] costs) {
		// The last day on which we need to travel.
		int lastDay = days[days.length - 1];
		int dp[] = new int[lastDay + 1];
		Arrays.fill(dp, -1);

		// Mark the days on which we need to travel.
		for (int day : days) {
			isTravelNeeded.add(day);
		}

		return solve(dp, days, costs, 1);
	}
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList();
      Map<Integer,TreeMap<String,String>> map = new HashMap();

      for(String s: strings)
      {
        int length = s.length();
        if(map.containsKey(s))
        {
            map.get(length).put(s,s);
        }
        else{
            TreeMap<String,String> treemap = new TreeMap();
            treemap.put(s,s);
            map.put(length,treemap);
        }
      }
        for(Map.Entry<Integer,TreeMap<String,String>> iterator1:  map.entrySet())
        {
        	List<String> list =  new ArrayList<String>();
        	
        	 for(Map.Entry<String,String> iterator2:  iterator1.getValue().entrySet() )
             {
        		 list.add(iterator2.getKey());
        		 
             }
        	 result.add(list);
            
           
        }

       return result; 
    }
}
