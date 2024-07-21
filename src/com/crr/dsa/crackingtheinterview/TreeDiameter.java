package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class TreeDiameter {
	static class Result{
	    int count=0;
	}
	public static void main(String[] args) {
		TreeDiameter diameter = new TreeDiameter();
		 int[][] array_2d = {
		            {0, 1},
		            {1, 2},
		            {2, 3},
		            {1, 4},
		            {4, 5}
		        };
		 
		 
		 
		 
		 System.out.println(diameter.treeDiameter(array_2d));
	}
	    public int treeDiameter(int[][] edges) {
	        Map<Integer,List<Integer>>  graph = new HashMap<>();
	        build(edges ,  graph);
	        int distance = 0;
	        for(int node :  graph.keySet())
	        {
	            
	            int newD = dfs(graph,node,null , new HashSet<Integer>());
	            distance =  Math.max(distance,newD);
	        }
	        return distance;

	    }
	    private int dfs(Map<Integer,List<Integer>>  graph,int node ,Result result , Set<Integer> visited)
	    {
	        if(visited.contains(node)) return 0;
	        Queue<Integer> queue = new LinkedList<Integer>();
	        visited.add(node);
	        queue.add(node);
	        int distance = 0;
	         
	        while(!queue.isEmpty())
	        {
	            int size = queue.size();
	            distance++;
	            while(size-- > 0){
	                
	                int nextNode =  queue.poll();
	                for(int edge :  graph.getOrDefault(nextNode,new ArrayList<>())){
	            
	                    if(!visited.contains(edge))
	                    {  
	                         visited.add(edge);
	                         queue.add(edge);
	                        
	                    }
	                }
	            }
	           
	        }
	        return distance;
	    }
	    private void build(int[][] edges , Map<Integer,List<Integer>>  graph)
	    {
	        for(int []edge :  edges)
	        {
	            graph.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
	             graph.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
	        }
	    }
	
}
