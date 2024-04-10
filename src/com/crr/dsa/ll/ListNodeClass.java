package com.crr.dsa.ll;

public class ListNodeClass {

	public class Node {
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
	
	int size = 0;

	public void add(int data) {
		Node node = new Node(data);
		if (head == null) {

			head = node;
		} else {
			Node previous = head;
			while (previous.next != null) {
				previous = previous.next;
			}
			previous.next = node;
		}
		size++;
	}

	public void insertBeforeHead(int data) {
		Node node = new Node(data);
		Node temp = head;
		head = node;
		head.next = temp;
		size++;
	}

	public void insertInMiddle(int data, int location) {
		Node newNode = new Node(data);
		int counter = 0;

		if (counter == location) {
			insertBeforeHead(data);
		} else {
			Node current = head;
			Node next = head;
			while (next.next != null && counter != location) {
				counter++;
				if (counter == location) {

				} else {
					current = next;
					next = next.next;

				}

			}

			if (counter != location) {
				Node lastNode = next;
				next = newNode;
				newNode.next = lastNode;
				current.next = next;
			} else {

				current.next = newNode;
				newNode.next = next;
			}
		}
	}

	public void deleteHead() {
		Node temp = head;
		head = head.next;
		temp = null;
	}

	public void deleteTail() {
		Node current = head;
		Node next = head;
		while (next.next != null) {
			current = next;
			next = next.next;
		}
		current.next = null;

	}

	public void deleteNodefromMiddle(int data) {
		Node current = head;
		Node next = head;
		if (next.data == data) {
			deleteHead();
		}
		while (next.next != null) {
			current = next;
			next = next.next;
			if (next.data == data) {

				Node temp = next.next;
				current.next = temp;
				break;
			}
		}

	}

	public void display() {
		Node tmp = head;
		while (tmp.next != null) {
			System.out.print(tmp.data + "   ");
			tmp = tmp.next;

		}
		System.out.print(tmp.data + "   ");
	}

	public static void main(String[] args) {
		ListNodeClass listNode = new ListNodeClass();
		listNode.add(1);
		listNode.add(2);
		listNode.add(3);
		listNode.add(4);
		listNode.insertBeforeHead(0);

		// listNode.insertInMiddle(3, 3);
		// listNode.insertInMiddle(12, 3);
		// listNode.insertInMiddle(13, 4);
		// listNode.deleteHead();
		// listNode.deleteTail();
		listNode.deleteNodefromMiddle(2);
		listNode.display();
	}

}
