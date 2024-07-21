package com.crr.dsa.crackingtheinterview;

import java.util.TreeMap;

public class Lemonadehange {
	  public boolean lemonadeChange(int[] bills) 
	    {
	      TreeMap<Integer,Integer> treemap =  new TreeMap<>( ) ;
	        treemap.put(20,0);
	        treemap.put(10,0);
	        treemap.put(5,0); 

	        for(int i:bills)
	        {
	          treemap.put(i,treemap.get(i)+1);
	          if(i==5)
	          {
	            continue;
	          }else{
	              boolean result =changePossible(treemap, i-5);
	               System.out.println(result);
	             if(!result)
	                return false;
	          }
	          
	        }  
	        return true;
	    }
	    public boolean changePossible(TreeMap<Integer,Integer> treemap,
	     int remainingamount)
	    {
	      System.out.println(treemap);
	      
	      if(remainingamount==0)
	        return true;
	    
	      if(remainingamount>20 && treemap.get(20)>0)
	      {
	          treemap.put(20,treemap.get(20)-1);
	        return changePossible( treemap, remainingamount-20);
	        
	      }
	     
	     else  if(remainingamount>=10 && treemap.get(10)>0 )
	      {
	       
	          treemap.put(10,treemap.get(10)-1);
	         return changePossible( treemap, remainingamount-10);
	        
	      }
	       else if(remainingamount >= 5 && treemap.get(5)>0 )
	      {
	      
	          treemap.put(5,treemap.get(5)-1);
	         return changePossible( treemap, remainingamount-5);
	        
	      }
	         
	      return false;
	    }
	 
	  public static void main(String[] args) {
	    int g[]={5,5,10,10,20};
	    System.out.println(new Lemonadehange().lemonadeChange(g));
	  
	  }
}
