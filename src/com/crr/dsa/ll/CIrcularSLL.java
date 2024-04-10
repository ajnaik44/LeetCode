package com.crr.dsa.ll;

public class CIrcularSLL {
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
	int size = 0;

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else if (head.next == null) {
			newNode.next = head;
			head.next = newNode;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}

	}

	public void display() {
		Node temp = head;
		if (temp != null) {
			while (temp.next != head) {
				System.out.print(" " + temp.data);
				temp = temp.next;
			}
			System.out.print(" " + temp.data);
		}
	}

	public static void main(String[] args) {
		CIrcularSLL doublyLL = new CIrcularSLL();
		doublyLL.add(2);
		doublyLL.add(3);
		doublyLL.add(4);
		doublyLL.display();
	}

}
