package com.crr.dsa.crackingtheinterview;

public class LoopDetection {
	static Node FindBeginning(Node head) {
	    Node slow = head;
	    Node fast = head;

	    /* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if (slow == fast) { // Collision
	            break;
	        }
	    }

	    /* Error check - no meeting point, and therefore no loop*/
	    if (fast == null || fast.next == null) {
	        return null;
	    }
	    /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
	     * Loop Start. If they move at the same pace, they must meet at Loop Start. */
	    slow = head;
	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }

	    /* Both now point to the start of the loop. */
	    return fast;
	}
	public static void main(String[] args) {
        // Create a linked list with a loop for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // Create a loop at node with data 3

        Node loopStart = FindBeginning(head);
        if (loopStart != null) {
            System.out.println("Loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}
