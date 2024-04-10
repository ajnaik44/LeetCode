package com.crr.dsa.ll;

public class ReverseBlockByK {
	public static ListNode reverseBlock(ListNode head, int k) {
	    if (head == null || k <= 1) {
	        return head;
	    }
	    
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode prev = dummy;
	    
	    int length = 0;
	    ListNode current = head;
	    while (current != null) {
	        current = current.next;
	        length++;
	    }
	    
	    current = head;
	    ListNode tail = dummy;
	    
	    while (length >= k) {
	        for (int i = 1; i < k; i++) {
	            ListNode nextNode = current.next;
	            current.next = nextNode.next;
	            nextNode.next = prev.next;
	            prev.next = nextNode;
	        }
	        
	        prev = current;
	        current = current.next;
	        tail = prev;
	        length -= k;
	    }
	    
	    return dummy.next;
	}
	public static ListNode reverseBlockUsingRecursion(ListNode head, int k) {
	    if (head == null || k <= 1) {
	        return head;
	    }
	    
	    ListNode current = head;
	    int count = 0;
	    
	    // Traverse k nodes to check if there are enough nodes to reverse
	    while (current != null && count < k) {
	        current = current.next;
	        count++;
	    }
	    
	    if (count < k) {
	        return head; // Not enough nodes to reverse, return the list as is
	    }
	    
	    // Reverse the first k nodes
	    ListNode prev = null;
	    ListNode next = null;
	    current = head;
	    count = 0;
	    
	    while (current != null && count < k) {
	        next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	        count++;
	    }
	    
	    // Recursively reverse the remaining nodes
	    if (next != null) {
	        head.next = reverseBlockUsingRecursion(next, k);
	    }
	    
	    return prev; // The new head of the reversed block
	}


	public static void main(String[] args) {
		// Test Case 1
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		ListNode listA = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		 node5.next = node6;
		LLIntersection.printIntersectionList(listA);
		LLIntersection.printIntersectionList(reverseBlockUsingRecursion(listA, 3));
	}
}
