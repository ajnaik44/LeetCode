package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Allnodesdistance {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        generateGraph(root, null,  graph);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(target.val);
        
        List<Integer> answer = new ArrayList<Integer>();
        
        findDistanceFromTarget(target.val,  graph, k,0,visited,answer );
        
        return answer;
    }
   public List<Integer>  findDistanceFromTarget(int target, HashMap<Integer,
   ArrayList<Integer>>  graph,int k,int distance,Set<Integer> visited, List<Integer> answer )
   {
    if(distance==k)
    {
        answer.add(target);
    }

    for(int neighours: graph.getOrDefault(target,new ArrayList<Integer>()))
    {

        if(!visited.contains(neighours))
            {
                visited.add(neighours);
                findDistanceFromTarget(neighours,  graph, k,distance+1,visited ,answer);
            }
        
    }


   }

    public void generateGraph(TreeNode current, TreeNode parent, HashMap<Integer,ArrayList<Integer>>  graph)
    {
        if(current!=null&&  parent!=null)
        {
            graph.putIfAbsent(current.val, new ArrayList()).add(parent.val);
             graph.putIfAbsent(parent.val, new ArrayList()).add(current.val);
        }
        if(current.left!=null)
            generateGraph(current.left, current,  graph);
        
        
        if(current.right!=null)
            generateGraph(current.right, current,  graph);

    }
}
