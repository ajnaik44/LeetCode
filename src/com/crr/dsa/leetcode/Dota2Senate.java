package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dota2Senate {
	
	 // Ban the candidate "toBan", immediate next to "startAt"
    public static void ban(String senate, boolean[] banned, char toBan, int startAt) {
        // Find the next eligible candidate to ban
        int pointer = startAt;
        while (true) {
            if (senate.charAt(pointer) == toBan && !banned[pointer]) {
                banned[pointer] = true;
                break;
            }
            pointer = (pointer + 1) % senate.length();
        }
    }

    public static String predictPartyVictory_old1(String senate) {

        // To mark Banned Senators
        boolean[] banned = new boolean[senate.length()];

        // Count of Each Type of Senator who are not-banned
        int rCount = 0, dCount = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // Turn of Senator at this Index
        int turn = 0;

        // While both parties have at least one senator
        while (rCount > 0 && dCount > 0) {

            if (!banned[turn]) {
                if (senate.charAt(turn) == 'R') {
                    ban(senate, banned, 'D', (turn + 1) % senate.length());
                    dCount--;
                } else {
                    ban(senate, banned, 'R', (turn + 1) % senate.length());
                    rCount--;
                }
            }

            turn = (turn + 1) % senate.length();
        }

        return dCount == 0 ? "Radiant" : "Dire";
    }
	 public static  String predictPartyVictory_old(String senate) {
	        List<Character> queue = new ArrayList<>();
	        for(char c: senate.toCharArray())
	        {
	        	queue.add(c);
	        }
	        boolean winner =true;
	    	Character first =queue.get(0);
	    	queue.remove(0);
	    	if(queue.isEmpty())
        	{
        		return String.valueOf(first).equalsIgnoreCase("R")?"Radiant":"Dire";
        	}
	        while(winner)
	        {
	        
	        	Character second =null;
	        	boolean flag =true;
	        	
	        	for(int i=0;i<queue.size();)
	        	{
	        		second =  queue.get(i);
	        		if(first==second)
	        		{
	        			i++;
	        			continue;
	        			
	        		}
	        		else {
	        			flag=false;
	        			queue.remove(i);
	        			if(!queue.isEmpty()&& queue.size()>1) {
	        			queue.add(i, first);
	        			first =  queue.get(i+1);
	        			}
	        			else {
	        				return String.valueOf(first).equalsIgnoreCase("R")?"Radiant":"Dire";
	        			}
	        			
	        		}
	        	}
	        	if(flag)
	        		winner =false;
	        }
	        return queue.get(0).toString().equalsIgnoreCase("R")?"Radiant":"Dire";
	    }
	 public static void main(String[] args) {
		System.out.println(predictPartyVictory("DDR"));
	}
	 public static String predictPartyVictory(String senate) {
	        
	        // Number of Senators of each party
	        int rCount = 0, dCount = 0;
	       
	        // Floating Ban Count
	        int dFloatingBan = 0, rFloatingBan = 0;

	        // Queue of Senators
	        Queue<Character> q = new LinkedList<>();
	        for (char c : senate.toCharArray()) {
	            q.add(c);
	            if (c == 'R') rCount++;
	            else dCount++;
	        }

	        // While any party has eligible Senators
	        while (rCount > 0 && dCount > 0) {

	            // Pop the senator with turn
	            char curr = q.poll();

	            // If eligible, float the ban on the other party, enqueue again.
	            // If not, decrement the floating ban and count of the party.
	            if (curr == 'D') {
	                if (dFloatingBan > 0) {
	                    dFloatingBan--;
	                    dCount--;
	                } else {
	                    rFloatingBan++;
	                    q.add('D');
	                }
	            } else {
	                if (rFloatingBan > 0) {
	                    rFloatingBan--;
	                    rCount--;
	                } else {
	                    dFloatingBan++;
	                    q.add('R');
	                }
	            }
	        }

	        // Return the party with eligible Senators
	        return rCount > 0 ? "Radiant" : "Dire";
	    }
}
