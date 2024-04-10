package com.crr.dsa.ll;


public class DoublyLL {
	
	
	
	
	class Node{
		int data;
		Node next;
		Node previous;
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	Node head;
	Node tail;
	public void add(int data)
	{
		Node newnode =  new Node(data);
		if(head==null)
		{
			head= newnode;
			
		}else {
			Node temp = tail;
			if(tail==null)
			{
				tail =  newnode;
				tail.previous=head;
				head.next =  tail;
			}
			
			
		}
	}
	public void addHead(int data)
	{
		Node newnode =  new Node(data);
		Node temp =  head;
		newnode.next =  temp;
		temp.previous = newnode;
		head =  newnode;
		
	}
	public void addNodeinMiddle(int position, int data)
	{
		
		Node newNode =  new Node(data);
		Node temp =  head;
		int counter=0;
		while(temp!=null)
		{
			counter++;
			if(counter==position)
			{
				break;
			}
			temp =  temp.next;
			
		}
		Node previous =  temp.previous;
		previous.next =newNode;
		newNode.previous =  previous;
		newNode.next =  temp;
		temp.previous =  newNode;
		
		
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null&& temp.next!=null&&temp!=tail)
		{
			System.out.print("  "+ temp.data);
			temp = temp.next;
		}
		System.out.print("  "+ temp.data);
	}
	public static void main(String[] args) {
		DoublyLL  doublyLL = new DoublyLL();
		doublyLL.add(2);
		doublyLL.add(3);
		doublyLL.addHead(1);
		doublyLL.addNodeinMiddle(3, 4);
		doublyLL.display();
	}
}
