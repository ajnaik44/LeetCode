package com.crr.dsa.ll;

import java.util.HashMap;
import java.util.Iterator;

import com.crr.dsa.ll.ListNodeClass.Node;

public class FindLLNullOrCircular {
	public static String checkCircular(ListNode1 listNode1)
	{
		ListNode1  temp =  listNode1.next;
		HashMap  hashmap = new HashMap();
		hashmap.put(listNode1.value, 1);
		while(temp!=null)
		{
			if(hashmap.get(temp.value)!=null)
			{
				System.out.println(temp.next.value);
				return "Cycle";
			}
			else {
				hashmap.put(temp.value, 1);
			}
			if(temp.next==null)
			{
				return "Null";
			}
			temp = temp.next;
		}
		return null;
	}
	public static int  checkCircularUsingFloyd(ListNode1 listNode1)
	{
		ListNode1 slowptr =  listNode1;
		ListNode1 fastwptr =  listNode1;
		boolean loopexit=false;
		while(fastwptr!=null&& fastwptr.next!=null)
		{
			fastwptr =  fastwptr.next.next;
			slowptr =  slowptr.next;
			if(slowptr==fastwptr) {
				loopexit= true;
				break;
			}
		}
		int length=0;
		if(loopexit)
		{
			do {
				slowptr =  slowptr.next;
				length++;
				
			}while(slowptr!=fastwptr);
		}
		return length;
		
	}
	public static void insertInSortedLL(ListNode1 head,int data)
	{
		ListNode1 current =head;
		ListNode1 tempNext =head;
		while(tempNext!=null &&   tempNext.value<data)
		{
			current = tempNext;
			tempNext =  tempNext.next;
		}
		ListNode1  newNode = new ListNode1(data);
		current.next=newNode;
		newNode.next= tempNext;
		
	}
	
	public static void insertNodeInSortedOrder(ListNode1 head,int data)
	{
		ListNode1 temp =  head;
		ListNode1 newNode = new ListNode1(data);
		while(temp!=null)
		{
			if(temp.next==null && temp.value<data)
			{
				temp.next=  newNode;
			}
			if(temp!=null && temp.next!=null && data > temp.value    && data<temp.next.value)
			{
				ListNode1 nextNode =  temp.next;
				temp.next =  newNode;
				newNode.next =  nextNode;
			}
			if(temp.next==null&& data > temp.value)
			{
				ListNode1 nextNode =  temp;	
				newNode.next=nextNode;
			}
			
			temp =  temp.next;
		}
		
	}

	public static void display(ListNode1 head) {
		ListNode1 tmp = head;
		while (tmp.next != null) {
			System.out.print(tmp.value + "   ");
			tmp = tmp.next;

		}
		System.out.print(tmp.value + "   ");
	}

	public static void main(String[] args) {
		ListNode1 head = new ListNode1(1);
		head.next = new ListNode1(2);
		head.next.next = new ListNode1(3);
		head.next.next.next = new ListNode1(4);
		head.next.next.next.next = new ListNode1(5);
		head.next.next.next.next.next = new ListNode1(7);
		
		insertInSortedLL(head,6);
		display(head);
	}
}
