package com.crr.dsa.crackingtheinterview;

public class RemoveDupsFromLL {

	public static void removeduplicates(Node node)
	{
		Node head =  node;
		while(head.next!=null)
		{
			Node prev =  head;
			Node next =  head.next;
			while(next!=null)
			{
				if(head.data==next.data)
				{
					prev.next =  next.next;
				}
				next =  next.next;
			}
			head =  head.next;
		}
	}
	    public static void main(String[] args) {
	        // Creating a linked list
	        Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(2);
	        head.next.next.next = new Node(3);
	        head.next.next.next.next = new Node(3);
	        head.next.next.next.next.next = new Node(4);

	        // Printing the original list
	        System.out.println("Original list:");
	        printList(head);

	        // Removing duplicates
	        removeduplicates(head);

	        // Printing the list after removing duplicates
	        System.out.println("\nList after removing duplicates:");
	        printList(head);
	    }

	   
	    public static void printList(Node node) {
	        Node current = node;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

}
