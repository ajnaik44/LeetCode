package com.crr.dsa.leetcode;

public class OddEvenLinkedList {
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
	public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline at the end for better readability
    }
	public static ListNode oddEvenList(ListNode head) {
	    if (head == null || head.next == null)
	        return head;

	    ListNode odd = head;
	    ListNode even = head.next;
	    ListNode even_head = even;

	    while (even != null && even.next != null) {
	        odd.next = even.next;
	        odd = odd.next;

	        even.next = odd.next;
	        even = even.next;
	    }

	    // Connect the odd list to the even list
	    odd.next = even_head;

	    return head;
	}

	public static void main(String[] args) {
		ListNode head = new OddEvenLinkedList.ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));



		head = oddEvenList(head);
		printList(head);
	}
}
