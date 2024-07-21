package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.leetcode.ListNode;

public class SortList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create an unsorted linked list: 4 -> 2 -> 1 -> 3
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		// Print the original list
		System.out.print("Original list: ");
		printList(head);

		// Sort the list
		SortList solution = new SortList();
		ListNode sortedHead = solution.sortList(head);

		// Print the sorted list
		System.out.print("Sorted list: ");
		printList(sortedHead);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode dummy = dummyHead;
		ListNode l1 = list1;
		ListNode l2 = list2;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				dummy.next = l2;
				l2 = l2.next;
			} else {
				dummy.next = l1;
				l1 = l1.next;
			}
			dummy = dummy.next;
		}
		if (l1 != null)
			dummy.next = l1;
		if (l2 != null)
			dummy.next = l2;
		return dummyHead.next;
	}

	ListNode getMid(ListNode head) {
		ListNode midPrev = null;
		while (head != null && head.next != null) {
			midPrev = (midPrev == null) ? head : midPrev.next;
			head = head.next.next;
		}
		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}

}
