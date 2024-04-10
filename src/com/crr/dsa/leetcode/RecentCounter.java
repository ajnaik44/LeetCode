package com.crr.dsa.leetcode;

import java.util.LinkedList;

class RecentCounter {
	LinkedList<Integer> linkedList;
	
    public RecentCounter() {
        linkedList = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.linkedList.add(t);
        
        while(this.linkedList.getFirst()< t-3000)
        {
        	this.linkedList.removeFirst();
        }
        System.out.println(this.linkedList);
        return this.linkedList.size();
    }
    public static void main(String[] args) {
		RecentCounter counter = new RecentCounter();
		counter.ping(1);
		counter.ping(100);
		counter.ping(3001);
		counter.ping(3002);
		counter.ping(7000);
	}
}