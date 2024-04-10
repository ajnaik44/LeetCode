package com.crr.dsa.ll;

public class Reverseasinglylinkedlist {
	public static ListNodeClass reverseLL(ListNodeClass listNode)
	{
		ListNodeClass  reverseList =  new ListNodeClass();
		ListNodeClass.Node temp = listNode.head;
		while(temp!=null)
		{
			reverseList.insertBeforeHead(temp.data);
			temp = temp.next;
		}
		return reverseList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNodeClass listNode = new ListNodeClass();
		listNode.add(0);
		listNode.add(1);
		listNode.add(2);
		listNode.add(3);
		listNode.add(4);
		listNode.add(5);
		reverseLL(listNode).display();
	}

}
