package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class Palindrome {
	public static boolean checkNumberIsPalindromeAjay(Node node) {
		if (node == null || node.next == null)
			return true;

		Stack<Integer> stack = new Stack<>();

		Node p1 = node;
		while (p1 != null) {
			stack.add(p1.data);
			p1 = p1.next;
		}
		int size = stack.size() / 2;
		System.out.println(stack);
		p1 = node;
		for (int i = 0; i <= size; i++) {
			if (stack.pop() != p1.data) {
				System.out.println(p1.data);
				return false;
			}
			p1 = p1.next;
		}
		return true;
	}



	static Node reverseAndClone(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node reversed = reverseAndClone(node.next);
		Node newNode = new Node(node.data); // Clone
		Node current = reversed;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		return reversed;
	}

	class Result {
		public Node node;
		public boolean result;
		public Result(Node node, boolean result) {
			super();
			this.node = node;
			this.result = result;
		}
		
	}

	boolean isPalindromeOptimize(Node head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	Result isPalindromeRecurse(Node head, int length) {
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}

		// Recurse on sublist.
		Result res = isPalindromeRecurse(head.next, length - 2);

		// If child calls are not a palindrome, pass back up a failure.
		if (!res.result || res.node == null) {
			return res;
		}

		// Check if matches corresponding node on the other side.
		res.result = (head.data == res.node.data);

		// Return corresponding node.
		res.node = res.node.next;

		return res;
	}

	int lengthOfList(Node n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		 head.next.next.next = new Node(1);
		 head.next.next.next.next = new Node(0);
		// head.next.next.next.next.next = new Node(0);
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome.isPalindromeOptimize(head));
		head = reverseAndClone(head);
		Node.printList(head);
	}

}
