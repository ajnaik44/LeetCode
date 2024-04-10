package com.crr.dsa.leetcode;

public class ReverseList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	static ListNode front;
	 public static ListNode reverseListRecursion(ListNode head) {
		
		while(head!=null)
		{
			reverseListHelper(head);
			head = head.next;
		}
		return front;
		 
	 }
	 public static void reverseListHelper(ListNode head) {
			
		 if(head!=null )
		 {
			 ListNode node = new ListNode(head.val);
			 if(front==null) {
				 front = node; 
			 }else {
				 ListNode temp =  front;
				node.next =  temp;
				front =node;
			 }
		 }

	 }
	 public static ListNode reverseListIterative(ListNode head) {
			
		 ListNode front=null;
		 if(head!=null) {
			 front = new ListNode(head.val);
		 }
		 else {
			 return head;
		 }
		 head =  head.next;
		 while(head!=null)
		 {
			 ListNode temp = new ListNode(head.val);
			 ListNode t1 = front;
			 temp.next = t1;
			 front =temp;
			 head = head.next;
					 
		 }
		return front;	 
		 }
	 private static void printList(String testName, ListNode list) {
	        System.out.print(testName + ": ");
	        while (list != null) {
	            System.out.print(list.val + " -> ");
	            list = list.next;
	        }
	        System.out.println("null");
	    }
	 public static void main(String[] args) {
		 // Test Case 1: Empty List
	        ListNode result1 = reverseListIterative(null);
	        printList("Test Case 1", result1);

	        // Test Case 2: Single Node List
	        ListNode list2 = new ListNode(5);
	        ListNode result2 = reverseListIterative(list2);
	        printList("Test Case 2", result2);

	        // Test Case 3: List with Multiple Nodes
	        ListNode list3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
	        ListNode result3 = reverseListIterative(list3);
	        printList("Test Case 3", result3);

	        // Test Case 4: List with Duplicate Values
	        ListNode list4 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
	        ListNode result4 = reverseListIterative(list4);
	        printList("Test Case 4", result4);

	        // Test Case 5: List with Null Values
	        ListNode list5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
	        ListNode result5 = reverseListIterative(list5);
	        printList("Test Case 5", result5);

	        
	}
}
