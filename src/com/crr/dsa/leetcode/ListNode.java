package com.crr.dsa.leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	ListNode() {
	}

public	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline at the end for better readability
    }
	public static void main(String[] args) {
		Solution solution=new ListNode.Solution();
		ListNode head = new ListNode(1);


		head = solution.deleteMiddle(head);
		printList(head);

	}
static	class Solution {
	public ListNode deleteMiddle(ListNode head) {
	    if (head == null || head.next == null) {
	        // List is empty or has only one node
	        return null;
	    }

	    ListNode slow = head;
	    ListNode fast = head;
	    ListNode previous = null;

	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        previous = slow;
	        slow = slow.next;
	    }

	    // At this point, 'slow' is at the middle node
	    if (previous != null) {
	        // If the list has odd nodes, skip the middle node
	        previous.next = slow.next;
	    } else {
	        // If the list has even nodes, update the head to skip the first middle node
	        head = head.next;
	    }

	    return head;
	}

	public ListNode deleteMiddle_old(ListNode head) {
	    int size = 0;
	    if (head == null)
	        return head;

	    ListNode current = head;
	    while (current != null) {
	        size++;
	        current = current.next;
	    }

	    int mid = size / 2;
	    current = head;
	    ListNode previous = null;
	    int counter = 0;

	    while (current != null) {
	        if (counter == mid) {
	            if (previous == null) {
	                // If deleting the first node, update head
	                head = current.next;
	            } else {
	                // Skip the middle node
	                previous.next = current.next;
	            }
	            break;
	        }

	        previous = current;
	        current = current.next;
	        counter++;
	    }

	    return head;
	}

	
	}
}


