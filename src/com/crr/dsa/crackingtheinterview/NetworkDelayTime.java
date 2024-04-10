package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkDelayTime {
	int result = -1;
	
	public static void main(String[] args) {
		int arr[][]= {{2,1,1},{2,3,1},{3,4,1}};
		System.out.println(new NetworkDelayTime().networkDelayTimeOPt(arr, 4, 2));
	}
	 public int networkDelayTime(int[][] times, int n, int k) 
	    {
	        Map<Integer,Map<Integer,Integer>> map =  new HashMap();
	        Set<Integer> set = new HashSet<Integer>();

	        for(int [] time:times)
	        {
	            if(map.containsKey(time[0]))
	            {
	                map.get(time[0]).put(time[1],time[2]);
	            }
	            else
	            {
	                
	                Map<Integer,Integer> timeMap =  new HashMap();
	                timeMap.put(time[1],time[2]);
	                map.put(time[0] ,  timeMap);
	            }
	        }
	         minimumTime( map ,set,k,  0);
	         return result;
	    }
	    public int minimumTime(Map<Integer,Map<Integer,Integer>> map ,Set<Integer> set, int node, int time)
	    {
	        if(map.get(node)==null )
	        	set.add(node);
	        if(set.contains(node))
	        {
	        	return time;
	        }
	        System.out.println(set);    
	        set.add(node);

	         for(int nextNode :   map.get(node).keySet())
            {

                time+= map.get(node).get(nextNode);
                int res =  minimumTime(map ,set,nextNode,time);
               
                if(  res==time)
                {
                    result =  Math.max(time,result);
                    time=0;
                }
            }
	       
	        return time;

	    }
	    
	    
	    
	        // Adjacency list
	        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

	        private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
	            // If the current time is greater than or equal to the fastest signal received
	            // Then no need to iterate over adjacent nodes
	            if (currTime >= signalReceivedAt[currNode]) {
	                return;
	            }

	            // Fastest signal time for currNode so far
	            signalReceivedAt[currNode] = currTime;
	            
	            if (!adj.containsKey(currNode)) {
	                return;
	            }
	            
	            // Broadcast the signal to adjacent nodes
	            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
	                int travelTime = edge.first;
	                int neighborNode = edge.second;
	                
	                // currTime + time : time when signal reaches neighborNode
	                DFS(signalReceivedAt, neighborNode, currTime + travelTime);
	            }
	        }
	        
	        public int networkDelayTimeOPt(int[][] times, int n, int k) {
	            // Build the adjacency list
	            for (int[] time : times) {
	                int source = time[0];
	                int dest = time[1];
	                int travelTime = time[2];
	                
	                adj.putIfAbsent(source, new ArrayList<>());
	                adj.get(source).add(new Pair(travelTime, dest));
	            }
	            
	            // Sort the edges connecting to every node
	            for (int node : adj.keySet()) {
	                Collections.sort(adj.get(node), (a, b) -> a.first - b.second);
	            }
	            
	            int[] signalReceivedAt = new int[n + 1];
	            Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
	            
	            DFS(signalReceivedAt, k, 0);
	            
	            int answer = Integer.MIN_VALUE;
	            for (int node = 1; node <= n; node++) {
	                answer = Math.max(answer, signalReceivedAt[node]);
	            }
	            
	            // Integer.MAX_VALUE signifies atleat one node is unreachable
	            return answer == Integer.MAX_VALUE ? -1 : answer;
	        }
	    
}
