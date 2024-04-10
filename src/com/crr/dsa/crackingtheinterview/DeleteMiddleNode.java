package com.crr.dsa.crackingtheinterview;

public class DeleteMiddleNode {

	public static Node deleteMiddleNode(Node  node)
	{
		if(node==null ||  node.next==null)
			return node;
		Node p1 =  node;
		Node p2=node.next.next;
		while(p2!=null &&  p2.next!=null)
		{
			p1 =  p1.next;
			p2 =  p2.next.next;
		}
		if(p1.next!=null)
		{
			
				p1.next=  p1.next.next;
		}
		return node;
	}
	static Node partition(Node node, int x) {
	    Node head = node;
	    Node tail = node;

	    while (node != null) {
	        Node next = node.next;
	        if (node.data < x) {
	            // Insert node at head.
	            node.next = head;
	            head = node;
	        } else {
	            // Insert node at tail.
	            tail.next = node;
	            tail = node;
	        }
	        node = next;
	    }
	    tail.next = null;

	    // The head has changed, so we need to return it to the user.
	    return head;
	}

	public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
     
       
        System.out.println("Original Linked List:");
       Node.printList(head);

        // Delete middle node
        head = partition(head,8);

        System.out.println("\nLinked List after partition middle node:");
        Node.printList(head);
    }
}
