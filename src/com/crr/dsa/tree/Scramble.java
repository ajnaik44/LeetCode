package com.crr.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class Scramble {
	 public List<String> split(String s2)
	    {
		 	List<String> list = new ArrayList<>();
		 	
	        if(s2.length()<=0) return null;
		        while(true) {
			        int splitIndex =  (int) ((int)s2.length()*Math.random());
			        if(splitIndex==0) continue;
			        
			        if(s2.substring(0,splitIndex+1).isEmpty() || s2.substring(splitIndex).isEmpty() ) continue;
			        list.add(s2.substring(0,splitIndex+1));
			        list.add(s2.substring(splitIndex));
			        return list;
		        }

	    }
}
