package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class PowerSet {
	
	static void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
		   //TODO: Write - Your - Code
	       
	      sets .addAll(  getSet(v,0));
	  }

	  public static List<HashSet<Integer>> getSet(List<Integer> v,int index)
	  {
	      List<HashSet<Integer>> result ;
	      if(v.size()==index)
	      {
	          HashSet<Integer>  emptySet = new HashSet<Integer>();
	          result =  new ArrayList<HashSet<Integer>>();
	          result.add(emptySet);
	      }
	      else{
	          result =  getSet(v,index+1);
	          int item =  v.get(index);
	          List<HashSet<Integer>> moreSet =  new ArrayList<HashSet<Integer>> ()  ;
	         
	          for(HashSet<Integer> subSet :  result)
	          {
	              HashSet<Integer>  tempSet = new HashSet<Integer>(subSet);
	              
	              tempSet.add(item);
	              moreSet.add(tempSet);
	          } 
	          result.addAll(moreSet);
	      }
	      
	      return result;

	  }
	
	public static ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set, int index)
	{
		
		ArrayList<ArrayList<Integer>> allSubset;
		if(set.size()==index)
		{
			ArrayList<Integer> list = new ArrayList<>();
			allSubset = new ArrayList<ArrayList<Integer>>();
			allSubset.add(list);
			
		}else {
			allSubset =  getSubSet(set, index+1);
			int item =  set.get(index);
			ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<>();
			
			for(ArrayList<Integer> subset :  allSubset)
			{
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubset.add(newSubset);
			}
			allSubset.addAll(moreSubset);
		}
		return allSubset;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<HashSet<Integer>> res = new  ArrayList<HashSet<Integer>>();
		get_all_subsets(list, res);
		System.out.println(res);
		System.out.println(printAllBraces(3));
	}
	
	
	static ArrayList<ArrayList<Character>> printAllBraces(int n) {
	    ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
	    LinkedHashSet<ArrayList<Character>> set = new LinkedHashSet<>(); // HashSet to store unique combinations
	    if(n==1)
	    {
	      ArrayList<Character> firstBraces = new ArrayList<Character>();
	      firstBraces.add('{');
	      firstBraces.add('}');
	      result.add(firstBraces);
	    }else{
	     result =   printAllBraces(n-1);
	     ArrayList<ArrayList<Character>> moreSet = new ArrayList<ArrayList<Character>>();

	      for(ArrayList<Character> temp : result)
	      {
	         
	          ArrayList<Character>  addFirstlist = new ArrayList<Character>(temp);
	          ArrayList<Character>  addLast = new ArrayList<Character>(temp);
	          for(int i=0;i<temp.size();i++){
	        	  
	            if(temp.get(i)=='{')
	            {
	            	ArrayList<Character>  newlist = new ArrayList<Character>(temp);
		              newlist.add(i+1,'{');
		              newlist.add(i+2,'}');
		              moreSet.add(newlist);
	            }
	            
	          
	          }
	          addFirstlist.add(0,'{');
	          addFirstlist.add(1,'}');
	          moreSet.add(addFirstlist);
	          if(temp.size()>2) {
	        	  addLast.add(addLast.size()-1, '{');
	          addLast.add( '}');  
	          moreSet.add(addLast);
	          }
	         
	        
	          
	      }
	      result.clear();
	      set.addAll(moreSet); // Add all combinations to the HashSet to remove duplicates
          result.addAll(set);

	    }
	    
	    return result;
	  }
	
}
