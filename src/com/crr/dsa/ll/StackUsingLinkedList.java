package com.crr.dsa.ll;

import java.util.NoSuchElementException;

public class StackUsingLinkedList {
	class Node {
		int data;
		Node next;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int data) {
			super();
			this.data = data;

		}

	}

	Node head;

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {

			newNode.next = head;
			head = newNode;

		}
	}

	public Node pop() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			Node temp = head;
			head = head.next;
			return temp;
		}

	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(" " + temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		try {
			StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
			stackUsingLinkedList.add(1);
			stackUsingLinkedList.add(2);
			System.out.println(stackUsingLinkedList.pop().data);
			stackUsingLinkedList.display();
		}

		catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("No such elements");
		}

	}
}
