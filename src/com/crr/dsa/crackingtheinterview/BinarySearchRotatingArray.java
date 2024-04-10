package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinarySearchRotatingArray {
	
	public static void main(String[] args) {
		int[] nums= {2,5,6,0,0,1,2};
		System.out.println(search(nums,2));
		List<List<Integer>>  res = new ArrayList();
		List<Integer> templist = new ArrayList<Integer>();
		templist.add(1);
		res.add(templist);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		
		int[][] prerequisites= {{1,4},{2,4},{3,1},{3,2}};
		System.out.println(new BinarySearchRotatingArray().canFinishOptimize(5, prerequisites));
		
		
	}

	    public boolean canFinishOptimize(int numCourses, int[][] prerequisites) {
	        int[] indegree = new int[numCourses];
	        List<List<Integer>> adj = new ArrayList<>(numCourses);

	        for (int i = 0; i < numCourses; i++) {
	            adj.add(new ArrayList<>());
	        }

	        for (int[] prerequisite : prerequisites) {
	            adj.get(prerequisite[1]).add(prerequisite[0]);
	            indegree[prerequisite[0]]++;
	        }

	        Queue<Integer> queue = new LinkedList<>();
	        // Push all the nodes with indegree zero in the queue.
	        for (int i = 0; i < numCourses; i++) {
	            if (indegree[i] == 0) {
	                queue.offer(i);
	            }
	        }

	        int nodesVisited = 0;
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            nodesVisited++;

	            for (int neighbor : adj.get(node)) {
	                // Delete the edge "node -> neighbor".
	                indegree[neighbor]--;
	                if (indegree[neighbor] == 0) {
	                    queue.offer(neighbor);
	                }
	            }
	        }

	        return nodesVisited == numCourses;
	    }
	
	public static boolean search(int[] nums, int target) {
        int s=0, e=nums.length-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(nums[mid]==target){
                return true;
            }

             if (nums[s] == nums[mid]) {
                s++;
                continue;
            }

            if(nums[s]<nums[mid]){
                if(nums[s]<= target && target<nums[mid]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else{
                if(nums[mid]<target && target<= nums[e]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
     return false;
    }
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> result = new ArrayList();
        for(int i=0;i<numCourses;i++)
        {
            ArrayList<Integer> temp =  new ArrayList<Integer>();
            result.add(temp);
        }

        for(int [] temp :prerequisites  )
        {
             result.get(temp[0]).add(temp[1]);   
        }

        boolean visited[] = new boolean[numCourses];
        Set<Integer> completed = new HashSet<Integer>();

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                finishCourse(result,visited,completed, i);
            }
        }
        if(completed.size()==numCourses)
            return true;
        else 
            return false;

    }
    public void finishCourse(List<ArrayList<Integer>> res,boolean visited[],Set<Integer> completed,int course)
    {
        ArrayList<Integer> preCourses = res.get(course);
        if(preCourses.isEmpty()){
            completed.add(course);
            return;
        }
        for(Integer preCourse :  preCourses)
        {
            if(!visited[preCourse])
            {
                visited[preCourse] = true;
                finishCourse( res,visited, completed, preCourse);
              

            }
            System.out.println(completed);
            System.out.println(preCourses);
            System.out.println(completed.containsAll(preCourses));
            if(completed.containsAll(preCourses))
                completed.add(course);
        }
    }
}
