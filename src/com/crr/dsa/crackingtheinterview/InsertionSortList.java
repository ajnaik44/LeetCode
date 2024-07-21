package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.leetcode.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode();
		ListNode curr = head;

		while (curr != null) {
			// At each iteration, we insert an element into the resulting list.
			ListNode prev = dummy;

			// find the position to insert the current node
			while (prev.next != null && prev.next.val <= curr.val) {
				prev = prev.next;
			}

			ListNode next = curr.next;
			// insert the current node to the new list
			curr.next = prev.next;
			prev.next = curr;

			// moving on to the next iteration
			curr = next;
		}

		return dummy.next;
	}

	// Method to print the linked list
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample linked list: 4 -> 2 -> 1 -> 3
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		// Sorting the linked list using insertion sort
		InsertionSortList main = new InsertionSortList();
		ListNode sortedHead = main.insertionSortList(head);

		// Printing the sorted linked list
		printList(sortedHead);
	}
}
