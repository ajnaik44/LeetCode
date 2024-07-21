package com.crr.dsa.crackingtheinterview;

import java.util.PriorityQueue;

public class MedianFinder {
	
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
	}
	
	PriorityQueue<Integer> maxPQ ;  
    PriorityQueue<Integer> minPQ ;  
   public MedianFinder() {
       maxPQ  = new  PriorityQueue<Integer> ();
       minPQ  = new  PriorityQueue<Integer> ();
   }
   
   public void addNum(int num) {
       
       minPQ.add(num);
       
       if( maxPQ.size() - minPQ.size() > 1  )
       {
           while(maxPQ.size() - minPQ.size() > 1)
           {
               minPQ.add(maxPQ.poll());
           }
            
       }
      else  
       {
           while(minPQ.size() - maxPQ.size() > 1)
           {
               maxPQ.add(minPQ.poll());
           }
          
       }
        System.out.println( "min" +   minPQ);
        System.out.println( "max " +  maxPQ);
   }
   
   public double findMedian() {
      
       if(minPQ.size() == maxPQ.size())
       {
           return (double) (minPQ.peek()+maxPQ.peek())/2;
       }
       if(minPQ.size() >  maxPQ.size())
           return (double) minPQ.peek();
        else
           return (double) maxPQ.peek();
   }
}
