package com.crr.practice;

public class SinglyLinkedList {
	private class Node {
		String data;
		Node next;

		private Node(String e) {
			data = e;
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size > 0 ? true : false;
	}

	public void addFirst(String e) {
		if (head == null) {
			head = new Node(e);
			tail = head;
		} else {
			Node newNode = new Node(e);
			newNode.next = head;
			head = newNode;
		}
	}

	public void addLast(String e) {
		if (tail == null) {
			head = new Node(e);
			tail = head;
		} else {
			Node newNode = new Node(e);
			tail.next = newNode;
			tail = newNode;
		}
	}

	public boolean removeFirst() {
		if (head == null || head.next == null) {
			return false;
		} else {
			
			head = head.next;
			
		}
		return true;
	}

	public Node first() {
		return head;
	}

	public Node last() {
		return tail;
	}
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addFirst("1");
		linkedList.addFirst("2");
		linkedList.addFirst("3");
		System.out.println(linkedList.first().data);
		System.out.println(linkedList.last().data);
		linkedList.removeFirst();
		System.out.println(linkedList.first().data);
	}

}
