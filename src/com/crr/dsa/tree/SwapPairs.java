package com.crr.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.crr.dsa.leetcode.ListNode;

public class SwapPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode answer = head.next;

		Queue<ListNode> queue = new LinkedList<ListNode>();
		ListNode current = head;

		while (current != null) {
			queue.add(current);
			current = current.next;

		}

		ListNode prev = null;
		while (!queue.isEmpty() && queue.size() >= 2) {
			ListNode node1 = queue.poll();
			ListNode node2 = queue.poll();
			node2.next = node1;

			node1.next = null;

			if (prev == null)
				prev = node1;
			else {
				prev.next = node2;
				while(prev.next!=null)
				{
					prev =  prev.next;
				}
			}

		}
		while (!queue.isEmpty()) {
			prev.next = queue.poll();
		}
		return answer;

	}

	public static void main(String[] args) {
		// Creating the linked list: 1 -> 2 -> 3 -> 4
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original list:");
		printList(head);

		// Swapping pairs
		ListNode swappedHead = swapPairs(head);

		System.out.println("List after swapping pairs:");
		printList(swappedHead);
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
}
