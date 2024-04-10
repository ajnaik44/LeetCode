package com.crr.dsa.crackingtheinterview;

import java.util.*;

public class RouteBetweenNodes {
	
	public static boolean isRoute(Map<Integer,List<Integer>> graph,int source,int destination)
	{
		if(source==destination)
			return true;
		boolean [] visted = new boolean[graph.size()];
		Queue<Integer> nextNode = new LinkedList<>();
		nextNode.add(source);
		while(!nextNode.isEmpty())
		{
			int key  = nextNode.poll();
			if(!visted[key])
			{
				visted[key]=true;
				System.out.println(key);
				List<Integer> tempList  = graph.get(key)!=null ? graph.get(key): new LinkedList<Integer>();
				for(int node : tempList)
				{
					if(!visted[node])
					{
						if(node== destination)
						{
							return true;
							
						}
						if (!visted[node]) {
	                        nextNode.add(node);
	                    }
					}
					
					
				}
			}
			
		}
		return false;
		
	}
	 public static void main(String[] args) {
	        // Example graph creation
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        graph.put(0, Arrays.asList(1, 2));
	        graph.put(1, Arrays.asList(2, 3));
	        graph.put(2, Arrays.asList(3));
	        graph.put(3, Arrays.asList(4));
	        graph.put(4, Arrays.asList(1)); // Creating a cycle for testing purposes

	        int source = 0;
	        int destination = 4;

	        boolean routeExists = isRoute(graph, source, destination);
	        System.out.println("Route exists from " + source + " to " + destination + ": " + routeExists);
	    }

}
