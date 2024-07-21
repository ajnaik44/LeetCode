package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Visited {
	public String username;
	public int timestamp;
	public String website;

	public Visited(String username, int timestamp, String website) {
		this.username = username;
		this.timestamp = timestamp;
		this.website = website;
	}

}

public class MostVisitedPattern {
	public static void main(String[] args) {
		String[] username = { "ua","ua","ua","ub","ub","ub" };
		int[] timestamp = new int[] { 1,2,3,4,5,6 };
		String[] website = { "a","b","a","a","b","c"};
		MostVisitedPattern mostVisitedPattern = new MostVisitedPattern();
		System.out.println(mostVisitedPattern.mostVisitedPattern(username, timestamp, website));
	}

	Map<String, Integer> answer = new TreeMap<String, Integer>();
	String answerPattern = "";
	int max = 0;

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		int n = username.length;
		int start = 0;
		int end = 1;
		List<String> list = new ArrayList<String>();
		List<Visited>  visitedList =  new ArrayList<Visited>();
        for(int i=0;i<n;i++)
        {
           visitedList.add(new Visited(username[i],timestamp[i],website[i])); 
        }
        
        Collections.sort(visitedList , (a,b) ->  a.timestamp -  b.timestamp);
        while(end < n){
            
            if(end >0 && !visitedList.get(end-1).username.equals(visitedList.get(end).username))
            {
                
                backtracking(visitedList, start,  end-1,list);
                start =  end;     
            }
            end++;
        }
        backtracking(visitedList, start,n-1 ,list);
	      for(Map.Entry<String, Integer>  map :  answer.entrySet()) {
	    	  List<String> temp =  new ArrayList<>();
	    	  if(map.getValue()==max)
	    	  {
	    		  for(String t1 :  map.getKey().split(","))
	    		  {
	    			  temp.add(t1);
	    		  }
	    	  } 
            if(!temp.isEmpty())
	    	 return temp;
	      }
	      return  list;
        
	}

	public void backtracking(List<Visited>  visitedList , int start, int end,
			List<String> list) {

		if (start > end + 1)
			return;
		if (list.size() == 3) {

			String pattern = populate(list);
			answer.put(pattern, answer.getOrDefault(pattern, 0) + 1);
			if (answer.get(pattern) > max) {
				max = answer.get(pattern);
				answerPattern = pattern;
			}
			return;
		}

		for (int i = start; i <= end; i++) {
			list.add(visitedList.get(i).website);
			backtracking(visitedList, i + 1, end, list);
			list.remove(list.size() - 1);

		}
	}

	public String populate(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String temp : list) {
			sb.append(temp + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
