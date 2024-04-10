package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwinSumofaLinkedList {
	 public static int pairSum(ListNode head) {
		
		 ListNode  current = head;
		 List<Integer> list = new ArrayList<>();
		 while(current!=null)
		 {
			 list.add(current.val);
			 current =  current.next;
		 }
		 int max = 0;
		 for(int i=0,j=list.size()-1;!(i>=j);i++,j--)
		 {
			 max =  Math.max(max, list.get(i) + list.get(j));
		 }
		 return max;
	 }
	 public static int pairSumUsingStack(ListNode head) {
			
		 ListNode  current = head;
		 Stack<Integer> stack = new Stack<>();
		 while(current!=null)
		 {
			 stack.add(current.val);
			 current =  current.next;
		 }
		 current=head;
		 int mid_size =  stack.size()/2;
		 System.out.println(mid_size);
		 int counter=0;
		 int max = 0;
		 while(counter<=mid_size)
		 {
			 max =  Math.max(max, current.val +  stack.pop());
			 counter++;
			 current =  current.next;
		 }
		 return max;
	 }
	 public static void main(String[] args) {
		 ListNode head = new ListNode(1);
	        head.next = new ListNode(3);
	        head.next.next = new ListNode(5);
	        head.next.next.next = new ListNode(2);

	        // Call the pairSum method
	        int result = pairSumUsingStack(head);
	        System.out.println(result);

	}
}
