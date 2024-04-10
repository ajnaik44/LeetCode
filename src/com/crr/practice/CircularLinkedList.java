package com.crr.practice;

public class CircularLinkedList {
	private class Node {
		String data;
		Node next;

	
		public Node(String data) {
			// TODO Auto-generated constructor stub
			this.data = data;
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
	public void insertAtLast(String data) {
		 Node newNode = new Node(data);
		if(head==null)
		{
			 //If list is empty, both head and tail would point to new node.
		    head = newNode;
		    tail = newNode;
		    newNode.next = head;
		}else {
			Node temp = head;
			tail.next = newNode;
			tail.next= temp;
		}
	}
	public void addFirst(String data) {
		  Node newNode = new Node(data);
		  //Checks if the list is empty.
		  if (head == null) {
		    //If list is empty, both head and tail would point to new node.
		    head = newNode;
		    tail = newNode;
		    newNode.next = head;
		  } else {
		    //Store data into temporary node
		    Node temp = head;
		    //New node will point to temp as next node
		    newNode.next = temp;
		    //New node will be the head node
		    head = newNode;
		    //Since, it is circular linked list tail will point to head.
		    tail.next = head;
		  }
		}

	public void addLast(String e) {

	}

	/*
	 * public boolean removeFirst() {
	 * 
	 * }
	 */

	public Node first() {
		return tail.next;
	}

	public Node last() {
		return tail;
	}
	//Displays all the nodes in the list  
    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Nodes of the circular linked list: ");  
             do{  
                //Prints each node by incrementing pointer.  
                System.out.print(" "+ current.data);  
                current = current.next;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
	public static void main(String[] args) {
		CircularLinkedList linkedList = new CircularLinkedList();
		linkedList.addFirst("1");
		linkedList.addFirst("2");
		linkedList.addFirst("3");
		linkedList.insertAtLast("4");
		System.out.println();
		linkedList.display();

	}
}
