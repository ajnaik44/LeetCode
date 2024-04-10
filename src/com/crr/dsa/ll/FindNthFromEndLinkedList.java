package com.crr.dsa.ll;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

class ListNode1 {
	int value;
	ListNode1 next;

	ListNode1(int value) {
		this.value = value;
		this.next = null;
	}
}

public class FindNthFromEndLinkedList {

	/*
	 * public static ListNode1 findNthFromEnd(ListNode1 head, int n) { if (head ==
	 * null || n <= 0) { return null; }
	 * 
	 * // Initialize two pointers ListNode1 firstPointer = head; ListNode1
	 * secondPointer = head;
	 * 
	 * // Move the firstPointer n nodes ahead for (int i = 0; i < n; i++) { if
	 * (firstPointer == null) { // The list has less than n nodes return null; }
	 * firstPointer = firstPointer.next; }
	 * 
	 * // Move both pointers until the firstPointer reaches the end while
	 * (firstPointer != null) { firstPointer = firstPointer.next; secondPointer =
	 * secondPointer.next; }
	 * 
	 * // The secondPointer now points to the nth node from the end return
	 * secondPointer; }
	 */
	public static ListNode1 findNthFromEnd(ListNode1 head, int n) throws Exception {
		int totalnodes = 0;
		ListNode1 listNode = head;
		while (listNode != null) {
			listNode = listNode.next;
			totalnodes += 1;
		}
		System.out.println(totalnodes);
		if (totalnodes < n || n <= 0) {
			throw new IllegalArgumentException(
					"Invalid value of N. Number of nodes is less than N or N is not positive.");
		}

		int nodetofind = totalnodes - n;
		int counter = 0;
		listNode = head;
		while (listNode != null) {
			counter = counter + 1;
			listNode = listNode.next;
			if (nodetofind == counter) {
				return listNode;
			}
		}
		return null;
	}

	public static ListNode1 findNthFromEndUsingHashTable(ListNode1 head, int n) throws Exception {
		ListNode1 listNode = head;
		HashMap<Integer, ListNode1> hashMap = new HashMap<>();
		Integer counter = 1;
		while (listNode != null) {
			hashMap.put(counter, listNode);
			listNode = listNode.next;
			counter++;
		}
		return hashMap.get(hashMap.size() - n + 1);
	}

	public static ListNode1 findNthFromEndUsingTwoPointers(ListNode1 head, int n) throws Exception {

		ListNode1 nNode = head;
		ListNode1 nTemp = head;
		int counter = 0;
		while (nTemp != null) {
			counter = counter + 1;
			nTemp = nTemp.next;
			if(counter==n)
			{
				nNode=nNode.next;
			}
		}
		return nNode;
	}
	static int   globalcounter=0;
	public static ListNode1 findNthFromEndRecursion(ListNode1 head, int n) throws Exception {
		if(head!=null)
		{
			ListNode1 temp= findNthFromEndRecursion(head.next, n);
			globalcounter = globalcounter + 1;
			if(globalcounter == n || temp!=null)
			{
				return temp!=null?temp:head;
			}
		}
		return null;
	
	}
	public static void main(String[] args) throws Exception {
		// Test case
		ListNode1 head = new ListNode1(1);
		head.next = new ListNode1(2);
		head.next.next = new ListNode1(3);
		head.next.next.next = new ListNode1(4);
		head.next.next.next.next = new ListNode1(5);

		int n = 2;
		ListNode1 nthNode = findNthFromEndRecursion(head, n);

		if (nthNode != null) {
			System.out.println("The " + n + "th node from the end is: " + nthNode.value);
		} else {
			System.out.println("The list has less than " + n + " nodes.");
		}
	}
}
