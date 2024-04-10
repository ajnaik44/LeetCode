package com.crr.dsa.crackingtheinterview;

public class ReturnKthtoLast {

	public static Node findKthElement(Node node, int k) {
		if (node == null)
			return null;
		Node current = node;
		int totalElemenet = 0;
		while (current != null) {
			totalElemenet++;
			current = current.next;
		}

		int counter = 0;
		current = node;
		while (current != null) {
			if (counter == totalElemenet - k) {
				return current;
			}
			counter++;
			current = current.next;
		}
		return null;
	}

	static int printKthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}

	static class Index {
		public int value;
	}

	static Node kthToLast(Node head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	static Node kthToLast(Node head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}
	static Node nthToLast(Node head, int k) {
		Node p1 = head;
		Node p2= head;
		
		for(int i=0;i<k;i++)
		{
			p1 =  p1.next;
		}
		while(p1!=null)
		{
			p1 =  p1.next;
			p2 =  p2.next;
		}
		return p2;
		
		
	}

	public static void main(String[] args) {
		// Creating a linked list
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		// Printing the original list
		System.out.println("Original list:");
		Node.printList(head);

		// Finding the kth element from the end
		int k = 3; // Change this value to test different values of k
		Node kthElement;// printKthToLast(head, k);
		Node node = nthToLast(head, k);
		System.out.println("dddddddd " + node.data);

	}
}
