package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysandRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<List<Integer>> rooms = new ArrayList<>();
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();

        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(5);
        list4.add(7);

        List<Integer> list5 = new ArrayList<>();
        list5.add(1);

        List<Integer> list6 = new ArrayList<>();

        List<Integer> list7 = new ArrayList<>();
        list7.add(8);
        list7.add(9);

        List<Integer> list8 = new ArrayList<>();

        List<Integer> list9 = new ArrayList<>();

        List<Integer> list10 = new ArrayList<>();
        list10.add(6);

        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        rooms.add(list5);
        rooms.add(list6);
        rooms.add(list7);
        rooms.add(list8);
        rooms.add(list9);
        rooms.add(list10);
		KeysandRooms keysandRooms =  new KeysandRooms();
		System.out.println(keysandRooms.canVisitAllRooms(rooms));

	}
	  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        boolean[] seen = new boolean[rooms.size()];
	        seen[0] = true;
	        Stack<Integer> stack = new Stack();
	        stack.push(0);

	        //At the beginning, we have a todo list "stack" of keys to use.
	        //'seen' represents at some point we have entered this room.
	        while (!stack.isEmpty()) { // While we have keys...
	            int node = stack.pop(); // Get the next key 'node'
	            for (int nei: rooms.get(node)) // For every key in room # 'node'...
	                if (!seen[nei]) { // ...that hasn't been used yet
	                    seen[nei] = true; // mark that we've entered the room
	                    stack.push(nei); // add the key to the todo list
	                }
	        }

	        for (boolean v: seen)  // if any room hasn't been visited, return false
	            if (!v) return false;
	        return true;
	    }
}
