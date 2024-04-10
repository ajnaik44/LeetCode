package com.crr.dsa.crackingtheinterview;

public class ReversePortionOfLinkedList {
	void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	 public static void main(String[] args) {
		 ReversePortionOfLinkedList list = new ReversePortionOfLinkedList();
	        Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(4);
	        head.next.next.next = new Node(3);
	        head.next.next.next.next = new Node(6);
	        head.next.next.next.next.next = new Node(8);

	        System.out.println("Original Linked List:");
	        list.printList(head);
	        System.out.println();

	        head = list.reverse(head);

	        System.out.println("Reversed Linked List:");
	        list.printList(head);
	    }
	 Node reverse(Node head) {
	        Node prev = null;
	        Node current = head;

	        while (current != null) {
	           // If the current node's data is even, reverse the segment
	            if (current!=null && current.data % 2 == 0) {
	                Node reversedSegment = reverseSegment(current);
	                prev.next =  reversedSegment;
	                current = reversedSegment;
	                while(current!=null && current.data%2==0)
	                {
	                	prev =current;
	                	current = current.next;
	                }
	            }
	            prev =current;
	            if(current!=null)
	        	current = current.next;
	        }
	        return head;
	    }

	    Node reverseSegment(Node firstNode) {
	        Node prev = null;
	        Node current = firstNode;
	        Node next;

	        while (current != null && current.data % 2 == 0) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        next = prev;
	        while(next!=null &&  next.next!=null )
	        {
	        	next =  next.next;
	        }
	        next.next =  current;
	       // prev.next = current;
	        // 'prev' now points to the head of the reversed segment
	        return prev;
	    }
}
